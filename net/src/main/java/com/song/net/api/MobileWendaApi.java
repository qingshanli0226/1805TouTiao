package com.song.net.api;

import com.song.net.UrlHelper;
import com.song.net.mode.mobile.wenda.WendaArticleBean;
import com.song.net.mode.mobile.wenda.WendaContentBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface MobileWendaApi {
    /**
     * 获取头条问答标题等信息
     * http://is.snssdk.com/wenda/v1/native/feedbrow/?category=question_and_answer&wd_version=5&count=20&max_behot_time=1495245397?iid=10344168417&device_id=36394312781
     *
     * @param maxBehotTime 时间轴
     */
    @GET("wenda/v1/native/feedbrow/?iid=10344168417&device_id=36394312781&category=question_and_answer&wd_version=5&count=20&aid=13")
    Observable<WendaArticleBean> getWendaArticle(
            @Query("max_behot_time") String maxBehotTime);

    /**
     * 获取头条问答优质回答
     * http://is.snssdk.com/wenda/v1/question/brow/?iid=10344168417&device_id=36394312781
     *
     * @param qid 问答ID
     */
    @POST("wenda/v1/question/brow/?iid=10344168417&device_id=36394312781")
    @FormUrlEncoded
    Observable<WendaContentBean> getWendaNiceContent(@Field("qid") String qid);

    /**
     * 获取头条问答优质回答(加载更多)
     * http://is.snssdk.com/wenda/v1/question/loadmore/?iid=10344168417&device_id=36394312781
     *
     * @param qid    问答ID
     * @param offset 偏移量
     */
    @POST("wenda/v1/question/loadmore/?iid=10344168417&device_id=36394312781")
    @FormUrlEncoded
    Observable<WendaContentBean> getWendaNiceContentLoadMore(
            @Field("qid") String qid,
            @Field("offset") int offset);

    @POST("wenda/v1/questionother/loadmore/?iid=10344168417&device_id=36394312781")
    @FormUrlEncoded
    Observable<WendaContentBean> getWendaNormalContentLoadMore(
            @Field("qid") String qid,
            @Field("offset") int offset);

}