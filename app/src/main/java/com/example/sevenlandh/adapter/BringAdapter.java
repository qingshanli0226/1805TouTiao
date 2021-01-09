package com.example.sevenlandh.adapter;

import android.util.Log;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.common.news.NewsBean;
import com.example.common.news.NewsDataBean;
import com.example.sevenlandh.R;
import com.google.gson.Gson;

import java.util.List;

public class BringAdapter extends BaseQuickAdapter<NewsBean.DataBean, BaseViewHolder> {
    public BringAdapter(int layoutResId, @Nullable List<NewsBean.DataBean> data) {
        super(layoutResId, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, NewsBean.DataBean item) {

        String content = item.getContent();
        String title = new Gson().fromJson(content, NewsDataBean.class).getTitle();
        helper.setText(R.id.te,title+"");
    }
}
