package com.bw.framework.mvptest.model;

import android.util.Log;

import com.bw.bean.NewsBean;
import com.bw.framework.callback.INews;
import com.bw.framework.mvptest.control.Control;
import com.bw.net.RetrfitFactory;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class NewsModel implements Control.newsControlModel {

    @Override
    public void news(String url, HashMap<String, String> map, final INews iNews) {
        Log.e("AAAA",url+""+map.toString());
        RetrfitFactory.getRetrfitFactory().getInstance()
                 .getNews(url,map)
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Observer<NewsBean>() {
                     @Override
                     public void onSubscribe(Disposable d) {

                     }

                     @Override
                     public void onNext(NewsBean newsBean) {
                           iNews.onSuccess(newsBean);
                     }

                     @Override
                     public void onError(Throwable e) {
                          iNews.onError(e.getMessage());
                     }

                     @Override
                     public void onComplete() {

                     }
                 });
    }
}
