package com.bw.framework.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bw.framework.mvp.Presenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public abstract class BaseFragment<P extends Presenter> extends Fragment {

     protected P mPresenter;
     private View view=null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.e("onCreate","onCreate");
        createPresenter();
        EventBus.getDefault().register(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Log.e("onCreateView","onCreateView");
        if (view==null){
            view=inflater.inflate(getlayoutid(),container,false);
        }
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Log.e("onActivityCreated","onActivityCreated");
        initData();
        initEvent();
    }



    protected abstract void initEvent();

    protected abstract void initData();

    protected abstract void initView(View view);

    protected abstract int getlayoutid();

    protected abstract void createPresenter();

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getconnect(Boolean connect){
        if (connect){
            connected();
        }else {
            disconnect();
        }
    }

    protected void disconnect(){
        Toast.makeText(getContext(), "网络已连接", Toast.LENGTH_SHORT).show();
    }

    protected void connected(){
        Toast.makeText(getContext(), "网络未连接", Toast.LENGTH_SHORT).show();
    }
    


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        //Log.e("onAttach","onAttach");
    }

    @Override
    public void onStart() {
        super.onStart();
        //Log.e("onStart","onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        //Log.e("onResume","onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        //Log.e("onPause","onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        //Log.e("onStop","onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //Log.e("onDestroyView","onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        //Log.e("onDestroy","onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //Log.e("onDetach","onDetach");
    }
}
