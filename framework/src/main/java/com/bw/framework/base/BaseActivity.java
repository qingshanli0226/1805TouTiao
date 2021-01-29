package com.bw.framework.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.bw.framework.R;
import com.bw.framework.manager.ShareManager;
import com.bw.framework.mvp.Presenter;

public abstract class BaseActivity<P extends Presenter> extends AppCompatActivity {
       protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //夜间模式
        int shareValues = ShareManager.getInstance().getShareValues();
        if (shareValues== R.style.AppTheme_black){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            setTheme(shareValues);
        }else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            setTheme(shareValues);
        }

        super.onCreate(savedInstanceState);
        setContentView(getlayoutid());
        createPresenter();
        initView();
        initData();
        initEvent();
    }

    protected abstract void initEvent();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void createPresenter();

    protected abstract int getlayoutid();


}
