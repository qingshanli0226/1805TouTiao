package com.bw.home.newsmvp;

import android.util.Log;

import com.bw.framework.base.BasePresenter;
import com.bw.framework.base.IView;
import com.bw.net.bean.MultiNewsArticleBean;
import com.bw.net.bean.NewsArticeBean1;
import com.bw.net.bean.NewsArticeBean2;

import java.util.List;

public class NewsArticleContract {

    public interface newsView extends IView{
        void getNewsOk(MultiNewsArticleBean multiNewsArticleBean);
    }

    public abstract static class newsPresenter extends BasePresenter<newsView>{
        //category=news_society&max_behot_time=1610526416
        public abstract void newsData(String category,String max_behot_time);

    }
}
