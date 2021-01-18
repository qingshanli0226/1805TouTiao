package com.toutiao.bawei.a1805toutiao.handler;

import java.util.HashMap;
import java.util.Map;

//定义一个单例，来存放这个各个线程的looper。Handler的构造函数会查询该单例的Looper Map表，并获取该线程对应的Looper
public class NewLooperManager {
    private static volatile NewLooperManager instance;
    //定义一个数据结构，来存放每个线程的looper，其中该数据结构的Key是线程Id，每个线程的ID值不一样，我们可以通过这个线程Id去找到每个线程的Looper
    private Map<Long, NewsLooper> newsLooperMap = new HashMap<>();

    private NewLooperManager(){

    }

    public static NewLooperManager getInstance() {
        if (instance==null) {
            synchronized (NewLooperManager.class) {
                if (instance==null) {
                    instance = new NewLooperManager();
                }
            }
        }
        return instance;
    }

    //存放线程的looper，为了保证线程安全，该方法必须加锁，保护我们这个Map
    public void saveLooper(long threadId,NewsLooper newsLooper) {
        synchronized (newsLooperMap) {
            if (!newsLooperMap.containsKey(threadId)) {
                newsLooperMap.put(threadId, newsLooper);
            }
        }
    }

    //获取threadid线程对应的looper
    public NewsLooper getLooper(long threadId) {
        synchronized (newsLooperMap) {
            return newsLooperMap.get(threadId);
        }
    }

}
