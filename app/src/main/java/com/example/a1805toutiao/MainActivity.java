package com.example.a1805toutiao;


import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.example.framework.base.BaseActivity;
import com.example.framework.helper.BottomNavigationViewHelper;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.toolbar_left_iv)
    ImageView toolbarLeftIv;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar_right_iv)
    ImageView toolbarRightIv;
    @BindView(R.id.toolbar)
    AppBarLayout toolbar;
    @BindView(R.id.vp_main)
    ViewPager viewpagerMain;
    @BindView(R.id.bottom_main)
    BottomNavigationView bottomMain;
    @BindView(R.id.drawer_main)
    DrawerLayout drawerMain;

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        toolbarTitle.setText("头条");
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        toolbarLeftIv.setImageResource(R.drawable.list);
        toolbarRightIv.setImageResource(R.drawable.search);
        toolbar.setBackgroundResource(R.color.themeColor);
        BottomNavigationViewHelper.disableShiftMode(bottomMain);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }


    @OnClick({R.id.toolbar_left_iv, R.id.toolbar_right_iv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.toolbar_left_iv:
                break;
            case R.id.toolbar_right_iv:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}