package com.song.common;

import androidx.annotation.NonNull;

import io.reactivex.functions.Consumer;


public class ErrorAction {

    @NonNull
    public static Consumer<Throwable> error() {
        return new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                if (BuildConfig.DEBUG) {
                    throwable.printStackTrace();
                }
            }
        };
    }

    public static void print(@NonNull Throwable throwable) {
        if (BuildConfig.DEBUG) {
            throwable.printStackTrace();
        }
    }
}
