package com.example.framework.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.framework.R;
import com.example.framework.view.LogingPage;
import com.example.framework.view.ToolBar;

public abstract class BaseActivity extends AppCompatActivity implements ToolBar.IToolBarClickListenter {
    private LogingPage logingPage;
    private ToolBar toolBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logingPage = new LogingPage(this) {
            @Override
            protected int getlayoutid() {
                return getlayoutids();
            }
        };
        setContentView(getlayoutids());
        initView();
        //初始化ToolBar
        toolBar = findViewById(R.id.toolbar);
        //注册ToolBar
        toolBar.setiToolBarClickListenter(this);
    }
    public void showloading(){
        logingPage.loadingPage();
    }
    public void hideLoading(){
        logingPage.showsucessPage();
    }
    public void showerror(String errorName){
        logingPage.showError(errorName);
    }
    public void showEnpty(){
        logingPage.showEnptyPage();
    }
    protected abstract void initView();

    protected abstract int getlayoutids();

    @Override
    public void onLeftClick() {

    }

    @Override
    public void onRightClick() {

    }
}
