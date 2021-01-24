package com.example.picture.fragment.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.Constans;
import com.example.framework.base.BaseLazyFragment;
import com.example.framework.base.BaseMVPFragment;
import com.example.picture.R;
import com.example.picture.fragment.contract.PhotoContract;
import com.example.picture.fragment.presenter.PhotoPresenter;

import java.util.HashMap;
import java.util.List;

import bean.ImagesBean;

public class AllFragmentFragment extends BaseMVPFragment<PhotoPresenter, PhotoContract.IPhotoView> implements PhotoContract.IPhotoView {
    private TextView tv;

    @Override
    protected void initHttpDate() {
        HashMap<String,String> map = new HashMap<>();
        map.put("as","A115C8457F69B85");
        map.put("cp","585F294B8845EE1");
        map.put("_signature","2");
        map.put("category","%E7%BB%84%E5%9B%BE");
        map.put("max_behot_time","1611494141");
        httpPresenter.getPhoto(Constans.BASE_PHOTO_FEED,map);
    }

    @Override
    protected void initView() {
        super.initView();
        tv = findViewById(R.id.tv);
    }

    @Override
    protected void initData() {
    }

    @Override
    protected int getlayoutids() {
        return R.layout.fragment_all;
    }

    @Override
    protected void initPresenter() {
        httpPresenter = new PhotoPresenter();
    }

    @Override
    public void onSucess(List<ImagesBean.DataBean> list) {
        tv.setText(""+list.get(0).getMedia_url());
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
        showEnpty();
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
