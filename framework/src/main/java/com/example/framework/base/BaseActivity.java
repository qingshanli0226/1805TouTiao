package com.example.framework.base;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.framework.view.LoadingPage;

public abstract class BaseActivity<V extends IView,P extends IPresenter> extends AppCompatActivity {
    protected P presenter;
    private LoadingPage loadingPage;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadingPage=new LoadingPage(this) {
            @Override
            protected int getSuccessLayoutId() {
                return getLayoutID();
            }
        };
        setContentView(loadingPage);
        initPresenter();
        initView();
        if(presenter!=null){
            presenter.attach((V) this);
        }
        initListener();
        initData();
    }

    protected abstract void initPresenter();

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getLayoutID();
    protected void toast(String toast){
        Toast.makeText(this, ""+toast, Toast.LENGTH_SHORT).show();
    }
    protected void logI(String TAG,String msg){
        Log.i(TAG,msg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onThisDestroy();
    }

    protected void onThisDestroy(){
        if(presenter!=null){
            presenter.detach();
        }
    }
}
