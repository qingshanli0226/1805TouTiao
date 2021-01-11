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

import com.example.common.error.ErrorBean;
import com.example.framework.view.LoadingPage;

public abstract class BaseFragment<P extends IPresenter,V extends IView> extends Fragment {
    protected P presenter;
    private LoadingPage loadingPage;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        loadingPage=new LoadingPage(getActivity()) {
            @Override
            protected int getSuccessLayoutId() {
                return getLayoutID();
            }
        };
        initPresenter();
        initView();
        if(presenter!=null){
            presenter.attach((V) this);
        }

        return loadingPage;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        initListener();
        initData();
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
        return loadingPage.findViewById(id);
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
    protected void showLoading(){
        loadingPage.showLoadingpage();
    }
    protected void hideLoading(boolean isSuccess, ErrorBean bean){
        if(isSuccess){
            loadingPage.showSuccessView();
        }else {
            toast(bean.getCode()+bean.getMessage());
            loadingPage.showErrorPage(bean.getMessage());
        }

    }
    protected void showEmptyContent(){
        loadingPage.showEmptyContentPage();
    }
    protected void showEmptyComment(){
        loadingPage.showEmptyCommentPage();
    }
}
