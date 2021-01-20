package com.bw.home.newsmvp;

import android.util.Log;

import com.bw.net.RetroficCreator;
import com.bw.net.bean.MultiNewsArticleBean;


import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class NewsPresenterImpl extends NewsArticleContract.newsPresenter {
    @Override
    public void newsData(String category,String max_behot_time) {
        //category=&max_behot_time=1610582775
        //category=news_society&max_behot_time=1610526416
        HashMap<String,String> map = new HashMap<>();
        map.put("category",category);
        map.put("max_behot_time",""+max_behot_time);
        Log.e("===max_behot_time:  ",""+max_behot_time);

        RetroficCreator.iNetWorkApiServiceMOBILEMEDIA().getNewsArticle2(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MultiNewsArticleBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MultiNewsArticleBean multiNewsArticleBean) {
                        iView.getNewsOk(multiNewsArticleBean);
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
