package com.bw.a1805atoutiao.application;

import com.bw.framework.manage.TitleManage;

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //GreenDao初始化
        TitleManage.getInstance().init(this);

    }


}
