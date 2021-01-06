package com.example.framework.base;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment<P extends IPresenter,V extends IView> extends Fragment {
    protected P presenter;
    private View inflate;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(getLayoutID(), container, false);
        initPresenter();
        initView();
        if(presenter!=null){
            presenter.attach((V) this);
        }
        initListener();
        initData();
        return inflate;
    }

    protected abstract void initData();

    protected abstract void initListener();
    protected void toast(String toast){
        Toast.makeText(getContext(), ""+toast, Toast.LENGTH_SHORT).show();
    }
    protected void logI(String TAG,String msg){
        Log.i(TAG,msg);
    }
    public <T extends View> T findViewById(@IdRes int id){
        return inflate.findViewById(id);
    }
    protected abstract void initView();

    protected abstract void initPresenter();

    protected abstract int getLayoutID();

    @Override
    public void onDestroy() {
        super.onDestroy();
        onThisDestory();
    }

    protected void onThisDestory(){
        if(presenter!=null){
            presenter.detach();
        }
    }
}
