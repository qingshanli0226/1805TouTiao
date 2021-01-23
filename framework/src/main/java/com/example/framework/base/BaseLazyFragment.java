package com.example.framework.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Fragment懒加载的基类
 */
public abstract class BaseLazyFragment extends BaseFragment {
    private boolean isVisity = false;//设置标记位，标示当前Fragment是否用户看见
    private boolean isViewCread = false;//设置标记为，标示当前Fragment控件是否初始化完毕

    /**
     * 该方法代表用户是否看见了这个页面
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isVisity = isVisibleToUser;
        prepareLoadDate();
    }

    private void prepareLoadDate() {
        if (isVisity&&isViewCread){
            lazyLoadDate();
        }
    }
    //抽象方法
    protected abstract void lazyLoadDate();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewCread = true;
        prepareLoadDate();
    }

    @Override
    protected void initDate() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getlayoutids() {
        return 0;
    }
}
