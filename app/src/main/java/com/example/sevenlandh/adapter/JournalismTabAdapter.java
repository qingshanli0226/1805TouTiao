package com.example.sevenlandh.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class JournalismTabAdapter extends FragmentPagerAdapter {

    private List<Fragment> list_fragment;
    private List<String> list;


    public JournalismTabAdapter(@NonNull FragmentManager fm,List<Fragment> list_fragment,List<String> list) {
        super(fm);
        this.list_fragment = list_fragment;
        this.list = list;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list_fragment.get(position);
    }

    @Override
    public int getCount() {
        return list_fragment.size();

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
