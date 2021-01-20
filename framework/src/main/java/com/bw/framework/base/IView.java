package com.bw.framework.base;

public interface IView {
    void onError(String message);
    void showsloading();
    void hideloading();
    void showErroy(String message);
    void showEmpty();
}
