package com.example.ui.fragment.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.framework.base.BaseLazyFragment;
import com.example.framework.base.BaseMVPFragment;
import com.example.framework.base.IPresenter;
import com.example.framework.base.IView;
import com.example.ui.fragment.contract.VideoContract;
import com.example.ui.fragment.presenter.VideoPresenter;
import com.example.viedeo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoThemFragment extends BaseMVPFragment<VideoPresenter,VideoContract.IVideoView> implements VideoContract.IVideoView {


    @Override
    protected void lazyLoadDate() {

    }

    @Override
    protected void initHttpDate() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initDate() {
        super.initDate();
    }

    @Override
    protected int getlayoutids() {
        return R.layout.fragment_video_them;
    }

    @Override
    public void onvideo() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void showError(String message) {
        showerror(message);
    }

    @Override
    public void showEmpty() {
        showEmpty();
    }

    @Override
    public void showLoading() {
        showloading();
    }

    @Override
    public void hidesLoading() {
        hideLoading();
    }
}
