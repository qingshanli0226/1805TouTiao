package com.example.a1805toutiao.pictrue.type;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a1805toutiao.R;
import com.example.common.error.ErrorBean;
import com.example.framework.base.BaseFragment;
import com.example.net.bean.photo.PhotoArticleBean;


public class PicTypeFragment extends BaseFragment<PicTypePresenterImpl, PicTypeContract.IPicTypeView> implements PicTypeContract.IPicTypeView {
    private RecyclerView rvPicType;
    private String type;

    public PicTypeFragment(String type) {
        this.type = type;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
    @Override
    protected void initView() {
        rvPicType = (RecyclerView) findViewById(R.id.rv_pic_type);

    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_pic_type;
    }

    @Override
    public void onPicTypeLoadOk(PhotoArticleBean bean) {

    }

    @Override
    public void showLoadingPage() {
        showLoading();
    }

    @Override
    public void hideLoadingPage(boolean isSuccess, ErrorBean errorBean) {
        hideLoading(isSuccess,errorBean);
    }

    @Override
    public void showEmptyPage() {
        showEmptyContent();
    }
}