package com.bw.a1805atoutiao.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bw.a1805atoutiao.R;
import com.bw.a1805atoutiao.adapter.HomeFragmentAdapter;
import com.bw.a1805atoutiao.ui.activity.TagManageActivity;
import com.bw.a1805atoutiao.ui.fragment.newsframent.LoadFragment;
import com.bw.framework.base.BaseFragment;
import com.bw.framework.bean.TitleBean;
import com.bw.framework.manage.TitleManage;
import com.flyco.tablayout.CommonTabLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends BaseFragment implements TitleManage.titleChangeListener{

    private CommonTabLayout newsCommon;
    private ImageView addTag;
    private ViewPager newViewpager;
    private List<String> titles=new ArrayList<>();
    private TabLayout tavlayout;
    private List<Fragment> fragments=new ArrayList<>();
    private HomeFragmentAdapter homeFragmentAdapter;
    @Override
    protected void initEvent() {

        tavlayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //fragment滑动监听
        newViewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                 TitleManage.getInstance().getUrl(titles.get(position),position);

           }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //跳转标签添加/删除页面
        addTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 startActivity(new Intent(getContext(), TagManageActivity.class));
            }
        });
    }

    @Override
    protected void initData() {
        //初始化创建
        for (TitleBean showTitleBean : TitleManage.getInstance().getShowTitleBeans()) {
              titles.add(showTitleBean.getTitle());
              fragments.add(new LoadFragment());
        }

            homeFragmentAdapter=new HomeFragmentAdapter(getChildFragmentManager(),fragments,titles);
            newViewpager.setAdapter(homeFragmentAdapter);
            tavlayout.setupWithViewPager(newViewpager);
            newViewpager.setOffscreenPageLimit(10);
        }



    @Override
    protected void initView(View view) {



        addTag = view.findViewById(R.id.add_tag);
        newViewpager = view.findViewById(R.id.new_viewpager);

        tavlayout = view.findViewById(R.id.tavlayout);
        TitleManage.getInstance().registerTitleChangeListener(this);
    }

    @Override
    protected int getlayoutid() {
        return R.layout.fragment_news;
    }

    @Override
    protected void createPresenter() {

    }


    @Override
    public void titleUrl(String url) {

    }

    @Override
    public void addTitle(String title) {
        homeFragmentAdapter.setFragments(new LoadFragment(),title);
    }

    @Override
    public void removeTitle(String title, int position) {
        homeFragmentAdapter.setRemoveFragments(position,title);
    }

    @Override
    public void titlePosition(int position1, int position2) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        TitleManage.getInstance().unTitleChangeListener(this);
    }
}
