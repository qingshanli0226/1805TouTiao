package com.example.freamwork.mvp;

public interface IPresenter<V extends IView> {
    void attachView(V iView);
    void detachView();
}
