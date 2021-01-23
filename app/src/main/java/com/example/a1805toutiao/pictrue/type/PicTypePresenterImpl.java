package com.example.a1805toutiao.pictrue.type;

import android.util.Log;

import com.example.common.error.ExceptionUtil;
import com.example.net.api.RetrofitCreater;
import com.example.net.bean.photo.PhotoArticleBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class PicTypePresenterImpl extends PicTypeContract.PicTypePresenter {
    private List<PhotoArticleBean.DataBean> dataList = new ArrayList<>();

    @Override
    public void loadPic(String type, String time) {
        RetrofitCreater.getiMobileMEdiaApi().getPhotoArticle(type, time)
                .subscribeOn(Schedulers.io())
                .switchMap((Function<PhotoArticleBean, Observable<PhotoArticleBean.DataBean>>) photoArticleBean -> {
                    List<PhotoArticleBean.DataBean> dataBeans =  photoArticleBean.getData();
                    if (dataBeans.size() > 0) {
                        dataBeans.remove(dataBeans.size() - 1);
                    }
                    return Observable.fromIterable(dataBeans);
                })
                .filter(dataBean -> {
                    for (PhotoArticleBean.DataBean bean : dataList) {
                        if (dataBean.getTitle().equals(bean.getTitle())) {
                            return false;
                        }
                    }
                    return true;
                })
                .toList()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                       if(view!=null){
                           view.showLoadingPage();
                       }

                    }
                }).subscribe(new Consumer<List<PhotoArticleBean.DataBean>>() {
            @Override
            public void accept(List<PhotoArticleBean.DataBean> dataBeans) throws Exception {
              if(view!=null){
                  view.hideLoadingPage(true, null);
                  view.onPicTypeLoadOk(dataBeans);
              }

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                if(view!=null){
                    view.hideLoadingPage(false, ExceptionUtil.getErrorBean(throwable));
                }
            }
        });

    }
}
