package com.song.picture.presenter;

import com.song.fromwork.BasePresenter;
import com.song.fromwork.IView;
import com.song.net.mode.photo.PhotoArticleBean;

import java.util.List;

public interface IPhotoArticle {

    interface View extends IView {
        void onLoadData();
    }

    abstract static class Presenter extends BasePresenter<IView> {
        public abstract void doLoadData(String... category);

        public abstract void doLoadMoreData();

        public abstract void doSetAdapter(List<PhotoArticleBean.DataBean> dataBeen);

        public abstract void doShowNoMore();
    }
}
