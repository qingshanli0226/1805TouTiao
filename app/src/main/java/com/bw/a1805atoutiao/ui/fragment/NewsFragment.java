package com.bw.a1805atoutiao.ui.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bw.a1805atoutiao.R;
import com.bw.a1805atoutiao.adapter.HomeFragmentAdapter;
import com.bw.a1805atoutiao.ui.fragment.newsframent.LoadFragment;
import com.bw.framework.base.BaseFragment;
import com.flyco.tablayout.CommonTabLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends BaseFragment {

    private CommonTabLayout newsCommon;
    private ImageView addTag;
    private ViewPager newViewpager;
    private List<String> titles=new ArrayList<>();
    private TabLayout tavlayout;
    private List<Fragment> fragments=new ArrayList<>();
    private HomeFragmentAdapter homeFragmentAdapter;
    @Override
    protected void initEvent() {


        tavlayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Toast.makeText(getContext(), ""+position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected void initData() {
         titles.add("视频");
         titles.add("问答");
         titles.add("社会");
         titles.add("娱乐");
         titles.add("汽车");
         titles.add("热点");
         titles.add("房产");
         titles.add("体育");

            for (int i = 0; i <titles.size() ; i++) {
                 fragments.add(new LoadFragment());
            }


        homeFragmentAdapter=new HomeFragmentAdapter(getChildFragmentManager(),fragments,titles);
        newViewpager.setAdapter(homeFragmentAdapter);
        tavlayout.setupWithViewPager(newViewpager);




    }

    @Override
    protected void initView(View view) {



        addTag = view.findViewById(R.id.add_tag);
        newViewpager = view.findViewById(R.id.new_viewpager);

        tavlayout = view.findViewById(R.id.tavlayout);

    }

    @Override
    protected int getlayoutid() {
        return R.layout.fragment_news;
    }

    @Override
    protected void createPresenter() {

    }


}
