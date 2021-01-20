package com.example.a1805toutiao.pictrue.type;

import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.a1805toutiao.R;
import com.example.common.time.TimeUtil;
import com.example.net.bean.photo.PhotoArticleBean;

import java.util.List;

public class PicTypeAdapter extends BaseQuickAdapter<PhotoArticleBean.DataBean, BaseViewHolder> {
    public PicTypeAdapter(@Nullable List<PhotoArticleBean.DataBean> data) {
        super(R.layout.item_pic_child,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, PhotoArticleBean.DataBean item) {
        Glide.with(mContext).load("http:"+item.getMedia_avatar_url()).circleCrop().into((ImageView) helper.getView(R.id.item_child_pic_head));
        List<PhotoArticleBean.DataBean.ImageListBean> image_list = item.getImage_list();
        if(image_list!=null){
            Glide.with(mContext).load("http:"+image_list.get(0).getUrl()).into((ImageView) helper.getView(R.id.item_child_pic_photo_one));
            Glide.with(mContext).load("http:"+image_list.get(1).getUrl()).into((ImageView) helper.getView(R.id.item_child_pic_photo_two));
            Glide.with(mContext).load("http:"+image_list.get(2).getUrl()).into((ImageView) helper.getView(R.id.item_child_pic_photo_three));
        }

        long l =System.currentTimeMillis()/1000-item.getBehot_time();
        helper.setText(R.id.item_child_pic_provenance,item.getSource()+"-"+item.getComments_count()+"评论-"+ TimeUtil.getStringTime(l) );
        helper.setText(R.id.item_child_pic_title,item.getTitle());

    }
}
