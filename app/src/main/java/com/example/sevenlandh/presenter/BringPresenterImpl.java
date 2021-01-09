package com.example.sevenlandh.presenter;

import com.example.common.news.NewsBean;
import com.example.net.util.IsRetrofitUtils;
import com.example.sevenlandh.contract.BringContract;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class BringPresenterImpl extends BringContract.BringPresenter {

    @Override
    public void getBring() {
        IsRetrofitUtils.createKSApiService().getrecommend()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onNext(NewsBean newsBean) {

                        iView.onBringView(newsBean);
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
