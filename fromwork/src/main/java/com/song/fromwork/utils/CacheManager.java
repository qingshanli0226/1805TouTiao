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
                    newsChannelBeansAll.addAll(newsChannelBeanList);
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
                if (index < length) {
                    newsChannelBeansAll.add(newsChannelBean);
                    index++;
                }
                Log.i("TAG", "onResult: " + newsChannelBeansAll.size());
            }
        }
    };

}
