package com.example.framework.manager;

import android.content.Context;

import com.example.framework.dao.DaoMaster;

public class DragMananger {
    private Context context;
    private static DragMananger instance;
    private String DB_NAME = "dragdown.db";
    private DragMananger(){

    }
    public static DragMananger getInstance(){
        if (instance == null){
            instance = new DragMananger();
        }
        return instance;
    }
    public void init(Context context){
        this.context = context;
        //初始化数据库
        new DaoMaster.DevOpenHelper(context,DB_NAME);
    }
}
