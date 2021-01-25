package com.example.onemyapp;

import android.content.Context;


import com.example.framewrok.base.view.Preferences;

public class UiUtils {
    //获取主题

    public static int getAppTheme(Context ctx) {
//        给他的默认值是1默认是白天模式

        String value = Preferences.getString(ctx, "activity_theme", "1");

        switch (Integer.valueOf(value)) {

            case 1:
//默认系统自带的主题
                return R.style.AppTheme;//白色主题

            case 2:

                return R.style.AppTheme_Black;

            default:

                return R.style.AppTheme;//默认白色

        }

    }
//    通过点击时给activity_theme不同的值

    public static void switchAppTheme( Context ctx){

        String value = Preferences.getString(ctx, "activity_theme", "1");

        switch (Integer.valueOf(value)){

            case 1:

                Preferences.setString(ctx, "activity_theme", "2");

                break;

            case 2:

                Preferences.setString(ctx, "activity_theme", "1");

                break;

            default:

                Preferences.setString(ctx, "activity_theme", "1");

                break;

        }

    }
}
