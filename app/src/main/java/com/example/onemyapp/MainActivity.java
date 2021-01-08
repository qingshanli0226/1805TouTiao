package com.example.onemyapp;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import com.example.framewrok.base.base.BaseActivity;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;


import android.widget.FrameLayout;
import android.widget.ScrollView;

import com.example.framewrok.base.base.BaseActivity;
import com.example.image.ImageFragment;
import com.example.onemyapp.home.fragment.HomeFragment;
import com.example.toutiao.HeadLineFragment;
import com.example.video.VideoFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;


public class MainActivity extends BaseActivity implements OnTabSelectListener {
    public static BottomBar  bottomBar;
    private FragmentTransaction transaction;
    private FragmentManager manager;
    private FrameLayout newsFrameLayout;
    private HomeFragment homeFragment=new HomeFragment();
    private ImageFragment imageFragment=new ImageFragment();
    private VideoFragment videoFragment=new VideoFragment();
    private HeadLineFragment headLineFragment=new HeadLineFragment();
    private ScrollView scroll;



    @Override
    protected int getlayoutId() {
        return R.layout.activity_main;
    }
    @Override
    protected void intView() {
        scroll = (ScrollView) findViewById(R.id.scroll);
        bottomBar = findViewById(R.id.bottomBar);
        newsFrameLayout = findViewById(R.id.newsFrameLayout);
         manager=getSupportFragmentManager();
         transaction = manager.beginTransaction();
        transaction.add(R.id.newsFrameLayout,homeFragment);
        transaction.add(R.id.newsFrameLayout,imageFragment);
        transaction.add(R.id.newsFrameLayout,videoFragment);
        transaction.add(R.id.newsFrameLayout,headLineFragment);
        transaction.commit();
        bottomBar.setOnTabSelectListener(this);
    }

    @Override
    protected void inPresone() {

    }

    @Override
    protected void inData() {

    }

    @Override
    protected void ondestroy() {

    }

    @Override
    public void onTabSelected(int tabId) {
        switch (tabId){
            case R.id.tab_news:
                manager.beginTransaction().hide(imageFragment)
                        .hide(videoFragment)
                        .hide(headLineFragment)
                        .show(homeFragment).commit();
                break;
            case R.id.tab_image:
                manager.beginTransaction().hide(homeFragment)
                        .hide(videoFragment)
                        .hide(headLineFragment)
                        .show(imageFragment).commit();
                break;
            case R.id.tab_video:
                manager.beginTransaction().hide(imageFragment)
                        .hide(homeFragment)
                        .hide(headLineFragment)
                        .show(videoFragment).commit();
                break;
            case R.id.tab_headline:
                manager.beginTransaction().hide(imageFragment)
                        .hide(videoFragment)
                        .hide(homeFragment)
                        .show(headLineFragment).commit();
                break;
        }
    }


}