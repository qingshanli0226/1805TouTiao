package com.example.onemyapp.apter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.onemyapp.R;
import com.example.onemyapp.bean.LabelBean;

import java.util.List;

public class LableAdapter extends BaseQuickAdapter<LabelBean, BaseViewHolder> {
    public LableAdapter(int layoutResId, @Nullable List<LabelBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, LabelBean item) {
          helper.setText(R.id.buttton,item.getTitle());
    }
}
