package com.bw.framework.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bw.framework.view.LoadingPage;

public abstract class BaseFragment<V extends IView,P extends BasePresenter> extends Fragment {

    private View rootView;
    protected P httpPresenter;
    protected LoadingPage loadingPage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        loadingPage = new LoadingPage(getContext()) {
            @Override
            protected int getsuccessId() {
                return getLayoutId();
            }
        };

        initView();
        initPresenter();
        initData();
        if (httpPresenter != null){
            httpPresenter.attachView((V) this);
        }
        return loadingPage;
    }

    public <T extends View> T findViewById(@IdRes int id) {
        return loadingPage.getSucessView().findViewById(id);
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
    public void onDestroy() {
        super.onDestroy();
        if (httpPresenter != null){
            httpPresenter.detachView();
        }
    }
}
