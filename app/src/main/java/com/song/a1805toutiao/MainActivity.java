package com.song.a1805toutiao;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.google.android.material.navigation.NavigationView;
import com.song.a1805toutiao.adapter.FragmentAdapter;
import com.song.a1805toutiao.entity.CommonEntity;
import com.song.common.MyToolBar;
import com.song.common.MyViewPager;
import com.song.fromwork.BaseActivity;



import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements MyToolBar.IToolBarClickListner,NavigationView.OnNavigationItemSelectedListener {

    private MyViewPager mainViewpager;
    private CommonTabLayout mainCommon;
    private NavigationView navView;
    private DrawerLayout drawerLayout;
    private List<Fragment> fragmentList = new ArrayList<>();
    private FragmentAdapter adapter;
    private ArrayList<CustomTabEntity> commonList = new ArrayList<>();



    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mainViewpager = findViewById(R.id.main_viewpager);
        mainCommon = findViewById(R.id.main_common);
        navView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer_layout);

        fragmentList.add(new BlankFragment());
        fragmentList.add(new BlankFragment());
        fragmentList.add(new BlankFragment());
        fragmentList.add(new BlankFragment());

        adapter = new FragmentAdapter(getSupportFragmentManager(), fragmentList);
        mainViewpager.setAdapter(adapter);

        commonList.add(new CommonEntity("新闻", R.drawable.ic_newspaper_blue_24dp, R.drawable.ic_newspaper_white_24dp));
        commonList.add(new CommonEntity("图片", R.drawable.ic_gallery_blue_24dp, R.drawable.ic_gallery_white_24dp));
        commonList.add(new CommonEntity("视频", R.drawable.ic_youtube_blue_24dp, R.drawable.ic_youtube_white_24dp));
        commonList.add(new CommonEntity("头条号", R.drawable.ic_library_books_blue_24dp, R.drawable.ic_library_books_white_24dp));

        mainCommon.setTabData(commonList);
        mainCommon.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mainViewpager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onLeftClick() {
        drawerLayout.openDrawer(navView);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }
}
