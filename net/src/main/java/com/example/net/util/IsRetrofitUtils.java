package com.example.net.util;



import com.example.common.HomeUrl;
import com.example.net.ShopmallApiService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public  class IsRetrofitUtils {

    private static volatile ShopmallApiService shopmallApiService;


    public static synchronized ShopmallApiService getShopmallApiService(){
        if (shopmallApiService==null){
            shopmallApiService = createKSApiService();
        }
        return shopmallApiService;
    }

    public static ShopmallApiService createKSApiService(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .writeTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .callTimeout(5, TimeUnit.MINUTES);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HomeUrl.HTTPISURL)
                .client(builder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ShopmallApiService.class);
    }



}
