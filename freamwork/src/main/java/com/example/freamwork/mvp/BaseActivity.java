package com.example.freamwork.mvp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bandLayout());
        initView();
        initData();
        initEvent();
    }

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initEvent();

    protected abstract int bandLayout();

}
