package com.toutiao.bawei.a1805toutiao.mvvm;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;


import com.kuaishou.bawei.net.BaseBean;
import com.kuaishou.bawei.net.NetKuaishouFunction;
import com.kuaishou.bawei.net.RetrofitCreator;
import com.kuaishou.bawei.net.bean.FindVideoBean;
import com.kuaishou.bawei.net.bean.MVVMItemBean;
import com.kuaishou.bawei.net.bean.VideoBean;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

//继承ViewModel
public class FindvideoViewMode extends ViewModel {
    //使用LiveData声明一个变量
    private MutableLiveData<MVVMBaseBean<List<MVVMItemBean>>> data = new MutableLiveData<>();
    private MutableLiveData<List<VideoBean>> dataFindVideo = new MutableLiveData<>();

    public MutableLiveData<List<VideoBean>> getFindVideoData() {
        return dataFindVideo;
    }

    public MutableLiveData<MVVMBaseBean<List<MVVMItemBean>>> getData() {
        return data;
    }

    public void getMVVMFindVideo() {
        RetrofitCreator.getNetworkApiService().findMVVMVideo()
                .subscribeOn(Schedulers.io())
                .map(new NetKuaishouFunction<BaseBean<List<MVVMItemBean>>,List<MVVMItemBean>>())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        //显示loading
                        MVVMBaseBean loadingBean = MVVMBaseBean.loadingBean();
                        data.setValue(loadingBean);
                    }
                })
                .subscribe(new Observer<List<MVVMItemBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(List<MVVMItemBean> videoBeans) {
                        //获取数据
                        MVVMBaseBean<List<MVVMItemBean>> successBean = MVVMBaseBean.successBean(videoBeans);
                        data.setValue(successBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        //出现错误
                        String errorMessage = e.getMessage();
                        MVVMBaseBean errorBean = MVVMBaseBean.errorBean(errorMessage);
                        data.setValue(errorBean);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
    public void getFindVideo() {
        RetrofitCreator.getNetworkApiService().findVideo()
                .subscribeOn(Schedulers.io())
                .map(new NetKuaishouFunction<BaseBean<List<VideoBean>>,List<VideoBean>>())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<VideoBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<VideoBean> videoBeans) {
                        dataFindVideo.setValue(videoBeans);
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
