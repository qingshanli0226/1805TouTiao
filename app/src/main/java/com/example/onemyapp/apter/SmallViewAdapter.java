package com.example.onemyapp.apter;

import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.deom.News;
import com.bumptech.glide.Glide;
import com.example.framewrok.base.base.BaseRvAdapter;
import com.example.net.bean.JournalismBean;
import com.example.net.bean.NewsBean;
import com.example.onemyapp.R;
import com.google.gson.Gson;


public class SmallViewAdapter extends BaseRvAdapter<News> {
    @Override
    protected int getLayoutid(int viewtype) {
        return R.layout.newsview;
    }

    @Override
    protected int getViewtype(int postion) {
        return 0;
    }

    @Override
    protected void cover(BaseViewHolder holder, int position, News news) {
        ImageView imgHeads = holder.getView(R.id.imgHead);
        TextView txtNames = holder.getView(R.id.txtName);
        TextView txtMessage = holder.getView(R.id.txtMessage);
        TextView txtTitles = holder.getView(R.id.txtTitle);
        Glide.with(holder.itemView.getContext()).load(news.getAvatar_url()).into(imgHeads);
        txtNames.setText(news.getName());
        txtMessage.setText(news.getAnAbstract());
        txtTitles.setText(news.getTitle());
    }


}
