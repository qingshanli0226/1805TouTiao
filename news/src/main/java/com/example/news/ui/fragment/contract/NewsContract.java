package com.example.news.ui.fragment.contract;

import com.example.framework.base.BaseIPresenter;
import com.example.framework.base.IView;

import java.util.HashMap;
import java.util.List;


public class NewsContract {

    public interface INewsView extends IView{
        void onNews(List<HashMap<String,String>> newBeans);
    }

    public static abstract class NewsPresenter extends BaseIPresenter<INewsView>{
        public abstract void getNewsInfo(String url, HashMap<String,String> map);
    }

}
