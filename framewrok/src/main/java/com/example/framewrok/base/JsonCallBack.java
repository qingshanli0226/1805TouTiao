package com.example.framewrok.base;

import com.google.gson.Gson;
import com.lzy.okgo.callback.AbsCallback;

import okhttp3.Response;

public abstract class JsonCallBack<T> extends AbsCallback<T> {
    private Class<T> tClass;

    public JsonCallBack(Class<T> tClass) {
        this.tClass = tClass;
    }
    //核心：将response转成自己想要的对象
    @Override
    public T convertResponse(Response response) throws Throwable {
        //自己解析
        String string = response.body().string();
        Gson gson = new Gson();
        T t = gson.fromJson(string, tClass);
        return t;
    }
}