package com.toutiao.bawei.a1805toutiao.handler;


import java.util.ArrayList;
import java.util.List;

//消息队列，提供方法，实现消息的插入和读取
public class NewsMessageQueue {
    private List<NewsMessage> newsMessageList = new ArrayList<>();

    //定义存储消息的方法
    public synchronized void enqueueMessage(NewsMessage message) {
            newsMessageList.add(message);
            notify();//唤醒睡眠的线程
    }

    //获取队列的下一条待处理消息
    public synchronized NewsMessage next() {
        if (newsMessageList.size() == 0) {//如果获取消息时，队列里没有消息，则睡眠等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        NewsMessage newsMessage = newsMessageList.get(0);//因为是先插入的消息，最先被处理，消息队列是一个先进先出的队列。所以返回第一条消息
        newsMessageList.remove(newsMessage);//返回第一条消息后，将该条消息从队列中删除
        return newsMessage;
    }


}
