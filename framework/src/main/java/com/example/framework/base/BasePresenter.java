package com.example.framework.base;

public class BasePresenter<V extends IView> implements IPresenter<V> {
    public  V view;
    @Override
    public void attach(V view) {
        this.view=view;
    }

    @Override
    public void detach() {
        view=null;
    }
}