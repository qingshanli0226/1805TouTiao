package com.example.news;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.example.framework.base.BaseMVPFragment;
import com.example.news.adpter.NewsAdapter;
import com.example.news.contract.NewsContract;
import com.example.news.presenter.NewsPresenterImpl;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class NewsFragment extends BaseMVPFragment<NewsPresenterImpl, NewsContract.INewsView> implements NewsContract.INewsView {

    private TabLayout tabLayout;
    private String[] titles = new String[]{"推荐","热点","视频","社会","娱乐","科技","问答","汽车"};
    private RecyclerView newsRec;
    private NewsAdapter newsAdapter;
    private List<HashMap<String,String>> hashMaps = new ArrayList<>();

    @Override
    protected void initData() {
        for (int i = 0; i < titles.length; i++) {
            tabLayout.addTab(tabLayout.newTab());
        }
        for (int i = 0; i < titles.length; i++) {
            tabLayout.getTabAt(i).setText(titles[i]);
        }
        httpPresenter.getNewsInfo();
    }

    @Override
    protected void initView() {
        tabLayout = findViewById(R.id.newsTab);
        newsRec = findViewById(R.id.newsRec);
    }

    @Override
    protected void initPresenter() {
        httpPresenter = new NewsPresenterImpl();
    }

    @Override
    protected int getlayoutids() {
        return R.layout.fragment_news;
    }

    @Override
    public void onNews(List<HashMap<String,String>> newBeans) {
        //适配器进行适配
        hashMaps.addAll(newBeans);
        newsAdapter = new NewsAdapter(R.layout.item_news_article_img,hashMaps);
        newsRec.setAdapter(newsAdapter);
        newsRec.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onError(String message) {
    }

    @Override
    public void showError(String message) {
        showerror(message);
    }

    @Override
    public void showEmpty() {
        showEnpty();
    }

    @Override
    public void showLoading() {
        showloading();
    }

    @Override
    public void hidesLoading() {
        hideLoading();
    }
}
