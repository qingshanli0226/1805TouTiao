package com.song.fromwork.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

public class GlideRequest {

    private String picUrl;
    private ImageView imageView;
    private GlideLoad glideLoad;

    public GlideRequest(Context context) {
        glideLoad = GlideLoad.getInstance();
        if (!glideLoad.isInitated()) {
            glideLoad.init(context);
        }
    }

    public GlideRequest load(String url) {
        this.picUrl = url;
        return this;
    }

    public void into(final ImageView imageView) {
        this.imageView = imageView;
        String key = GlideLoad.getInstance().generateCacheKey(picUrl);
        //鍏堜粠鍐呭瓨涓­鑾峰彇Bitmap
        Bitmap bitmap = null;
        bitmap = glideLoad.getBitmapFromMem(key);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            Log.d("LQS", "鍐呭瓨涓­鍛戒腑 鏁堢巼鏈€楂樸€傘€傘€傘€");
            return;
        }
        //浠庡唴瀛樹腑娌℃湁鑾峰彇鍒癇itmap锛屼笅闈¢浠庢湰鍦拌幏鍙朾itmap
        glideLoad.getBitmapFromDisk(key, new GlideLoad.IGetBitmapListener() {
            @Override
            public void onBitmap(Bitmap bitmap) {
                if (bitmap != null) {
                    Log.d("LQS", "鏈¬鍦颁腑鍛戒腑 鏁堢巼涓­闂淬€傘€傘€傘€");
                    imageView.setImageBitmap(bitmap);
                    return;
                }
                //濡傛灉浠庢湰鍦版病鏈夎幏鍙栧埌bitmap,鍙ª鑳戒粠缃戠粶鑾峰彇
                glideLoad.getBitmapFromServer(picUrl, imageView, new GlideLoad.IGetBitmapListener() {
                    @Override
                    public void onBitmap(Bitmap bitmap) {
                        if (bitmap != null) {
                            Log.d("LQS", "鏈嶅姟绔¯鍛戒腑 鏁堢巼鏈€浣庛€傘€傘€傘€");
                            imageView.setImageBitmap(bitmap);
                        }
                    }
                });
            }
        });
    }
}
