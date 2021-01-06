package com.song.fromwork;

import com.song.common.ErrorBean;

public interface IView {
    void showLoading();

    void hideLoading(boolean isSuccess, ErrorBean errorBean);

    void showEmpty();
}
