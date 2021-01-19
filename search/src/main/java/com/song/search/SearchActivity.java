package com.song.search;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.ViewPager;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.material.tabs.TabLayout;
import com.jakewharton.rxbinding2.view.RxView;
import com.song.common.ErrorAction;
import com.song.fromwork.BaseActivity;
import com.song.fromwork.BasePagerAdapter;
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

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SearchActivity extends BaseActivity implements View.OnClickListener {

    private static final String STRING = "SearchActivity";
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

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
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
//                if (position == 0) {
//                    if (slidrInterface != null) {
//                        slidrInterface.unlock();
//                    }
//                } else {
//                    if (slidrInterface != null) {
//                        slidrInterface.lock();
//                    }
//                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_search;
    }

    @Override
    public void onClick(View view) {

    }
}
