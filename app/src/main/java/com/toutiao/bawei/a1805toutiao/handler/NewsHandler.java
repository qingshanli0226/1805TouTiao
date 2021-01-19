package com.toutiao.bawei.a1805toutiao.handler;

import io.reactivex.annotations.NonNull;

public class NewsHandler {
    private NewsMessageQueue newsMessageQueue;
    private long threadId;
    private NewsLooper newsLooper;
    private CallBack mCallback;
    public NewsHandler(CallBack callBack) {
        this();
        mCallback = callBack;
    }

    public NewsHandler() {
        long threadId = Thread.currentThread().getId();
        this.threadId = threadId;
        NewsLooper newsLooper = NewsLooperManager.getInstance().getLooper(threadId);
        this.newsLooper = newsLooper;
        if (newsLooper == null) {
            throw new RuntimeException("该线程没有准备好looper");
        }

        newsMessageQueue = newsLooper.newsMessageQueue;//让handler的newMessageQueue指向loopper的NewsMessageQueue
    }

    //发送延迟消息
    public void sendDelayedMessage(NewsMessage newsMessage, long delayTime) {
        newsMessage.target = this;
        newsMessage.when = System.currentTimeMillis()+delayTime;//设置延迟时间
        newsMessageQueue.enqueueMessage(newsMessage);
    }

    public void sendEmptyMessage(int what) {
        NewsMessage emptyMessage = new NewsMessage();
        emptyMessage.what = what;
        sendDelayedMessage(emptyMessage,0);
    }

    //发送消息
    public void sendMessage(@NonNull NewsMessage newsMessage) {
        sendDelayedMessage(newsMessage,0);
    }
    //发送消息
    public void removeAllMessageAndCallBacks() {
        NewsMessage newsMessage = new NewsMessage();
        newsMessageQueue.enqueueMessage(newsMessage);
    }
    //发送Runnable消息
    public void post(@NonNull Runnable runnable) {
        NewsMessage newsMessage = new NewsMessage();
        newsMessage.callBack = runnable;
        sendDelayedMessage(newsMessage,0);
    }

    //该方法默认不处理消息，如果子类要处理的话，就重写该方法
    public void handleMessage(NewsMessage newsMessage) {
    }

    //该方法被looper调用，处理该条消息
    public void dispatchMessage(NewsMessage newsMessage) {
        if (newsMessage.callBack!=null) {//如果post的是一条Runnable消息，则直接调用run方法处理
            newsMessage.callBack.run();
        } else {
            if (mCallback!=null) {
                if (mCallback.handleMessage(newsMessage)) {
                    return;
                }
            }
            handleMessage(newsMessage);//否则的话，调用handleMessage处理该条消息
        }
    }

    public interface CallBack {
        boolean handleMessage(NewsMessage newsMessage);
    }
}
