package com.example.a1805toutiao.news;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.example.a1805toutiao.ComplieActivity;
import com.example.a1805toutiao.R;
import com.example.framework.base.BaseFragment;
import com.google.android.material.tabs.TabLayout;


public class NewsFragment extends BaseFragment {

    private TabLayout tabNews;
    private ImageView addFragNews;
    private RecyclerView rvNews;

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        addFragNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), ComplieActivity.class));
            }
        });
    }

    @Override
    protected void initView() {

        tabNews = (TabLayout) findViewById(R.id.tab_news);
        addFragNews = (ImageView) findViewById(R.id.add_frag_news);
        rvNews = (RecyclerView) findViewById(R.id.rv_news);

    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_news;
    }
}