package com.example.sevenlandh.image.adapter;

import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.common.news.NewsBean;
import com.example.common.news.NewsDataBean;
import com.example.common.picture.PictureBean;
import com.example.sevenlandh.R;
import com.google.gson.Gson;

import java.util.List;

public class ImageAdapter extends BaseQuickAdapter<PictureBean.DataBean, BaseViewHolder> {
    public ImageAdapter(int layoutResId, @Nullable List<PictureBean.DataBean> data) {
        super(layoutResId, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, PictureBean.DataBean item) {
        helper.setText(R.id.image_name,item.getSource());
        helper.setText(R.id.image_title,item.getTitle());
        Glide.with(mContext).load("http:"+item.getMedia_avatar_url()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into((ImageView)helper.getView(R.id.image_head_image));

        List<PictureBean.DataBean.ImageListBean> image_list = item.getImage_list();

        if (image_list!=null){
                Glide.with(mContext).load("http:"+image_list.get(0).getUrl()).into((ImageView)helper.getView(R.id.image_one));
                Glide.with(mContext).load("http:"+image_list.get(1).getUrl()).into((ImageView)helper.getView(R.id.image_two));
                Glide.with(mContext).load("http:"+image_list.get(2).getUrl()).into((ImageView)helper.getView(R.id.image_three));

        }



    }
}
