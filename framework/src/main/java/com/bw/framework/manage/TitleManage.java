package com.bw.framework.manage;

import android.content.Context;
import android.util.Log;

import com.bw.framework.bean.DaoMaster;
import com.bw.framework.bean.DaoSession;
import com.bw.framework.bean.TitleBean;
import com.bw.framework.bean.TitleBeanDao;

import java.util.ArrayList;
import java.util.List;

public class TitleManage {
      private Context context;
      //list缓存标题数据
      List<TitleBean> dataTitleBeans=new ArrayList<>();
      //缓存video标题数据
      List<TitleBean> videoTitleBeans = new ArrayList<>();
       //显示标题集合
       List<TitleBean> showTitleBeans=new ArrayList<>();
      //存放不显示标题集合
       List<TitleBean> notShowTitleBeans=new ArrayList<>();
       //存放fragment注册监听的list
       List<titleChangeListener> titleChangeListenerList=new ArrayList<>();
       //存放标题监听的list
       List<titleChangeListener> titleAlertListenerList=new ArrayList<>();

      private TitleBeanDao titleBeanDao;
      private TitleBean titleBean;

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
            this.context=context;
      }


      //初始化数据添加
      public void initData(String[] stringArray,String[] stringArray1){
            selectAll();
            if (dataTitleBeans.size()==0){
                  for (int i = 0; i <stringArray.length ; i++) {

                        if (i<6){
                              titleBean=new TitleBean(null,stringArray[i],stringArray1[i],true);
                        }else {
                              titleBean=new TitleBean(null,stringArray[i],stringArray1[i],false);
                        }
                        insert(titleBean);
                  }
            }
      }

      //添加数据
      public void insert(TitleBean titleBean){
            titleBeanDao.insert(titleBean);
            dataTitleBeans.add(titleBean);
      }

      public void initVideo(String[] stringArray2, String[] stringArray3) {

            if (videoTitleBeans.size() == 0){
                  for (int i=0; i<stringArray2.length; i++){
                     titleBean = new TitleBean(null,stringArray2[i],stringArray3[i],true);
                  }
                  insertV(titleBean);
            }
      }

      private void insertV(TitleBean titleBean) {
//            titleBeanDao.insert(titleBean);
//            videoTitleBeans.add(titleBean);
      }

      //修改数据111
      public void update(TitleBean titleBean,int position){

            TitleBean unique = titleBeanDao.queryBuilder().where(TitleBeanDao.Properties.Title.eq(titleBean.getTitle())).unique();
            if (unique!=null){
                  unique.setIsShow(titleBean.getIsShow());
                  titleBeanDao.update(unique);
                  updatedataTitleBeans(titleBean);
            }
            if (titleBean.getIsShow()){
                  addTitleNotifyAllChange(titleBean.getTitle());
            }else {
                  removeTitleNotifyAllChange(titleBean.getTitle(),position);
            }
      }
      //修改缓存中的数据
      private void updatedataTitleBeans(TitleBean titleBean) {
            for (TitleBean dataTitleBean : dataTitleBeans) {
                   if (dataTitleBean.equals(titleBean)){
                         dataTitleBean.setIsShow(titleBean.getIsShow());
                   }
            }
      }


      //查询全部放入缓存集合
      public void selectAll(){
            dataTitleBeans = titleBeanDao.queryBuilder().list();
      }

      //获取标题数据集合方法
      public List<TitleBean> getDataTitleBeans(){
            return dataTitleBeans;
      }


      //获取网址并通知
      public void getUrl(String title,int position){
            for (TitleBean dataTitleBean : dataTitleBeans) {
                    if(dataTitleBean.getTitle().equals(title)){
                          urlNotifyAllChange(dataTitleBean.getUrl(),position);
                          return;
                    }
            }
      }


      //获取显示标题集合
      public List<TitleBean> getShowTitleBeans(){
            showTitleBeans.clear();
            for (TitleBean dataTitleBean : dataTitleBeans) {
                   if (dataTitleBean.getIsShow()){
                         showTitleBeans.add(dataTitleBean);
                   }
            }
            return showTitleBeans;
      }

      //获取不显示标题集合
      public List<TitleBean> getNotShowTitleBeans(){
            notShowTitleBeans.clear();
            for (TitleBean dataTitleBean : dataTitleBeans) {
                  if (!dataTitleBean.getIsShow()){
                        notShowTitleBeans.add(dataTitleBean);
                  }
            }
            return notShowTitleBeans;
      }


      //通知注册的接口标题网址变化
      public void urlNotifyAllChange(String url,int position){
               Log.e("size",""+titleChangeListenerList.size());
               titleChangeListenerList.get(position).titleUrl(url);

      }

      //通知注册的标题添加变化
      public void addTitleNotifyAllChange(String title){
            for (titleChangeListener titleChangeListener : titleAlertListenerList) {
                   titleChangeListener.addTitle(title);
            }
      }

      //通知注册的标题添加变化
      public void removeTitleNotifyAllChange(String title,int position){
            for (titleChangeListener titleChangeListener : titleAlertListenerList) {
                  titleChangeListener.removeTitle(title,position);
            }
      }

      //通知注册的标题位置交换变化
      public void titleNotifyAllChange(int position1,int position2){
            for (titleChangeListener titleChangeListener : titleAlertListenerList) {
                  titleChangeListener.titlePosition(position1,position2);
            }
      }




      //fragment网址通知注册监听
      public void registerChangeListener(titleChangeListener titleChangeListener){
             if (!titleChangeListenerList.contains(titleChangeListener)){
                   titleChangeListenerList.add(titleChangeListener);
             }
      }

      //fragment网址通知注销监听
      public void unChangeListener(titleChangeListener titleChangeListener){
            if (titleChangeListenerList.contains(titleChangeListener)){
                  titleChangeListenerList.remove(titleChangeListener);
            }
      }


      //标题添加/删除/换位注册监听
      public void registerTitleChangeListener(titleChangeListener titleChangeListener){
            if (!titleAlertListenerList.contains(titleChangeListener)){
                  titleAlertListenerList.add(titleChangeListener);
            }
      }

      //标题添加/删除/换位注销监听
      public void unTitleChangeListener(titleChangeListener titleChangeListener){
            if (titleAlertListenerList.contains(titleChangeListener)){
                  titleAlertListenerList.remove(titleChangeListener);
            }
      }



      public interface titleChangeListener{
            void titleUrl(String url);
            void addTitle(String title);
            void removeTitle(String title,int position);
            void titlePosition(int position1,int position2);
      }

}
