package com.example.framewrok.base.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.framewrok.base.IPrine;
import com.example.framewrok.base.IView;
import com.example.framewrok.base.view.LoadingPage;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public abstract class BaseMVPFragment<Prine extends IPrine,PView extends IView> extends Fragment {
    public Prine presenter;
    protected LoadingPage loadingPage;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onregister(savedInstanceState);
    }

    protected abstract void onregister(Bundle savedInstanceState);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        loadingPage=new LoadingPage(getContext()) {
            @Override
            protected int getSuccessLayoutid() {
                return getLayoutid();
            }
        };


//        View inflate = inflater.inflate(getLayoutid(), null);

        return loadingPage;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        intView(loadingPage);
        inPresone();

        if (presenter!=null){
            presenter.attach((PView)this);
        }
        inData();
        initHttpData();
    }


    protected abstract void initHttpData();

    protected abstract int getLayoutid();
    protected abstract void intView(View inflate);
    protected abstract void inPresone();
    protected abstract void inData();

    @Override
    public void onStart() {
        super.onStart();
        onstart();
    }

    protected abstract void onstart();

    @Override
    public void onStop() {
        super.onStop();
        onstop();
    }

    protected abstract void onstop();

    @Override
    public void onDestroy() {
        super.onDestroy();
        ondestroy();
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onConnectChange(Boolean isConnected){
        if (isConnected){
            onConnected();
        }else {
            onDisConnected();
        }
    }

    protected void onDisConnected() {
    }

    protected  void onConnected(){};
    protected abstract void ondestroy();

}
