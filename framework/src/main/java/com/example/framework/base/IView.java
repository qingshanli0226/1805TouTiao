package com.example.framework.base;

import com.example.common.error.ErrorBean;

public interface IView {
    void showLoadingPage();
    void hideLoadingPage(boolean isSuccess, ErrorBean errorBean);
    void showEmpty();
}
