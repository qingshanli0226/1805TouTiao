package com.song.a1805toutiao;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.song.a1805toutiao.entity.CommonEntity;
import com.song.common.MyToolBar;
import com.song.fromwork.BaseActivity;
import com.song.net.mode.RoutePath;
import com.song.news.NewsFragment;

import java.util.ArrayList;

@Route(path = "/main/MainActivity")
public class MainActivity extends BaseActivity implements MyToolBar.IToolBarClickListner, View.OnClickListener {

    private CommonTabLayout mainCommon;
    private LinearLayout linearLayout;
    private DrawerLayout drawerLayout;
    private ArrayList<CustomTabEntity> commonList = new ArrayList<>();
    private Button btSwitchThemes;
    private Button btSetting;
    private Button btShare;

    private Fragment[] fragments = new Fragment[]{new NewsFragment(),new BlankFragment(),new BlankFragment(),new BlankFragment()};
    private Fragment showFragment;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mainCommon = findViewById(R.id.main_common);
        drawerLayout = findViewById(R.id.drawer_layout);
        linearLayout = findViewById(R.id.navView);
        btSwitchThemes = findViewById(R.id.bt_switch_themes);
        btSetting = findViewById(R.id.bt_setting);
        btShare = findViewById(R.id.bt_share);

        btSwitchThemes.setOnClickListener(this);
        btSetting.setOnClickListener(this);
        btShare.setOnClickListener(this);

        commonList.add(new CommonEntity("新闻", R.drawable.ic_newspaper_blue_24dp, R.drawable.ic_newspaper_white_24dp));
        commonList.add(new CommonEntity("图片", R.drawable.ic_gallery_blue_24dp, R.drawable.ic_gallery_white_24dp));
        commonList.add(new CommonEntity("视频", R.drawable.ic_youtube_blue_24dp, R.drawable.ic_youtube_white_24dp));
        commonList.add(new CommonEntity("头条号", R.drawable.ic_library_books_blue_24dp, R.drawable.ic_library_books_white_24dp));

        mainCommon.setTabData(commonList);
        mainCommon.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                switchFragment(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        switchFragment(0);
    }

    private void switchFragment(int position) {
        Fragment fragment = fragments[position];
        if (showFragment == fragment) {
            return;
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (showFragment != null) {
            transaction.hide(showFragment);
        }
        if (fragment.isAdded()) {
            transaction.show(fragment).commit();
        } else {
            transaction.add(R.id.main_frameLayout, fragment, fragment.getClass().getSimpleName()).commit();
        }
        showFragment = fragment;
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
        drawerLayout.openDrawer(linearLayout);
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
