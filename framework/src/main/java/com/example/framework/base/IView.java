package com.example.framework.base;

public interface IView {

    void onError(String message);
    void showError(String message);
    void showEmpty();
    void showLoading();
    void hidesLoading();

}
