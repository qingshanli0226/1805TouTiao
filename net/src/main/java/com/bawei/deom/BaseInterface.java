package com.bawei.deom;

import com.example.net.bean.ImagesBean;
import com.example.net.bean.JournalismBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface BaseInterface {
    @GET("?iid=12507202490&device_id=37487219424&category=news_hots")//推荐
    Observable<JournalismBean>journalis();
    @GET("?iid=5034850950&device_id=6096495334&refer=1&count=20&aid=13&category=news_hot&max_behot_time=1610064590")//热点
   Observable<JournalismBean>hotnews();
    @GET("iid=5034850950&device_id=6096495334&refer=1&count=20&aid=13&category=video&max_behot_time=1610064590")//视屏
    Observable<JournalismBean>video();
    @GET("as=A115C8457F69B85&cp=585F294B8845EE1&_signature=l&category=%E7%BB%84%E5%9B%BE&max_behot_time=1610065111")//全部图片
    Observable<ImagesBean>image();
}