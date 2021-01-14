package com.song.news;

import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.song.fromwork.BaseFragment;
import com.song.fromwork.utils.CacheManager;
import com.song.fromwork.utils.RxBus;
import com.song.fromwork.dao.NewsChannelBean;
import com.song.fromwork.dao.NewsChannelManager;
import com.song.news.fragment.NewsArticleFragment;
import com.song.news.fragment.WendaArticleFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class NewsFragment extends BaseFragment {
    private LinearLayout headerLayout;
    private TabLayout tabLayoutNews;
    private ImageView addChannelIv;
    private ViewPager viewPagerNews;

    private Observable<Boolean> observable;


    private List<Fragment> fragments = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();
    private Map<String, Fragment> map = new HashMap<>();

    private List<NewsChannelBean> newsChannelBeans = new ArrayList<>();
    private CacheManager.ICacheChangeListener cacheChangeListener = new CacheManager.ICacheChangeListener() {
        @Override
        public void onAllChange(List<NewsChannelBean> newsChannelBeansAll) {
            newsChannelBeans = newsChannelBeansAll;
            adapter.notifyDataSetChanged();
        }
    };

    private MyVpAdapter adapter;

    @Override
    protected void initData() {
        adapter = new MyVpAdapter(getActivity().getSupportFragmentManager());
        viewPagerNews.setAdapter(adapter);
        viewPagerNews.setOffscreenPageLimit(15);
        initTabs();
    }

    private void initTabs() {
        List<NewsChannelBean> newsChannelBeansAll = CacheManager.getInstance().getNewsChannelBeansAll();
        if (newsChannelBeansAll.size() != 0 && newsChannelBeansAll != null) {
            newsChannelBeans = newsChannelBeansAll;
        }
        update();
    }

    private void update() {
        fragments.clear();
        titleList.clear();
        map.clear();
        for (NewsChannelBean bean : newsChannelBeans) {
            if (bean.getIsEnable() == 1) {
                Fragment fragment = null;
                String channelId = bean.getChannelId();
                switch (channelId) {
                    case "question_and_answer":
                        if (map.containsKey(channelId)) {
                            fragments.add(map.get(channelId));
                        } else {
                            fragment = WendaArticleFragment.newInstance();//问答
                            fragments.add(fragment);
                        }
                        break;
                    default:
                        if (map.containsKey(channelId)) {
                            fragments.add(map.get(channelId));
                        } else {
                            fragment = NewsArticleFragment.newInstance(channelId);//普通新闻
                            fragments.add(fragment);
                        }
                        break;
                }
                titleList.add(bean.getChannelName());
                if (fragment != null) {
                    map.put(channelId, fragment);
                }
            }
        }
        adapter.notifyDataSetChanged();
    }

//    private NewsChannelManager.INewsChannelListener newsChannelListener = new NewsChannelManager.INewsChannelListener() {
//        @Override
//        public void onResult(boolean isSuccess, List<NewsChannelBean> newsChannelBeanList) {
//            if (newsChannelBeanList.size() == 0) {
//                NewsChannelManager.getInstance().addInitData();
//                NewsChannelManager.getInstance().query(1, newsChannelListener);
//            } else {
//                Log.i("TAG", "onResult: " + newsChannelBeanList.size());
//                for (NewsChannelBean bean : newsChannelBeanList) {
//                    Fragment fragment = null;
//                    String channelId = bean.getChannelId();
//
//                    switch (channelId) {
//                        case "question_and_answer":
//                            if (map.containsKey(channelId)) {
//                                fragments.add(map.get(channelId));
//                            } else {
//                                fragment = WendaArticleFragment.newInstance();//问答
//                                fragments.add(fragment);
//                            }
//                            break;
//                        default:
//                            if (map.containsKey(channelId)) {
//                                fragments.add(map.get(channelId));
//                            } else {
//                                fragment = NewsArticleFragment.newInstance(channelId);//普通新闻
//                                fragments.add(fragment);
//                            }
//                            break;
//                    }
//
//                    titleList.add(bean.getChannelName());
//
//                    if (fragment != null) {
//                        map.put(channelId, fragment);
//                    }
//                    Log.i("TAG", "channelName: " + bean.getChannelName());
//                }
//                adapter.notifyDataSetChanged();
//            }
//        }
//    };

    @Override
    protected void initView() {
        CacheManager.getInstance().registerChangeListener(cacheChangeListener);
        headerLayout = (LinearLayout) findViewById(R.id.header_layout);
        tabLayoutNews = (TabLayout) findViewById(R.id.tab_layout_news);
        addChannelIv = (ImageView) findViewById(R.id.add_channel_iv);
        viewPagerNews = (ViewPager) findViewById(R.id.view_pager_news);


        tabLayoutNews.setupWithViewPager(viewPagerNews);
        tabLayoutNews.setTabMode(TabLayout.MODE_SCROLLABLE);
//        addChannelIv.setOnClickListener(v -> startActivity(new Intent(getActivity(),)));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news;
    }


    class MyVpAdapter extends FragmentPagerAdapter {
        public MyVpAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        CacheManager.getInstance().unRegisterChangeListener(cacheChangeListener);
    }
}
