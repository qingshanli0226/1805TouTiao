package com.example.framework.base;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class BaseRVAdapter<T> extends RecyclerView.Adapter<BaseRVAdapter.BaseViewHolder> {
    private IRecyclerViewItemClickListener iRecyclerViewItemClickListener;
    private IRecyclerViewItemLongClickListener iRecyclerViewItemClickLongListener;
    private ArrayList<T> dataList = new ArrayList<>();

    public void updataData(List<T> datas) {
        if (datas== null) {
            return;
        }
        dataList.clear();
        dataList.addAll(datas);
        notifyDataSetChanged();
    }

    public void removeOneData(T dataBean) {
        dataList.remove(dataBean);
        notifyDataSetChanged();
    }

    public void addOneData(T dataBean) {
        dataList.add(dataBean);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    //根据viewType生成一个布局
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        //因为需要适配不同的布局，所以需要提供一个抽象方法，让子类把布局文件传递过来
        View rootView = LayoutInflater.from(viewGroup.getContext()).inflate(getLayoutId(viewType), viewGroup, false);
        return new BaseViewHolder(rootView);
    }

    protected abstract int getLayoutId(int viewType);//让子类根据viewType类型返回指定的布局文件

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, final int position) {
        baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (iRecyclerViewItemClickListener!=null) {
                    iRecyclerViewItemClickListener.onItemClick(position);//设置Item的点击事件
                }
            }
        });
        baseViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (iRecyclerViewItemClickLongListener!=null){
                    iRecyclerViewItemClickLongListener.onItemClick(position);//设置Item长点击事件;
                }
                return true;
            }
        });

        T itemData = getItemData(position);
        convert(itemData, baseViewHolder, position);//通过position，将itemData转换成需要的类型，并且将baseViewHoder也转换成需要的viewHolder

    }
    //需要子类来，渲染UI
    protected abstract void convert(T itemData, BaseViewHolder baseViewHolder, int position);

    public T getItemData(int position) {
        return dataList.get(position);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public IRecyclerViewItemClickListener getiRecyclerViewItemClickListener() {
        return iRecyclerViewItemClickListener;
    }
    //长点击事件
    public void setiRecyclerViewItemLongClickListener(IRecyclerViewItemLongClickListener iRecyclerViewItemClickLongListener){
        this.iRecyclerViewItemClickLongListener = iRecyclerViewItemClickLongListener;
    }
    //段点击事件
    public void setiRecyclerViewItemClickListener(IRecyclerViewItemClickListener iRecyclerViewItemClickListener) {
        this.iRecyclerViewItemClickListener = iRecyclerViewItemClickListener;
    }

    //定义一个ViewHolder，可以适配不同的UI
    public static class BaseViewHolder extends RecyclerView.ViewHolder {
        //Integer是id，View是控件，所有的控件的父类都是View,使用HashMap来存储这些Item里的所有View.findViewById,是比较耗时的
        HashMap<Integer, View> viewHashMap = new HashMap<>();

        public BaseViewHolder(View rootView) {
            super(rootView);
        }

        //泛型方法，可以通过它获取view，并且强制转换成需要的view类型,可以参考系统的findViewById
        public <V extends View> V getView(@IdRes int id) {
            View view = viewHashMap.get(id);
            if (view == null) {
                view = itemView.findViewById(id);
                viewHashMap.put(id, view);
            }

            return (V)view;
        }
    }

    public interface IRecyclerViewItemClickListener {
        void onItemClick(int position);
    }
    public interface IRecyclerViewItemLongClickListener {
        void onItemClick(int position);
    }

    //通过这个position来返回一种对应的布局类型，让子类来指定
    @Override
    public int getItemViewType(int position) {
        return getViewType(position);
    }


    //让子类来实现
    protected abstract int getViewType(int position);
}