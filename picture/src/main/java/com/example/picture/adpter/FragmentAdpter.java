package com.example.picture.adpter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class FragmentAdpter extends FragmentStatePagerAdapter {
    private List<String> stringList;
    private List<Fragment> fragmentList;
    public FragmentAdpter(@NonNull FragmentManager fm,List<Fragment> fragmentListList,List<String> stringList) {
        super(fm);
        this.fragmentList = fragmentListList;
        this.stringList = stringList;
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
