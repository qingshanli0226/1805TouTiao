package com.bw.home.adapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.bw.framework.base.BaseRVAdapter;
import com.bw.framework.glide.GlideUtils;
import com.bw.home.R;
import com.bw.net.bean.News;


public class NewsRecycleAdapter extends BaseRVAdapter<News> {
    private ImageView ivMedia;
    private TextView tvExtra;
    private ImageView ivDots;
    private TextView tvTitle;
    private TextView tvAbstract;
    private ImageView ivImage;
    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_news_img;
    }

    @Override
    protected void convert(News itemData, BaseViewHolder baseViewHolder, int position) {


        ivMedia = baseViewHolder.itemView.findViewById(R.id.iv_media);//头图片
        tvExtra = baseViewHolder.itemView.findViewById(R.id.tv_extra);//新闻网
        ivDots = baseViewHolder.itemView.findViewById(R.id.iv_dots);//分享
        tvTitle = baseViewHolder.itemView.findViewById(R.id.tv_title);//标题
        tvAbstract = baseViewHolder.itemView.findViewById(R.id.tv_abstract);//内容
        ivImage = baseViewHolder.itemView.findViewById(R.id.iv_image);//新闻配图
        if (itemData.getAvatar_url()!=null){
            GlideUtils.circleImage(baseViewHolder.itemView.getContext(),itemData.getAvatar_url(),ivMedia);
        }

        if (itemData.getUrl()!=null){
            GlideUtils.Image(baseViewHolder.itemView.getContext(),itemData.getUrl(),ivImage);
        }

        tvExtra.setText(itemData.getName()+"");
        tvTitle.setText(itemData.getTitle()+"");
        tvAbstract.setText(itemData.getAnAbstract()+"");

    }

    @Override
    protected int getViewType(int position) {
        return 0;
    }
}
