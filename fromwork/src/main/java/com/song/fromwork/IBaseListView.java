package com.song.fromwork;

import java.util.List;


public interface IBaseListView<T> extends IBaseView<T> {

    void onShowLoading();

    void onHideLoading();

    void onShowNetError();

    void setPresenter(T presenter);

    void onSetAdapter(List<?> list);

    void onShowNoMore();
}
