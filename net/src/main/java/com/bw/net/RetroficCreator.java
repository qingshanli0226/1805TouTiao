package com.bw.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroficCreator {

    private static INetWorkApiService iNetWorkApiService;

    public static INetWorkApiService getiNetWorkApiService(){
        if (iNetWorkApiService == null){
            iNetWorkApiService = createINetWorkApiService();
        }
        return iNetWorkApiService;
    }

    private static INetWorkApiService createINetWorkApiService() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Contents.BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        INetWorkApiService iNetWorkApiService = retrofit.create(INetWorkApiService.class);
        return iNetWorkApiService;
    }

}
