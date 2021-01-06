package com.song.net.api;

import com.song.net.UrlHelper;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Url;

public interface NewsApi {
    /**
     * 获取新闻内容的API
     */
    @GET
    @Headers("User-Agent:" + UrlHelper.USER_AGENT_MOBILE)
    Observable<ResponseBody> getNewsContentRedirectUrl(@Url String url);
}
