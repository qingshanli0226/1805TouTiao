package com.example.framework.base;

public interface IPresenter<V extends IView> {

    //将presenter和Ui建立关联,也就是绑定
    void attachView(V iView);
    //接触关联,避免内存泄漏
    void detachView();

}
