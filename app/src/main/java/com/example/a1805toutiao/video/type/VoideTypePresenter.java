package com.example.a1805toutiao.video.type;

import android.util.Log;

import com.example.common.error.ExceptionUtil;
import com.example.net.api.RetrofitCreater;
import com.example.net.bean.news.MultiNewsArticleBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public
class VoideTypePresenter extends VoideTypeContract.VoideTypePresenter {
    @Override
    public void loadVoide(String type, String time) {
        RetrofitCreater.getiMobileMEdiaApi().getVideoArticle(type,time)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        view.showLoadingPage();
                    }
                })
                .subscribe(new Observer<MultiNewsArticleBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MultiNewsArticleBean multiNewsArticleBean) {
                        view.hideLoadingPage(true,null);
                        if (multiNewsArticleBean!=null){
                            if (multiNewsArticleBean.isHas_more()){
                                view.onVoideTypeLoadOk(multiNewsArticleBean);
                            }else {
                                view.showEmptyPage();
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("====",e.getMessage());
                        view.hideLoadingPage(false, ExceptionUtil.getErrorBean(e));
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
