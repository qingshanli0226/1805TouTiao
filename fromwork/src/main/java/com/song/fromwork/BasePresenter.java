package com.song.fromwork;

public class BasePresenter<V extends IView> implements IPresenter<V> {
    protected V iHttpView;

    @Override
    public void attach(V iView) {
        this.iHttpView = iView;
    }

    @Override
    public void detach() {
        this.iHttpView = null;
    }
}
