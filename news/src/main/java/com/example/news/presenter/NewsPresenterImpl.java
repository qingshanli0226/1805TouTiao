package com.example.news.presenter;

import android.util.Log;

import com.example.news.contract.NewsContract;

import bean.NewsBean;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import uitls.HeadConfig;
import uitls.HttpRetrofitManager;
import uitls.ITouTiaoApiService;

public class NewsPresenterImpl extends NewsContract.NewsPresenter {

    @Override
    public void getNewsInfo() {

         HttpRetrofitManager.getHttpRetrofitManager()
                 .getRetrofit(HeadConfig.BASE_URL_IS)
                 .create(ITouTiaoApiService.class)
                 .getNews("5034850950","6096495334","1","20","13","","1609981326")
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribeOn(Schedulers.io())
                 .subscribe(new Observer<NewsBean>() {
                     @Override
                     public void onSubscribe(Disposable d) {

                     }

                     @Override
                     public void onNext(NewsBean newsBean) {
                        iView.onNews(newsBean.getData());
                         Log.i("newsPresenter", "onNext: "+newsBean.getData());
                     }

                     @Override
                     public void onError(Throwable e) {

                     }

                     @Override
                     public void onComplete() {

                     }
                 });


    }
}
