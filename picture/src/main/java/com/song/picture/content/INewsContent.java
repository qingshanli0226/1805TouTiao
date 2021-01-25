package com.song.picture.content;

import com.song.fromwork.IBasePresenter;
import com.song.fromwork.IBaseView;
import com.song.net.mode.mobile.news.MultiNewsArticleDataBean;

interface INewsContent {

    interface View extends IBaseView<Presenter> {
        void onSetWebView(String url, boolean flag);
    }

    interface Presenter extends IBasePresenter {
        void doLoadData(MultiNewsArticleDataBean dataBean);
    }
}
