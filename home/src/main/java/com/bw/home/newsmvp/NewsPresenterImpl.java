package com.bw.home.newsmvp;

import com.bw.net.RetroficCreator;
import com.bw.net.bean.NewsArticeBean1;
import com.bw.net.bean.NewsArticeBean2;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class NewsPresenterImpl extends NewsArticleContract.newsPresenter {
    @Override
    public void newsData() {
        RetroficCreator.iNetWorkApiServiceMOBILEMEDIA().getNewsArticle()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsArticeBean1>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NewsArticeBean1 newsArticeBean1) {
                        iView.getNewsOk(newsArticeBean1);
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
