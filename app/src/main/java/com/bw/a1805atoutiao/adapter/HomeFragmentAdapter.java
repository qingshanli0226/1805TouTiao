package com.bw.a1805atoutiao.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class HomeFragmentAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragments;
    private List<String> title;
    public HomeFragmentAdapter(@NonNull FragmentManager fm,List<Fragment> fragments,List<String> title) {
        super(fm);
        this.fragments=fragments;
        this.title=title;

    }

    public void setFragments(Fragment fragment,String title){
         this.fragments.add(fragment);
         this.title.add(title);
         notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
