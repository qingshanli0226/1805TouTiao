package com.example.framework.manager;


import android.content.Context;
import android.os.Handler;

import com.example.framework.R;
import com.example.framework.dao.DaoMaster;
import com.example.framework.dao.TouTiaoMessageGreenBean;
import com.example.framework.dao.TouTiaoMessageGreenBeanDao;
import com.example.framework.manager.listener.IMessageListener;


import org.greenrobot.greendao.annotation.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 数据库单例
 */

public class MessageManager {
    private static MessageManager instance;
    private Context alpplicationContext;
    private final String MMU_NAME  = "DB_NAME";//数据库名
    private TouTiaoMessageGreenBeanDao touTiaoMessageGreenBeanDao;
    private Handler handler = new Handler();
    private List<TouTiaoMessageGreenBean> comList = new ArrayList<>();
    private List<TouTiaoMessageGreenBean> editList = new ArrayList<>();
    //创建一个全局线程池
    private ExecutorService executorService = Executors.newCachedThreadPool();
    public static MessageManager getInstance(){
        if (instance == null){
            synchronized (MessageManager.class){
                if (instance == null){
                    instance = new MessageManager();
                }
            }
        }
        return instance;
    }
    public Integer getTagsCount(){

        return comList.size()+editList.size();
    }
    public  void init(Context context){
        this.alpplicationContext = context;
        //初始化数据库
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(alpplicationContext, MMU_NAME);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        touTiaoMessageGreenBeanDao = daoMaster.newSession().getTouTiaoMessageGreenBeanDao();
        queryMessage(new IMessageListener() {
            @Override
            public void OnResult(boolean isSuccess, List<TouTiaoMessageGreenBean> touTiaoMessageGreenBeanDao) {
                if(isSuccess){
                    if(touTiaoMessageGreenBeanDao.size()>0){
                        for (TouTiaoMessageGreenBean touTiaoMessageGreenBean : touTiaoMessageGreenBeanDao) {
                            if(touTiaoMessageGreenBean.getIsShow()){
                                comList.add(touTiaoMessageGreenBean);
                            }else {
                                editList.add(touTiaoMessageGreenBean);
                            }
                        }
                    }else {
                        String[] newsNames = alpplicationContext.getResources().getStringArray(R.array.mobile_news_name);
                        String[] tags = alpplicationContext.getResources().getStringArray(R.array.mobile_news_id);
                        for (int i = 0; i < newsNames.length; i++) {
                            final TouTiaoMessageGreenBean touTiaoMessageGreenBean = new TouTiaoMessageGreenBean();
                            touTiaoMessageGreenBean.setId((long) i);
                            touTiaoMessageGreenBean.setTilte(newsNames[i]);
                            touTiaoMessageGreenBean.setTag(tags[i]);
                            if(i<7){
                                touTiaoMessageGreenBean.setIsShow(true);
                            }else {
                                touTiaoMessageGreenBean.setIsShow(false);
                            }
                            addMessage(touTiaoMessageGreenBean, new IMessageListener() {
                                @Override
                                public void OnResult(boolean isSuccess, List<TouTiaoMessageGreenBean> touTiaoMessageGreenBeanDao) {
                                    if(touTiaoMessageGreenBean.getIsShow()){
                                        comList.add(touTiaoMessageGreenBean);
                                    }else {
                                        editList.add(touTiaoMessageGreenBean);
                                    }
                                }
                            });
                        }
                    }
                }
            }
        });

    }

    public List<TouTiaoMessageGreenBean> getComList() {
        return comList;
    }

    public List<TouTiaoMessageGreenBean> getEditList() {
        return editList;
    }

    //使用线程池来做存储数据，不能在主线程中操作数据里
    public void addMessage(@NotNull final TouTiaoMessageGreenBean messageGreenBean, final IMessageListener iMessageListener){
        synchronized (touTiaoMessageGreenBeanDao){
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
    }

    public void deleteMessage(@NotNull final TouTiaoMessageGreenBean messageGreenBean, final IMessageListener iMessageListener){
        synchronized (touTiaoMessageGreenBeanDao){
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
    }
    public void updataMessage(final TouTiaoMessageGreenBean messageGreenBean, final IMessageListener iMessageListener){
        synchronized (touTiaoMessageGreenBeanDao){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    touTiaoMessageGreenBeanDao.update(messageGreenBean);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            if(iMessageListener!=null){
                                iMessageListener.OnResult(true,null);
                            }
                        }
                    });
                }
            });
        }
    }
    public void queryMessage(@NotNull final  IMessageListener iMessageListener){
        synchronized (touTiaoMessageGreenBeanDao){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    final List<TouTiaoMessageGreenBean> list = touTiaoMessageGreenBeanDao.loadAll();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            iMessageListener.OnResult(true,list);
                        }
                    });
                }
            });
        }
    }
    public void tabAdd(int position,IMessageListener iMessageListener){
        TouTiaoMessageGreenBean bean = editList.get(position);
        bean.setIsShow(true);
        updataMessage(bean,iMessageListener);
        comList.add(bean);
        editList.remove(position);

    }
    public void tabDelete(int position,IMessageListener iMessageListener){
        TouTiaoMessageGreenBean bean = comList.get(position);
        bean.setIsShow(false);
        updataMessage(bean,iMessageListener);
        editList.add(0,bean);
        comList.remove(position);

    }
}
