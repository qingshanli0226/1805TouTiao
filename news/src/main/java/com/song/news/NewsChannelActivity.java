package com.song.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.song.fromwork.BaseActivity;
import com.song.fromwork.dao.NewsChannelBean;
import com.song.fromwork.utils.CacheManager;

import java.util.ArrayList;
import java.util.List;

public class NewsChannelActivity extends BaseActivity {
    private RecyclerView newsChannelRv;
    private NewsChannelAdapter adapter;


    @Override
    protected void initData() {
        adapter.addOneData("我的频道");
        adapter.addOneData(CacheManager.getInstance().getNewsChannelBeansEnable());
        adapter.addOneData("隐藏频道");
        adapter.addOneData(CacheManager.getInstance().getNewsChannelBeansUnable());
    }

    @Override
    protected void initView() {
        newsChannelRv = (RecyclerView) findViewById(R.id.news_channel_rv);
        newsChannelRv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NewsChannelAdapter();
        newsChannelRv.setAdapter(adapter);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_news_channel;
    }
}