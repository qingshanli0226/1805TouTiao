package com.example.sevenlandh.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.sevenlandh.fragment.journalism.BringUpFragment;

import java.util.List;

public class JournalismTabAdapter extends FragmentPagerAdapter {

    private List<String> list;

    public JournalismTabAdapter(@NonNull FragmentManager fm,List<String> list) {
        super(fm);
        this.list = list;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return new BringUpFragment();
    }
    @Override
    public int getCount() {
        return list.size();
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
