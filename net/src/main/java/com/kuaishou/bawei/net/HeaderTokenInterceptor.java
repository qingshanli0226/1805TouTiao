package com.kuaishou.bawei.net;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderTokenInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        //通过拦截器在请求头上，添加token
        SharedPreferences sharedPreferences = NetModule.context.getSharedPreferences("SP", Context.MODE_PRIVATE);
        String token = sharedPreferences.getString("token", "");
        Request request = chain.request();
        Request newRequest = request.newBuilder().addHeader("appversion", "1.0").addHeader("token", token).build();
        return chain.proceed(newRequest);
    }
}
