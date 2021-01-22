package com.bw.home.application;


import com.bw.framework.manage.LabelsManage;

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //GreenDao初始化
        LabelsManage.getInstance().init(this);

    }


}
