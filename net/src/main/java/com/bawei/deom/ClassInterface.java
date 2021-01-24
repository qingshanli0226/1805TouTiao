package com.bawei.deom;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClassInterface {
    private static BaseInterface baseInterface;

    public static BaseInterface getBaseInterface(){
        if (baseInterface==null){
            baseInterface=getBaseUserInterface();
        }
        return baseInterface;
    }

    private static BaseInterface getBaseUserInterface() {
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .writeTimeout(5000, TimeUnit.SECONDS)
                .readTimeout(5000,TimeUnit.SECONDS)
                .connectTimeout(5000,TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
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
