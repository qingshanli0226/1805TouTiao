package com.bw.home;

import android.view.View;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bw.framework.base.BaseFragment;
import com.bw.framework.base.BasePresenter;
import com.bw.framework.base.IView;
import com.bw.home.fragment.AnswerFragment;
import com.bw.home.fragment.CarFragment;
import com.bw.home.fragment.HotspotFragment;
import com.bw.home.fragment.RecommenFragment;
import com.bw.home.fragment.RecreationFragment;
import com.bw.home.fragment.ScienceFragment;
import com.bw.home.fragment.SocialFragment;
import com.bw.home.fragment.TVFragment;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends BaseFragment<IView, BasePresenter> {


    private CommonTabLayout commonTab;
    private ViewPager newsViewPager;
    private ArrayList<CustomTabEntity> tobs = new ArrayList<>();
    private List<Fragment> listFragments = new ArrayList<>();
    private MyFragmentAdapter myFragmentAdapter;

    @Override
    protected void initData() {

        myFragmentAdapter = new MyFragmentAdapter(getActivity().getSupportFragmentManager(),listFragments);
        newsViewPager.setAdapter(myFragmentAdapter);

        commonTab.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                newsViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        newsViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                commonTab.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView() {


        listFragments.add(new RecommenFragment());
        listFragments.add(new HotspotFragment());
        listFragments.add(new TVFragment());
        listFragments.add(new SocialFragment());
        listFragments.add(new RecreationFragment());
        listFragments.add(new ScienceFragment());
        listFragments.add(new AnswerFragment());
        listFragments.add(new CarFragment());




        commonTab = (CommonTabLayout) findViewById(R.id.commonTab);
        newsViewPager = (ViewPager) findViewById(R.id.newsViewPager);

        initCommonTab();
    }

    private void initCommonTab() {
        tobs.add(new MyTobBean("推荐",0,0));
        tobs.add(new MyTobBean("热点",0,0));
        tobs.add(new MyTobBean("视频",0,0));
        tobs.add(new MyTobBean("社会",0,0));
        tobs.add(new MyTobBean("娱乐",0,0));
        tobs.add(new MyTobBean("科技",0,0));
        tobs.add(new MyTobBean("问答",0,0));
        tobs.add(new MyTobBean("汽车",0,0));
        commonTab.setTabData(tobs);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news;
    }
}
