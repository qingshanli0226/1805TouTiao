package com.example.a1805toutiao.adaper;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.a1805toutiao.R;

import java.util.List;

/**
 * 编辑页 Adaper
 */
public
class OtherlieAdaper extends BaseQuickAdapter<String, BaseViewHolder> {

    public OtherlieAdaper(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.item_comple_text,item);
    }
}
