package com.toutiao.bawei.a1805toutiao.handler;

//定义消息类，我们的Handler发送该消息类，Looper的MessageQueue来管理这个消息类
public class NewsMessage {
    public int what;
    public Object obj;
    public Runnable callBack;//当Handler post Runnable时，我们会实例化一个Message，并且将post的Runnable赋给Message的callBack
    public NewsHandler target;//该target就是发送该条消息的handler。当looper遍历到该条消息时，会使用target指向的Handler，处理该条消息
    public long when;//延迟消息的时间
}
