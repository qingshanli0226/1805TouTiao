package com.song.a1805toutiao;

import android.app.Application;
import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;

import com.alibaba.android.arouter.launcher.ARouter;
import com.song.fromwork.dao.NewsChannelManager;
import com.song.fromwork.utils.CacheManager;
import com.song.fromwork.utils.InitApp;
import com.song.fromwork.utils.SettingUtil;

import java.util.Calendar;

public class MyApp extends Application {

    public static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
        NewsChannelManager.getInstance().init(appContext);
        CacheManager.getInstance().init(appContext);

        ARouter.openDebug();
        ARouter.openLog();
        ARouter.init(MyApp.this);
        InitApp.init(appContext);

        initTheme();
    }

    private void initTheme() {
        SettingUtil settingUtil = SettingUtil.getInstance();

        // 获取是否开启 "自动切换夜间模式"
        if (settingUtil.getIsAutoNightMode()) {

            int nightStartHour = Integer.parseInt(settingUtil.getNightStartHour());
            int nightStartMinute = Integer.parseInt(settingUtil.getNightStartMinute());
            int dayStartHour = Integer.parseInt(settingUtil.getDayStartHour());
            int dayStartMinute = Integer.parseInt(settingUtil.getDayStartMinute());

            Calendar calendar = Calendar.getInstance();
            int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
            int currentMinute = calendar.get(Calendar.MINUTE);

            int nightValue = nightStartHour * 60 + nightStartMinute;
            int dayValue = dayStartHour * 60 + dayStartMinute;
            int currentValue = currentHour * 60 + currentMinute;

            if (currentValue >= nightValue || currentValue <= dayValue) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                settingUtil.setIsNightMode(true);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                settingUtil.setIsNightMode(false);
            }

        } else {
            // 获取当前主题
            if (settingUtil.getIsNightMode()) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        }
    }
}
