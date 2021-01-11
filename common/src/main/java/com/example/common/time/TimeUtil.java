package com.example.common.time;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    public static String stampToDate(long time){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date date = new Date(time);
        return simpleDateFormat.format(date);
    }
    public static String getStringTime(long time){
        long s = time /1000% 60;
        long m = time /1000/60 % 60;
        long h = time /1000/60/60 % 24;
        long d = time/1000 /60/60/24 % 30;
        long month = time/1000 /60/60/24/30 % 12;
        long y = time /1000/60/60/24/365;
        String timestr="";
        Log.i("Yoyo", "getStringTime: "+s);
        Log.i("Yoyo", "getStringTime: "+m);
        Log.i("Yoyo", "getStringTime: "+h);
        Log.i("Yoyo", "getStringTime: "+d);
        Log.i("Yoyo", "getStringTime: "+month);
        Log.i("Yoyo", "getStringTime: "+y);
        if(m>0){
            timestr=m+"分"+timestr+"前";
        }else {
            timestr="刚刚";
        }
        if(h>0){
            timestr=h+"小时"+m+"分"+"前";
        }
        if(d>0){
            timestr=d+"天"+h+"小时"+"前";
        }
        if(month>0){
            timestr=month+"月"+d+"天"+"前";
        }
        if(y>0){
            timestr=y+"年"+month+"月"+"前";
        }
        return timestr;
    }
}
