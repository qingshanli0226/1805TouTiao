package com.bw.framework.callback;

import org.json.JSONException;

public interface INews {
     void onSuccess(Object... objects) throws JSONException;
     void onError(String msg);
}
