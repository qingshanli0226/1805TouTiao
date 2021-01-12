package com.song.news.fragment.contract;

import com.song.fromwork.BasePresenter;
import com.song.fromwork.IView;
import com.song.net.mode.mobile.news.MultiNewsArticleDataBean;

import java.util.List;

public class NewsContract {
    public interface INewsView extends IView {
        void onLoadData(List<MultiNewsArticleDataBean> newsArticleDataBeans);
        void onRefresh(List<MultiNewsArticleDataBean> newsArticleDataBeans);
    }

    public abstract static class INewsPresenter extends BasePresenter<INewsView> {
        public abstract void doLoadData(String... category);
        public abstract void doLoadMoreData();
        public abstract void doRefresh();
    }
}
