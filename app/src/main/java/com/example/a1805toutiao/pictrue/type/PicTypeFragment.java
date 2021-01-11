package com.example.a1805toutiao.pictrue.type;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a1805toutiao.R;
import com.example.common.error.ErrorBean;
import com.example.framework.base.BaseFragment;
import com.example.net.bean.photo.PhotoArticleBean;

import java.util.ArrayList;
import java.util.List;


public class PicTypeFragment extends BaseFragment<PicTypePresenterImpl, PicTypeContract.IPicTypeView> implements PicTypeContract.IPicTypeView {
    private RecyclerView rvPicType;
    private String type;
    private List<PhotoArticleBean.DataBean> list=new ArrayList<>();
    private PicTypeAdapter adapter;
    public PicTypeFragment(String type) {
        this.type = type;
    }

    @Override
    protected void initData() {
        presenter.loadPic(type,System.currentTimeMillis()/1000+"");
    }

    @Override
    protected void initListener() {

    }
    @Override
    protected void initView() {
        rvPicType = (RecyclerView) findViewById(R.id.rv_pic_type);
        rvPicType.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new PicTypeAdapter(list);
        rvPicType.setAdapter(adapter);
    }

    @Override
    protected void initPresenter() {
        presenter=new PicTypePresenterImpl();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_pic_type;
    }

    @Override
    public void onPicTypeLoadOk(PhotoArticleBean bean) {
        List<PhotoArticleBean.DataBean> data = bean.getData();
        list.addAll(data);
        adapter.notifyDataSetChanged();
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