package com.example.a1805toutiao.adaper;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

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
class ComplieAdaper extends BaseQuickAdapter<String, BaseViewHolder> {

    public ComplieAdaper(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.item_comple_text,item);
    }
}
