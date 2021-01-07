package com.example.net.api;


import android.database.Observable;

import com.example.net.bean.video.VideoContentBean;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * name:tianyanyue
 * time:2021/1/6
 * 视频
 */

public
interface IVideoApi {

    /**
     * 获取视屏标题等信息
     * 网址及类型如下 (网址"http://toutiao.com/" 已写成 )
     * http://toutiao.com/api/article/recent/?source=2&category=类型&as=A105177907376A5&cp=5797C7865AD54E1&count=20"
     */

    @GET("api/article/recent/?source=2&as=A105177907376A5&cp=5797C7865AD54E1&count=30")
    Observable<ResponseBody> getVideoArticle(
            @Query("category") String category,
            @Query("_") String time
    );

    /**
     * 获取视屏信息
     * http://ib.365yg.com/video/urls/v/1/toutiao/mp4/视频ID?r=17位随机数&s=加密结果
     */
    @GET
    Observable<VideoContentBean> getVideoContent(@Url String url);


}
