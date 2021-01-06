package com.example.freamwork.mvp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {
    protected View iView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return iView = inflater.inflate(bandLayout(),null);
    }

    protected abstract int bandLayout();//加载布局

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView();
        initData(savedInstanceState);
        initEvent();
    }

    protected abstract void initEvent();


    public <V extends View> V F(int id){//封装findViewId使用
        return iView.findViewById(id);
    }
    protected abstract void initData(Bundle savedInstanceState);//加载数据

    protected abstract void initView();//初始化视图

    public void Ts(String msg){//封装吐司
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

}
