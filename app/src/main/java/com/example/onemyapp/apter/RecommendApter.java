package com.example.onemyapp.apter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bawei.deom.News;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.onemyapp.R;

import java.util.List;

public class RecommendApter extends BaseQuickAdapter<News, BaseViewHolder> {
    public RecommendApter(int layoutResId, @Nullable List<News> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, News item) {
        Glide.with(mContext).load(item.getAvatar_url()).into((ImageView)helper.getView(R.id.imgHeads));
        helper.setText(R.id.txtTitles,item.getTitle());
        helper.setText(R.id.txtMessage,item.getAnAbstract());
        helper.setText(R.id.txtNames,item.getName());
        Glide.with(mContext).load(item.getUrl()).into((ImageView)helper.getView(R.id.largeImage));
    }
}
