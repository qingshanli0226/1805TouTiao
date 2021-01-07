package com.example.sevenlandh.fragment.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.freamwork.mvp.BaseFragment;
import com.example.sevenlandh.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class JournalismFragment extends BaseFragment {

    private TabLayout journalTab;
    private ViewPager journalVp;
    private ArrayList<String> list_tab=new ArrayList<>();
    private ArrayList<Fragment> list_fragment=new ArrayList<>();

    @Override
    protected int bandLayout() {
        return R.layout.fragment_journalism;
    }
    @Override
    protected void initEvent() {

    }
    @Override
    protected void initData(Bundle savedInstanceState) {

    }
    @Override
    protected void initView() {
        journalTab = F(R.id.journal_tab);
        journalVp = F(R.id.journal_vp);

    }
}