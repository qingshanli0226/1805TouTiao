package com.example.image.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class ContentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private List<String> headImgtablayout;

    public ContentPagerAdapter(FragmentManager fm, List<Fragment> fragments, List<String> headImgtablayout) {
        super(fm);
        this.fragments = fragments;
        this.headImgtablayout = headImgtablayout;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return headImgtablayout.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return headImgtablayout.get(position);
    }
}
