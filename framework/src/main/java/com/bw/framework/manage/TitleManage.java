package com.bw.framework.manage;

import android.content.Context;

import com.bw.framework.bean.DaoMaster;
import com.bw.framework.bean.DaoSession;
import com.bw.framework.bean.TitleBean;
import com.bw.framework.bean.TitleBeanDao;

import java.util.ArrayList;
import java.util.List;

public class TitleManage {
      //list缓存标题数据
      List<TitleBean> dataTitleBeans=new ArrayList<>();
       //显示标题集合
       List<TitleBean> showTitleBeans=new ArrayList<>();
      private TitleBeanDao titleBeanDao;

      private static volatile  TitleManage titleManage=null;

      public static TitleManage getInstance(){
            if (null==titleManage){
                  synchronized (TitleManage.class){
                        if (titleManage==null){
                              titleManage=new TitleManage();
                        }
                  }
            }
            return titleManage;
      }

      private TitleManage(){

      }

      public void init(Context context){
            DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, "title");
            DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
            DaoSession daoSession=daoMaster.newSession();
            titleBeanDao = daoSession.getTitleBeanDao();
      }


      public void insert(TitleBean titleBean){
            titleBeanDao.insert(titleBean);
            dataTitleBeans.add(titleBean);
      }


      public void update(TitleBean titleBean){

            TitleBean unique = titleBeanDao.queryBuilder().where(TitleBeanDao.Properties.Id.eq(titleBean.getId())).unique();
            if (unique!=null){
                  unique.setIsShow(titleBean.getIsShow());
                  titleBeanDao.update(unique);
            }

      }

      public void selectAll(){
            dataTitleBeans = titleBeanDao.queryBuilder().list();
      }

      //获取标题数据集合
      public List<TitleBean> getDataTitleBeans(){
            return dataTitleBeans;
      }

      //获取显示标题集合
      public List<TitleBean> getShowTitleBeans(){
            for (TitleBean dataTitleBean : dataTitleBeans) {
                   if (dataTitleBean.getIsShow()){
                         showTitleBeans.add(dataTitleBean);
                   }
            }

            return showTitleBeans;
      }

}
