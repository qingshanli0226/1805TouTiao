package com.toutiao.bawei.a1805toutiao;

public class Sum {
    public static int sum = 0;


    public  void addSum() {
        synchronized (Sum.class) {
            sum = sum + 1;
        }
    }
}
