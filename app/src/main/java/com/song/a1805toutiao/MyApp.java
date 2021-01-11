package com.song.a1805toutiao;

import android.app.Application;
import android.content.Context;

import com.song.fromwork.dao.NewsChannelManager;

public class MyApp extends Application {

    public static Context appContext;
    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
        NewsChannelManager.getInstance().init(appContext);
    }
}