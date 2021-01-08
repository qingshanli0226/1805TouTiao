package com.song.news.fragment;

import com.song.fromwork.BaseRVAdapter;
import com.song.net.mode.mobile.wenda.WendaArticleDataBean;

public class WendaArticleAdapter extends BaseRVAdapter<WendaArticleDataBean> {
    @Override
    protected int getLayoutId(int viewType) {
        return 0;
    }

    @Override
    protected int getViewType(int position) {
        return 0;
    }

    @Override
    protected void convert(WendaArticleDataBean itemData, BaseViewHolder baseViewHolder, int position) {

    }
}
