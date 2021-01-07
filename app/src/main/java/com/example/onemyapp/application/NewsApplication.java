package com.example.onemyapp.application;

import android.app.Application;

import com.example.framewrok.base.NewsManager;

public class NewsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        NewsManager.getInstance().init(this);
    }
}
