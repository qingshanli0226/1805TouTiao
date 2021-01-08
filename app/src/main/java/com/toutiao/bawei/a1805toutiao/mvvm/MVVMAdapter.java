package com.toutiao.bawei.a1805toutiao.mvvm;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kuaishou.bawei.net.bean.MVVMItemBean;
import com.toutiao.bawei.a1805toutiao.BR;
import com.toutiao.bawei.a1805toutiao.R;

import java.util.ArrayList;
import java.util.List;

public class MVVMAdapter extends RecyclerView.Adapter<MVVMAdapter.MVVMViewHolder> {
    private List<MVVMItemBean> data = new ArrayList<>();

    public void updateData(List<MVVMItemBean> mvvmItemBeanList) {
        data.clear();
        data.addAll(mvvmItemBeanList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MVVMViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rv,viewGroup,false);
        return new MVVMViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MVVMViewHolder mvvmViewHolder, int i) {
        mvvmViewHolder.getViewDataBinding().setVariable(BR.item,data.get(i));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MVVMViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding viewDataBinding;
        public ViewDataBinding getViewDataBinding() {
            return viewDataBinding;
        }
        public MVVMViewHolder(View itemView) {
            super(itemView);
            viewDataBinding = DataBindingUtil.bind(itemView);
        }
    }
}
