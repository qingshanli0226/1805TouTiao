package com.example.news.adpter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.news.R;

import java.util.List;

public class MineAdpter extends BaseQuickAdapter<String, BaseViewHolder> {
    public MineAdpter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_mine,item+"");
    }
}
