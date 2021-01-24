package com.bw.framework.mvptest.presenter;

import android.util.Log;

import com.bw.bean.News;
import com.bw.bean.NewsBean;
import com.bw.bean.NewsBeans;
import com.bw.framework.callback.INews;
import com.bw.framework.mvptest.control.Control;
import com.bw.framework.mvptest.repository.NewsRepository;
import com.google.gson.Gson;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NewsPresenter extends Control.newsControlPresenter {
    private List<News> arrlist=new ArrayList<>();
    public NewsPresenter(Control.newsControlView newsControlView) {
        super(newsControlView);
    }

    @Override
    public void news(String url, HashMap<String, String> map) {
               mRepository.news(url, map, new INews() {
                   @Override
                   public void onSuccess(Object... objects) {
                         if (objects!=null){

                             arrlist.clear();
                             NewsBean dataBeans=(NewsBean) objects[0];

                                 for (int i=0;i<dataBeans.getData().size();i++){

                                     NewsBeans newsBeans = new Gson().fromJson(dataBeans.getData().get(i).getContent(), NewsBeans.class);
                                     JSONObject jsonObject= null;
                                     try {
                                         jsonObject = new JSONObject(dataBeans.getData().get(i).getContent());
                                         JSONObject middle_image = jsonObject.getJSONObject("middle_image");
                                         String url1 = middle_image.getString("url");
                                         Log.e("jsons",""+url1);
                                         News news = new News(newsBeans.getAbstractX(), newsBeans.getArticle_url(), newsBeans.getUser_info().getAvatar_url(), newsBeans.getMedia_name(), newsBeans.getTitle(), url1);
                                         arrlist.add(news);
                                     } catch (JSONException e) {
                                         e.printStackTrace();
                                     }


                                 }

                                 if (mView.get()!=null){
                                     mView.get().success(arrlist);
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
