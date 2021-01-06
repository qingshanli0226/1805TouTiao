package com.song.net.api;

import com.song.net.UrlHelper;
import com.song.net.mode.photo.PhotoArticleBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface PhotoApi {
    /**
     * 获取图片标题等信息
     * http://www.toutiao.com/api/article/feed/?category=类型&as=A115C8457F69B85&cp=585F294B8845EE1&_=时间&count=30
     */
    @GET("api/pc/feed/?as=A115C8457F69B85&cp=585F294B8845EE1&_signature=l")
    Observable<PhotoArticleBean> getPhotoArticle(
            @Query("category") String category,
            @Query("max_behot_time") String time);
}
