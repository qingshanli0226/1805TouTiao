package com.bw.a1805atoutiao.ui.activity;

import android.app.FragmentTransaction;
import com.bw.a1805atoutiao.R;
import com.bw.framework.base.BaseActivity;

public class SettingActivity extends BaseActivity {


    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.setting_framelayout,new PreferenFragment()).commit();
    }

    @Override
    protected void createPresenter() {

    }

    @Override
    protected int getlayoutid() {
        return R.layout.activity_setting;
    }
}
