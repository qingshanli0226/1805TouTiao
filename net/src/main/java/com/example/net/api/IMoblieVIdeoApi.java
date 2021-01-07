package com.example.net.api;


import android.database.Observable;

import com.example.net.bean.news.MultiNewsArticleBean;

import retrofit2.http.GET;
import retrofit2.http.Query;

//获取视屏标题等
public
interface IMoblieVIdeoApi {
    /**
     * 获取视频标题等信息
     * http://is.snssdk.com/api/news/feed/v53/?category=subv_cute&refer=1&count=20&max_behot_time=1499321562&iid=11776029171&device_id=36394312781
     */
    @GET("http://is.snssdk.com/api/news/feed/v62/?iid=5034850950&device_id=6096495334&refer=1&count=20&aid=13")
    Observable<MultiNewsArticleBean> getVideoArticle(
            @Query("category") String category,
            @Query("max_behot_time") String maxBehotTime);
}
