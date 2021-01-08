package com.kuaishou.bawei.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

//retrofit创建网络接口
public class RetrofitCreator {

    private static INetworkApiService iNetworkApiService;
    public RetrofitCreator() {

    }


    public static INetworkApiService getNetworkApiService() {
        if (iNetworkApiService == null) {
            iNetworkApiService = createNetworkApiService();
        }

        return iNetworkApiService;
    }

    private static INetworkApiService createNetworkApiService() {
        //Retrofit底层封装是okhttpclient
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5,TimeUnit.SECONDS)//超时连接
                .readTimeout(5,TimeUnit.SECONDS)//读超时连接
                .writeTimeout(5,TimeUnit.SECONDS)//写超时连接
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))//打印log
                .addInterceptor(new HeaderTokenInterceptor())//把token拦截器添加上
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //创建实现该接口的一个类,就是说该类实现了INetworkAPIService接口
        INetworkApiService iNetworkApiService = retrofit.create(INetworkApiService.class);

        return iNetworkApiService;
    }


}
