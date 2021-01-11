package com.bw.a1805atoutiao.ui.fragment;

import android.view.View;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bw.a1805atoutiao.R;
import com.bw.a1805atoutiao.adapter.HomeFragmentAdapter;
import com.bw.a1805atoutiao.ui.fragment.newsframent.LoadFragment;
import com.bw.framework.base.BaseFragment;
import com.bw.framework.bean.TitleBean;
import com.bw.framework.manage.TitleManage;
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



        //fragment滑动监听
        newViewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

        }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void initData() {
        for (TitleBean showTitleBean : TitleManage.getInstance().getShowTitleBeans()) {
              titles.add(showTitleBean.getTitle());
        }
        if (titles.size()!=0){
            for (int i = 0; i <titles.size() ; i++) {
                fragments.add(new LoadFragment());
            }

            homeFragmentAdapter=new HomeFragmentAdapter(getChildFragmentManager(),fragments,titles);
            newViewpager.setAdapter(homeFragmentAdapter);
            tavlayout.setupWithViewPager(newViewpager);

        }





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
