package com.example.a1805toutiao.app;

import android.app.Application;

import com.example.a1805toutiao.R;
import com.example.framework.manager.DragMananger;

public class AppAplcation extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DragMananger.getInstance().init(this);

    }
}
