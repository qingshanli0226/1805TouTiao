package com.example.framewrok.base.glide;

import android.graphics.Bitmap;
import android.util.LruCache;

import androidx.annotation.NonNull;

public class NewGlide {
    private LruCache<String,Bitmap> memoryCache;//内存

    private static volatile  NewGlide glide;

    private NewGlide(){

    }
    public static NewGlide getInstance(){
        if (glide==null) {
            synchronized (NewGlide.class) {
                if (glide == null) {
                    glide = new NewGlide();
                }
            }
        }
            return glide;
    }
    //第一步取内存
    public Bitmap getBitmapFromMem(@NonNull String key){
        synchronized (memoryCache){
            return memoryCache.get(key);
        }
    }
    //存内存
    public  void setBitmapTomem(@NonNull String key,@NonNull Bitmap bitmap){
        synchronized (memoryCache){
             memoryCache.put(key,bitmap);
        }
    }

}
