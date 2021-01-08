package com.example.a1805toutiao;


import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
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

    private FragmentAdapter fragmentAdapter;
    private List<Fragment> fragments=new ArrayList<>();
    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initListener() {
        bottomMain.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_news:
                        vpMain.setCurrentItem(0);
                        toolbarTitle.setText("头条");
                        break;
                    case R.id.action_photo:
                        vpMain.setCurrentItem(1);
                        toolbarTitle.setText("图片");
                        break;
                    case R.id.action_video:
                        vpMain.setCurrentItem(2);
                        toolbarTitle.setText("视频");
                        break;
                    case R.id.action_media:
                        vpMain.setCurrentItem(3);
                        toolbarTitle.setText("头条号");
                        break;
                }
                return true;
            }
        });
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
        vpMain.setCanScroll(false);
        vpMain.setOffscreenPageLimit(4);
        fragments.add(new NewsFragment());
        fragments.add(new PicFragment());
        fragments.add(new VideoFragment());
        fragments.add(new TouTiaoFragment());
        fragmentAdapter=new FragmentAdapter(getSupportFragmentManager(),fragments);
        vpMain.setAdapter(fragmentAdapter);
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

}