package com.bw.a1805atoutiao.ui.fragment;

import android.graphics.Color;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bw.a1805atoutiao.R;
import com.bw.a1805atoutiao.adapter.HomeFragmentAdapter;
import com.bw.framework.base.BaseFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class VideoFragment extends BaseFragment {
    private TabLayout tabLayoutVideo;
    private ViewPager vpVideo;
    private List<Fragment> fragments = new ArrayList<>();
    private HomeFragmentAdapter adapter;

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        tabLayoutVideo = (TabLayout) view.findViewById(R.id.tabLayout_video);
        vpVideo = (ViewPager) view.findViewById(R.id.vp_video);

    }

    @Override
    protected int getlayoutid() {
        return R.layout.fragment_video;
    }

    @Override
    protected void createPresenter() {

    }
}
