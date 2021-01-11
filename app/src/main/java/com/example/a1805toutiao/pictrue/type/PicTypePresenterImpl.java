package com.example.a1805toutiao.pictrue.type;

import com.example.common.error.ExceptionUtil;
import com.example.net.api.RetrofitCreater;
import com.example.net.bean.photo.PhotoArticleBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class PicTypePresenterImpl extends PicTypeContract.PicTypePresenter {
    @Override
    public void loadPic(String type, String time) {
        RetrofitCreater.getiMobileMEdiaApi().getPhotoArticle(type,time)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        view.showLoadingPage();
                    }
                })
                .subscribe(new Observer<PhotoArticleBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PhotoArticleBean bean) {
                        view.hideLoadingPage(true,null);
                       if(bean.isHas_more()){
                           view.onPicTypeLoadOk(bean);
                       }else {
                           view.showEmpty();
                       }

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.hideLoadingPage(false, ExceptionUtil.getErrorBean(e));
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
