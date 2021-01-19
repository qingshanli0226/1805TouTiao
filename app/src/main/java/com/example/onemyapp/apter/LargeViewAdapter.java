package com.example.onemyapp.apter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.deom.News;
import com.bumptech.glide.Glide;
import com.example.framewrok.base.base.BaseRvAdapter;
import com.example.net.bean.JournalismBean;
import com.example.net.bean.NewsBean;
import com.example.onemyapp.R;
import com.google.gson.Gson;


public class LargeViewAdapter extends BaseRvAdapter<NewsBean> {
    @Override
    protected int getLayoutid(int viewtype) {
        return R.layout.newsviewimg;
    }

    @Override
    protected int getViewtype(int postion) {
        return 0;
    }

    @Override
    protected void cover(BaseViewHolder holder, int position, NewsBean news) {
        ImageView imgHeads = holder.getView(R.id.imgHeads);
        TextView txtNames = holder.getView(R.id.txtNames);
        TextView txtMessage = holder.getView(R.id.txtMessage);
        TextView txtTitles = holder.getView(R.id.txtTitles);
        ImageView largeImage = holder.getView(R.id.largeImage);
        if (news.getUser_info().getAvatar_url()!=null){
            Glide.with(holder.itemView.getContext()).load(news.getUser_info().getAvatar_url()).into(imgHeads);
        }

        txtNames.setText(news.getMedia_name());
        txtMessage.setText(news.getAbstractX());
        txtTitles.setText(news.getTitle());
        Glide.with(holder.itemView.getContext()).load(news.getMedia_info().getAvatar_url()).into(largeImage);
    }


}
