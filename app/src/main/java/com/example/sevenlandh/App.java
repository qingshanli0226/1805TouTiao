package com.example.sevenlandh;

import android.app.Application;

import com.example.sevenlandh.entity.DaoMaster;
import com.example.sevenlandh.entity.DaoSession;
import androidx.multidex.MultiDex;

public class App extends Application {
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        initDao();
        MultiDex.install(this);
    }

    private void initDao() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "home-db");
        daoSession = new DaoMaster(devOpenHelper.getReadableDb()).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;

    }
}
