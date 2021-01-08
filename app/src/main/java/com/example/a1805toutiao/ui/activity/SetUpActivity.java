package com.example.a1805toutiao.ui.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.example.a1805toutiao.R;
import com.example.a1805toutiao.ui.fragment.PreSettingFragment;
import com.example.framework.base.BaseActivity;
import com.example.framework.base.IPresenter;
import com.example.framework.base.IView;
import com.example.framework.view.ToolBar;

public class SetUpActivity extends BaseActivity<IPresenter, IView>{
    private FrameLayout frameSettingLayout;
    private PreSettingFragment preSettingFragment = new PreSettingFragment();
    private ToolBar toolbar;



    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initData() {
        //注册ToolBar监听
        toolbar.setiToolBarClickListenter(this);
    }

    @Override
    protected void initView() {
        //初始化控件
        frameSettingLayout = findViewById(R.id.frame_setting_layout);
        toolbar = findViewById(R.id.toolbar);
        //显示出来
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frame_setting_layout,preSettingFragment).commit();

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_set_up;
    }

    /**
     * 左侧ToolBar点击事件
     */
    @Override
    public void onLeftClick() {
        SetUpActivity.this.finish();
    }

    /**
     * 右侧ToolBar点击事件
     */
    @Override
    public void onRightClick() {

    }
}
