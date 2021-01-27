package com.example.framewrok.base.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

public class NewsRequest {
    private String picUrl;
    private ImageView imageView;
    private NewsGlide newsGlide;
    public NewsRequest(Context context) {
        newsGlide = NewsGlide.getInstance();
        if (!newsGlide.isInitated()) {
            newsGlide.init(context);
        }
    }

    public NewsRequest load(String url) {
        this.picUrl = url;
        return this;
    }

    public void into(final ImageView imageView) {
        this.imageView = imageView;
        String key = NewsGlide.getInstance().generateCacheKey(picUrl);
        final String name = "";
        //先从内存中获取Bitmap
        Bitmap bitmap = null;
        bitmap = newsGlide.getBitmapFromMem(key);
        if (bitmap!=null) {
            imageView.setImageBitmap(bitmap);
            Log.d("LQS", "内存中命中 效率最高。。。。");
            return;
        }
        //从内存中没有获取到Bitmap，下面从本地获取bitmap
        newsGlide.getBitmapFromDisk(key, new NewsGlide.IGetBitmapListerner() {
            @Override
            public void onBitmap(Bitmap bitmap) {
                if (bitmap!=null) {
                    Log.d("LQS", "本地中命中 效率中间。。。。");
                    imageView.setImageBitmap(bitmap);
                    return;
                }
                //如果从本地没有获取到bitmap,只能从网络获取
                newsGlide.getBitmapFromServer(name,picUrl, imageView, new NewsGlide.IGetBitmapListerner() {
                    @Override
                    public void onBitmap(Bitmap bitmap) {
                        if (bitmap!=null) {
                            Log.d("LQS", "服务端命中 效率最低。。。。");
                            imageView.setImageBitmap(bitmap);
                        }
                    }
                });
            }
        });
    }
}
