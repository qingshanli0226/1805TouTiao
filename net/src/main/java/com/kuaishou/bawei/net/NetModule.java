package com.kuaishou.bawei.net;

import android.content.Context;

public class NetModule {
    public static Context context;

    public static void init(Context applicationContext) {
        context = applicationContext;
    }
}
