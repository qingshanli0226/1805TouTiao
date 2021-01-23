package com.example.a1805toutiao.news.type;

import com.example.common.error.ExceptionUtil;
import com.example.net.api.RetrofitCreater;
import com.example.net.bean.news.MultiNewsArticleBean;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class NewsTypePresenterImpl extends NewsTypeContract.NewsTypePresenter {
    @Override
    public void loadNews(int id,String type, String time) {

        if (id % 2 == 0) {
            RetrofitCreater.getiMobileMEdiaApi().getNewsArticle(type,time)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe(new Consumer<Disposable>() {
                        @Override
                        public void accept(Disposable disposable) throws Exception {
                            if(view!=null){
                                view.showLoadingPage();
                            }
                        }
                    })
                    .subscribe(new Observer<MultiNewsArticleBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(MultiNewsArticleBean multiNewsArticleBean) {
                            if(view!=null){
                                view.hideLoadingPage(true,null);
                                List<MultiNewsArticleBean.DataBean> data = multiNewsArticleBean.getData();
                                if(data.size()!=0){
                                    view.onNewsTypeLoadOk(multiNewsArticleBean);
                                }else {
                                    view.showEmptyPage();
                                }
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            if(view!=null){
                                view.hideLoadingPage(false, ExceptionUtil.getErrorBean(e));
                            }
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        } else {
            RetrofitCreater.getiMobileMEdiaApi().getNewsArticle2(type,time)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe(new Consumer<Disposable>() {
                        @Override
                        public void accept(Disposable disposable) throws Exception {
                            if(view!=null){
                                view.showLoadingPage();
                            }
                        }
                    })
                    .subscribe(new Observer<MultiNewsArticleBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(MultiNewsArticleBean multiNewsArticleBean) {
                            if(view!=null){
                                view.hideLoadingPage(true,null);
                                List<MultiNewsArticleBean.DataBean> data = multiNewsArticleBean.getData();
                                if(data.size()!=0){
                                    view.onNewsTypeLoadOk(multiNewsArticleBean);
                                }else {
                                    view.showEmptyPage();
                                }                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            if(view!=null){
                                view.hideLoadingPage(false, ExceptionUtil.getErrorBean(e));
                            }
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }

    }
}
