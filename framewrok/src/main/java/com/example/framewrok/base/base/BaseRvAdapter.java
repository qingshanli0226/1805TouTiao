package com.example.framewrok.base.base;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRvAdapter<T> extends RecyclerView.Adapter<BaseRvAdapter.BaseViewHolder> {
    private List<T> datalist=new ArrayList<>();
    private IBaseRecyclerLinsterner iBaseRecyclerLinsterner;

    public void updatelist(List<T> datelist) {
        this.datalist.clear();
        this.datalist.addAll(datelist);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(getLayoutid(viewType), parent, false);
        return new BaseViewHolder(view);
    }

    protected abstract int getLayoutid(int viewType);

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iBaseRecyclerLinsterner!=null){
                    iBaseRecyclerLinsterner.onItemclick(position);
                }
            }
        });
        cover(holder,position,datalist.get(position));
    }
    @Override
    public int getItemViewType(int position) {
        return getViewtype(position);
    }

    protected abstract int getViewtype(int postion);

    protected abstract void cover(BaseViewHolder holder, int position, T t);

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public static class BaseViewHolder extends RecyclerView.ViewHolder{
        SparseArray<View> sparseArray=new SparseArray<>();
        public BaseViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        public <V extends View> V getView(@IdRes int id){
            if (sparseArray.get(id)==null){
                V childid = itemView.findViewById(id);
                sparseArray.put(id,childid);
            }
            return (V) sparseArray.get(id);
        }
    }
    //实现点击事件的方法
    public void setBaseRVAdapterlinterner(IBaseRecyclerLinsterner linsterner) {
        this.iBaseRecyclerLinsterner = linsterner;
    }
    //实现接口回调
    public interface IBaseRecyclerLinsterner{
        void onItemclick(int position);
    }
}
