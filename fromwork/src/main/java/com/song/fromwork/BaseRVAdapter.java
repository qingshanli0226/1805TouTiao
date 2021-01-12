package com.song.fromwork;

import android.util.Log;
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
    protected ArrayList<T> dataList = new ArrayList<>();

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(getLayoutId(viewType), parent, false);
        return new BaseViewHolder(rootView);
    }

    protected abstract int getLayoutId(int viewType);

    protected abstract int getViewType(int position);

    protected abstract void convert(T itemData, BaseViewHolder baseViewHolder, int position);

    public T getItemData(int position) {
        return dataList.get(position);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return getViewType(position);
    }

    public void updataData(List<T> datas) {
        if (datas == null) {
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


    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iRecyclerViewItemClickListener != null) {
                    iRecyclerViewItemClickListener.onItemClick(position);
                }
            }
        });
        T itemData = getItemData(position);
        convert(itemData, holder, position);
    }

    public IRecyclerViewItemClickListener getiRecyclerViewItemClickListener() {
        return iRecyclerViewItemClickListener;
    }

    public void setIRecyclerViewItemClickListener(IRecyclerViewItemClickListener iRecyclerViewItemClickListener) {
        this.iRecyclerViewItemClickListener = iRecyclerViewItemClickListener;
    }

    public interface IRecyclerViewItemClickListener {
        void onItemClick(int position);
    }

    public static class BaseViewHolder extends RecyclerView.ViewHolder {
        HashMap<Integer, View> viewHashMap = new HashMap<>();

        public BaseViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public <V extends View> V getVIew(@IdRes int id) {
            View view = viewHashMap.get(id);
            if (view == null) {
                view = itemView.findViewById(id);
                viewHashMap.put(id, view);
            }
            return (V) view;
        }
    }

}
