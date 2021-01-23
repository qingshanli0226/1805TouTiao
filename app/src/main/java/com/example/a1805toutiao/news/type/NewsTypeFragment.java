package com.example.a1805toutiao.news.type;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a1805toutiao.R;
import com.example.common.error.ErrorBean;
import com.example.framework.base.BaseFragment;
import com.example.net.bean.news.MultiNewsArticleBean;


public class NewsTypeFragment extends BaseFragment<NewsTypePresenterImpl, NewsTypeContract.INewsTypeView> implements NewsTypeContract.INewsTypeView {
    private RecyclerView rvNewsType;
    private String tag;
    private int id;
    public NewsTypeFragment(int id,String tag) {
        this.tag = tag;
        this.id = id;
    }

    @Override
    protected void initData() {
        presenter.loadNews(id,tag,System.currentTimeMillis()/1000+"");
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        rvNewsType = (RecyclerView) findViewById(R.id.rv_news_type);



    }

    @Override
    protected void initPresenter() {
        presenter=new NewsTypePresenterImpl();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_news_type;
    }

    @Override
    public void onNewsTypeLoadOk(MultiNewsArticleBean bean) {
        logI("Yoyo",bean.toString());
    }

    @Override
    public void showLoadingPage() {
        showLoading();
    }

    @Override
    public void hideLoadingPage(boolean isSuccess, ErrorBean errorBean) {
        hideLoading(isSuccess,errorBean);
    }

    @Override
    public void showEmptyPage() {
        showEmptyContent();
    }
}