package com.song.picture.comment;

import com.song.fromwork.BasePresenter;
import com.song.fromwork.IBaseListView;
import com.song.net.mode.mobile.news.NewsCommentBean;

import java.util.List;


public interface INewsComment {

    interface View extends IBaseListView<Presenter> {
        void onLoadData();
    }

    abstract static class Presenter extends BasePresenter {

        public abstract void doLoadData(String... groupId_ItemId);

        public abstract void doLoadMoreData();

        public abstract void doSetAdapter(List<NewsCommentBean.DataBean.CommentBean> list);

        public abstract void doShowNoMore();
    }
}
