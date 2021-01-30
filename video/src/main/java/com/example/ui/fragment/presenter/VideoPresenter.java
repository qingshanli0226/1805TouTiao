package com.example.ui.fragment.presenter;

import com.example.ui.fragment.contract.VideoContract;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import bean.VideosBean;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import uitls.Retrofitcreators;

public class VideoPresenter extends VideoContract.IVideoPresenter {
    @Override
    public void getvideo(String url, HashMap<String, String> map) {
        Retrofitcreators.getBaseUserInterface().video(url,map)
                .delay(1, TimeUnit.MINUTES)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VideosBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(VideosBean videosBean) {
                        iView.onvideo();
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
