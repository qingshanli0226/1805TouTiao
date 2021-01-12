package com.song.news.fragment;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.song.fromwork.BaseRVAdapter;
import com.song.fromwork.utils.TimeUtil;
import com.song.net.mode.mobile.news.MultiNewsArticleDataBean;
import com.song.news.R;

public class NewsArticleAdapter extends BaseRVAdapter<MultiNewsArticleDataBean> {
    private final int TEXT_TYPE = 1;
    private final int IMG_TYPE = 2;
    private final int VIDEO_TYPE = 3;

    private int type;

    @Override
    protected int getLayoutId(int viewType) {
        switch (viewType) {
            case VIDEO_TYPE:
                return R.layout.item_news_article_video;
            case IMG_TYPE:
                return R.layout.item_news_article_img;
            default:
                return R.layout.item_news_article_text;
        }
    }

    @Override
    protected int getViewType(int position) {
        Log.i("sss", "getViewType: " + dataList.get(position).isHas_video());

        if (dataList.get(position).isHas_video() && dataList.get(position).getImage_list() != null) {
            type = VIDEO_TYPE;
            Log.i("TAG", "getViewType: " + type);
            return VIDEO_TYPE;
        }
        if (null != dataList.get(position).getMiddle_image()) {
            type = IMG_TYPE;
            return IMG_TYPE;
        } else {
            type = TEXT_TYPE;
            return TEXT_TYPE;
        }

    }

    @Override
    protected void convert(MultiNewsArticleDataBean itemData, BaseViewHolder baseViewHolder, int position) {
        switch (type) {
            case TEXT_TYPE:
                convertTextLayout(itemData, baseViewHolder, position);
                return;
            case IMG_TYPE:
                convertImgLayout(itemData, baseViewHolder, position);
                break;
            case VIDEO_TYPE:
                convertVideoLayout(itemData, baseViewHolder, position);
                break;
        }
    }

    private void convertVideoLayout(MultiNewsArticleDataBean itemData, BaseViewHolder baseViewHolder, int position) {
        ImageView iconImg = baseViewHolder.getVIew(R.id.iv_media);
        TextView tvExtra = baseViewHolder.getVIew(R.id.tv_extra);
        TextView tvTitle = baseViewHolder.getVIew(R.id.tv_title);
        ImageView ivVideoImage = baseViewHolder.getVIew(R.id.iv_video_image);

        Glide.with(baseViewHolder.itemView.getContext()).load(itemData.getUser_info().getAvatar_url()).into(iconImg);
        tvExtra.setText(itemData.getUser_info().getName() + " - " + itemData.getComment_count() + "条评论 - " + TimeUtil.getInstance().getTimeStampAgo(itemData.getBehot_time()));
        tvTitle.setText(itemData.getTitle());
        Glide.with(baseViewHolder.itemView.getContext()).load(itemData.getImage_list().get(0).getUrl()).into(ivVideoImage);
    }

    private void convertImgLayout(MultiNewsArticleDataBean itemData, BaseViewHolder baseViewHolder, int position) {
        ImageView iconImg = baseViewHolder.getVIew(R.id.iv_media);
        TextView tvExtra = baseViewHolder.getVIew(R.id.tv_extra);
        TextView tvTitle = baseViewHolder.getVIew(R.id.tv_title);
        TextView tvAbstract = baseViewHolder.getVIew(R.id.tv_abstract);
        ImageView ivRight = baseViewHolder.getVIew(R.id.iv_image);

        Glide.with(baseViewHolder.itemView.getContext()).load(itemData.getUser_info().getAvatar_url()).into(iconImg);
        Glide.with(baseViewHolder.itemView.getContext()).load(itemData.getMiddle_image().getUrl()).into(ivRight);
        tvExtra.setText(itemData.getUser_info().getName() + " - " + itemData.getComment_count() + "条评论 - " + TimeUtil.getInstance().getTimeStampAgo(itemData.getBehot_time()));
        tvTitle.setText(itemData.getTitle());
        tvAbstract.setText(itemData.getAbstractX());
    }

    private void convertTextLayout(MultiNewsArticleDataBean itemData, BaseViewHolder baseViewHolder, int position) {
        ImageView iconImg = baseViewHolder.getVIew(R.id.iv_media);
        TextView tvExtra = baseViewHolder.getVIew(R.id.tv_extra);
        TextView tvTitle = baseViewHolder.getVIew(R.id.tv_title);
        TextView tvAbstract = baseViewHolder.getVIew(R.id.tv_abstract);

        Glide.with(baseViewHolder.itemView.getContext()).load(itemData.getUser_info().getAvatar_url()).into(iconImg);
        tvExtra.setText(itemData.getUser_info().getName() + " - " + itemData.getComment_count() + "条评论 - " + TimeUtil.getInstance().getTimeStampAgo(itemData.getBehot_time()));
        tvTitle.setText(itemData.getTitle());
        tvAbstract.setText(itemData.getAbstractX());

    }
}
