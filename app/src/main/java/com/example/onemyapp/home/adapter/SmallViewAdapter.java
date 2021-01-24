package com.example.onemyapp.home.adapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.deom.News;
import com.bumptech.glide.Glide;
import com.example.framewrok.base.base.BaseRvAdapter;
import com.example.net.bean.JournalismBean;
import com.example.net.bean.NewsBean;
import com.example.onemyapp.R;
import com.google.gson.Gson;


public class SmallViewAdapter extends BaseRvAdapter<NewsBean> {
    @Override
    protected int getLayoutid(int viewtype) {
        return R.layout.newsview;
    }

    @Override
    protected int getViewtype(int postion) {
        return 0;
    }

    @Override
    protected void cover(BaseViewHolder holder, int position, NewsBean news) {
        ImageView imgHeads = holder.getView(R.id.imgHead);
        TextView txtNames = holder.getView(R.id.txtName);
        TextView txtMessage = holder.getView(R.id.txtMessages);
        TextView txtTitles = holder.getView(R.id.txtTitle);
        Glide.with(holder.itemView.getContext()).load(news.getUser_info().getAvatar_url()).into(imgHeads);
        txtNames.setText(news.getMedia_name());
        txtMessage.setText(news.getAbstractX());
        txtTitles.setText(news.getTitle());
    }


}
