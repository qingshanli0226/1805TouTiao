package com.example.a1805toutiao.news;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.example.a1805toutiao.ComplieActivity;
import com.example.a1805toutiao.R;
import com.example.a1805toutiao.news.type.NewsTypeFragment;
import com.example.framework.adapter.TabFragmentAdapter;
import com.example.framework.base.BaseFragment;
import com.example.framework.dao.TouTiaoMessageGreenBean;
import com.example.framework.manager.MessageManager;
import com.example.framework.manager.NewsFragmentManager;
import com.google.android.material.tabs.TabLayout;

import java.util.List;


public class NewsFragment extends BaseFragment {
    private TabLayout tabNews;
    private ImageView addFragNews;
    private ViewPager vpNews;
    private TabFragmentAdapter adapter;
    private boolean canChange=false;
    @Override
    protected void initData() {
        List<TouTiaoMessageGreenBean> comList = MessageManager.getInstance().getComList();

        for (TouTiaoMessageGreenBean touTiaoMessageGreenBean : comList) {
            NewsFragmentManager.getInstance().addFragment(touTiaoMessageGreenBean.getTilte(),new NewsTypeFragment(touTiaoMessageGreenBean.getTag()));
        }
        vpNews.setOffscreenPageLimit(MessageManager.getInstance().getTagsCount());
        List<Fragment> visibleFragments = NewsFragmentManager.getInstance().getVisibleFragments();
        adapter=new TabFragmentAdapter(getChildFragmentManager(),NewsFragmentManager.getInstance().getVisibleFragments(),NewsFragmentManager.getInstance().getVisibleTags());
        vpNews.setAdapter(adapter);
        canChange=true;
    }

    @Override
    protected void initListener() {
        addFragNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), ComplieActivity.class));
            }
        });
        NewsFragmentManager.getInstance().bindListener(new NewsFragmentManager.IOnFragmentChangeListener() {
            @Override
            public void onChange() {
                if(canChange){
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    protected void initView() {
        tabNews = (TabLayout) findViewById(R.id.tab_news);
        addFragNews = (ImageView) findViewById(R.id.add_frag_news);
        vpNews = (ViewPager) findViewById(R.id.vp_news);
        tabNews.setupWithViewPager(vpNews);
        tabNews.setTabGravity(TabLayout.GRAVITY_FILL);

    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_news;
    }
}