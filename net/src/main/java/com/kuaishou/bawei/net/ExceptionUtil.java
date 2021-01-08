package com.kuaishou.bawei.net;

import android.accounts.NetworkErrorException;

import com.kuaishou.bawei.net.bean.ErrorBean;

import org.json.JSONException;

import java.net.SocketTimeoutException;

public class ExceptionUtil {
    public static ErrorBean getErrorBean(Throwable e) {
        ErrorBean errorBean = new ErrorBean();
        BusinessException businessException;
        if (e instanceof BusinessException) {
            businessException = (BusinessException) e;
            errorBean = businessException.getErrorBean();
        } else  if(e instanceof NetworkErrorException) {
            errorBean.setErrorCode("1000");
            errorBean.setErrorMessage("网络错误");
        } else if (e instanceof JSONException) {
            errorBean.setErrorCode("2000");
            errorBean.setErrorMessage("Json解析错误");
        } else if (e instanceof IndexOutOfBoundsException) {

        } else if (e instanceof SocketTimeoutException) {
            errorBean.setErrorCode("3000");
            errorBean.setErrorMessage("连接超时错误");
        } else {
            errorBean.setErrorCode("20000");
            errorBean.setErrorMessage("其他错误");
        }

        return errorBean;
    }
}
