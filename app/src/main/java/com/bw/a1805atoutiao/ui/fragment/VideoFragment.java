package com.bw.a1805atoutiao.ui.fragment;

import android.graphics.Color;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bw.a1805atoutiao.R;
import com.bw.a1805atoutiao.adapter.HomeFragmentAdapter;
import com.bw.a1805atoutiao.ui.fragment.newsframent.LoadFragment;
import com.bw.framework.base.BaseFragment;
import com.bw.framework.bean.TitleBean;
import com.bw.framework.manage.TitleManage;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class VideoFragment extends BaseFragment implements TitleManage.titleChangeListener {
    private TabLayout tabLayoutVideo;
    private ViewPager vpVideo;
    private List<Fragment> fragments = new ArrayList<>();
    private List<String> titles=new ArrayList<>();
    private HomeFragmentAdapter adapter;

    @Override
    protected void initEvent() {
        tabLayoutVideo.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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

        vpVideo.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
    }

    @Override
    protected void initData() {

        adapter=new HomeFragmentAdapter(getChildFragmentManager(),fragments,titles);
        vpVideo.setAdapter(adapter);
        tabLayoutVideo.setupWithViewPager(vpVideo);
        vpVideo.setOffscreenPageLimit(10);
    }

    @Override
    protected void initView(View view) {
        tabLayoutVideo = (TabLayout) view.findViewById(R.id.tabLayout_video);
        vpVideo = (ViewPager) view.findViewById(R.id.vp_video);

        TitleManage.getInstance().registerTitleChangeListener(this);
    }

    @Override
    protected int getlayoutid() {
        return R.layout.fragment_video;
    }

    @Override
    protected void createPresenter() {

    }

    @Override
    public void titleUrl(String url) {

    }

    @Override
    public void addTitle(String title) {
        adapter.setFragments(new LoadFragment(),title);
    }

    @Override
    public void removeTitle(String title, int position) {
        adapter.setRemoveFragments(position,title);
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
