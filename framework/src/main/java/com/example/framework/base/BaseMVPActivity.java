package com.example.framework.base;

import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.framework.R;
import com.example.framework.view.ToolBar;

public abstract class BaseMVPActivity<P extends IPresenter,V extends IView> extends BaseActivity {

    protected P httpPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter();
        initData();
        if (httpPresenter!=null){
            httpPresenter.attachView((V)this);
        }
    }
    protected abstract void initPresenter();

    protected abstract void initData();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (httpPresenter!=null){
            httpPresenter.detachView();
        }
    }
}
