package com.bawei.deom;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClassInterface {
    private static BaseInterface baseInterface;
    private static BaseInterface baseInterface2;
    public static BaseInterface getBaseInterface(String s){
        if (baseInterface==null){
            baseInterface=getBaseUserInterface(s);
        }
        return baseInterface;
    }

    public static BaseInterface getBaseUserInterface(String s) {
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .writeTimeout(5000, TimeUnit.SECONDS)
                .readTimeout(5000,TimeUnit.SECONDS)
                .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
     if (s.equals("生活")||s.equals("影视")||s.equals("推荐")){
         Retrofit retrofit=new Retrofit.Builder()
                 .baseUrl(BaseUrl.ShengUrl)
                 .client(okHttpClient)
                 .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                 .addConverterFactory(GsonConverterFactory.create())
                 .build();
         BaseInterface baseInterface = retrofit.create(BaseInterface.class);
         return  baseInterface;
     }else {
         Retrofit retrofit=new Retrofit.Builder()
                 .baseUrl(BaseUrl.UrlS)
                 .client(okHttpClient)
                 .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                 .addConverterFactory(GsonConverterFactory.create())
                 .build();
         BaseInterface baseInterface = retrofit.create(BaseInterface.class);
         return  baseInterface;
     }


    }

}
