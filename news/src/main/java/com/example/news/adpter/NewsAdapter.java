package com.example.news.adpter;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;


import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.framework.base.BaseRVAdapter;
import com.example.news.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import bean.NewsBean;

public class NewsAdapter extends BaseRVAdapter<List<HashMap<String, String>>> {
    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_news_article_img;
    }

    @Override
    protected void convert(List<HashMap<String, String>> itemData, BaseViewHolder baseViewHolder, int position) {
        for (HashMap<String, String> itemDatum : itemData) {
            //头像
            ImageView iv = baseViewHolder.getView(R.id.iv_media);
            Glide.with(baseViewHolder.itemView.getContext()).load(itemDatum.get("avatar_url")).circleCrop().into(iv);
            //时间
//        @SuppressLint("SimpleDateFormat")
//        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
//        Date curDate =  new Date(item.get("behot_time"));
//        //获取消息时间
//        String str  =  formatter.format(curDate);
            Long behot_time = Long.parseLong(itemDatum.get("behot_time"));
            TextView tv_extra = baseViewHolder.getView(R.id.tv_extra);
            tv_extra.setText(""+convert_before(behot_time));
            //标题
            TextView tv_title = baseViewHolder.getView(R.id.tv_title);
            tv_title.setText(""+itemDatum.get("title"));
            //内容
            TextView tv_abstract = baseViewHolder.getView(R.id.tv_abstract);
            tv_abstract.setText(""+itemDatum.get("anAbstract"));
            //图片
            ImageView iv_image = baseViewHolder.getView(R.id.iv_image);
            Glide.with(baseViewHolder.itemView.getContext()).load(itemDatum.get("url")).into(iv_image);
        }



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

    @Override
    protected int getViewType(int position) {
        return 0;
    }
}
