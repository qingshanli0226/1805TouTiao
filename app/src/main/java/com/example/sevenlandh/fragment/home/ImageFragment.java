package com.example.sevenlandh.fragment.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.View;
import android.widget.ImageView;

import com.example.freamwork.mvp.BaseFragment;
import com.example.sevenlandh.R;
import com.example.sevenlandh.adapter.JournalismTabAdapter;
import com.example.sevenlandh.image.view.AgricultureFragment;
import com.example.sevenlandh.image.view.ChinaRapFragment;
import com.example.sevenlandh.image.view.GoodBodyFragment;
import com.example.sevenlandh.image.view.NumericalFragment;
import com.google.android.material.tabs.TabLayout;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

public class ImageFragment extends BaseFragment {
    private ImageView homeToobarList;
    private TabLayout journalTab;
    private ViewPager journalVp;
    private ArrayList<String> list_tab=new ArrayList<>();
    private ArrayList<Fragment> list_fragment=new ArrayList<>();
    private JournalismTabAdapter journalismTabAdapter;

    @Override
    protected int bandLayout() {
        return R.layout.fragment_image;
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        list_tab.add("全部");
        list_tab.add("老照片");
        list_tab.add("故事照片");
        list_tab.add("摄影集");

        list_fragment.add(new NumericalFragment());
        list_fragment.add(new GoodBodyFragment());
        list_fragment.add(new AgricultureFragment());
        list_fragment.add(new ChinaRapFragment());

        journalismTabAdapter=new JournalismTabAdapter(getFragmentManager(),list_fragment,list_tab);
        journalVp.setAdapter(journalismTabAdapter);
        journalTab.setupWithViewPager(journalVp);

    }

    @Override
    protected void initView() {
        homeToobarList = F(R.id.home_toobar_list);
        journalTab = F(R.id.journal_tab1);
        journalVp = F(R.id.journal_vp1);
        homeToobarList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().postSticky("0");
            }
        });

    }
}