 package com.example.sevenlandh.activity;


import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.drawerlayout.widget.DrawerLayout;

import com.example.freamwork.mvp.BaseActivity;
import com.example.sevenlandh.R;
import com.example.sevenlandh.entity.HomeTabDownEntity;
import com.example.sevenlandh.fragment.home.HeadlineFragment;
import com.example.sevenlandh.fragment.home.ImageFragment;
import com.example.sevenlandh.fragment.home.JournalismFragment;
import com.example.sevenlandh.fragment.home.VideoFragment;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

 public class HomeActivity extends BaseActivity {

     private CommonTabLayout homeCommons;
     private ArrayList<CustomTabEntity> list_tab=new ArrayList<>();
     private FrameLayout homeFrame;
     private JournalismFragment journalismFragment;
     private ImageFragment imageFragment;
     private VideoFragment videoFragment;
     private HeadlineFragment headlineFragment;
     private DrawerLayout drawer;
     private boolean bok = true;
     @Override
     protected void onStart() {
         super.onStart();
     }
     private TextView homeset;
     private TextView homeswitch;
     private TextView homeshare;

     @Override
     protected void onDestroy() {
         super.onDestroy();
         EventBus.getDefault().unregister(this);
     }
     @Override
     protected void initView() {
         EventBus.getDefault().register(this);
         homeCommons = findViewById(R.id.home_commons);
         homeFrame = findViewById(R.id.home_frame);
         drawer = (DrawerLayout) findViewById(R.id.drawer);
         homeset = (TextView) findViewById(R.id.homeset);
         homeswitch = (TextView) findViewById(R.id.homeswitch);
         homeshare = (TextView) findViewById(R.id.homeshare);
         slideOver();
         list_tab.add(new HomeTabDownEntity("新闻",R.mipmap.select_1,R.mipmap.default_1));
         list_tab.add(new HomeTabDownEntity("图片",R.mipmap.select_2,R.mipmap.default_2));
         list_tab.add(new HomeTabDownEntity("视频",R.mipmap.select_3,R.mipmap.default_3));
         list_tab.add(new HomeTabDownEntity("头条号",R.mipmap.select_4,R.mipmap.default_4));
         homeCommons.setTabData(list_tab);

         journalismFragment=new JournalismFragment();
         imageFragment=new ImageFragment();
         videoFragment=new VideoFragment();
         headlineFragment=new HeadlineFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.home_frame,journalismFragment)
                .add(R.id.home_frame,imageFragment)
                .add(R.id.home_frame,videoFragment)
                .add(R.id.home_frame,headlineFragment)
                .hide(imageFragment)
                .hide(videoFragment)
                .hide(headlineFragment)
                .show(journalismFragment)
                .commit();
     }
    //侧拉点击事件
     private void slideOver() {
         homeset.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText(HomeActivity.this, "设置", Toast.LENGTH_SHORT).show();
             }
         });
         homeswitch.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText(HomeActivity.this, "切换主题", Toast.LENGTH_SHORT).show();
             }
         });
         homeshare.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText(HomeActivity.this, "分享", Toast.LENGTH_SHORT).show();
             }
         });
     }

     @Override
     protected void initData() {
     }
     @Override
     protected void initEvent() {
         homeCommons.setOnTabSelectListener(new OnTabSelectListener() {
             @Override
             public void onTabSelect(int position) {
                 switch (position){
                     case 0:
                         getSupportFragmentManager().beginTransaction()
                                 .show(journalismFragment)
                                 .hide(imageFragment)
                                 .hide(videoFragment)
                                 .hide(headlineFragment)
                                 .commit();
                         break;
                     case 1:
                         getSupportFragmentManager().beginTransaction()
                                 .show(imageFragment)
                                 .hide(journalismFragment)
                                 .hide(videoFragment)
                                 .hide(headlineFragment)
                                 .commit();
                         break;
                     case 2:
                         getSupportFragmentManager().beginTransaction()
                                 .show(videoFragment)
                                 .hide(imageFragment)
                                 .hide(journalismFragment)
                                 .hide(headlineFragment)
                                 .commit();
                         break;
                     case 3:
                         getSupportFragmentManager().beginTransaction()
                                 .show(headlineFragment)
                                 .hide(imageFragment)
                                 .hide(videoFragment)
                                 .hide(journalismFragment)
                                 .commit();
                         break;
                 }
             }
             @Override
             public void onTabReselect(int position) {
             }
         });
     }
     @Override
     protected int bandLayout() {
         return R.layout.activity_home;
     }
     //Eventbus点击显示侧拉菜单
     @Subscribe(sticky = true,threadMode = ThreadMode.MAIN)
     public void onEvent(String msg){
         if (msg.equals("0")){
            drawer.openDrawer(Gravity.LEFT);
         }else if(msg.equals("8")){//隐藏底部动画
             Log.i("TAG", "onEvent: 8");
             if(homeCommons.getVisibility() == View.GONE){
                 homeCommons.setVisibility(View.GONE);
             }else {
                 Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.anim_out);
                 animation1.setAnimationListener(new Animation.AnimationListener() {
                     @Override
                     public void onAnimationStart(Animation animation) {
                     }
                     @Override
                     public void onAnimationEnd(Animation animation) {
                         homeCommons.setVisibility(View.GONE);
                         animation.cancel();
                     }
                     @Override
                     public void onAnimationRepeat(Animation animation) {
                     }
                 });
                 homeCommons.startAnimation(animation1);
             }
         }else if(msg.equals("6")){//显示底部动画
             Log.i("TAG", "onEvent: 6");
             if(homeCommons.getVisibility() == View.VISIBLE){
                 homeCommons.setVisibility(View.VISIBLE);
             }else {
                 Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_in);
                 animation.setAnimationListener(new Animation.AnimationListener() {
                     @Override
                     public void onAnimationStart(Animation animation) {

                     }
                     @Override
                     public void onAnimationEnd(Animation animation) {
                         homeCommons.setVisibility(View.VISIBLE);
                         animation.cancel();
                     }
                     @Override
                     public void onAnimationRepeat(Animation animation) {
                     }
                 });
                 homeCommons.startAnimation(animation);
             }
         }
     }
 }