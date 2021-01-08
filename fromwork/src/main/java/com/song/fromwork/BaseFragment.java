package com.song.fromwork;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.song.common.ErrorBean;
import com.song.common.LoadingPage;
import com.song.common.MyToolBar;

public abstract class BaseFragment extends Fragment implements MyToolBar.IToolBarClickListner {

    protected MyToolBar toolBar;
    private LoadingPage loadingPage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        loadingPage = new LoadingPage(getActivity()) {
            @Override
            protected int getSuccessLayoutId() {
                return getLayoutId();
            }
        };
        toolBar = findViewById(R.id.toolBar);
        toolBar.setToolBarClickListner(this);
        return loadingPage;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getLayoutId();

    public <T extends View> T findViewById(@IdRes int id) {
        return loadingPage.findViewById(id);
    }

    @Override
    public void onLeftClick() {
        getActivity().finish();
    }

    @Override
    public void onRightClick() {

    }

    public void showLoading() {
        loadingPage.showLoadingView();
    }

    public void hideLoadingPage(boolean isSuccess, ErrorBean errorBean) {
        if (isSuccess) {
            showSuccess();
        } else {
            if(errorBean != null) {
                showError(errorBean.getErrorMessage());
            } else {
                showError();
            }
        }
    }

    private void showSuccess() {
        loadingPage.showSuccessView();
    }

    private void showError(String errorMessage) {
        loadingPage.showErrorView(errorMessage);
    }

    private void showError(){
        loadingPage.showErrorView("错误");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        destroy();
    }

    private void destroy() {

    }

}
