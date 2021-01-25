package com.example.picture.adpter;

import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.picture.R;

import java.util.List;

import bean.ImagesBean;

public class PhotoAdpter extends BaseQuickAdapter<ImagesBean.DataBean, BaseViewHolder> {
    public PhotoAdpter(int layoutResId, @Nullable List<ImagesBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ImagesBean.DataBean item) {
        helper.setText(R.id.tv_title,item.getTitle()+"");
        helper.setText(R.id.tv_extra,"新闻源 - 1小时前");
        if (item.getImage_list().get(0).getUrl()!=null&&item.getImage_list().get(1).getUrl()!=null&&item.getImage_list().get(2).getUrl()!=null){
            Log.e("convert",""+item.getImage_list().get(0).getUrl());
            Glide.with(mContext).load("http://"+item.getImage_list().get(0).getUrl()).into((ImageView) helper.getView(R.id.iv_0));
            Glide.with(mContext).load("http://"+item.getImage_list().get(1).getUrl()).into((ImageView) helper.getView(R.id.iv_1));
            Glide.with(mContext).load("http://"+item.getImage_list().get(2).getUrl()).into((ImageView) helper.getView(R.id.iv_2));
        }else {
            Glide.with(mContext).load("http://p3.pstatp.com/list/dfic-imagehandler/e1e36c3b-b16e-4822-821a-5d50ef8f4226").into((ImageView) helper.getView(R.id.iv_0));
            Glide.with(mContext).load("http://p1.pstatp.com/list/dfic-imagehandler/e66969d8-3212-4047-bb36-a85324e59ee3").into((ImageView) helper.getView(R.id.iv_1));
            Glide.with(mContext).load("http://p9.pstatp.com/list/dfic-imagehandler/5a7e65ed-6908-461a-a995-ee224607f6ed"+item.getImage_list().get(2).getUrl()).into((ImageView) helper.getView(R.id.iv_2));
        }

    }
}
