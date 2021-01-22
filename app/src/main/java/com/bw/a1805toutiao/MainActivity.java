package com.bw.a1805toutiao;



import android.graphics.Color;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bw.framework.ToolBar;
import com.bw.framework.base.BaseActivity;
import com.bw.framework.base.BasePresenter;
import com.bw.framework.base.IView;
import com.bw.home.NewsFragment;
import com.bw.image.ImageFragment;
import com.bw.toutiao.TouFragment;
import com.bw.video.VideoFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;


public class MainActivity extends BaseActivity<IView, BasePresenter> {

    private FrameLayout frameLayout;
    private RadioGroup group;
    private RadioButton homeBtn;
    private RadioButton imageBtn;
    private RadioButton videoBtn;
    private RadioButton touBtn;
    private NewsFragment newsFragment;
    private VideoFragment videoFragment;
    private ImageFragment imageFragment;
    private TouFragment touFragment;
    private SlidingMenu slidingMenu;
    private ToolBar toolbar;


    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {
        toolbar = findViewById(R.id.toolbar);
        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        group = (RadioGroup) findViewById(R.id.group);
        homeBtn = (RadioButton) findViewById(R.id.homeBtn);
        imageBtn = (RadioButton) findViewById(R.id.imageBtn);
        videoBtn = (RadioButton) findViewById(R.id.videoBtn);
        touBtn = (RadioButton) findViewById(R.id.touBtn);

        newsFragment = new NewsFragment();
        imageFragment = new ImageFragment();
        videoFragment = new VideoFragment();
        touFragment = new TouFragment();

        toolbar.setToolBarTitleColor(Color.WHITE);

        showSlidingView();

        addFragment();

        showOneFragment();

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.homeBtn:
                        showOneFragment();
                        break;
                    case R.id.imageBtn:
                        showTwoFragment();
                        break;
                    case R.id.videoBtn:
                        showThreeFragment();
                        break;
                    case R.id.touBtn:
                        showFourFragment();
                        break;
                }
            }
        });
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void createPresenter() {

    }

    @Override
    protected int getlayoutid() {
        return R.layout.activity_main;
    }


    private void showSlidingView() {
        slidingMenu = new SlidingMenu(MainActivity.this);
        View slidingView = getLayoutInflater().inflate(R.layout.sliding_layout, null);
        slidingMenu.setContent(slidingView);
        slidingMenu.attachToActivity(MainActivity.this,SlidingMenu.SLIDING_WINDOW);
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setBehindOffset(300);

    }

    private void showOneFragment() {
        getSupportFragmentManager().beginTransaction()
                .show(newsFragment)
                .hide(imageFragment)
                .hide(videoFragment)
                .hide(touFragment)
                .commit();
    }

    private void showTwoFragment() {
        getSupportFragmentManager().beginTransaction()
                .show(imageFragment)
                .hide(newsFragment)
                .hide(videoFragment)
                .hide(touFragment)
                .commit();
    }

    private void showThreeFragment() {
        getSupportFragmentManager().beginTransaction()
                .show(videoFragment)
                .hide(imageFragment)
                .hide(newsFragment)
                .hide(touFragment)
                .commit();
    }

    private void showFourFragment() {
        getSupportFragmentManager().beginTransaction()
                .show(touFragment)
                .hide(imageFragment)
                .hide(videoFragment)
                .hide(newsFragment)
                .commit();
    }

    private void addFragment() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frameLayout,newsFragment)
                .add(R.id.frameLayout,imageFragment)
                .add(R.id.frameLayout,videoFragment)
                .add(R.id.frameLayout,touFragment)
                .commit();
    }


}
