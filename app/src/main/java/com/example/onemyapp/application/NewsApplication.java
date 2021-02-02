package com.example.onemyapp.application;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;


import com.alibaba.android.arouter.launcher.ARouter;

import com.example.framewrok.base.NetModule;

import com.example.framewrok.base.glide.NewsGlide;
import com.example.framewrok.base.glide.NewsRequest;
import com.example.framewrok.base.net.NetConnectManager;
import com.example.onemyapp.NewsManager;
import com.example.onemyapp.bean.DaoMaster;
import com.example.onemyapp.bean.DaoSession;
import com.example.webpage.MessageManager;

public class NewsApplication extends Application {
    public static DaoSession daoSession;
    @Override
    public void onCreate() {
        super.onCreate();
       DaoMaster.DevOpenHelper devOpenHelper=new DaoMaster.DevOpenHelper(this,"lable");
        SQLiteDatabase writableDatabase = devOpenHelper.getWritableDatabase();
        daoSession=new DaoMaster(writableDatabase).newSession();
        NewsManager.getInstance().init(this);
        NewsGlide.getInstance().init(this);
        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(NewsApplication.this);
          NetConnectManager.getInstance().init(this);
        NetModule.init(this);
        MessageManager.getInstance().init(this);

    }
    public static DaoSession getDaoSession(){
        return daoSession;
    }
}
