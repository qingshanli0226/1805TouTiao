package com.toutiao.bawei.a1805toutiao.mvvm;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.kuaishou.bawei.net.bean.MVVMItemBean;
import com.kuaishou.bawei.net.bean.VideoBean;
import com.toutiao.bawei.a1805toutiao.R;
import com.toutiao.bawei.a1805toutiao.databinding.ActivityMvvmBinding;

import java.util.List;

public class MVVMActivity extends AppCompatActivity {
    private ActivityMvvmBinding activityMvvmBinding;
    private MVVMAdapter mvvmAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMvvmBinding = DataBindingUtil.setContentView(this,R.layout.activity_mvvm);
        initRv();
        initData();
    }

    private void initData() {
        FindvideoViewMode findvideoViewMode = ViewModelProviders.of(this).get(FindvideoViewMode.class);
        findvideoViewMode.getData().observe(this, new Observer<MVVMBaseBean<List<MVVMItemBean>>>() {
            @Override
            public void onChanged(@Nullable MVVMBaseBean<List<MVVMItemBean>> mvvmBaseBean) {
                mvvmBaseBean.handleMessage(mvvmBaseBean, new MVVMBaseBean.IMVVMBaseBeanHandler<List<MVVMItemBean>>() {
                    @Override
                    public void onLoading() {
                        Toast.makeText(MVVMActivity.this, "正在加载数据11", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onSuccess(List<MVVMItemBean> data) {
                        mvvmAdapter.updateData(data);
                    }

                    @Override
                    public void onError(String message) {
                        Toast.makeText(MVVMActivity.this, "加载数据失败11", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        findvideoViewMode.getFindVideoData().observe(this, new Observer<List<VideoBean>>() {

            @Override
            public void onChanged(@Nullable List<VideoBean> videoBeans) {

            }
        });
        findvideoViewMode.getMVVMFindVideo();
        findvideoViewMode.getFindVideo();
    }

    private void initRv() {
        activityMvvmBinding.rv.setLayoutManager(new LinearLayoutManager(this));
        mvvmAdapter = new MVVMAdapter();
        activityMvvmBinding.rv.setAdapter(mvvmAdapter);
    }
}
