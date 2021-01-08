package com.toutiao.bawei.a1805toutiao.mvvm;

public class MVVMBaseBean<T> {
    private int status;//状态，表示不同网络处理状态
    private String errorMessage;
    private static final int LOAING = 1;
    private static final int SUCCESS = 2;
    private static final int ERROR = 3;

    public MVVMBaseBean(T data, int status, String errorMessage) {
        this.data = data;
        this.status = status;
        this.errorMessage = errorMessage;
    }

    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> MVVMBaseBean<T> loadingBean() {
        return new MVVMBaseBean(null, LOAING,null);
    }
    public static <T> MVVMBaseBean<T> successBean(T data) {
        return new MVVMBaseBean<>(data, SUCCESS, null);
    }
    public static <T> MVVMBaseBean<T> errorBean(String errorMessage) {
        return new MVVMBaseBean<>(null, ERROR, errorMessage);
    }

    public void handleMessage(MVVMBaseBean<T> baseBean, IMVVMBaseBeanHandler<T> handler) {
        if (baseBean.getStatus() == LOAING) {
            handler.onLoading();
        } else if (baseBean.getStatus() == SUCCESS) {
            handler.onSuccess(baseBean.getData());
        } else {
            handler.onError(baseBean.getErrorMessage());
        }
    }

    public interface IMVVMBaseBeanHandler<T> {
        void onLoading();
        void onSuccess(T data);
        void onError(String message);
    }
}
