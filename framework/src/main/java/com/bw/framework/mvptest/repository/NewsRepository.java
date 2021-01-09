package com.bw.framework.mvptest.repository;

import com.bw.framework.callback.INews;
import com.bw.framework.mvptest.control.Control;
import com.bw.framework.mvptest.model.NewsModel;

import java.util.HashMap;

public class NewsRepository extends Control.newsControlRepository {


    @Override
    protected void createModel() {
         mModel=new NewsModel();
    }

    @Override
    public void news(String url, HashMap<String, String> map, INews iNews) {
           mModel.news(url,map,iNews);
    }
}
