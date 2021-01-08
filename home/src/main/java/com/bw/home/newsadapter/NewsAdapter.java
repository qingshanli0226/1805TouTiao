package com.bw.home.newsadapter;

import androidx.annotation.Nullable;

import com.bw.home.R;
import com.bw.net.bean.NewsContentBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class NewsAdapter extends BaseQuickAdapter<NewsContentBean.DataBean.LabelsBean, BaseViewHolder> {
    public NewsAdapter(int layoutResId, @Nullable List<NewsContentBean.DataBean.LabelsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NewsContentBean.DataBean.LabelsBean item) {
        helper.setText(R.id.tvNewsTitle,item.getLabel());
//        helper.setText(R.id.tvNewsContent,item.getStress_type());
    }

}
