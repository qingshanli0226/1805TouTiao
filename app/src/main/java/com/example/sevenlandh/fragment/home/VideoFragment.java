package com.example.sevenlandh.fragment.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.View;
import android.widget.ImageView;

import com.example.freamwork.mvp.BaseFragment;
import com.example.sevenlandh.R;
import com.example.sevenlandh.adapter.JournalismTabAdapter;
import com.example.sevenlandh.image.view.GoodBodyFragment;
import com.example.sevenlandh.video.view.RecommendVideo;
import com.google.android.material.tabs.TabLayout;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;


public class VideoFragment extends BaseFragment {
    private ImageView homeToobarList;
    private TabLayout journalTab;
    private ViewPager journalVp2;
    private ArrayList<String> list_tab=new ArrayList<>();
    private ArrayList<Fragment> list_fragment=new ArrayList<>();
    private JournalismTabAdapter journalismTabAdapter;



    @Override
    protected int bandLayout() {
        return R.layout.fragment_video;
    }
    @Override
    protected void initEvent() {
        list_tab.add("全部");
        list_tab.add("老照片");
        list_fragment.add(new RecommendVideo());
        list_fragment.add(new GoodBodyFragment());
        journalismTabAdapter=new JournalismTabAdapter(getFragmentManager(),list_fragment,list_tab);
        journalVp2.setAdapter(journalismTabAdapter);
        journalTab.setupWithViewPager(journalVp2);
    }
    @Override
    protected void initData(Bundle savedInstanceState) {

    }
    @Override
    protected void initView() {
        homeToobarList = F(R.id.home_toobar_list);
        journalTab = F(R.id.journal_tab2);
        journalVp2 = F(R.id.journal_vp2);
        homeToobarList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().postSticky("0");
            }
        });
    }
}