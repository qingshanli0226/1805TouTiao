package com.bw.framework.callback;

public interface IUser {
     void onSuccess(Object...objects);
     void onError(String msg);
}
