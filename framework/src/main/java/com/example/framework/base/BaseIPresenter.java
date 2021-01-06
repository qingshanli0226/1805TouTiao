package com.example.framework.base;

public class BaseIPresenter<T extends IView> implements IPresenter<T> {

    protected T iView;

    @Override
    public void attachView(T iView) {
        this.iView = iView;
    }

    @Override
    public void detachView() {
        iView = null;
    }
}
