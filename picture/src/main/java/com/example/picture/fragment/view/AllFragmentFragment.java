package com.example.picture.fragment.view;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.Constans;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.framework.base.BaseLazyFragment;
import com.example.framework.base.BaseMVPFragment;
import com.example.picture.PictureDetailsActivity;
import com.example.picture.R;
import com.example.picture.adpter.PhotoAdpter;
import com.example.picture.fragment.contract.PhotoContract;
import com.example.picture.fragment.presenter.PhotoPresenter;

import java.util.HashMap;
import java.util.List;

import bean.ImagesBean;

public class AllFragmentFragment extends BaseMVPFragment<PhotoPresenter, PhotoContract.IPhotoView> implements PhotoContract.IPhotoView {
    private RecyclerView rvPhoto;
    private PhotoAdpter photoAdpter;
    private SwipeRefreshLayout swipe;


    @Override
    protected void initHttpDate() {

        httpPresenter.getPhoto("组图",getTime());
        //上啦刷新
        swipe.setRefreshing(true);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                httpPresenter.getPhoto("组图",getTime());
            }
        });
    }
    public String getTime(){
        long time = System.currentTimeMillis()/1000;
        String s = String.valueOf(time);
        return s;
    }
    @Override
    protected void initView() {
        super.initView();
        rvPhoto = findViewById(R.id.rv_photo);
        swipe = findViewById(R.id.swipe);
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
    public void onSucess(final List<ImagesBean.DataBean> list) {
        swipe.setRefreshing(false);
        photoAdpter = new PhotoAdpter(R.layout.item_photo,list);
        rvPhoto.setAdapter(photoAdpter);
        rvPhoto.setLayoutManager(new LinearLayoutManager(getContext()));
        Toast.makeText(getContext(), ""+list.get(0).getImage_list().get(0).getUrl(), Toast.LENGTH_SHORT).show();

        photoAdpter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity(), PictureDetailsActivity.class);
                intent.putExtra("path",list.get(position).getMedia_url());

                startActivity(intent);
            }
        });
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
