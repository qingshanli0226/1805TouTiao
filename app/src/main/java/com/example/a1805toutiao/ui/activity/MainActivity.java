package com.example.a1805toutiao.ui.activity;


import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.a1805toutiao.R;
import com.example.a1805toutiao.entity.TabEntity;
import com.example.framework.base.BaseActivity;
import com.example.framework.base.BaseMVPActivity;
import com.example.framework.base.IPresenter;
import com.example.framework.base.IView;
import com.example.framework.view.ToolBar;
import com.example.headlinenumber.HeadLineNumberFragment;
import com.example.news.NewsFragment;
import com.example.picture.PictureFragment;
import com.example.viedeo.VideoFragment;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;


import java.util.ArrayList;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private SlidingMenu slidingmenu;
    private TextView tvTitle;
    private FrameLayout framelayout;
    private CommonTabLayout common;
    private NewsFragment newsFragment = new NewsFragment();
    private PictureFragment pictureFragment = new PictureFragment();
    private VideoFragment videoFragment = new VideoFragment();
    private HeadLineNumberFragment headLineNumberFragment = new HeadLineNumberFragment();
    private ArrayList<CustomTabEntity> tabEntitys = new ArrayList<>();
    private TextView tvTheme;
    private TextView tvShe;
    private TextView tvFen;
    private void showFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .hide(pictureFragment)
                .hide(videoFragment)
                .hide(headLineNumberFragment)
                .hide(newsFragment)
                .show(fragment)
                .commit();
    }

    /**
     * 初始化控件
     */
    protected void initView() {

        tvTitle = findViewById(R.id.tv_title);
        framelayout = (FrameLayout) findViewById(R.id.framelayout);
        common = (CommonTabLayout) findViewById(R.id.common);
        //slide侧拉菜单
        slidingmenu = new SlidingMenu(MainActivity.this);
        slidingmenu.setMode(SlidingMenu.LEFT);// 左边的侧滑菜单
        slidingmenu.setBehindOffset(400);
        //设置滑动时拖拽效果
        slidingmenu.setBehindScrollScale(0);
        View view = getLayoutInflater().inflate(R.layout.item_silde, null);
        tvTheme = view.findViewById(R.id.tv_theme);
        tvShe = view.findViewById(R.id.tv_she);
        tvFen = view.findViewById(R.id.tv_fen);
        tvTheme.setOnClickListener(this);
        tvShe.setOnClickListener(this);
        tvFen.setOnClickListener(this);
        slidingmenu.setMenu(view);//设置侧滑菜单界面
        slidingmenu.attachToActivity(MainActivity.this, SlidingMenu.SLIDING_CONTENT);// 附加到Activity中
        //将Fragment加入到事务中
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.framelayout,newsFragment);
        fragmentTransaction.add(R.id.framelayout,pictureFragment);
        fragmentTransaction.add(R.id.framelayout,videoFragment);
        fragmentTransaction.add(R.id.framelayout,headLineNumberFragment);
        fragmentTransaction.commit();
        //底部菜单
        tabEntitys.add(new TabEntity("新闻",R.drawable.select_1,R.drawable.default_1));
        tabEntitys.add(new TabEntity("图片",R.drawable.select_2,R.drawable.default_2));
        tabEntitys.add(new TabEntity("视频",R.drawable.select_3,R.drawable.default_3));
        tabEntitys.add(new TabEntity("头条号",R.drawable.select_4,R.drawable.default_4));
        common.setTabData(tabEntitys);
        //默认选中newsFragment
        getSupportFragmentManager().beginTransaction()
                .hide(pictureFragment)
                .hide(videoFragment)
                .hide(headLineNumberFragment)
                .show(newsFragment)
                .commit();
        //点击菜单切换到对应的Fragment
        common.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                switch (position){
                    case 0:
                        tvTitle.setText("新闻");
                        showFragment(newsFragment);
                        break;
                    case 1:
                        tvTitle.setText("图片");
                        showFragment(pictureFragment);
                        break;
                    case 2:
                        tvTitle.setText("视频");
                        showFragment(videoFragment);
                        break;
                    case 3:
                        tvTitle.setText("头条号");
                        showFragment(headLineNumberFragment);
                        break;
                }
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }

    @Override
    protected int getlayoutids() {
        return R.layout.activity_main;
    }


    /**
     * ToolBar左侧图片点击事件
     */
    @Override
    public void onLeftClick() {
        slidingmenu.showMenu();
    }

    /**
     * 图片右侧图片点击事件
     */
    @Override
    public void onRightClick() {

    }

    /**
     * slideMenu 的点击事件
     * @param view
     */
    @Override
    public void onClick(View view) {
        if (view == tvTheme){
            Toast.makeText(this, "主题切换", Toast.LENGTH_SHORT).show();
        }else if (view == tvShe){
            Intent intent = new Intent(MainActivity.this, SetUpActivity.class);
            slidingmenu.toggle();
            startActivity(intent);
        }else if (view ==tvFen){
            Toast.makeText(this, "分享", Toast.LENGTH_SHORT).show();
        }
    }
}
