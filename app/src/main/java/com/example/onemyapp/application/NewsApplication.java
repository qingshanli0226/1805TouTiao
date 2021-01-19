package com.example.onemyapp.application;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.framewrok.base.NetModule;
import com.example.onemyapp.NewsManager;
import com.example.onemyapp.bean.DaoMaster;
import com.example.onemyapp.bean.DaoSession;

public class NewsApplication extends Application {
    public static DaoSession daoSession;
    @Override
    public void onCreate() {
        super.onCreate();
       DaoMaster.DevOpenHelper devOpenHelper=new DaoMaster.DevOpenHelper(this,"lable");
        SQLiteDatabase writableDatabase = devOpenHelper.getWritableDatabase();
        daoSession=new DaoMaster(writableDatabase).newSession();
        NewsManager.getInstance().init(this);
        NetModule.init(this);
    }
    public static DaoSession getDaoSession(){
        return daoSession;
    }
}
