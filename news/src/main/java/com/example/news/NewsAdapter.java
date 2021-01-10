package com.example.news;

import android.annotation.SuppressLint;
import android.widget.ImageView;

import androidx.annotation.Nullable;


import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import bean.NewsBean;

public class NewsAdapter extends BaseQuickAdapter<HashMap<String,String>, BaseViewHolder> {

    public NewsAdapter(int layoutResId, @Nullable List<HashMap<String, String>> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HashMap<String, String> item) {
        //头像
        Glide.with(mContext).load(item.get("avatar_url")).circleCrop().into((ImageView) helper.getView(R.id.iv_media));
        //时间
//        @SuppressLint("SimpleDateFormat")
//        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
//        Date curDate =  new Date(item.get("behot_time"));
//        //获取消息时间
//        String str  =  formatter.format(curDate);
        Long behot_time = Long.parseLong(item.get("behot_time"));
        helper.setText(R.id.tv_extra,""+convert_before(behot_time));
        //标题
        helper.setText(R.id.tv_title,item.get("title"));
        //内容
        helper.setText(R.id.tv_abstract,item.get("anAbstract"));
        Glide.with(mContext).load(item.get("url")).into((ImageView) helper.getView(R.id.iv_image));

    }
    /**
     * 将对比后的时间，格式化为：xx分钟前，xx小时前和日期
     * @param time 需比对的时间
     * @return
     */
    public static String convert_before(long time) {
        if (time < 0)
            return String.valueOf(time);

        int difftime = (int) ((System.currentTimeMillis() - time) / 1000);
        if (difftime < 86400 && difftime > 0) {
            if (difftime < 3600) {
                int min = (int) (difftime / 60);
                if (min == 0)
                    return "刚刚";
                else
                    return (int) (difftime / 60) + "分钟前";
            } else {
                return (int) (difftime / 3600) + "小时前";
            }
        } else {
            Calendar now = Calendar.getInstance();
            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(time);
            if (c.get(Calendar.YEAR) == now.get(Calendar.YEAR) && c.get(Calendar.MONTH) == now.get(Calendar.MONTH)
                    && c.get(Calendar.DATE) == now.get(Calendar.DATE)) {
                return new SimpleDateFormat("HH:mm").format(c.getTime());
            }
            if (c.get(Calendar.YEAR) == now.get(Calendar.YEAR) && c.get(Calendar.MONTH) == now.get(Calendar.MONTH)
                    && c.get(Calendar.DATE) == now.get(Calendar.DATE) - 1) {
                return new SimpleDateFormat("昨天 HH:mm").format(c.getTime());
            } else if (c.get(Calendar.YEAR) == now.get(Calendar.YEAR)
                    && c.get(Calendar.MONTH) == now.get(Calendar.MONTH)
                    && c.get(Calendar.DATE) == now.get(Calendar.DATE) - 2) {
                return new SimpleDateFormat("前天 HH:mm").format(c.getTime());
            } else if (c.get(Calendar.YEAR) == now.get(Calendar.YEAR)) {
                return new SimpleDateFormat("M月d日 HH:mm").format(c.getTime());
            } else {
                return new SimpleDateFormat("yy年M月d日").format(c.getTime());
            }
        }
    }
}
