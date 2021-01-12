package com.song.fromwork.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 判断时间的单例
 * <p>
 * System.currentTimeMillis()是获取计算机当前时间的毫秒值
 * <p>
 * 毫秒值/1000获取秒数
 * 秒数/60获取分钟
 * 分钟/60获取小时
 */

public class TimeUtil {
    private TimeUtil() {
    }

    private static TimeUtil instance;

    public static TimeUtil getInstance() {
        if (instance == null) {
            synchronized (TimeUtil.class) {
                if (instance == null) {
                    instance = new TimeUtil();
                }
            }
        }
        return instance;
    }

    //String转Date
    public Date stringConverDate(String time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CANADA);
        Date date = null;
        try {
            date = simpleDateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    //当时的时间距离现在的时间
    public String timeAgo(Date createTime) {
        SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm", Locale.CHINA);
        //传进来的时间不为空
        if (createTime != null) {
            long agoTimeInMin = (new Date(System.currentTimeMillis()).getTime() - createTime.getTime() / 1000 / 60);
            //判断分钟数如果小于等于1分钟
            if (agoTimeInMin <= 1) {
                return "刚刚";
            } else if (agoTimeInMin <= 60) {//小于等于60分钟（一小时）
                return agoTimeInMin + "分钟前";
            } else if (agoTimeInMin <= 60 * 24) {//小于等于1天（60分钟*24）
                return agoTimeInMin / 60 + "小时前";
            } else if (agoTimeInMin <= 60 * 24 * 2) {//小于等于2天（同上*2）
                return agoTimeInMin / (60 * 24) + "天前";
            } else {//直接实例化返回
                return format.format(createTime);
            }
        } else {//为空直接返回0
            return format.format(new Date(0));
        }
    }

    //根据返回的时间戳判断距离现在的时间
    public String getTimeStampAgo(String timeStamop) {
        Long time = Long.valueOf(timeStamop);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        String format = simpleDateFormat.format(time * 1000);
        Date date = null;
        try {
            simpleDateFormat.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timeAgo(date);
    }

    public static String getCurrentTimeStamp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }
}
