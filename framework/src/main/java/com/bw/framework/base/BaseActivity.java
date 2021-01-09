package com.bw.framework.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bw.framework.R;
import com.bw.framework.ToolBar;


public  abstract class BaseActivity<V extends IView,P extends BasePresenter> extends AppCompatActivity implements ToolBar.IToolBarClickListner {

    protected P httpPresenter;
    protected ToolBar toolBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        initView();
        initPresenter();
        initData();

        toolBar = findViewById(R.id.toolbar);
        toolBar.setToolBarClickListner(this);

        if (httpPresenter != null){

            httpPresenter.attachView((V) this);

        }
    }

    protected abstract void initData();

    protected abstract void initPresenter();

    protected abstract void initView();

    protected abstract int getLayoutId();




    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (httpPresenter != null){
            httpPresenter.detachView();
        }
    }
}
