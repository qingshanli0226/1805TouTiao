package com.example.sevenlandh.fragment.home;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.freamwork.mvp.BaseFragment;
import com.example.sevenlandh.R;
import com.google.android.material.tabs.TabLayout;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;


public class JournalismFragment extends BaseFragment {

    private TabLayout journalTab;
    private ViewPager journalVp;
    private ArrayList<String> list_tab=new ArrayList<>();
    private ArrayList<Fragment> list_fragment=new ArrayList<>();
    private ImageView homeToobarList;
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
        homeToobarList = F(R.id.home_toobar_list);
        homeToobarList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().postSticky("0");
            }
        });
    }
}