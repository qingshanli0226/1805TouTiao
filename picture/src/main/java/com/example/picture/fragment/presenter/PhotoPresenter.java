package com.example.picture.fragment.presenter;

import android.util.Log;

import com.example.picture.fragment.contract.PhotoContract;
import com.google.android.material.tabs.TabLayout;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import bean.ImagesBean;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import uitls.Retrofitcreators;

public class PhotoPresenter extends PhotoContract.PhotoPrsenter {
    @Override
    public void getPhoto(String category,String behottime) {
        Retrofitcreators.getiNetPhotoApiService().getImages(category,behottime)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ImagesBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ImagesBean imagesBean) {
                        iView.onSucess(imagesBean.getData());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("ZLD","123");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
