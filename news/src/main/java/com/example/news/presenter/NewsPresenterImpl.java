package com.example.news.presenter;

import androidx.lifecycle.Observer;

import com.example.news.contract.NewsContract;

import bean.NewsBean;
import uitls.HeadConfig;
import uitls.HttpRetrofitManager;
import uitls.ITouTiaoApiService;

public class NewsPresenterImpl extends NewsContract.NewsPresenter {
    @Override
    public void getNewsInfo(Observer<NewsBean> observer) {

         HttpRetrofitManager.getHttpRetrofitManager().getRetrofit(HeadConfig.BASE_URL_IS)
                 .create(ITouTiaoApiService.class);
//                 .getNews();

    }
}
