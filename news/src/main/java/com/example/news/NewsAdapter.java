package com.example.news;

import androidx.annotation.Nullable;


import java.util.List;

import bean.NewsBean;

public class NewsAdapter extends BaseQuickAdapter<NewsBean.DataBean, BaseViewHolder> {
    public NewsAdapter(int layoutResId, @Nullable List<NewsBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NewsBean.DataBean item) {
        helper.setText(R.id.tv_newsItem,item.getContent());
    }
}
