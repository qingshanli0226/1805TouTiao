package com.song.news;

import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.song.fromwork.BaseRVAdapter;
import com.song.fromwork.dao.NewsChannelBean;
import com.song.fromwork.utils.CacheManager;

import java.util.ArrayList;
import java.util.List;

public class NewsChannelAdapter extends BaseRVAdapter<Object> {

    public final int HEAD_TYPE = 0;
    public final int MY_TYPE = 1;
    public final int BODY_TYPE = 2;
    public final int ELSE_TYPE = 3;


    @Override
    protected int getLayoutId(int viewType) {
        CacheManager.getInstance().registerChangeListener(cacheChangeListener);
        switch (viewType) {
            case HEAD_TYPE:
                return R.layout.item_channel_my_header;
            case MY_TYPE:
                return R.layout.item_channel_my;
            case BODY_TYPE:
                return R.layout.item_channel_other_header;
            case ELSE_TYPE:
                return R.layout.item_channel_other;
            default:return R.layout.item_channel_my_header;
        }
    }

    @Override
    protected int getViewType(int position) {
        switch (position) {
            case 0:
                return HEAD_TYPE;
            case 1:
                return MY_TYPE;
            case 2:
                return BODY_TYPE;
            case 3:
                return ELSE_TYPE;
            default:
                return HEAD_TYPE;
        }
    }

    @Override
    protected void convert(Object itemData, BaseViewHolder baseViewHolder, int position) {
        switch (position) {
            case 0:
                convertHeader(itemData,baseViewHolder);
                break;
            case 1:
                convertMy(itemData,baseViewHolder);
                break;
            case 2:
                convertElseHeader(itemData,baseViewHolder);
                break;
            case 3:
                convertElse(itemData,baseViewHolder);
                break;
        }
    }

    private int position2 = 0;
    private NewsMyAdapter newsMyAdapter2;

    private void convertElse(Object itemData, BaseViewHolder baseViewHolder) {
        newsChannelBeanUnable.addAll((List<NewsChannelBean>) itemData);
        RecyclerView newsChannelRv = baseViewHolder.getVIew(R.id.news_channel_rv);
        newsChannelRv.setLayoutManager(new GridLayoutManager(baseViewHolder.itemView.getContext(),4,GridLayoutManager.VERTICAL,false));
        newsMyAdapter2 = new NewsMyAdapter();
        newsMyAdapter2.updataData(newsChannelBeanUnable);
        newsMyAdapter2.setIRecyclerViewItemClickListener(new IRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(int position) {
                newsChannelBeanUnable.get(position).setIsEnable(1);
                CacheManager.getInstance().updateTag(newsChannelBeanUnable.get(position));
                position2 = position;
            }
        });
    }


    private void convertElseHeader(Object itemData, BaseViewHolder baseViewHolder) {

    }

    private int position1 = 0;
    private NewsMyAdapter newsMyAdapter;

    private void convertMy(Object itemData, BaseViewHolder baseViewHolder) {
        newsChannelBeanEnable.addAll((List<NewsChannelBean>) itemData);
        RecyclerView newsChannelRv = baseViewHolder.getVIew(R.id.news_channel_rv);
        newsChannelRv.setLayoutManager(new GridLayoutManager(baseViewHolder.itemView.getContext(),4,GridLayoutManager.VERTICAL,false));
        newsMyAdapter = new NewsMyAdapter();
        newsMyAdapter.updataData(newsChannelBeanEnable);
        newsMyAdapter.setIRecyclerViewItemClickListener(new IRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(int position) {
                newsChannelBeanEnable.get(position).setIsEnable(0);
                CacheManager.getInstance().updateTag(newsChannelBeanEnable.get(position));
                position1 = position;
            }
        });
    }

    private void convertHeader(Object itemData, BaseViewHolder baseViewHolder) {
        String str = (String) itemData;
        TextView tv = baseViewHolder.getVIew(R.id.tv);
        tv.setText(str);
        TextView tvBtnEdit = baseViewHolder.getVIew(R.id.tv_btn_edit);
    }



    private CacheManager.ICacheChangeListener cacheChangeListener = new CacheManager.ICacheChangeListener() {
        @Override
        public void onAllChange(List<NewsChannelBean> newsChannelBeansAll) {

        }

        @Override
        public void onEnableChange(List<NewsChannelBean> newsChannelBeansEnable) {
            newsChannelBeanEnable.clear();
            newsChannelBeanEnable.addAll(newsChannelBeansEnable);
            newsMyAdapter.notifyItemChanged(position1);
        }

        @Override
        public void onUnableChange(List<NewsChannelBean> newsChannelBeansUnable) {
            newsChannelBeanUnable.clear();
            newsChannelBeanUnable.addAll(newsChannelBeansUnable);
            newsMyAdapter2.notifyItemChanged(position2);
        }
    };

    private List<NewsChannelBean> newsChannelBeanEnable = new ArrayList<>();
    private List<NewsChannelBean> newsChannelBeanUnable = new ArrayList<>();

}
