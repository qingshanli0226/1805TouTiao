package com.song.net.api;

import com.song.common.BaseBean;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface NetWorkAPI {

    @GET
    @Streaming
    Observable<ResponseBody> downloadFile(@Url String url);

    @Multipart
    @POST("upload")
    Observable<BaseBean<String>> uploadFile(@Part("body") RequestBody body, @Part MultipartBody.Part file);

}
