package com.example.framework.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public
class SettingUtil {
    /**
     * 获取唯一单例对象
     */
    private static SettingUtil settingUtil = null;

    /**
     * 获取上下文
     */
    private Context context;

    /**
     * 做出唯一实例
     * @return
     */

    /**
     * 获取系统sp
     */

//    private SharedPreferences setting = PreferenceManager.getDefaultSharedPreferences(context);
    public static SettingUtil getInstance(){
        if (settingUtil ==null){
            synchronized (SettingUtil.class){
                if (settingUtil==null){
                    settingUtil = new SettingUtil();
                }
            }
        }
        return settingUtil;
    }

    /**
     * 从application中传入一上下文对象
     * @param applicationContext
     */
    public void init(Context applicationContext){
        context = applicationContext;
    }

    /**
     * 获取是否自动切换夜间模式
     * 通过返回值false/true判断
     * @return
     */
/*    public boolean getIsAutoNightMode() {
        return setting.getBoolean("auto_nightMode",false);
    }*/

    public String getNightStartHour() {
        return "";
    }
}
