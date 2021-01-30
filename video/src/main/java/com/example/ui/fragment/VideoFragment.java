package com.example.ui.fragment;


import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.adpter.FragmentAdpter;
import com.example.ui.fragment.view.VideoThemFragment;
import com.example.framework.base.BaseFragment;
import com.example.viedeo.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class VideoFragment extends BaseFragment{
    private TabLayout videoTab;
    private ViewPager vrVideo;
    private List<String> stringList = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();
    private FragmentAdpter fragmentAdpter;
    @Override
    protected void initDate() {
        String[] stringArray = getActivity().getResources().getStringArray(R.array.mobile_video_name);
        for (int i = 0; i < stringArray.length; i++) {
            stringList.add(stringArray[i]);
            fragmentList.add(new VideoThemFragment());
        }
        fragmentAdpter = new FragmentAdpter(getChildFragmentManager(),fragmentList,stringList);
        vrVideo.setAdapter(fragmentAdpter);
        videoTab.setupWithViewPager(vrVideo);
    }

    @Override
    protected void initView() {
        //初始化控件
        videoTab = findViewById(R.id.videoTab);
        vrVideo = findViewById(R.id.vr_video);
    }

    @Override
    protected int getlayoutids() {
        return R.layout.fragment_video;
    }
}
