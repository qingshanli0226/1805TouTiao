package com.song.news.fragment;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.song.fromwork.BaseRVAdapter;
import com.song.fromwork.utils.TimeUtil;
import com.song.net.mode.mobile.wenda.WendaArticleDataBean;
import com.song.news.R;

import java.util.List;

public class WendaArticleAdapter extends BaseRVAdapter<WendaArticleDataBean> {
    private final int THREE_IMAGE = 3;
    private final int NORMAL = 1;
    private int type = NORMAL;


    @Override
    protected int getLayoutId(int viewType) {
        switch (viewType){
            case THREE_IMAGE:
                return R.layout.item_wenda_article_three_img;
            default: NORMAL:
                return R.layout.item_wenda_article_text;
        }
    }

    @Override
    protected int getViewType(int position) {
        if (dataList.get(position).getExtraBean().getWenda_image().getThree_image_list().size() != 0) {
            type = THREE_IMAGE;
        } else {
            type = NORMAL;
        }
        return type;
    }

    @Override
    protected void convert(WendaArticleDataBean itemData, BaseViewHolder baseViewHolder, int position) {
        switch (type){
            case THREE_IMAGE:
                convertThree(itemData,baseViewHolder,position);
                break;
            case NORMAL:
                convertNormal(itemData,baseViewHolder,position);
                break;
        }
    }

    private void convertThree(WendaArticleDataBean itemData, BaseViewHolder baseViewHolder, int position) {
        TextView tvTitle = baseViewHolder.getVIew(R.id.tv_title);
        TextView tvAnswerCount = baseViewHolder.getVIew(R.id.tv_answer_count);
        TextView tvTime = baseViewHolder.getVIew(R.id.tv_time);
        ImageView iv = baseViewHolder.getVIew(R.id.iv_0);
        ImageView iv1 = baseViewHolder.getVIew(R.id.iv_1);
        ImageView iv2 = baseViewHolder.getVIew(R.id.iv_2);
        List<WendaArticleDataBean.ExtraBean.WendaImageBean.ThreeImageListBean> threeImageListBeans =
                itemData.getExtraBean().getWenda_image().getThree_image_list();
        tvTitle.setText(itemData.getQuestionBean().getTitle());
        tvAnswerCount.setText(itemData.getQuestionBean().getNormal_ans_count()+"回答");
        tvTime.setText(TimeUtil.getInstance().getTimeStampAgo(String.valueOf(itemData.getQuestionBean().getCreate_time())));
        Glide.with(baseViewHolder.itemView.getContext()).load(threeImageListBeans.get(0)).into(iv);
        Glide.with(baseViewHolder.itemView.getContext()).load(threeImageListBeans.get(1)).into(iv1);
        Glide.with(baseViewHolder.itemView.getContext()).load(threeImageListBeans.get(2)).into(iv2);
    }

    private void convertNormal(WendaArticleDataBean itemData, BaseViewHolder baseViewHolder, int position) {
        TextView tvTitle = baseViewHolder.getVIew(R.id.tv_title);
        TextView tvAnswerCount = baseViewHolder.getVIew(R.id.tv_answer_count);
        TextView tvContent = baseViewHolder.getVIew(R.id.tv_content);
        TextView tvTime = baseViewHolder.getVIew(R.id.tv_time);
        tvTitle.setText(itemData.getQuestionBean().getTitle());
        tvContent.setText(itemData.getAnswerBean().getAbstractX());
        tvAnswerCount.setText(itemData.getQuestionBean().getNormal_ans_count()+"回答");
        tvTime.setText(TimeUtil.getInstance().getTimeStampAgo(String.valueOf(itemData.getQuestionBean().getCreate_time())));
    }
}
