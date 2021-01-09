package com.example.a1805toutiao;


import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.a1805toutiao.news.NewsFragment;
import com.example.a1805toutiao.pictrue.PicFragment;
import com.example.a1805toutiao.toutiao.TouTiaoFragment;
import com.example.a1805toutiao.video.VideoFragment;
import com.example.framework.adapter.FragmentAdapter;
import com.example.framework.base.BaseActivity;
import com.example.framework.helper.BottomNavigationViewHelper;
import com.example.framework.view.TouTiaoViewPager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

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
    TouTiaoViewPager vpMain;
    @BindView(R.id.bottom_main)
    BottomNavigationView bottomMain;
    @BindView(R.id.drawer_main)
    DrawerLayout drawerMain;
    @BindView(R.id.navView)
    NavigationView navView;

    private long exitTime = 0;
    private FragmentAdapter fragmentAdapter;
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initListener() {
        bottomMain.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_news:
                        vpMain.setCurrentItem(0);
                        toolbarTitle.setText(R.string.title_home);
                        break;
                    case R.id.action_photo:
                        vpMain.setCurrentItem(1);
                        toolbarTitle.setText(R.string.title_photo);
                        break;
                    case R.id.action_video:
                        vpMain.setCurrentItem(2);
                        toolbarTitle.setText(R.string.title_video);
                        break;
                    case R.id.action_media:
                        vpMain.setCurrentItem(3);
                        toolbarTitle.setText(R.string.title_media);
                        break;
                }
                return true;
            }
        });
        toolbarLeftIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerMain.openDrawer(Gravity.LEFT, true);
            }
        });
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.navMenuSwitchNightMode:
                        Toast.makeText(MainActivity.this, "点击", Toast.LENGTH_SHORT).show();
                        int mode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
                        if (mode == Configuration.UI_MODE_NIGHT_YES) {

                        }

                        return false;

                    case R.id.navMenuSetting:
                        Toast.makeText(MainActivity.this, "2", Toast.LENGTH_SHORT).show();
                        drawerMain.closeDrawers();
                        return false;
                    case R.id.navMenuShare:
                        Toast.makeText(MainActivity.this, "3", Toast.LENGTH_SHORT).show();
                        drawerMain.closeDrawers();
                        return false;
                }
                return false;
            }
        });
    }

    @Override
    protected void initData() {

        toolbarTitle.setText(R.string.title_home);

    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        toolbarLeftIv.setImageResource(R.drawable.list);
        toolbarRightIv.setImageResource(R.drawable.search);
        toolbar.setBackgroundResource(R.color.themeColor);
        BottomNavigationViewHelper.disableShiftMode(bottomMain);
        vpMain.setCanScroll(false);
        vpMain.setOffscreenPageLimit(4);
        fragments.add(new NewsFragment());
        fragments.add(new PicFragment());
        fragments.add(new VideoFragment());
        fragments.add(new TouTiaoFragment());
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments);
        vpMain.setAdapter(fragmentAdapter);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,drawerMain,R.string.navigation_drawer_open,R.string.navigation_drawer_close
        );
        drawerMain.addDrawerListener(toggle);

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
    public void onBackPressed() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - exitTime < 2000) {
            super.onBackPressed();
        } else {
            Toast.makeText(this, R.string.double_click_exit, Toast.LENGTH_SHORT).show();
            exitTime = currentTimeMillis;
        }
    }


}