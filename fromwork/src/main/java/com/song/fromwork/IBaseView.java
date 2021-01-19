package com.song.fromwork;

import com.uber.autodispose.AutoDisposeConverter;

public interface IBaseView<T> {

    void onShowLoading();

    void onHideLoading();

    void onShowNetError();

    void setPresenter(T presenter);

    <X> AutoDisposeConverter<X> bindAutoDispose();
}
