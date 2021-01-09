package com.example.news;

import android.widget.ImageView;

import androidx.annotation.Nullable;


import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.HashMap;
import java.util.List;

import bean.NewsBean;

public class NewsAdapter extends BaseQuickAdapter<HashMap<String,String>, BaseViewHolder> {

    public NewsAdapter(int layoutResId, @Nullable List<HashMap<String, String>> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HashMap<String, String> item) {
        helper.setText(R.id.tv_newsItem,item.get("anAbstract"));
        Glide.with(mContext).load(item.get("article_url")).into((ImageView) helper.getView(R.id.itemImage));
    }
}
