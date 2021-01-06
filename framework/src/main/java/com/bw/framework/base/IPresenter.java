package com.bw.framework.base;

public interface IPresenter<V extends IView> {

    void attachView(V iView);
    void detachView();

}
