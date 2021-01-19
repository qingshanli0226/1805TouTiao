package com.toutiao.bawei.a1805toutiao.handler;


import android.util.Log;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

//消息队列，提供方法，实现消息的插入和读取
public class NewsMessageQueue {
    private List<NewsMessage> newsMessageList = new LinkedList<>();
    //定义存储消息的方法
    public  void enqueueMessage(NewsMessage message) {
        synchronized (newsMessageList) {
            //将消息按照时间排序，越是延迟时间长的越往后放
            int i = 0;
            if (newsMessageList.size() == 0) {//如果之前队列长度为0，直接添加该消息即可
                newsMessageList.add(message);
            } else {//里面有消息，进行排序
                for(i = 0; i < newsMessageList.size(); i++) {
                    if (message.when > newsMessageList.get(i).when) {//如果新添加的新消息延迟时间大于i位置的消息的延迟时间，则将新消息继续往后放
                        continue;
                    } else {
                        //如果新添加的新消息延迟时间小于i位置的消息的延迟时间,那么就讲新消息存到i位置上，后面的消息后移一位
                        newsMessageList.add(i,message);
                        break;
                    }
                }
                //已经找到最后一个，队列里没有一个消息的延迟时间大于新消息的延迟时间，则把新消息放到队列的尾部
                if (i == newsMessageList.size()) {
                    newsMessageList.add(i,message);
                }
            }
            //Log.d("enqueueMessage LQS size", +newsMessageList.size() + "  " + message.what + " 新添加的消息 index=" + " 唤醒wait的线程:" + "");
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
                        //Log.d("next------------ LQS", "wait 结束 + " + newsMessageList.size());
                        continue;//当被唤醒后，立刻再去检查，当前列表是否为空，如果为空继续等待，否则返回message
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {//如果队列不为空，则获取第一条消息，看看第一条消息延迟时间是否大于现在时间，如果大于，则获取时间差值，开启定时器，睡眠等待时间差值。否则直接返回第一条消息
                    NewsMessage newsMessage = newsMessageList.get(0);
                    long now = System.currentTimeMillis();//现在时间
                    long when = newsMessage.when;
                    long delayTime = when-now;
                    if (delayTime>0) {//延迟时间仍然未到，消息不能处理
                        startTimer(delayTime);//开启定时器
                        try {
                            newsMessageList.wait();
                            continue;//被定时唤醒后，再次去获取消息
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        newsMessageList.remove(newsMessage);
                        return newsMessage;
                    }
                }
            }

        }
    }

    private void notifyTimer() {
        synchronized (newsMessageList) {
            //当定时时间到了后，唤醒looper去处理消息
            newsMessageList.notify();
        }
    }

    private Timer timer =new Timer();
    private void startTimer(long delayTime) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                notifyTimer();
            }
        }, delayTime);
    }
}
