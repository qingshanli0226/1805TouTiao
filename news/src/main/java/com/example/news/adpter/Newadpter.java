package com.example.news.adpter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.news.R;

import java.util.HashMap;
import java.util.List;

public class Newadpter extends BaseQuickAdapter<HashMap<String,String>, BaseViewHolder> {

    public Newadpter(int layoutResId, @Nullable List<HashMap<String, String>> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HashMap<String, String> item) {
        if (item.get("behome_time")!=null){
            helper.setText(R.id.tv_extra,"1分钟前" +item.get("behome_time"));
        }else {
            helper.setText(R.id.tv_extra,"1分钟前");
        }

        helper.setText(R.id.tv_title,""+item.get("title"));
        helper.setText(R.id.tv_abstract,""+item.get("anAbstract"));
        Glide.with(mContext).load(item.get("avatar_url")).circleCrop().into((ImageView) helper.getView(R.id.iv_media));
        Glide.with(mContext).load(item.get("url")).into((ImageView) helper.getView(R.id.iv_image));

    }
}
