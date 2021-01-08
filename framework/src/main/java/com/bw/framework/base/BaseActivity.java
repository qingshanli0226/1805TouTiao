package com.bw.framework.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bw.framework.mvp.Presenter;

public abstract class BaseActivity<P extends Presenter> extends AppCompatActivity {
       protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
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
