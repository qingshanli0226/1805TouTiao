package com.example.framework.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * 此类是mvp基类继承Fragment懒加载基类
 * @param <P>
 * @param <V>
 */
public abstract class BaseMVPFragment<P extends IPresenter,V extends IView> extends BaseLazyFragment {

    protected P httpPresenter;



    @Override
    protected void lazyLoadDate() {
        initHttpDate();
    }

    protected abstract void initHttpDate();

    protected abstract void initData();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initPresenter();
        initData();
        if (httpPresenter!=null){
            httpPresenter.attachView((V)this);
        }
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    protected abstract void initPresenter();
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (httpPresenter!=null){
            httpPresenter.detachView();
        }
    }
}
