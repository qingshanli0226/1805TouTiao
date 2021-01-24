package com.example.sevenlandh.video.presenter;

import com.example.common.video.VideoBean;
import com.example.net.util.IfRetrofitUtils;
import com.example.net.util.IsRetrofitUtils;
import com.example.sevenlandh.video.contract.VideoContract;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class VideoPresenterImpl extends VideoContract.VideoPresenter {


    @Override
    public void getVideo(String catrgory, String time) {
        IfRetrofitUtils.createKSApiService()
                .getviode(catrgory,time)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VideoBean>() {


                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(VideoBean videoBean) {
                        iView.onVideoView(videoBean);
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
