package com.example.a1805toutiao;

import android.app.Application;
import android.content.Context;

import com.example.framework.manager.SettingUtil;

public
class TouTiaoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SettingUtil.getInstance().init(this);

        initTheme();
    }

    private void initTheme() {
        SettingUtil instance = SettingUtil.getInstance();
        //获取SettingUtil中的切换模式的方法 该方法返回boolean 类型
        if (instance.getInstance().getIsAutoNightMode()){
            int nightStartHour = Integer.parseInt(instance.getNightStartHour());

        }
    }






}
