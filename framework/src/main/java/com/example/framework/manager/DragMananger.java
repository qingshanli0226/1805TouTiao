package com.example.framework.manager;

import android.content.Context;
import android.os.Handler;
import android.util.Log;


import com.example.framework.dao.DaoMaster;
import com.example.framework.dao.DaoSession;
import com.example.framework.dao.DragBean;
import com.example.framework.dao.DragBeanDao;


import org.greenrobot.greendao.annotation.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DragMananger {
    private Context context;
    private static DragMananger instance;
    private String DB_NAME = "drag.db";
    private DragBeanDao dragBeanDao;
    private List<DragBean> dragBeanList = new ArrayList<>();
    private List<String> stringList = new ArrayList<>();
    //创建一个全局的线程池
    private ExecutorService service = Executors.newSingleThreadExecutor();
    private Handler handler = new Handler();

    public static DragMananger getInstance(){
        if (instance == null){
            instance = new DragMananger();
        }
        return instance;
    }
    private DragMananger(){

    }
    //初始化
    public void init(Context context){
        this.context = context;
        //初始化数据库
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context,"drag");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        DaoSession daoSession = daoMaster.newSession();
        dragBeanDao = daoSession.getDragBeanDao();
        Log.e("###","111");
    }
    //刚开始初始化数据的方法
    public void addDrag(@NotNull final String[] stringname, final String[] stringId){
        service.execute(new Runnable() {
            @Override
            public void run() {
                if (dragBeanList.size() == 0){
                    for (int i =0; i<stringname.length; i++) {
                        DragBean dragBean;
                        //默认显示8条数据
                        if (i<8){
                            dragBean = new DragBean(null,stringname[i],stringId[i],true);
                        }else {
                            dragBean = new DragBean(null,stringname[i],stringId[i],false);
                        }
                        //添加到数据库当中
                        insertDrag(dragBean);
                    }
                }
            }
        });
    }
    //让别的类能够拿到缓存集合
    public List<DragBean> getDragList(){
        return dragBeanList;
    }
    //将从查询到的数据全部加入到缓存当中
    public void addDragList(){
        dragBeanList = dragBeanDao.queryBuilder().list();
    }
    //添加数据库及其缓存
    public void insertDrag(DragBean dragBean){
        //数据库添加
        dragBeanDao.insert(dragBean);
    }

    //使用接口回调来刷新Ui
    public interface IDragDownListenter{
        void onresult(List<DragBean> list);
    }

}
