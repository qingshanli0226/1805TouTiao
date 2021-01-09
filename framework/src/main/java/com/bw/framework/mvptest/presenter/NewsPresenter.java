package com.bw.framework.mvptest.presenter;

import com.bw.framework.callback.INews;
import com.bw.framework.mvptest.control.Control;
import com.bw.framework.mvptest.repository.NewsRepository;

import java.util.HashMap;

public class NewsPresenter extends Control.newsControlPresenter {

    public NewsPresenter(Control.newsControlView newsControlView) {
        super(newsControlView);
    }

    @Override
    public void news(String url, HashMap<String, String> map) {
               mRepository.news(url, map, new INews() {
                   @Override
                   public void onSuccess(Object... objects) {
                         if (objects!=null){
                             mView.get().success(objects);
                         }
                   }

                   @Override
                   public void onError(String msg) {
                       if (msg!=null){
                           mView.get().error(msg);
                       }
                   }
               });
    }

    @Override
    protected void createRepository() {
         mRepository=new NewsRepository();
    }
}
