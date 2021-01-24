package com.example.sevenlandh.video.adapter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.common.picture.PictureBean;
import com.example.common.video.VideoBean;
import com.example.common.video.VideoDataBean;
import com.example.sevenlandh.R;
import com.google.gson.Gson;

import java.util.List;

public class VideoAdapter extends BaseQuickAdapter<VideoBean.DataBean, BaseViewHolder> {
    public VideoAdapter(int layoutResId, @Nullable List<VideoBean.DataBean> data) {
        super(layoutResId, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, VideoBean.DataBean item) {
        String content = item.getContent();
        VideoDataBean videoDataBean = new Gson().fromJson(content, VideoDataBean.class);

        if (videoDataBean!=null) {
            List<VideoDataBean.LargeImageListBean> large_image_list = videoDataBean.getLarge_image_list();
            helper.setText(R.id.video_name, videoDataBean.getSource());
            helper.setText(R.id.video_title, videoDataBean.getTitle());
            VideoDataBean.MediaInfoBean image_list = videoDataBean.getMedia_info();
            Glide.with(mContext).load(image_list.getAvatar_url()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into((ImageView) helper.getView(R.id.video_headimage));
            for (int i = 0; i <large_image_list.size() ; i++) {

                Glide.with(mContext).load(large_image_list.get(i).getUrl()).into((ImageView) helper.getView(R.id.video_image));

            }
        }









    }
}
