package com.song.fromwork.utils;

import android.content.Context;
import android.util.Log;

import com.song.fromwork.R;
import com.song.fromwork.dao.NewsChannelBean;
import com.song.fromwork.dao.NewsChannelManager;

import java.util.ArrayList;
import java.util.List;

public class CacheManager {
    private Context context;

    private static CacheManager cacheManager;

    private List<NewsChannelBean> newsChannelBeansAll = new ArrayList<>();

    private List<NewsChannelBean> newsChannelBeansEnable = new ArrayList<>();
    private List<NewsChannelBean> newsChannelBeansUnable = new ArrayList<>();

    private List<ICacheChangeListener> cacheChangeListeners = new ArrayList<>();

    private String categoryId[];
    private String categoryName[];

    private int length = 0;
    private int index = 0;

    private CacheManager() {
    }

    public static CacheManager getInstance() {
        if (cacheManager == null) {
            synchronized (CacheManager.class) {
                if (cacheManager == null) {
                    cacheManager = new CacheManager();
                }
            }
        }
        return cacheManager;
    }

    public List<NewsChannelBean> getNewsChannelBeansEnable() {
        return newsChannelBeansEnable;
    }

    public List<NewsChannelBean> getNewsChannelBeansUnable() {
        return newsChannelBeansUnable;
    }

    public List<NewsChannelBean> getNewsChannelBeansAll() {
        return newsChannelBeansAll;
    }

    public void init(Context context) {
        this.context = context;
        addInitTabs();
    }

    private void addInitTabs() {
        categoryId = context.getResources().getStringArray(R.array.mobile_news_id);
        categoryName = context.getResources().getStringArray(R.array.mobile_news_name);
        length = categoryId.length;
        NewsChannelManager.getInstance().queryAll(newsChannelListener);
    }

    public void updateTag(NewsChannelBean newsChannelBean) {
        NewsChannelManager.getInstance().updateNewsChannel(newsChannelBean,newsChannelListenerUpdate);
    }

    private NewsChannelManager.INewsChannelListener newsChannelListenerUpdate = new NewsChannelManager.INewsChannelListener() {
        @Override
        public void onResult(boolean isSuccess, List<NewsChannelBean> newsChannelBeanList) {
            NewsChannelManager.getInstance().queryAll(newsChannelListener);
        }
    };

    private NewsChannelManager.INewsChannelListener newsChannelListener = new NewsChannelManager.INewsChannelListener() {
        @Override
        public void onResult(boolean isSuccess, List<NewsChannelBean> newsChannelBeanList) {
            NewsChannelBean newsChannelBean = new NewsChannelBean();
            if (newsChannelBeanList != null) {
                if (newsChannelBeanList.size() == 0) {
                    newsChannelBean.setChannelId(categoryId[index]);
                    newsChannelBean.setChannelName(categoryName[index]);
                    newsChannelBean.setIsEnable(1);
                    newsChannelBean.setPosition(index);
                    NewsChannelManager.getInstance().addNewsChannel(newsChannelBean, this);
                } else {
                    index = newsChannelBeanList.size();
                    newsChannelBeansAll.clear();
                    newsChannelBeansAll.addAll(newsChannelBeanList);
                    initEnableList();
                }
            } else {
                if (index < 8 && isSuccess) {
                    newsChannelBean.setChannelId(categoryId[index]);
                    newsChannelBean.setChannelName(categoryName[index]);
                    newsChannelBean.setIsEnable(1);
                    newsChannelBean.setPosition(index);
                    NewsChannelManager.getInstance().addNewsChannel(newsChannelBean, this);
                } else if (index >= 8 && index < length && isSuccess) {
                    newsChannelBean.setChannelId(categoryId[index]);
                    newsChannelBean.setChannelName(categoryName[index]);
                    newsChannelBean.setIsEnable(0);
                    newsChannelBean.setPosition(index);
                    NewsChannelManager.getInstance().addNewsChannel(newsChannelBean, this);
                }
            }
            if (index < length) {
                newsChannelBeansAll.add(newsChannelBean);
                index++;
            } else if (index >= length) {
                newsChannelBean = null;

            }
            Log.i("newsChannelBeans>size", "onResult: " + newsChannelBeansAll.size());
        }
    };

    private void initEnableList() {
        newsChannelBeansEnable.clear();
        newsChannelBeansUnable.clear();
        for (int i = 0; i < newsChannelBeansAll.size(); i++) {
            if(newsChannelBeansAll.get(i).getIsEnable() == 1){
                newsChannelBeansEnable.add(newsChannelBeansAll.get(i));
            } else {
                newsChannelBeansUnable.add(newsChannelBeansAll.get(i));
            }
        }
        for (ICacheChangeListener changeListener : cacheChangeListeners){
            changeListener.onAllChange(newsChannelBeansAll);
            changeListener.onEnableChange(newsChannelBeansEnable);
            changeListener.onUnableChange(newsChannelBeansUnable);
        }
    }

    public interface ICacheChangeListener {
        void onAllChange(List<NewsChannelBean> newsChannelBeansAll);
        void onEnableChange(List<NewsChannelBean> newsChannelBeansEnable);
        void onUnableChange(List<NewsChannelBean> newsChannelBeansUnable);
    }

    public void registerChangeListener(ICacheChangeListener listener) {
        if (!cacheChangeListeners.contains(listener)) {
            cacheChangeListeners.add(listener);
        }
    }

    public void unRegisterChangeListener(ICacheChangeListener listener) {
        if (cacheChangeListeners.contains(listener)) {
            cacheChangeListeners.remove(listener);
        }
    }


}
