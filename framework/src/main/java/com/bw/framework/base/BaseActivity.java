package com.bw.framework.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bw.framework.R;
import com.bw.framework.ToolBar;
import com.bw.framework.view.LoadingPage;


public  abstract class BaseActivity<V extends IView,P extends BasePresenter> extends AppCompatActivity implements ToolBar.IToolBarClickListner {

    protected P httpPresenter;
    protected ToolBar toolBar;
    protected LoadingPage loadingPage;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadingPage = new LoadingPage(this) {
            @Override
            protected int getsuccessId() {
                return getLayoutId();
            }
        };
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


    public void showloading(){
        loadingPage.loadingPage();
    }
    public void hideLoading(){
        loadingPage.showsuccessPage();
    }
    public void showerror(String errorName){
        loadingPage.showError(errorName);
    }
    public void showEnpty(){
        loadingPage.showEnptyPage();
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (httpPresenter != null){
            httpPresenter.detachView();
        }
    }
}
