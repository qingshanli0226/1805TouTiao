package com.toutiao.bawei.a1805toutiao.handler;

import io.reactivex.annotations.NonNull;

public class NewsHandler {
    private NewsMessageQueue newsMessageQueue;

    public NewsHandler() {
        long threadId = Thread.currentThread().getId();
        NewsLooper newsLooper = NewLooperManager.getInstance().getLooper(threadId);
        if (newsLooper == null) {
            throw new RuntimeException("该线程没有准备好looper");
        }

        newsMessageQueue = newsLooper.newsMessageQueue;//让handler的newMessageQueue指向loopper的NewsMessageQueue
    }

    //发送消息
    public void sendMessage(@NonNull NewsMessage newsMessage) {
        newsMessage.target = this;//让message指向这个handler
        newsMessageQueue.enqueueMessage(newsMessage);
    }
    //发送Runnable消息
    public void post(@NonNull Runnable runnable) {
        NewsMessage newsMessage = new NewsMessage();
        newsMessage.callBack = runnable;
        sendMessage(newsMessage);
    }

    //该方法默认不处理消息，如果子类要处理的话，就重写该方法
    public void handleMessage(NewsMessage newsMessage) {
    }

    //该方法被looper调用，处理该条消息
    public void dispatchMessage(NewsMessage newsMessage) {
        if (newsMessage.callBack!=null) {//如果post的是一条Runnable消息，则直接调用run方法处理
            newsMessage.callBack.run();
        } else {
            handleMessage(newsMessage);//否则的话，调用handleMessage处理该条消息
        }
    }
}
