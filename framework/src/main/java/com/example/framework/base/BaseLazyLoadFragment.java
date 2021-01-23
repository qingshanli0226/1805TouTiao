package com.example.framework.base;

import android.os.Bundle;

import androidx.annotation.Nullable;

public abstract
class BaseLazyLoadFragment<P extends IPresenter,V extends IView> extends BaseFragment<P,V> {
    /**
     * 是否初始化布局
     */
    protected boolean IsViewInitiated;

    /**
     * 当前界面是否可见
     */
    protected  boolean isVisibkleToUser;
    /**
     * 是否加载过数据
     */

    protected boolean isDataInitIated;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isDataInitIated = true;
        prepareFetchData();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibkleToUser = isVisibleToUser;
        if (isVisibleToUser){
            prepareFetchData();
        }
    }

    /**
     * 数据初始化时开始执行次方法
     */
    public  void prepareFetchData(){prepareFetchData(false);}

    public void prepareFetchData(boolean forceUpdate) {
        if (isVisibkleToUser && IsViewInitiated && (!isDataInitIated || forceUpdate)) {
            fetchLazyData();
            isDataInitIated = true;
        }
    }


    protected abstract void fetchLazyData();
}
