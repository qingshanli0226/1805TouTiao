package com.example.a1805toutiao.pictrue;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a1805toutiao.R;
import com.example.a1805toutiao.pictrue.type.PicTypeFragment;
import com.example.framework.adapter.TabFragmentAdapter;
import com.example.framework.base.BaseFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class PicFragment extends BaseFragment {
    private TabLayout tabVideoOrPictrue;
    private ViewPager vpVideoOrPictrue;
    private List<Fragment> fragments=new ArrayList<>();
    private List<String> tags=new ArrayList<>();
    @Override
    protected void initData() {
        String[] phoneIds = getResources().getStringArray(R.array.photo_id);
        String[] phoneNames = getResources().getStringArray(R.array.photo_name);
        for (int i = 0; i < phoneNames.length; i++) {
            tags.add(phoneNames[i]);
        }
        for (int i = 0; i < phoneIds.length; i++) {
            fragments.add(new PicTypeFragment(phoneIds[i]));
        }
        TabFragmentAdapter adapter = new TabFragmentAdapter(getChildFragmentManager(), fragments, tags);
        vpVideoOrPictrue.setAdapter(adapter);
        tabVideoOrPictrue.setTabGravity(TabLayout.GRAVITY_FILL);
        tabVideoOrPictrue.setupWithViewPager(vpVideoOrPictrue);
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
        return R.layout.fragment_pic;
    }
}