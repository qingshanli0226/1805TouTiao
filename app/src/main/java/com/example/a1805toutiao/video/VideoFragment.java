package com.example.a1805toutiao.video;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.example.a1805toutiao.R;
import com.example.a1805toutiao.video.type.VoideTypeFragment;
import com.example.framework.adapter.TabFragmentAdapter;
import com.example.framework.base.BaseFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class VideoFragment extends BaseFragment {
    private TabLayout tabVideoOrPictrue;
    private ViewPager vpVideoOrPictrue;
    private List<Fragment> fragments = new ArrayList<>();
    private List<String> tags = new ArrayList<>();
    @Override
    protected void initData() {
        String[] voideNameS = getResources().getStringArray(R.array.mobile_video_name);
        String[] voideIds = getResources().getStringArray(R.array.mobile_video_id);
        for (String id: voideIds){
            fragments.add(new VoideTypeFragment(id));
        }
        for (String name: voideNameS){
            tags.add(name);
        }

        TabFragmentAdapter adapter = new TabFragmentAdapter(getChildFragmentManager(),fragments,tags);
        vpVideoOrPictrue.setAdapter(adapter);
        vpVideoOrPictrue.setOffscreenPageLimit(12);
        tabVideoOrPictrue.setTabGravity(TabLayout.GRAVITY_FILL);//不填充整个textview
        tabVideoOrPictrue.setupWithViewPager(vpVideoOrPictrue);//和viewpager绑定
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        tabVideoOrPictrue = (TabLayout) findViewById(R.id.tab_video_or_pictrue);
        vpVideoOrPictrue = (ViewPager) findViewById(R.id.vp_video_or_pictrue);


    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_video;
    }
}