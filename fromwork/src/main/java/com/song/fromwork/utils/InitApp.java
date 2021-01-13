package com.song.fromwork.utils;

import android.content.Context;

public class InitApp {

    private static Context AppContext;

    public static void init(Context context) {
        AppContext = context;
    }

    public static Context getAppContext() {
        return AppContext;
    }

}
