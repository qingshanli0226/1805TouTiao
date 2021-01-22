package com.bw.framework.manage;

import android.content.Context;
import android.util.Log;

import com.bw.framework.bean.DaoMaster;
import com.bw.framework.bean.DaoSession;
import com.bw.framework.bean.LabelsBean;
import com.bw.framework.bean.LabelsBeanDao;

import java.util.ArrayList;
import java.util.List;

public class LabelsManage {
      private Context context;
      //list缓存标题数据
      List<LabelsBean> dataLabelsBeans =new ArrayList<>();
       //显示标题集合
       List<LabelsBean> showLableBeans =new ArrayList<>();
      //存放不显示标题集合
       List<LabelsBean> notShowLableBeans =new ArrayList<>();
       //存放fragment注册监听的list
       List<labelChangeListener> labelChangeListeners =new ArrayList<>();
       //存放标题监听的list
       List<labelChangeListener> labelAlertListenerList =new ArrayList<>();

      private LabelsBeanDao labelsBeanDao;

      private static volatile LabelsManage labelsManage =null;

      public static LabelsManage getInstance(){
            if (null== labelsManage){
                  synchronized (LabelsManage.class){
                        if (labelsManage ==null){
                              labelsManage =new LabelsManage();
                        }
                  }
            }
            return labelsManage;
      }

      private LabelsManage(){

      }

      public void init(Context context){
            DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, "title");
            DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
            DaoSession daoSession=daoMaster.newSession();
            labelsBeanDao = daoSession.getTitleBeanDao();
            this.context=context;
      }


      //初始化数据添加
      public void initData(String[] stringArray,String[] stringArray1){
            selectAll();
            if (dataLabelsBeans.size()==0){
                  for (int i = 0; i <stringArray.length ; i++) {
                        LabelsBean labelsBean;
                        if (i<6){
                              labelsBean=new LabelsBean(null,stringArray[i],stringArray1[i],true);
                        }else {
                              labelsBean=new LabelsBean(null,stringArray[i],stringArray1[i],false);
                        }
                        insert(labelsBean);
                  }
            }
      }

      //添加数据
      public void insert(LabelsBean titleBean){
            labelsBeanDao.insert(titleBean);
            dataLabelsBeans.add(titleBean);
      }


      //修改数据111
      public void update(LabelsBean labelsBean, int position){

            LabelsBean unique = labelsBeanDao.queryBuilder().where(LabelsBeanDao.Properties.Title.eq(labelsBean.getTitle())).unique();
            if (unique!=null){
                  unique.setIsShow(labelsBean.getIsShow());
                  labelsBeanDao.update(unique);
                  updatedataTitleBeans(labelsBean);
            }
            if (labelsBean.getIsShow()){
                  addTitleNotifyAllChange(labelsBean.getTitle());
            }else {
                  removeTitleNotifyAllChange(labelsBean.getTitle(),position);
            }
      }
      //修改缓存中的数据
      private void updatedataTitleBeans(LabelsBean labelsBean) {
            for (LabelsBean dataLabelBean : dataLabelsBeans) {
                   if (dataLabelBean.equals(labelsBean)){
                         dataLabelBean.setIsShow(labelsBean.getIsShow());
                         return;
                   }
            }
      }


      //查询全部放入缓存集合
      public void selectAll(){
            dataLabelsBeans = labelsBeanDao.queryBuilder().list();
      }

      //获取标题数据集合方法
      public List<LabelsBean> getDataLabelsBeans(){
            return dataLabelsBeans;
      }


      //获取网址并通知
      public void getUrl(String title,int position){
            for (LabelsBean dataTitleBean : dataLabelsBeans) {
                    if(dataTitleBean.getTitle().equals(title)){
                          urlNotifyAllChange(dataTitleBean.getUrl(),position);
                          return;
                    }
            }
      }


      //获取显示标题集合
      public List<LabelsBean> getShowLableBeans(){
            showLableBeans.clear();
            for (LabelsBean dataTitleBean : dataLabelsBeans) {
                   if (dataTitleBean.getIsShow()){
                         showLableBeans.add(dataTitleBean);
                   }
            }
            return showLableBeans;
      }

      //获取不显示标题集合
      public List<LabelsBean> getNotShowLableBeans(){
            notShowLableBeans.clear();
            for (LabelsBean dataTitleBean : dataLabelsBeans) {
                  if (!dataTitleBean.getIsShow()){
                        notShowLableBeans.add(dataTitleBean);
                  }
            }
            return notShowLableBeans;
      }


      //通知注册的接口标题网址变化
      public void urlNotifyAllChange(String url,int position){
               Log.e("size",""+ labelChangeListeners.size());
               labelChangeListeners.get(position).titleUrl(url);

      }

      //通知注册的标题添加变化
      public void addTitleNotifyAllChange(String title){
            for (labelChangeListener labelChangeListener : labelAlertListenerList) {
                   labelChangeListener.addTitle(title);
            }
      }

      //通知注册的标题删除变化
      public void removeTitleNotifyAllChange(String title,int position){
            for (labelChangeListener labelChangeListener : labelAlertListenerList) {
                  labelChangeListener.removeTitle(title,position);
            }
      }

      //通知注册的标题位置交换变化
      public void titleNotifyAllChange(int position1,int position2){
            for (labelChangeListener labelChangeListener : labelAlertListenerList) {
                  labelChangeListener.titlePosition(position1,position2);
            }
      }




      //fragment网址通知注册监听
      public void registerChangeListener(labelChangeListener titleChangeListener){
             if (!labelChangeListeners.contains(titleChangeListener)){
                   labelChangeListeners.add(titleChangeListener);
             }
      }

      //fragment网址通知注销监听
      public void unChangeListener(labelChangeListener titleChangeListener){
            if (labelChangeListeners.contains(titleChangeListener)){
                  labelChangeListeners.remove(titleChangeListener);
            }
      }


      //标题添加/删除/换位注册监听
      public void registerTitleChangeListener(labelChangeListener titleChangeListener){
            if (!labelAlertListenerList.contains(titleChangeListener)){
                  labelAlertListenerList.add(titleChangeListener);
            }
      }

      //标题添加/删除/换位注销监听
      public void unTitleChangeListener(labelChangeListener labelChangeListener){
            if (labelAlertListenerList.contains(labelChangeListener)){
                  labelAlertListenerList.remove(labelChangeListener);
            }
      }



      public interface labelChangeListener {
            void titleUrl(String url);
            void addTitle(String title);
            void removeTitle(String title, int position);
            void titlePosition(int position1, int position2);
      }

}
