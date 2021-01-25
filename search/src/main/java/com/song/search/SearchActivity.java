package com.song.search;

import android.app.AlertDialog;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.ViewPager;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.material.tabs.TabLayout;
import com.jakewharton.rxbinding2.support.v7.widget.RxSearchView;
import com.jakewharton.rxbinding2.view.RxView;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrConfig;
import com.r0adkll.slidr.model.SlidrInterface;
import com.song.common.ErrorAction;
import com.song.common.search.SearchHistoryBean;
import com.song.fromwork.BaseActivity;
import com.song.fromwork.BasePagerAdapter;
import com.song.fromwork.utils.RetrofitFactory;
import com.song.fromwork.utils.SettingUtil;
import com.song.net.Constant;
import com.song.net.api.MobileSearchApi;
import com.song.net.mode.mobile.search.SearchRecommentBean;
import com.song.search.adapter.SearchHistoryAdapter;
import com.song.search.adapter.SearchSuggestionAdapter;
import com.song.search.dao.SearchHistoryDao;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.AutoDisposeConverter;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SearchActivity extends BaseActivity implements View.OnClickListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String[] titles = new String[]{"综合", "视频", "图集", "用户(beta)", "问答"};
    private SearchView searchView;
    private LinearLayout resultLayout;
    private ListView suggestionList;
    private ListView historyList;
    private SearchHistoryAdapter historyAdapter;
    private SearchSuggestionAdapter suggestionAdapter;
    private SearchHistoryDao dao = new SearchHistoryDao();
    private FlexboxLayout flexboxLayout;
    private LinearLayout hotWordLayout;
    private SlidrInterface slidrInterface;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        initSlidable();
        // 热门搜索
        hotWordLayout = findViewById(R.id.hotword_layout);
        flexboxLayout = findViewById(R.id.flexbox_layout);
        flexboxLayout.setFlexDirection(FlexDirection.ROW);
        flexboxLayout.setFlexWrap(FlexWrap.WRAP);
        TextView tv_clear = findViewById(R.id.tv_clear);
        tv_clear.setOnClickListener(this);
        TextView tv_refresh = findViewById(R.id.tv_refresh);
        RxView.clicks(tv_refresh)
                // 防抖
                .throttleFirst(1, TimeUnit.SECONDS)
                .as(this.bindAutoDispose())
                .subscribe(o -> {
                    flexboxLayout.removeAllViews();
                    getSearchHotWord();
                }, ErrorAction.error());
        // 搜索结果
        resultLayout = findViewById(R.id.result_layout);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        tabLayout.setBackgroundColor(SettingUtil.getInstance().getColor());
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        // 搜索建议
        suggestionList = findViewById(R.id.suggestion_list);
        suggestionAdapter = new SearchSuggestionAdapter(this, -1);
        suggestionList.setAdapter(suggestionAdapter);
        suggestionList.setOnItemClickListener((parent, view, position, id) -> {
            String keyWord = suggestionAdapter.getItem(position).getKeyword();
            searchView.clearFocus();
            searchView.setQuery(keyWord, true);
        });
        // 搜索历史
        historyList = findViewById(R.id.history_list);
        historyAdapter = new SearchHistoryAdapter(this, -1);
        historyList.setAdapter(historyAdapter);
        historyList.setOnItemClickListener((parent, view, position, id) -> {
            String keyWord = historyAdapter.getItem(position).getKeyWord();
            searchView.clearFocus();
            searchView.setQuery(keyWord, true);
        });
    }

    private void initSlidable() {
        int isSlidable = SettingUtil.getInstance().getSlidable();
        if (isSlidable != Constant.SLIDABLE_DISABLE) {
            SlidrConfig config = new SlidrConfig.Builder()
                    .edge(isSlidable == Constant.SLIDABLE_EDGE)
                    .build();
            slidrInterface = Slidr.attach(this, config);
        }
    }

    private void getSearchHotWord() {

        RetrofitFactory.getRetrofit().create(MobileSearchApi.class).getSearchRecomment()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .map(searchRecommentBean -> {
                    List<SearchRecommentBean.DataBean.SuggestWordListBean> suggest_word_list = searchRecommentBean.getData().getSuggest_word_list();
                    List<String> hotList = new ArrayList<>();
                    for (int i = 0; i < suggest_word_list.size(); i++) {
                        if (suggest_word_list.get(i).getType().equals("recom")) {
                            hotList.add(suggest_word_list.get(i).getWord());
                        }
                    }
                    return hotList;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .as(this.bindAutoDispose())
                .subscribe(list -> {
                    for (int i = 0; i < list.size(); i++) {
                        final TextView tv = (TextView) LayoutInflater.from(SearchActivity.this).inflate(R.layout.item_search_sug_text, flexboxLayout, false);
                        final String keyWord = list.get(i);
                        int color = Constant.TAG_COLORS[i % Constant.TAG_COLORS.length];
                        tv.setText(keyWord);
                        tv.setBackgroundColor(color);
                        tv.setTextColor(Color.WHITE);
                        tv.setOnClickListener(view -> {
                            searchView.clearFocus();
                            searchView.setQuery(keyWord, true);
                        });
                        flexboxLayout.addView(tv);
                        if (i == 7) {
                            return;
                        }
                    }
                }, ErrorAction.error());
    }

    public <X> AutoDisposeConverter<X> bindAutoDispose() {
        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider
                .from(this, Lifecycle.Event.ON_DESTROY));
    }

    private void initSearchLayout(String query) {
        hotWordLayout.setVisibility(View.GONE);
        resultLayout.setVisibility(View.VISIBLE);
        suggestionList.setVisibility(View.GONE);
        List<Fragment> fragmentList = new ArrayList<>();
        for (int i = 1; i < titles.length + 1; i++) {
            //fragmentList.add(SearchResultFragment.newInstance(query, i + ""));
        }
        BasePagerAdapter pagerAdapter = new BasePagerAdapter(getSupportFragmentManager(), fragmentList, titles);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(fragmentList.size());
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    if (slidrInterface != null) {
                        slidrInterface.unlock();
                    }
                } else {
                    if (slidrInterface != null) {
                        slidrInterface.lock();
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        searchView = (SearchView) MenuItemCompat.getActionView(item);
        // 关联检索配置与 SearchActivity
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchableInfo searchableInfo = searchManager.getSearchableInfo(
                new ComponentName(getApplicationContext(), SearchActivity.class));
        searchView.setSearchableInfo(searchableInfo);
        searchView.onActionViewExpanded();

        setOnQuenyTextChangeListener();

        return super.onCreateOptionsMenu(menu);
    }

    private void getSearchHistory() {
        Observable
                .create((ObservableOnSubscribe<List<SearchHistoryBean>>) e -> {
                    List<SearchHistoryBean> list = dao.queryAll();
                    e.onNext(list);
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(this.bindAutoDispose())
                .subscribe(list -> historyAdapter.updateDataSource(list), ErrorAction.error());
    }

    private void getSearchSuggest(String keyWord) {
        RetrofitFactory.getRetrofit().create(MobileSearchApi.class)
                .getSearchSuggestion(keyWord.trim())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(this.bindAutoDispose())
                .subscribe(bean -> suggestionAdapter.updateDataSource(bean.getData()), ErrorAction.error());
    }

    private void setOnQuenyTextChangeListener() {
        RxSearchView.queryTextChangeEvents(searchView)
                .throttleLast(100, TimeUnit.MILLISECONDS)
                .debounce(300, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .as(this.bindAutoDispose())
                .subscribe(searchViewQueryTextEvent -> {
                    final String keyWord = searchViewQueryTextEvent.queryText() + "";
                    if (searchViewQueryTextEvent.isSubmitted()) {
                        searchView.clearFocus();
                        initSearchLayout(keyWord);
                        new Thread(() -> {
                            if (dao.queryisExist(keyWord)) {
                                dao.update(keyWord);
                            } else {
                                dao.add(keyWord);
                            }
                        }).start();
                        return;
                    }
                    if (!TextUtils.isEmpty(keyWord)) {
                        getSearchSuggest(keyWord);
                        hotWordLayout.setVisibility(View.GONE);
                        resultLayout.setVisibility(View.GONE);
                        suggestionList.setVisibility(View.VISIBLE);
                    } else {
                        getSearchHistory();
                        if (hotWordLayout.getVisibility() != View.VISIBLE) {
                            hotWordLayout.setVisibility(View.VISIBLE);
                        }
                        if (resultLayout.getVisibility() != View.GONE) {
                            resultLayout.setVisibility(View.GONE);
                        }
                        if (suggestionList.getVisibility() != View.GONE) {
                            suggestionList.setVisibility(View.GONE);
                        }
                    }
                }, ErrorAction.error());
    }

    @Override
    protected void onPause() {
        super.onPause();
        searchView.clearFocus();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_search;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_clear) {
            new AlertDialog.Builder(this)
                    .setMessage("是否删除历史记录")
                    .setPositiveButton("确定", (dialog, which) -> {
                        new Thread(() -> {
                            dao.deleteAll();
                            getSearchHistory();
                        }).start();
                        dialog.dismiss();
                    })
                    .setNegativeButton("取消", (dialog, which) -> dialog.dismiss())
                    .show();
        }
    }

    @Override
    public void onBackPressed() {
        if (suggestionList.getVisibility() != View.GONE) {
            // 关闭搜索建议
            suggestionList.setVisibility(View.GONE);
            hotWordLayout.setVisibility(View.VISIBLE);
        } else if (resultLayout.getVisibility() != View.GONE) {
            // 关闭搜索结果
            searchView.setQuery("", false);
            searchView.clearFocus();
            resultLayout.setVisibility(View.GONE);
            hotWordLayout.setVisibility(View.VISIBLE);
        } else {
            finish();
        }
    }
}
