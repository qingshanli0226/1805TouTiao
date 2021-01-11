package com.example.framework.dao;


import android.content.Context;
import android.os.Handler;

import org.greenrobot.greendao.annotation.NotNull;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 数据库单例
 */

public
class MessageMangerUlis {
    private static MessageMangerUlis instance;
    private Context alpplicationContext;
    private final String MMU_NAME  = "DB_NAME";//数据库名
    private TouTiaoMessageGreenBeanDao touTiaoMessageGreenBeanDao;
    private Handler handler = new Handler();
    //创建一个全局线程池
    private ExecutorService executorService = Executors.newCachedThreadPool();
    public static MessageMangerUlis getInstance(){
        if (instance == null){
            synchronized (MessageMangerUlis.class){
                if (instance == null){
                    instance = new MessageMangerUlis();
                }
            }
        }
        return instance;
    }

    public  void init(Context context){
        this.alpplicationContext = context;
        //初始化数据库
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(alpplicationContext, MMU_NAME);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        touTiaoMessageGreenBeanDao = daoMaster.newSession().getTouTiaoMessageGreenBeanDao();


    }

    //使用线程池来做存储数据，不能在主线程中操作数据里
    public void addMessage(@NotNull final TouTiaoMessageGreenBean messageGreenBean, final IMessageListener iMessageListener){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                touTiaoMessageGreenBeanDao.insert(messageGreenBean);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (iMessageListener!=null){
                            iMessageListener.OnResult(true,null);
                        }
                    }
                });
            }
        });
    }

    public void deleteMessage(@NotNull final TouTiaoMessageGreenBean messageGreenBean, final IMessageListener iMessageListener){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                touTiaoMessageGreenBeanDao.deleteAll();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (iMessageListener!=null){
                            iMessageListener.OnResult(true,null);
                        }
                    }
                });
            }
        });
    }
    public void queryMessage(@NotNull final  IMessageListener iMessageListener){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                final List<TouTiaoMessageGreenBean> list = touTiaoMessageGreenBeanDao.queryBuilder().limit(50).list();

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iMessageListener.OnResult(true,list);
                    }
                });
            }
        });
    }

    public interface IMessageListener{
        void OnResult(boolean isSuccess, List<TouTiaoMessageGreenBean> touTiaoMessageGreenBeanDao);
    }
}
