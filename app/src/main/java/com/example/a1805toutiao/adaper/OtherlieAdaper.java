package com.example.a1805toutiao.adaper;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.a1805toutiao.R;
import com.example.framework.dao.TouTiaoMessageGreenBean;


import java.util.List;

/**
 * 编辑页 Adaper
 */
public
class OtherlieAdaper extends BaseQuickAdapter<TouTiaoMessageGreenBean, BaseViewHolder> {

    public OtherlieAdaper(int layoutResId, @Nullable List<TouTiaoMessageGreenBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TouTiaoMessageGreenBean item) {
        helper.setText(R.id.item_comple_text,item.getTilte());
    }
}
