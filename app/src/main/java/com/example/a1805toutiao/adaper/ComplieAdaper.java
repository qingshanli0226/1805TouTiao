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
class ComplieAdaper extends BaseQuickAdapter<TouTiaoMessageGreenBean, BaseViewHolder> {
    private boolean isEdit=false;
    private boolean iscanClick=true;

    public void setIscanClick(boolean iscanClick) {
        this.iscanClick = iscanClick;
    }

    public void setEdit(boolean edit) {
        isEdit = edit;
    }

    public ComplieAdaper(int layoutResId, @Nullable List<TouTiaoMessageGreenBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TouTiaoMessageGreenBean item) {
        helper.setText(R.id.item_comple_text,item.getTilte());
        helper.setVisible(R.id.item_comple_delete,isEdit);
    }

}
