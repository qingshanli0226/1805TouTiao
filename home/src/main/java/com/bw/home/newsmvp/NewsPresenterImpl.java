package com.bw.home.newsmvp;

import com.bw.net.RetroficCreator;
import com.bw.net.bean.NewsContentBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class NewsPresenterImpl extends NewsContract.newsPresenter {
    @Override
    public void newsData() {
        RetroficCreator.getiNetWorkApiServiceINews().getNewsContent()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsContentBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NewsContentBean newsContentBean) {
                        iView.getNewsOk(newsContentBean);
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
