package com.example.sevenlandh.image.presenter;

import com.example.common.picture.PictureBean;
import com.example.common.picture.PictureUrl;
import com.example.net.util.PictureRetrofitUtils;
import com.example.sevenlandh.image.contract.ImageContract;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ImagePresenterImpl extends ImageContract.ImagePresenter {
    @Override
    public void getImage(String catrgory, String time) {
        PictureRetrofitUtils.createKSApiService()
                .getpicture(catrgory,time)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PictureBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PictureBean pictureBean) {
                        iView.onImageView(pictureBean);
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
