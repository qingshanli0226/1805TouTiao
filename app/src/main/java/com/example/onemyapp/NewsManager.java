package com.example.onemyapp;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.net.bean.NewsBean;
import com.example.onemyapp.application.NewsApplication;
import com.example.onemyapp.bean.DaoSession;
import com.example.onemyapp.bean.LabelBean;
import com.example.onemyapp.bean.LabelBeanDao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewsManager {
    private static NewsManager newsManager;
     Context context;

     private List<LabelBean> newsBeans=new ArrayList<>();
     private   List<String> addnews=new ArrayList<>();
      DaoSession daoSession=((NewsApplication.daoSession));
     LabelBeanDao labelBeanDao = daoSession.getLabelBeanDao();
    private ExecutorService executorService= Executors.newCachedThreadPool();
    public NewsManager() {
    }
    public static NewsManager getInstance(){
        if (newsManager==null){
            newsManager=new NewsManager();
        }
        return newsManager;
    }
    public  void init(Context context){
        this.context=context;

          getaddnews();
    }
    Handler handler=new Handler();
    public void querMessage(@NonNull final IMessageListener iMessageListener){
          executorService.execute(new Runnable() {
              @Override
              public void run() {
                  newsBeans = daoSession.loadAll(LabelBean.class);
                  for (int i=0;i<newsBeans.size();i++){
                      Log.e("数据库2222222222222",newsBeans.get(i).toString());

                  }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                         iMessageListener.onResult(newsBeans);
                        }
                    });
              }
          });

    }
    public void addLable(String labelBean){
         addnews.add(labelBean);
    }
    public List<String> getaddnews(){

        return addnews;
    }
    public   interface IMessageListener{
        void onResult( List<LabelBean> labelBeans);
    }
}
