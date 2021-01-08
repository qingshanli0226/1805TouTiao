package com.bw.net;

import com.example.common.Constant;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroficCreator {

    private static INetWorkApiService iNetWorkApiServiceMOBILEMEDIA;

    public static INetWorkApiService iNetWorkApiServiceMOBILEMEDIA(){
        if (iNetWorkApiServiceMOBILEMEDIA == null){
            iNetWorkApiServiceMOBILEMEDIA = createIMOBILEMEDIA();
        }
        return iNetWorkApiServiceMOBILEMEDIA;
    }

    private static INetWorkApiService createIMOBILEMEDIA() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.MOBILE_MEDIA)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        INetWorkApiService iNetWorkApiService = retrofit.create(INetWorkApiService.class);
        return iNetWorkApiService;
    }


    private static INetWorkApiService iNetWorkApiServiceHost;

    public static INetWorkApiService getiNetWorkApiServiceHost(){
        if (iNetWorkApiServiceHost == null){
            iNetWorkApiServiceHost = createIHOST();
        }
        return iNetWorkApiServiceHost;
    }

    private static INetWorkApiService createIHOST() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.HOST)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        INetWorkApiService iNetWorkApiService = retrofit.create(INetWorkApiService.class);
        return iNetWorkApiService;
    }


}
