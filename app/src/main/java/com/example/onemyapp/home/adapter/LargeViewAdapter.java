package com.example.onemyapp.home.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.deom.News;
import com.bumptech.glide.Glide;
import com.example.framewrok.base.base.BaseRvAdapter;
import com.example.onemyapp.R;


public class LargeViewAdapter extends BaseRvAdapter<News> {
    @Override
    protected int getLayoutid(int viewtype) {
        return R.layout.newsviewimg;
    }

    @Override
    protected int getViewtype(int postion) {
        return 0;
    }

    @Override
    protected void cover(BaseViewHolder holder, int position, News news) {
        ImageView imgHeads = holder.getView(R.id.imgHeads);
        TextView txtNames = holder.getView(R.id.txtNames);
        TextView txtMessage = holder.getView(R.id.txtMessage);
        TextView txtTitles = holder.getView(R.id.txtTitles);
        ImageView largeImage = holder.getView(R.id.largeImage);
        Glide.with(holder.itemView.getContext()).load(news.getAvatar_url()).into(imgHeads);
        txtNames.setText(news.getName());
        txtMessage.setText(news.getAnAbstract());
        txtTitles.setText(news.getTitle());
        Glide.with(holder.itemView.getContext()).load(news.getUrl()).into(largeImage);
    }


}
