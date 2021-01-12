package com.song.news.fragment.contract;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.song.fromwork.utils.TimeUtil;
import com.song.net.RetrofitHelper;
import com.song.net.mode.mobile.wenda.WendaArticleBean;
import com.song.net.mode.mobile.wenda.WendaArticleDataBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class WendaImpl extends WendaContract.IWendaPresenter {

    private Gson gson = new Gson();
    private String time;
    private List<WendaArticleDataBean> dataList = new ArrayList<>();

    public WendaImpl(){
        this.time = TimeUtil.getInstance().getCurrentTimeStamp();
    }


    @Override
    public void doLoadData() {

        // 释放内存
        if (dataList.size() > 100) {
            dataList.clear();
        }

        time = TimeUtil.getInstance().getCurrentTimeStamp();
        RetrofitHelper.getMobileWendaApi()
                .getWendaArticle(time)
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        iHttpView.showLoading();
                    }
                })
                .subscribeOn(Schedulers.io())
                .switchMap(new Function<WendaArticleBean, ObservableSource<WendaArticleDataBean>>() {
                    @Override
                    public ObservableSource<WendaArticleDataBean> apply(WendaArticleBean wendaArticleBean) throws Exception {
                        List<WendaArticleDataBean> list = new ArrayList<>();
                        for (WendaArticleBean.DataBean bean : wendaArticleBean.getData()) {
                            WendaArticleDataBean contentBean = gson.fromJson(bean.getContent(), WendaArticleDataBean.class);
                            list.add(contentBean);
                        }
                        return Observable.fromIterable(list);
                    }
                })
                .filter(new Predicate<WendaArticleDataBean>() {
                    @Override
                    public boolean test(WendaArticleDataBean wendaArticleDataBean) throws Exception {
                        return !TextUtils.isEmpty(wendaArticleDataBean.getQuestion());
                    }
                })
                .map(new Function<WendaArticleDataBean, WendaArticleDataBean>() {
                    @Override
                    public WendaArticleDataBean apply(WendaArticleDataBean wendaArticleDataBean) throws Exception {
                        WendaArticleDataBean.ExtraBean extraBean = gson.fromJson(wendaArticleDataBean.getExtra(), WendaArticleDataBean.ExtraBean.class);
                        WendaArticleDataBean.QuestionBean questionBean = gson.fromJson(wendaArticleDataBean.getQuestion(), WendaArticleDataBean.QuestionBean.class);
                        WendaArticleDataBean.AnswerBean answerBean = gson.fromJson(wendaArticleDataBean.getAnswer(), WendaArticleDataBean.AnswerBean.class);
                        wendaArticleDataBean.setExtraBean(extraBean);
                        wendaArticleDataBean.setQuestionBean(questionBean);
                        wendaArticleDataBean.setAnswerBean(answerBean);

                        time = wendaArticleDataBean.getBehot_time();
                        return wendaArticleDataBean;
                    }
                })
                .filter(new Predicate<WendaArticleDataBean>() {
                    @Override
                    public boolean test(WendaArticleDataBean wendaArticleDataBean) throws Exception {
                        for (WendaArticleDataBean bean : dataList) {
                            if (bean.getQuestionBean().getTitle().equals(wendaArticleDataBean.getQuestionBean().getTitle())) {
                                return false;
                            }
                        }
                        return true;
                    }
                })

                .toList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<WendaArticleDataBean>>() {
                    @Override
                    public void accept(List<WendaArticleDataBean> wendaArticleDataBeans) throws Exception {
                        iHttpView.onLoadData(wendaArticleDataBeans);
                        iHttpView.hideLoading(true, null);
                    }
                }, new Consumer<Throwable>() {
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
}
