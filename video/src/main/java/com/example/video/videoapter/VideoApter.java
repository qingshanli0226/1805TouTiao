package com.example.video.videoapter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bawei.deom.News;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;


import java.util.List;

public class VideoApter extends BaseQuickAdapter<News, BaseViewHolder> {
    public VideoApter(int layoutResId, @Nullable List<News> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, News item) {
        Glide.with(mContext).load(item.getAvatar_url()).into((ImageView)helper.getView(com.example.framewrok.R.id.imgHeads));
        helper.setText(com.example.framewrok.R.id.txtTitles,item.getTitle());
        helper.setText(com.example.framewrok.R.id.txtMessage,item.getAnAbstract());
        helper.setText(com.example.framewrok.R.id.txtNames,item.getName());
        Glide.with(mContext).load(item.getUrl()).into((ImageView)helper.getView(com.example.framewrok.R.id.largeImage));
    }
}
