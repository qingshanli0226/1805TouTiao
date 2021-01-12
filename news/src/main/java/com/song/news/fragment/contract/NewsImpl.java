package com.song.news.fragment.contract;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.song.fromwork.utils.TimeUtil;
import com.song.net.RetrofitHelper;
import com.song.net.mode.mobile.news.MultiNewsArticleBean;
import com.song.net.mode.mobile.news.MultiNewsArticleDataBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class NewsImpl extends NewsContract.INewsPresenter {

    private static final String TAG = "NewsArticlePresenter";
    private List<MultiNewsArticleDataBean> dataList = new ArrayList<>();
    private String category;
    private String time;
    private Gson gson = new Gson();
    private Random random = new Random();

    public NewsImpl() {
        this.time = TimeUtil.getInstance().getCurrentTimeStamp();
    }

    @Override
    public void doLoadData(String... category) {
        try{
            if(this.category == null){
                this.category = category[0];
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        if (dataList.size() > 150) {
            dataList.clear();
        }

        getRandom()
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        iHttpView.showLoading();
                    }
                })
                .subscribeOn(Schedulers.io())
                .switchMap(new Function<MultiNewsArticleBean, ObservableSource<MultiNewsArticleDataBean>>() {
                    @Override
                    public ObservableSource<MultiNewsArticleDataBean> apply(MultiNewsArticleBean multiNewsArticleBean) throws Exception {
                        List<MultiNewsArticleDataBean> dataList = new ArrayList<>();
                        for (MultiNewsArticleBean.DataBean dataBean : multiNewsArticleBean.getData()) {
                            dataList.add(gson.fromJson(dataBean.getContent(),MultiNewsArticleDataBean.class));
                        }
                        return Observable.fromIterable(dataList);
                    }
                })
                .filter(new Predicate<MultiNewsArticleDataBean>() {
                    @Override
                    public boolean test(MultiNewsArticleDataBean dataBean) throws Exception {
                        time = dataBean.getBehot_time();
                        if(TextUtils.isEmpty(dataBean.getSource())) {
                            return false;
                        }
                        try {
                            if(dataBean.getSource().contains("头条问答")
                            || dataBean.getTag().contains("ad")
                            || dataBean.getSource().contains("悟空问答")){
                                return false;
                            }
                            if(dataBean.getRead_count() == 0 || TextUtils.isEmpty(dataBean.getMedia_name())) {
                                String title = dataBean.getTitle();
                                if(title.lastIndexOf("？") == title.length() - 1){
                                    return false;
                                }
                            }
                        } catch(NullPointerException e) {
                            e.printStackTrace();
                        }
                        for (MultiNewsArticleDataBean bean : dataList) {
                            if (bean.getTitle().equals(dataBean.getTitle())) {
                                return false;
                            }
                        }
                        return true;
                    }
                })
                .toList()
                .map(new Function<List<MultiNewsArticleDataBean>, List<MultiNewsArticleDataBean>>() {
                    @Override
                    public List<MultiNewsArticleDataBean> apply(List<MultiNewsArticleDataBean> newsArticleDataBeans) throws Exception {
                        for (int i = 0; i < newsArticleDataBeans.size() - 1; i++) {
                            for (int j = newsArticleDataBeans.size() - 1; j > i; j--) {
                                if(newsArticleDataBeans.get(j).getTitle().equals(newsArticleDataBeans.get(i).getTitle())) {
                                    newsArticleDataBeans.remove(j);
                                }
                            }
                        }
                        return newsArticleDataBeans;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<MultiNewsArticleDataBean>>() {
                               @Override
                               public void accept(List<MultiNewsArticleDataBean> newsArticleDataBeans) throws Exception {
                                   if(null != newsArticleDataBeans && newsArticleDataBeans.size() > 0){
                                       dataList.addAll(newsArticleDataBeans);
                                       iHttpView.onLoadData(dataList);
                                       iHttpView.hideLoading(true,null);
                                   }
                               }
                           }
                        , new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                iHttpView.hideLoading(false,null);
                            }
                        });
    }

    @Override
    public void doLoadMoreData() {
        doLoadData();
    }

    @Override
    public void doRefresh() {
        if (dataList.size() != 0) {
            dataList.clear();
            time = TimeUtil.getInstance().getCurrentTimeStamp();
        }
        doLoadData();
    }


    private Observable<MultiNewsArticleBean> getRandom() {
        time = TimeUtil.getInstance().getCurrentTimeStamp();
        int i = random.nextInt(10);
        if(i % 2 == 0){
            return RetrofitHelper.getElseApi()
                    .getNewsArticle2(category,time);
        } else {
            return RetrofitHelper.getMobileNewsApi()
                    .getNewsArticle(category,time);
        }

    }
}
