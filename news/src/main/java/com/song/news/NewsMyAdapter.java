package com.song.news;

import com.song.fromwork.BaseRVAdapter;
import com.song.fromwork.dao.NewsChannelBean;

public class NewsMyAdapter extends BaseRVAdapter<NewsChannelBean> {
    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_channel_my;
    }

    @Override
    protected int getViewType(int position) {
        return position;
    }

    @Override
    protected void convert(NewsChannelBean itemData, BaseViewHolder baseViewHolder, int position) {

    }
}
