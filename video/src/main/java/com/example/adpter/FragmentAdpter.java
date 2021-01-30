package com.example.adpter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class FragmentAdpter extends FragmentStatePagerAdapter {
    private List<Fragment> fragmentList;
    private List<String> stringList;
    public FragmentAdpter(@NonNull FragmentManager fm,List<Fragment> list,List<String> strings) {
        super(fm);
        this.fragmentList = list;
        this.stringList = strings;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return stringList.get(position);
    }
}
