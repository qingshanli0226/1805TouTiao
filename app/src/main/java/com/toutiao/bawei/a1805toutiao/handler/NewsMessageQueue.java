package com.toutiao.bawei.a1805toutiao.handler;


import android.util.Log;

import java.util.LinkedList;
import java.util.List;

//消息队列，提供方法，实现消息的插入和读取
public class NewsMessageQueue {
    private List<NewsMessage> newsMessageList = new LinkedList<>();
    //定义存储消息的方法
    public  void enqueueMessage(NewsMessage message) {
        synchronized (newsMessageList) {
            newsMessageList.add(message);
            Log.d("enqueueMessage LQS size", +newsMessageList.size() + "  " + message.what + " 新添加的消息 index=" + " 唤醒wait的线程:" + "");
            newsMessageList.notify();
        }
    }

    //获取队列的下一条待处理消息
    public  NewsMessage next() {
        synchronized (newsMessageList) {
            while (true) {
                if (newsMessageList.size() == 0) {
                    try {
                        //如果列表数据为空，则等待消息
                        newsMessageList.wait();
                        Log.d("next------------ LQS", "wait 结束 + " + newsMessageList.size());
                        continue;//当被唤醒后，立刻再去检查，当前列表是否为空，如果为空继续等待，否则返回message
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    Log.d("next------------ LQS", newsMessageList.get(0).what + "  " + newsMessageList.size());
                    break;
                }
            }
            //因为是先插入的消息，最先被处理，消息队列是一个先进先出的队列。所以返回第一条消息
            NewsMessage newsMessage = newsMessageList.get(0);
            newsMessageList.remove(newsMessage);
            return newsMessage;
        }
    }
}
