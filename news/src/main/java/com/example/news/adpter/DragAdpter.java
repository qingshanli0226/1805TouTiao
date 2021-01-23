package com.example.news.adpter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.framework.dao.DragBean;
import com.example.news.R;

import java.util.List;

public class DragAdpter extends BaseQuickAdapter<DragBean, BaseViewHolder> {

    public DragAdpter(int layoutResId, @Nullable List<DragBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DragBean item) {
        helper.setText(R.id.tv_mine,""+item.getUname());
    }
}
