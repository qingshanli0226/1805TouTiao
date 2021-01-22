package com.example.framework.manager;

import android.content.Context;
import android.os.Handler;
import android.util.Log;


import com.example.framework.R;
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

    private static DragMananger instance;
    private Context applcationcontext;
    private String DB_NAME = "drag.db";
    private DragBeanDao dragBeanDao;
    private List<DragBean> dragBeanList = new ArrayList<>();//我的显示频道
    private List<DragBean> editBeanList = new ArrayList<>();//隐藏频道里面
    //创建一个全局的线程池
    private ExecutorService service = Executors.newCachedThreadPool();
    private Handler handler = new Handler();
    private IDropLister iDropLister;
    public static DragMananger getInstance(){
        if (instance == null){
            instance = new DragMananger();
        }
        return instance;
    }
    private DragMananger(){

    }

    public void setiDropLister(IDropLister iDropLister) {
        this.iDropLister = iDropLister;
    }

    //初始化
    public void init(Context context){
        this.applcationcontext = context;
        //初始化数据库
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(applcationcontext,DB_NAME);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        final DaoSession daoSession = daoMaster.newSession();
        dragBeanDao = daoSession.getDragBeanDao();
        //首先查询数据库信息
        queryDragBean(new IDragDownListenter() {
            @Override
            public void onresult(boolean isSuccess, List<DragBean> list) {
                if (isSuccess){
                    if (list.size()>0){//判断当前数据库信息的是否>0，>0证明已经添加过了
                        for (DragBean dragBean : list) {
                            if (dragBean.getIsDisplay()){
                                //添加到我的显示频道集合当中
                                dragBeanList.add(dragBean);
                            }else {
                                //添加到隐藏频道集合当中
                                editBeanList.add(dragBean);
                            }
                        }
                        Log.e("CCCCCCCC","1");
                    }else {//如果为空，则证明数据库当中还没有消息，就往数据库添加消息
                        String[] dragId = applcationcontext.getResources().getStringArray(R.array.mobile_news_id);
                        String[] fragName = applcationcontext.getResources().getStringArray(R.array.mobile_news_name);
                        for (int i = 0; i < fragName.length; i++) {
                            final DragBean dragBean = new DragBean();
                            dragBean.setTitleid(dragId[i]);
                            dragBean.setUname(fragName[i]);
                            if (i<8){//默认显示8条
                                dragBean.setIsDisplay(true);
                                dragBeanList.add(dragBean);
                            }else {
                                dragBean.setIsDisplay(false);
                                editBeanList.add(dragBean);
                            }
                            //将数据添加到数据库当中
                            addDragBean(dragBean, new IDragDownListenter() {
                                @Override
                                public void onresult(boolean isSuccess, List<DragBean> list) {
                                }
                            });
                        }
                    }
                }
                Log.e("ZLD","2222");
                iDropLister.onsucess();
            }
        });

    }


    //查询数据库信息
    public void queryDragBean(@NotNull final IDragDownListenter iDragDownListenter){
        //使用多线程
        service.execute(new Runnable() {
            @Override
            public void run() {
                //查询所有的数据
                final List<DragBean> dragBeans = dragBeanDao.loadAll();
                //在主线程里面接口回掉，这样ui回调时，可以直接刷新Ui
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (iDragDownListenter!=null){
                            iDragDownListenter.onresult(true,dragBeans);
                        }
                    }
                });
            }
        });
    }
    //修改数据库信息
    public void updateDragBean(@NotNull final DragBean dragBean, final IDragDownListenter iDragDownListenter){
        //使用多线程
        service.execute(new Runnable() {
            @Override
            public void run() {
                dragBeanDao.update(dragBean);
                //在主线程里面接口回掉，这样ui回调时，可以直接刷新Ui
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (iDragDownListenter!=null){
                            iDragDownListenter.onresult(true,null);
                        }

                    }
                });
            }
        });
    }
    //删除数据库里面的内容信息
    public void deleteDragBean(@NotNull final DragBean dragBean, final IDragDownListenter iDragDownListenter){
        //使用多线程
        service.execute(new Runnable() {
            @Override
            public void run() {
                dragBeanDao.delete(dragBean);
                //在主线程里面接口回掉，这样ui回调时，可以直接刷新Ui
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (iDragDownListenter!=null){
                            iDragDownListenter.onresult(true,null);
                        }

                    }
                });
            }
        });
    }
    //往数据库内增加消息
    public void addDragBean(@NotNull final DragBean dragBean, final IDragDownListenter iDragDownListenter){
        //使用多线程
        service.execute(new Runnable() {
            @Override
            public void run() {
                dragBeanDao.insert(dragBean);
                //在主线程里面接口回掉，这样ui回调时，可以直接刷新Ui
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (iDragDownListenter!=null){
                            iDragDownListenter.onresult(true,null);
                        }

                    }
                });
            }
        });
    }
    public interface IDropLister{
        void onsucess();
    }
    //让别的类能够拿到缓存集合
    public List<DragBean> getDragList(){
        Log.e("CCCCCCCC","2");
        return dragBeanList;
    }
    //让别的类能够拿到隐藏的集合
    public List<DragBean> getEditList(){
        return editBeanList;
    }


}
