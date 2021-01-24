package com.example.image;

import android.os.Handler;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.framewrok.base.base.BaseFragment;
import com.example.image.adapter.ContentPagerAdapter;
import com.example.image.fragment.AllFragment;
import com.example.image.fragment.CameraFragment;
import com.example.image.fragment.OldPictureFragment;
import com.example.image.fragment.StoryFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ImageFragment extends BaseFragment {
    private TabLayout HeadTabLayout;
    private List<String> HeadImgString=new ArrayList<>();
    private ViewPager ContentViewPager;
    private List<Fragment> fragments=new ArrayList<>();
    private AllFragment allFragment=new AllFragment();
    private OldPictureFragment  oldPictureFragment=new OldPictureFragment();
    private StoryFragment storyFragment=new StoryFragment();
    private CameraFragment cameraFragment=new CameraFragment();
    private ContentPagerAdapter contentPagerAdapter;
    @Override
    protected void onregister() {

    }

    @Override
    protected int getLayoutid() {
        return R.layout.imagefragment;
    }

    @Override
    protected void intView(View view) {
        HeadTabLayout = view.findViewById(R.id.HeadTabLayout);
        HeadImgString.add("全部");
        HeadImgString.add("老图片");
        HeadImgString.add("故事");
        HeadImgString.add("摄影集");
        ContentViewPager = view.findViewById(R.id.ContentViewPager);
        fragments.add(allFragment);
        fragments.add(oldPictureFragment);
        fragments.add(storyFragment);
        fragments.add(cameraFragment);
        contentPagerAdapter=new ContentPagerAdapter(getChildFragmentManager(),fragments,HeadImgString);
        ContentViewPager.setAdapter(contentPagerAdapter);
        HeadTabLayout.setupWithViewPager(ContentViewPager);
        HeadTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }

    @Override
    protected void inPresone() {

    }

    @Override
    protected void inData() {

    }

    @Override
    protected void onstart() {

    }

    @Override
    protected void onstop() {

    }

    @Override
    protected void ondestroy() {

    }
}
