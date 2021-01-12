package com.toutiao.bawei.a1805toutiao;

import android.app.Application;

import com.bumptech.glide.Glide;
import com.kuaishou.bawei.net.NetModule;
import com.toutiao.bawei.a1805toutiao.glide.NewsGlide;

public class ToutiaoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        NetModule.init(this);
    }
}
