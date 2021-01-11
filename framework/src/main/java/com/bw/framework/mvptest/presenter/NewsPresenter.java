package com.bw.framework.mvptest.presenter;

import android.util.Log;

import com.bw.bean.News;
import com.bw.bean.NewsBean;
import com.bw.framework.callback.INews;
import com.bw.framework.mvptest.control.Control;
import com.bw.framework.mvptest.repository.NewsRepository;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NewsPresenter extends Control.newsControlPresenter {

    public NewsPresenter(Control.newsControlView newsControlView) {
        super(newsControlView);
    }

    @Override
    public void news(String url, HashMap<String, String> map) {
               mRepository.news(url, map, new INews() {
                   @Override
                   public void onSuccess(Object... objects) {
                         if (objects!=null){
                             boolean flag=false;
                             List<News> arrlist=new ArrayList<>();
                             NewsBean dataBeans=(NewsBean) objects[0];
                             if (dataBeans.getData().size()!=0){
                                 flag=true;
                                 for (int i=0;i<dataBeans.getData().size();i++){
                                     Log.e("=======",""+dataBeans.getData().get(i).getContent());
                                     try {

                                         JSONObject jsonObject=new JSONObject(dataBeans.getData().get(i).getContent()+"");
                                         String anAbstract = jsonObject.getString("abstract");//内容
                                         String article_url = jsonObject.getString("article_url");//网址
                                         String media_info = jsonObject.getString("media_info");
                                         JSONObject jsonObject1=new JSONObject(media_info);
                                         String avatar_url = jsonObject1.getString("avatar_url");//头像
                                         String name = jsonObject1.getString("name");//姓名
                                         String share_info = jsonObject.getString("share_info");
                                         JSONObject jsonObject2=new JSONObject(share_info);
                                         String title = jsonObject2.getString("title");//标题
                                         String middle_image = jsonObject.getString("middle_image");
                                         JSONObject jsonObject3=new JSONObject(middle_image);
                                         String url = jsonObject3.getString("url");//图片
                                         News news = new News(anAbstract, article_url, avatar_url, name, title, url);
                                         arrlist.add(news);
                                     } catch (JSONException e) {
                                         e.printStackTrace();
                                     }
                                 }
                             }

                             if (flag){
                                 mView.get().success(arrlist);
                             }else {
                                 mView.get().error("暂时没有获取内容");
                             }

                         }
                   }

                   @Override
                   public void onError(String msg) {
                       if (msg!=null){
                           mView.get().error(msg);
                       }
                   }
               });
    }

    @Override
    protected void createRepository() {
         mRepository=new NewsRepository();
    }
}
