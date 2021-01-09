package com.bw.net;

import com.bw.common.Constants;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrfitFactory {

    private static volatile RetrfitFactory retrfitFactory=null;

    /**
     * 双重锁
     * @return
     */
    public static RetrfitFactory getRetrfitFactory(){
           if (retrfitFactory==null){
               synchronized (RetrfitFactory.class){
                   if (null==retrfitFactory){
                       retrfitFactory=new RetrfitFactory();
                   }
               }
           }
           return retrfitFactory;
    }

    private Retrofit retrofit;

    private RetrfitFactory(){
        createRetrfit();
    }

    private void createRetrfit() {
          retrofit=new Retrofit.Builder()
                  .baseUrl(Constants.BASE3)
                  .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                  .addConverterFactory(GsonConverterFactory.create())
                  .client(createClient())
                  .build();
    }

    /**
     * 创建客户端
     * @return
     */
    private OkHttpClient createClient() {
        OkHttpClient build = new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .addNetworkInterceptor(createhttplogging())
                .addInterceptor(createIntercepor())
                .build();
        return build;
    }

    /**
     * 添加请求头
     * @return
     */
    private Interceptor createIntercepor() {
        Interceptor interceptor=new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request token = request.newBuilder()
                        .addHeader("token", "1.0")
                        .build();

                Response proceed = chain.proceed(token);
                return proceed;
            }
        };
        return interceptor;
    }

    /**
     * 网络拦截
     * @return
     */
    private Interceptor createhttplogging() {
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }


    public <T> T setInstance(Class<T> service){
        return retrofit.create(service);
    }
}
