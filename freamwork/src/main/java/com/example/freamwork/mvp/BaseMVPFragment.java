package com.example.freamwork.mvp;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class BaseMVPFragment<P extends IPresenter,V extends IView> extends BaseFragment {

    protected P iPresenter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initPresenter();
        iPresenter.attachView((V)this);
        initPresenterData();
    }

    protected abstract void initPresenterData();

    protected abstract void initPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        iPresenter.detachView();
    }
}
