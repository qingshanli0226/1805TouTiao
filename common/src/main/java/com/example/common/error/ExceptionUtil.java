package com.example.common.error;

import android.accounts.NetworkErrorException;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

public class ExceptionUtil {
    public static ErrorBean getErrorBean(String code,String message){
        ErrorBean errorBean = new ErrorBean();
        errorBean.setCode(code);
        errorBean.setMessage(message);
        return errorBean;
    }
    public static ErrorBean getErrorBean(Throwable e){
        ErrorBean errorBean = new ErrorBean();
        BusinessException businessException;
        if(e instanceof BusinessException){
           businessException=(BusinessException)e;
           errorBean=businessException.getErrorBean();
        }else if(e instanceof NetworkErrorException){
            errorBean.setMessage("网络错误");
            errorBean.setCode("1000");
        }else if(e instanceof JSONException){
            errorBean.setMessage("Json解析错误");
            errorBean.setCode("2000");
        }else if(e instanceof IndexOutOfBoundsException){
            errorBean.setMessage("下标越界");
            errorBean.setCode("warning");
        }else if(e instanceof SocketTimeoutException){
            errorBean.setMessage("连接超时");
            errorBean.setCode("3000");
        }else if(e instanceof ConnectException){
            errorBean.setMessage("网络连接错误");
            errorBean.setCode("4000");
        }else {
            errorBean.setMessage("其他错误");
            errorBean.setCode("20000");
        }
        return errorBean;
    }
}
