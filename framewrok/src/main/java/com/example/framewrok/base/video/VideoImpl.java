package com.example.framewrok.base.video;

import com.bawei.deom.ClassInterface;
import com.example.net.bean.VideoBean;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class VideoImpl extends VideoCountroller.ViewShow {
    @Override
    public void VideoShow(String s,String url, HashMap<String, String> map) {
        if (s.equals("生活")||s.equals("影视")||s.equals("推荐")){
            ClassInterface.getBaseInterface(s).video(url,map)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<VideoBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(VideoBean videoBean) {
                            pView.onVideoView(videoBean);
                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }else {
            ClassInterface.getBaseInterface(s).video(url,map)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<VideoBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(VideoBean videoBean) {
                            pView.onVideoView(videoBean);
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
}
