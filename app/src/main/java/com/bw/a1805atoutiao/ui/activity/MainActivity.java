package com.bw.a1805atoutiao.ui.activity;


import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.bw.a1805atoutiao.R;
import com.bw.a1805atoutiao.ui.fragment.HeadLineFragment;
import com.bw.a1805atoutiao.ui.fragment.ImageFragment;
import com.bw.a1805atoutiao.ui.fragment.NewsFragment;
import com.bw.a1805atoutiao.ui.fragment.VideoFragment;
import com.bw.bean.CusTab;
import com.bw.framework.base.BaseActivity;
import com.bw.framework.bean.TitleBean;
import com.bw.framework.manage.TitleManage;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    private Toolbar toobar;
    private CommonTabLayout common;
    private ArrayList<CustomTabEntity> custom=new ArrayList<>();
    private NewsFragment newsFragment;
    private ImageFragment imageFragment;
    private VideoFragment videoFragment;
    private HeadLineFragment headLineFragment;
    private DrawerLayout draw;
    @Override
    protected void initEvent() {
           toobar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
               @Override
               public boolean onMenuItemClick(MenuItem item) {
                   Toast.makeText(MainActivity.this, "搜索", Toast.LENGTH_SHORT).show();
                   return false;
               }
           });

           //打开抽屉侧滑
           toobar.setNavigationOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                     draw.openDrawer(Gravity.LEFT);
               }
           });
    }

    @Override
    protected void initData() {

        for (TitleBean dataTitleBean : TitleManage.getInstance().getDataTitleBeans()) {
            Log.e("titleAll",dataTitleBean.getId()+" "+dataTitleBean.getTitle()+"  "+dataTitleBean.getUrl()+"  "+dataTitleBean.getIsShow());
        }

        //设置NavigationIcon
        toobar.setNavigationIcon(R.mipmap.novelty_icon_edit_normal);
        //设置主标题
        toobar.setTitle(R.string.news_name);
        toobar.setTitleTextColor(Color.WHITE);
        //设置menu
        toobar.inflateMenu(R.menu.serch_menu);

            custom.add(new CusTab("新闻",R.drawable.ic_newspaper_white_24dp,R.drawable.ic_newspaper_blue_24dp));
            custom.add(new CusTab("图片",R.drawable.ic_gallery_white_24dp,R.drawable.ic_gallery_blue_24dp));
            custom.add(new CusTab("视频",R.drawable.ic_youtube_white_24dp,R.drawable.ic_youtube_blue_24dp));
            custom.add(new CusTab("头条号",R.drawable.ic_library_books_white_24dp,R.drawable.ic_gallery_blue_24dp));
            common.setTabData(custom);


        newsFragment=new NewsFragment();
        imageFragment=new ImageFragment();
        videoFragment=new VideoFragment();
        headLineFragment=new HeadLineFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.home_frame,newsFragment)
                .add(R.id.home_frame,imageFragment)
                .add(R.id.home_frame,videoFragment)
                .add(R.id.home_frame,headLineFragment)
                .commit();
        showfragment(newsFragment);
       common.setOnTabSelectListener(new OnTabSelectListener() {
           @Override
           public void onTabSelect(int position) {
                switch (position){
                    case 0:
                        showfragment(newsFragment);
                        toobar.setTitle(R.string.news_name);
                        break;
                    case 1:
                        showfragment(imageFragment);
                        toobar.setTitle(R.string.image_name);
                        break;
                    case 2:
                        showfragment(videoFragment);
                        toobar.setTitle(R.string.video_name);
                        break;
                    case 3:
                        showfragment(headLineFragment);
                        toobar.setTitle(R.string.headline_name);
                        break;
                }
           }

           @Override
           public void onTabReselect(int position) {

           }
       });


    }

    @Override
    protected void initView() {

        toobar = findViewById(R.id.toobar);

        common = findViewById(R.id.common);

        draw = findViewById(R.id.draw);


    }

    @Override
    protected void createPresenter() {

    }

    @Override
    protected int getlayoutid() {
        return R.layout.activity_main;
    }


    private void showfragment(Fragment fragment){
         getSupportFragmentManager().beginTransaction()
                 .hide(newsFragment)
                 .hide(imageFragment)
                 .hide(videoFragment)
                 .hide(headLineFragment)
                 .show(fragment)
                 .commit();
    }

}