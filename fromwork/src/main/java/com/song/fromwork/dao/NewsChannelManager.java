package com.song.fromwork.dao;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.song.fromwork.R;

import org.greenrobot.eventbus.EventBus;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewsChannelManager {
    private static NewsChannelManager instance;
    private Context applicationContext;
    private NewsChannelBeanDao newsChannelBeanDao;

    private int length = 0;

    private final String DB_NAME = "newsChannel.db";

    private Handler handler = new Handler();

    private ExecutorService executorService = Executors.newCachedThreadPool();

    private NewsChannelManager() {
    }

    public static NewsChannelManager getInstance() {
        if (instance == null) {
            instance = new NewsChannelManager();
        }
        return instance;
    }

    public void init(Context applicationContext) {
        this.applicationContext = applicationContext;
        DaoMaster.OpenHelper openHelper = new DaoMaster.DevOpenHelper(applicationContext, DB_NAME);
        DaoMaster daoMaster = new DaoMaster(openHelper.getReadableDb());
        DaoSession daoSession = daoMaster.newSession();

        newsChannelBeanDao = daoSession.getNewsChannelBeanDao();
    }

    public void addInitData() {
        String categoryId[] = applicationContext.getResources().getStringArray(R.array.mobile_news_id);
        String categoryName[] = applicationContext.getResources().getStringArray(R.array.mobile_news_name);
        length = categoryId.length;
        for (int i = 0; i < 8; i++) {
            NewsChannelBean newsChannelBean = new NewsChannelBean();
            newsChannelBean.setChannelId(categoryId[i]);
            newsChannelBean.setChannelName(categoryName[i]);
            newsChannelBean.setIsEnable(1);
            newsChannelBean.setPosition(i);
            addNewsChannel(newsChannelBean, newsChannelListener);
        }
        for (int i = 8; i < categoryId.length; i++) {
            NewsChannelBean newsChannelBean = new NewsChannelBean();
            newsChannelBean.setChannelId(categoryId[i]);
            newsChannelBean.setChannelName(categoryName[i]);
            newsChannelBean.setIsEnable(0);
            newsChannelBean.setPosition(i);
            addNewsChannel(newsChannelBean, newsChannelListener);
        }
    }

    private INewsChannelListener newsChannelListener = new INewsChannelListener() {
        @Override
        public void onResult(boolean isSuccess, List<NewsChannelBean> newsChannelBeanList) {

        }
    };


    public interface INewsChannelListener {
        void onResult(boolean isSuccess, List<NewsChannelBean> newsChannelBeanList);
    }

    public void addNewsChannel(final NewsChannelBean newsChannelBean, final INewsChannelListener newsChannelListener) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                synchronized (NewsChannelManager.this) {
                    newsChannelBeanDao.insert(newsChannelBean);
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (newsChannelListener != null) {
                            newsChannelListener.onResult(true, null);
                        }
                    }
                });
            }
        });
    }

    public void deleteNewsChannel(final NewsChannelBean newsChannelBean, final INewsChannelListener newsChannelListener) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                synchronized (NewsChannelManager.this) {
                    newsChannelBeanDao.delete(newsChannelBean);
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (newsChannelListener != null) {
                            newsChannelListener.onResult(true, null);
                        }
                    }
                });
            }
        });
    }

    public void removeAll(final INewsChannelListener newsChannelListener) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                synchronized (NewsChannelManager.this) {
                    newsChannelBeanDao.deleteAll();
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (newsChannelListener != null) {
                            newsChannelListener.onResult(true, null);
                        }
                    }
                });
            }
        });
    }

    public void queryAll(final INewsChannelListener newsChannelListener) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                final List<NewsChannelBean> newsChannelBeans = newsChannelBeanDao.loadAll();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (newsChannelListener != null) {
                            newsChannelListener.onResult(true, newsChannelBeans);
                        }
                    }
                });
            }
        });
    }

    public void query(final int isEnable, final INewsChannelListener newsChannelListener) {

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                final List<NewsChannelBean> list = newsChannelBeanDao.queryBuilder().where(NewsChannelBeanDao.Properties.IsEnable.ge(isEnable)).list();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (newsChannelListener != null) {
                            newsChannelListener.onResult(true, list);
                        }
                    }
                });
            }
        });
    }

    public void updateNewsChannel(final NewsChannelBean newsChannelBean, final INewsChannelListener newsChannelListener) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                synchronized (NewsChannelManager.this) {
                    newsChannelBeanDao.update(newsChannelBean);
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (newsChannelListener != null) {
                            newsChannelListener.onResult(true, null);
                        }
                    }
                });
            }
        });
    }


}
