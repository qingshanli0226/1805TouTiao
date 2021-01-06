package com.example.freamwork.mvp;

import android.os.Bundle;

import androidx.annotation.Nullable;

public abstract class BaseMVPActivity<P extends IPresenter,V extends IView> extends BaseActivity {

    protected P iPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bandLayout());
        initPresenter();
        iPresenter.attachView((V)this);
        initPresenterData();
    }

    protected abstract void initPresenterData();//获取p层数据

    protected abstract void initPresenter();//初始化p层实例

    @Override
    protected void onDestroy() {
        super.onDestroy();
        iPresenter.detachView();
    }
}
