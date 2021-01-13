package com.example.onemyapp.apter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.onemyapp.R;
import com.example.onemyapp.bean.LabelBean;

import java.util.List;

public class MyLableApter extends BaseQuickAdapter<String, BaseViewHolder> {
    public MyLableApter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.buttton,item);
    }
}
