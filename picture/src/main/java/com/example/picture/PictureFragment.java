package com.example.picture;


import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.framework.base.BaseFragment;
import com.example.picture.adpter.FragmentAdpter;
import com.example.picture.fragment.view.AllFragmentFragment;
import com.example.picture.fragment.OldPictureFragment;
import com.example.picture.fragment.PhotoGraphyFragment;
import com.example.picture.fragment.StoryPictureFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class PictureFragment extends BaseFragment {
    private TabLayout pictureTab;
    private ViewPager vrPicture;
    private List<String> stringList = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();
    private FragmentAdpter fragmentAdpter;
    private AllFragmentFragment allFragmentFragment = new AllFragmentFragment();
    private OldPictureFragment oldPictureFragment = new OldPictureFragment();
    private StoryPictureFragment storyPictureFragment = new StoryPictureFragment();
    private PhotoGraphyFragment photoGraphyFragment = new PhotoGraphyFragment();
    @Override
    protected void initDate() {
        //tab的集合添加
        stringList.add("全部");
        stringList.add("故事照片");
        stringList.add("老照片");
        stringList.add("摄影集");
        //Fragment集合添加
        fragmentList.add(allFragmentFragment);
        fragmentList.add(oldPictureFragment);
        fragmentList.add(storyPictureFragment);
        fragmentList.add(photoGraphyFragment);
        //viewPager适配
        fragmentAdpter = new FragmentAdpter(getChildFragmentManager(),fragmentList,stringList);
        vrPicture.setAdapter(fragmentAdpter);
        pictureTab.setupWithViewPager(vrPicture);

    }

    @Override
    protected void initView() {
        pictureTab = findViewById(R.id.picture_tab);
        vrPicture = findViewById(R.id.vr_picture);
    }

    @Override
    protected int getlayoutids() {
        return R.layout.fragment_picture;
    }
}
