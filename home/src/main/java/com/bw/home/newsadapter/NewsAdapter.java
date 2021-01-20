package com.bw.home.newsadapter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bw.home.R;
import com.bw.net.bean.NewsArticeBean1;
import com.bw.net.bean.NewsArticeBean2;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class NewsAdapter extends BaseQuickAdapter<NewsArticeBean2, BaseViewHolder> {


    public NewsAdapter(int layoutResId, @Nullable List<NewsArticeBean2> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NewsArticeBean2 item) {
        Glide.with(mContext).load(item.getAvatar_url()).transform(new CircleCrop()).into((ImageView) helper.getView(R.id.tvNewsArticle_url));
        helper.setText(R.id.tvNewsTitle,item.getTitle());
        helper.setText(R.id.tvNewsAbstract,item.getAnAbstract());
        helper.setText(R.id.tvNewsMediaName,item.getName());

        Glide.with(mContext).load(item.getUrl()).into((ImageView) helper.getView(R.id.tvNewsUrl));


    }
}
