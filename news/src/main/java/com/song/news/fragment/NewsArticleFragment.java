package com.song.news.fragment;

import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.song.common.ErrorBean;
import com.song.fromwork.BaseMVPFragment;
import com.song.net.mode.mobile.news.MultiNewsArticleDataBean;
import com.song.news.R;
import com.song.news.fragment.contract.NewsContract;
import com.song.news.fragment.contract.NewsImpl;

import java.util.ArrayList;
import java.util.List;

public class NewsArticleFragment extends BaseMVPFragment<NewsImpl, NewsContract.INewsView> implements NewsContract.INewsView {
    private RecyclerView newsRv;
    private NewsArticleAdapter adapter;

    private List<MultiNewsArticleDataBean> list = new ArrayList<>();


    private static final String TAG = "NewsArticleFragment";
    private String categoryId;

    public static NewsArticleFragment newInstance(String categoryId){
        Bundle bundle = new Bundle();
        bundle.putString(TAG,categoryId);
        NewsArticleFragment fragment = new NewsArticleFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    protected void initPresenter() {
        iHpptPresenter = new NewsImpl();
    }

    @Override
    protected void initHttpData() {
        iHpptPresenter.doLoadData(categoryId);
    }

    @Override
    protected void initData() {
        categoryId = getArguments().getString(TAG);
    }

    @Override
    protected void initView() {
        newsRv = (RecyclerView) findViewById(R.id.news_rv);
        newsRv.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new NewsArticleAdapter();
        adapter.updataData(list);
        newsRv.setAdapter(adapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_article_news;
    }

    @Override
    public void onLoadData(List<MultiNewsArticleDataBean> newsArticleDataBeans) {
        list.addAll(newsArticleDataBeans);
        adapter.updataData(list);
        Log.i(TAG, "onLoadData: "+adapter.getItemCount());
    }

    @Override
    public void onRefresh(List<MultiNewsArticleDataBean> newsArticleDataBeans) {

    }

    @Override
    public void hideLoading(boolean isSuccess, ErrorBean errorBean) {
        hideLoadingPage(isSuccess,errorBean);
    }

    @Override
    public void showEmpty() {

    }
}
