package com.example.a1805toutiao.video.type;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.net.bean.news.MultiNewsArticleBean;

import java.util.List;

public
class VoideTypeAdaper extends BaseQuickAdapter<MultiNewsArticleBean.DataBean, BaseViewHolder> {
    public VoideTypeAdaper(int layoutResId, @Nullable List<MultiNewsArticleBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultiNewsArticleBean.DataBean item) {
       // Glide.with(mContext).load("http:"+item.)
    }
}
