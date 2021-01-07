package com.example.net.api;

import android.database.Observable;

import com.example.net.bean.photo.PhotoArticleBean;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * name:tianyanyue
 * time:2021/1/6
 * 图片
 */
public
interface IPhotoApi {
    /**
     * 获取图片标题等信息
     * http://www.toutiao.com/api/article/feed/?category=类型&as=A115C8457F69B85&cp=585F294B8845EE1&_=时间&count=30
     */
    @GET("api/pc/feed/?as=A115C8457F69B85&cp=585F294B8845EE1&_signature=l")
    Observable<PhotoArticleBean> getPhotoArticle(
            @Query("category") String category,
            @Query("max_behot_time") String time);

    /**
     * 获取图片内容html内容
     */
    @GET()
    @Headers("User-Agent:" + CommonConstant.USER_AGENT_PC)
    Call<ResponseBody> getPhotoContentHTML(@Url String url);
}
