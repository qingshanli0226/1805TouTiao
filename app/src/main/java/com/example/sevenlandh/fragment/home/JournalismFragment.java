package com.example.sevenlandh.fragment.home;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.freamwork.mvp.BaseFragment;
import com.example.sevenlandh.R;
import com.example.sevenlandh.adapter.JournalismTabAdapter;
import com.example.sevenlandh.bring.view.BringUpFragment;
import com.example.sevenlandh.bring.view.CultureFragment;
import com.example.sevenlandh.bring.view.EmotionFragment;
import com.example.sevenlandh.bring.view.FilmMovieFragment;
import com.example.sevenlandh.bring.view.GovernmentFragment;
import com.example.sevenlandh.bring.view.PhoneFragment;
import com.google.android.material.tabs.TabLayout;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;


public class JournalismFragment extends BaseFragment {

    private TabLayout journalTab;
    private ViewPager journalVp;
    private ArrayList<String> list_tab=new ArrayList<>();
    private ArrayList<Fragment> list_fragment=new ArrayList<>();
    private ImageView homeToobarList;
    private JournalismTabAdapter journalismTabAdapter;

    @Override
    protected int bandLayout() {
        return R.layout.fragment_journalism;
    }
    @Override
    protected void initEvent() {

    }
    @Override
    protected void initData(Bundle savedInstanceState) {

        list_tab.add("育儿");
        list_tab.add("手机");
        list_tab.add("政务");
        list_tab.add("文化");
        list_tab.add("情感");
        list_tab.add("电影");



        list_fragment.add(new BringUpFragment());
        list_fragment.add(new PhoneFragment());
        list_fragment.add(new GovernmentFragment());
        list_fragment.add(new CultureFragment());
        list_fragment.add(new EmotionFragment());
        list_fragment.add(new FilmMovieFragment());

        journalismTabAdapter=new JournalismTabAdapter(getFragmentManager(),list_fragment,list_tab);
        journalVp.setAdapter(journalismTabAdapter);
        journalTab.setupWithViewPager(journalVp);




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