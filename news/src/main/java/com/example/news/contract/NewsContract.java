package com.example.news.contract;

import androidx.lifecycle.Observer;

import com.example.framework.base.BaseIPresenter;
import com.example.framework.base.IView;

import java.util.HashMap;
import java.util.List;

import bean.NewsBean;

public class NewsContract {

    public interface INewsView extends IView{
        void onNews(List<HashMap<String,String>> newBeans);
    }

    public static abstract class NewsPresenter extends BaseIPresenter<INewsView>{
        public abstract void getNewsInfo();
    }

}
