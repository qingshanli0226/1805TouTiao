package com.example.net.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCreater {
    private static IMobileMEdiaApi iMobileMEdiaApi;

    public static IMobileMEdiaApi getiMobileMEdiaApi() {
        if(iMobileMEdiaApi==null){
            iMobileMEdiaApi=createApi();
        }
        return iMobileMEdiaApi;
    }

    private static IMobileMEdiaApi createApi() {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                .writeTimeout(5000, TimeUnit.MILLISECONDS)
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(CommonConstant.TOUTIAO_COM)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IMobileMEdiaApi iMobileMEdiaApi = retrofit.create(IMobileMEdiaApi.class);
        return iMobileMEdiaApi;
    }
}
