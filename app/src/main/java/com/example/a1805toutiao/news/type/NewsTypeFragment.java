package com.example.a1805toutiao.news.type;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a1805toutiao.R;
import com.example.framework.base.BaseFragment;


public class NewsTypeFragment extends BaseFragment {
    private RecyclerView rvNewsType;
    private TextView tv;
    private String tag;

    public NewsTypeFragment(String tag) {
        this.tag = tag;
    }

    @Override
    protected void initData() {
        tv.setText(tag);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
//        rvNewsType = (RecyclerView) findViewById(R.id.rv_news_type);


        tv = (TextView) findViewById(R.id.tv);

    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_news_type;
    }
}