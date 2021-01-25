package com.example.framework.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract
class BaseLazyLoadFragment<P extends IPresenter,V extends IView> extends BaseFragment<P,V> {
    /**
     * 是否初可见
     */
    protected boolean isShow = false;

    /**
     * 是否初始化
     */
    protected  boolean isVisibkleToUser;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isShow = isVisibleToUser;
        showLoadData();
    }

    private void showLoadData(){
        if (isVisibkleToUser&&isShow){
            initData();
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isVisibkleToUser = true;
        showLoadData();
    }


}
