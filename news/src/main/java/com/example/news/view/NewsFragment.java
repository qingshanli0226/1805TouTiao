package com.example.news.view;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.framework.base.BaseMVPFragment;
import com.example.news.R;
import com.example.news.adpter.Newadpter;
import com.example.news.adpter.NewsAdapter;
import com.example.news.contract.NewsContract;

import com.example.news.presenter.NewsPresenterImpl;
import com.example.news.ui.activity.DragsortActivity;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class NewsFragment extends BaseMVPFragment<NewsPresenterImpl, NewsContract.INewsView> implements NewsContract.INewsView, View.OnClickListener {
    private ImageView ivAdd;
    private TabLayout tabLayout;
    private String[] titles = new String[]{"推荐","热点","视频","社会","娱乐","科技","问答","汽车"};
    private RecyclerView newsRec;
    private NewsAdapter newsAdapter;
    private Newadpter newAdapter;

    @Override
    protected void initData() {
        for (int i = 0; i < titles.length; i++) {
            tabLayout.addTab(tabLayout.newTab());
        }
        for (int i = 0; i < titles.length; i++) {
            tabLayout.getTabAt(i).setText(titles[i]);
        }
        httpPresenter.getNewsInfo();
        //点击进入拖拽排序列表
        ivAdd.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        tabLayout = findViewById(R.id.newsTab);
        newsRec = findViewById(R.id.newsRec);
        ivAdd = findViewById(R.id.iv_add);
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
    public void onNews(final List<HashMap<String,String>> newBeans) {
        //适配器进行适配
//        newsAdapter = new NewsAdapter();
//        newsAdapter.addOneData(newBeans);
//        newsRec.setAdapter(newsAdapter);
//        newsRec.setLayoutManager(new LinearLayoutManager(getContext()));
        newAdapter =  new Newadpter(R.layout.item_news_article_img,newBeans);
        newsRec.setAdapter(newAdapter);
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

    /**
     * 点击事件
     * @param view
     */
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.iv_add) {
            //跳转到搜索页面
            Intent intent = new Intent(getContext(), DragsortActivity.class);
            startActivity(intent);
        }
    }
}
