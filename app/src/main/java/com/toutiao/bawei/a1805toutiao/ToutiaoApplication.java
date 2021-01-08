package com.toutiao.bawei.a1805toutiao;

import android.app.Application;

import com.kuaishou.bawei.net.NetModule;

public class ToutiaoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        NetModule.init(this);
    }
}
