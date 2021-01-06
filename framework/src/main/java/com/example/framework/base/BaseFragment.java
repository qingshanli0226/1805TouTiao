package com.example.framework.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment<P extends IPresenter,V extends IView> extends Fragment {

    protected P httpPresenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        return getLayoutId();

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initPresenter();
        if (httpPresenter!=null){
            httpPresenter.attachView((V)this);
        }
        initData();
    }
    protected abstract View getLayoutId();

    protected abstract void initData();

    protected abstract void initPresenter();

    protected abstract void initView();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (httpPresenter!=null){
            httpPresenter.detachView();
        }
    }
}
