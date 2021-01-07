package com.example.framewrok.base;

import android.content.Context;

import com.bawei.deom.ClassInterface;
import com.example.net.bean.JournalismBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class NewsManager {
    private List<JournalismBean.DataBean> news=new ArrayList<>();
     private static NewsManager newsManager;
     private Context context;
     private List<NewsDataChangeListener> newsDataChangeListeners=new ArrayList<>();
    private NewsManager() {
    }
    public static NewsManager getInstance(){
        if (newsManager ==null){
                newsManager=new NewsManager();
        }
        return   newsManager;
    }
    public void init(Context context){
        this.context=context;
        addnews();
    }

    private void addnews() {
        ClassInterface.getBaseInterface().journalis()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JournalismBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JournalismBean journalismBean) {
                    news.addAll(journalismBean.getData());

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
    private void notifyNewsDataChanged(){
      for (NewsDataChangeListener listener:newsDataChangeListeners){
        listener.onDataChanged(news);
     }
    }
    private interface NewsDataChangeListener{
     void  onDataChanged(List<JournalismBean.DataBean> news);
    }
}
