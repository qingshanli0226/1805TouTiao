package com.bw.home.newsmvp;

import com.bw.framework.base.BasePresenter;
import com.bw.framework.base.IView;
import com.bw.net.bean.NewsArticeBean1;
import com.bw.net.bean.NewsArticeBean2;

import java.util.List;

public class NewsArticleContract {

    public interface newsView extends IView{
        void getNewsOk(NewsArticeBean1 newsArticeBean1);
    }

    public abstract static class newsPresenter extends BasePresenter<newsView>{

        public abstract void newsData();

    }
}
