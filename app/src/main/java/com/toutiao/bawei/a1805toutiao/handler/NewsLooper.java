package com.toutiao.bawei.a1805toutiao.handler;


import android.util.Log;

//定义一个Looper类，这个类它会不停的循环遍历一个消息队列，获取Handler发送的消息，并且调用Handler去处理消息
public class NewsLooper {
    //这个地方不能使用静态变量，否则不同的looper都会操作该数据
    public NewsMessageQueue newsMessageQueue;//定义消息队列，我们的looper会遍历该消息队列，处理里面的存储的消息。这些被处理的消息，是我么的Handler发送的消息
    public long threadId;
    private NewsLooper() {
        //构造函数里实例化该队列
        newsMessageQueue = new NewsMessageQueue();
    }

    //去实例化一个looper，并且将looper存放到线程的私有存储空间里
    public static void prepare() {
        long threadId = Thread.currentThread().getId();//获取当前线程的threadid
        if (NewsLooperManager.getInstance().getLooper(threadId) == null) {//如果当前线程没有准备好looper，则创建这个looper
            NewsLooper newsLooper = new NewsLooper();
            newsLooper.threadId = threadId;
            NewsLooperManager.getInstance().saveLooper(threadId,newsLooper);//创建好之后，将创建好的looper存储到单例里
        }
    }

    //该方法是一个死循环，该循环一直去遍历消息队列，然后处理里面消息
    public static void loop() {
        //死循环方法
        for(;;) {
            //1,从队列获取消息
            long threadId = Thread.currentThread().getId();
            NewsLooper newsLooper = NewsLooperManager.getInstance().getLooper(threadId);
            NewsMessage newsMessage = newsLooper.newsMessageQueue.next();//有可能睡眠
            //2,处理消息
            if (newsMessage.target == null) {
                Log.d("LQS", "关闭handler");
                break;
            }
            newsMessage.target.dispatchMessage(newsMessage);
        }
    }

}
