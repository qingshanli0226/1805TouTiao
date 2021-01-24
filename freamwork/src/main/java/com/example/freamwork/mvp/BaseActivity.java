package com.example.freamwork.mvp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bandLayout());
        initView();
        initData();
        initEvent();
    }
    protected abstract void initView();//初始化控件
    protected abstract void initData();//加载数据
    protected abstract void initEvent();//点击事件
    protected abstract int bandLayout();//加载布局

    public void Ts(String msg){//封装吐司
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}