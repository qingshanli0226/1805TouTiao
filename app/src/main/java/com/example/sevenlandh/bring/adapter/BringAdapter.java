package com.example.sevenlandh.bring.adapter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
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
        NewsDataBean newsDataBean = new Gson().fromJson(content, NewsDataBean.class);
        String title = newsDataBean .getTitle();
        NewsDataBean.MediaInfoBean media_info = newsDataBean.getMedia_info();
        helper.setText(R.id.bringname,media_info.getName());
        helper.setText(R.id.bringtitle,title+"");
        helper.setText(R.id.bringcontent,newsDataBean.getAbstractX());
        Glide.with(mContext).load(media_info.getAvatar_url()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into((ImageView)helper.getView(R.id.bringheadimage));

    }
}
