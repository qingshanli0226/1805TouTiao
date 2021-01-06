package com.song.fromwork;

import android.os.Bundle;

import androidx.annotation.Nullable;

public abstract class BaseMVPActivity<P extends IPresenter, V extends IView> extends BaseActivity {

    protected P iHttpPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        initView();
        initPresenter();
        initListener();
        if (iHttpPresenter != null) {
            iHttpPresenter.attach((V) this);
        }
        initData();
    }

    protected abstract void initListener();

    protected abstract void initPresenter();

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected abstract int layoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroy();
        if (iHttpPresenter != null) {
            iHttpPresenter.detach();
        }
    }

    protected void destroy() {

    }
}
