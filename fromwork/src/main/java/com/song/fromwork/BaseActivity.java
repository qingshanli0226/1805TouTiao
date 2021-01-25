package com.song.fromwork;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;

import com.song.common.ErrorBean;
import com.song.common.LoadingPage;
import com.song.common.MyToolBar;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.AutoDisposeConverter;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

public abstract class BaseActivity extends AppCompatActivity implements MyToolBar.IToolBarClickListner {

    protected MyToolBar myToolBar;
    private LoadingPage loadingPage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadingPage = new LoadingPage(this) {
            @Override
            protected int getSuccessLayoutId() {
                return layoutId();
            }
        };
        setContentView(layoutId());
        initView();
        myToolBar = findViewById(R.id.toolBar);
        myToolBar.setToolBarClickListner(this);
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int layoutId();

    @Override
    public void onLeftClick() {
        finish();
    }

    @Override
    public void onRightClick() {

    }

    public void showLoading() {
        loadingPage.showLoadingView();
    }

    public void hideLoadingPage(boolean isSuccess, ErrorBean errorBean) {
        if (isSuccess) {
            showSuccess();
        } else {
            showError(errorBean.getErrorMessage());
        }
    }

    public void showError(String errorMessage) {
        loadingPage.showErrorView(errorMessage);
    }

    public void showSuccess() {
        loadingPage.showEmptyView();
    }

    public <X> AutoDisposeConverter<X> bindAutoDispose() {
        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider
                .from(this, Lifecycle.Event.ON_DESTROY));
    }

}
