package com.example.a1805toutiao.news.type;

import com.example.a1805toutiao.pictrue.type.PicTypeContract;
import com.example.framework.base.BasePresenter;
import com.example.framework.base.IView;
import com.example.net.bean.news.MultiNewsArticleBean;
import com.example.net.bean.news.MultiNewsArticleDataBean;
import com.example.net.bean.photo.PhotoArticleBean;

import java.util.List;

public interface NewsTypeContract {
    interface INewsTypeView extends IView {
        void onNewsTypeLoadOk(MultiNewsArticleBean bean);
    }
    public abstract class NewsTypePresenter extends BasePresenter<NewsTypeContract.INewsTypeView> {
        public abstract void loadNews(int id,String type,String time);
    }
}
