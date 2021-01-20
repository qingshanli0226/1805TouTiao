package com.example.framework.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;

public
class TouTiaoRequest {
    private String picUrl;
    private ImageView imageView;
    private  TouTiaoGlide touTiaoGlide;

    public  TouTiaoRequest(Context context){
        touTiaoGlide = TouTiaoGlide.getInstance();
        if (touTiaoGlide.getIsInitAted()){
            touTiaoGlide.init(context);
        }
    }

    public TouTiaoRequest load(String url){
        this.picUrl = url;
        return this;
    }

    public void Into(final  ImageView imageView){
       this.imageView = imageView;

        String key = TouTiaoGlide.getInstance().generateCacheKey(picUrl);

        //先从内存读取

        Bitmap bitmap = null;

        bitmap = touTiaoGlide.getBitmapFromMap(picUrl);

        if (bitmap!=null){
            imageView.setImageBitmap(bitmap);
            Log.i("toutiao","内存命中，效率最高");
            return;
        }
        //内存中，没有获取到bitmap 下面获取bitmap
        touTiaoGlide.getBitmapFromDisk(key, new TouTiaoGlide.IGetBitmapListener() {
            @Override
            public void onBitmap(Bitmap bitmap) {
                if (bitmap!=null){
                    Log.i("toutiao","磁盘命中，效率中间");
                    imageView.setImageBitmap(bitmap);
                    return;
                }
                touTiaoGlide.getBitmapFromServer(picUrl, imageView, new TouTiaoGlide.IGetBitmapListener() {
                    @Override
                    public void onBitmap(Bitmap bitmap) {
                        if (bitmap !=null){
                            Log.i("toutiao","服务端命中，效率最低");
                            imageView.setImageBitmap(bitmap);
                        }
                    }
                });
            }
        });
    }
}
