package com.song.fromwork;

public interface IPresenter<V extends IView> {
    void attach(V iView);

    void detach();

    void doRefresh();

    void doShowNetError();
}
