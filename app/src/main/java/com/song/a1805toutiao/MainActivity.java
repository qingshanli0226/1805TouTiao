package com.song.a1805toutiao;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.song.a1805toutiao.entity.CommonEntity;
import com.song.common.FragmentAdapter;
import com.song.common.MyToolBar;
import com.song.common.MyViewPager;
import com.song.fromwork.BaseActivity;
import com.song.net.mode.RoutePath;
import com.song.news.NewsFragment;

import java.util.ArrayList;
import java.util.List;

@Route(path = "/main/MainActivity")
public class MainActivity extends BaseActivity implements MyToolBar.IToolBarClickListner, View.OnClickListener {

    private MyViewPager mainViewpager;
    private CommonTabLayout mainCommon;
    private LinearLayout navView;
    private DrawerLayout drawerLayout;
    private List<Fragment> fragmentList = new ArrayList<>();
    private FragmentAdapter adapter;
    private ArrayList<CustomTabEntity> commonList = new ArrayList<>();
    private Button btSwitchThemes;
    private Button btSetting;
    private Button btShare;


    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mainViewpager = findViewById(R.id.main_viewpager);
        mainCommon = findViewById(R.id.main_common);
        drawerLayout = findViewById(R.id.drawer_layout);
        navView = findViewById(R.id.navView);
        btSwitchThemes = findViewById(R.id.bt_switch_themes);
        btSetting = findViewById(R.id.bt_setting);
        btShare = findViewById(R.id.bt_share);

        btSwitchThemes.setOnClickListener(this);
        btSetting.setOnClickListener(this);
        btShare.setOnClickListener(this);

        fragmentList.add(new NewsFragment());
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
    public void onRightClick() {

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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_switch_themes:
                Toast.makeText(this, "切换主题", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_setting:
                ARouter.getInstance().inject(MainActivity.this);
                ARouter.getInstance().build(RoutePath.SETTINGACTIVITY).navigation();
                break;
            case R.id.bt_share:
                break;
        }
    }
}
