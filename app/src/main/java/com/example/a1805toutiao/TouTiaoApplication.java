package com.example.a1805toutiao;

import android.app.Application;

import com.example.framework.dao.MessageMangerUlis;
import com.example.framework.manager.SettingUtil;
import com.example.framework.manager.TouTiaoGlide;

public
class TouTiaoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SettingUtil.getInstance().init(this);
        MessageMangerUlis.getInstance().init(this);
        initTheme();
    }
    //侧滑栏设置方法
    private void initTheme() {
        SettingUtil instance = SettingUtil.getInstance();
        TouTiaoGlide.getInstance().init(this);
        //获取SettingUtil中的切换模式的方法 该方法返回boolean 类型
//        if (instance.getInstance().getIsAutoNightMode()){
//            int nightStartHour = Integer.parseInt(instance.getNightStartHour());
//
//        }

    }





}
