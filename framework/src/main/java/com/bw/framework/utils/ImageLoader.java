package com.bw.framework.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bw.framework.glide.GlideUtils;


import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

@GlideModule
public class ImageLoader extends AppGlideModule {

    public static void loadCenterCrop(Context context, String url, ImageView view, int defaultResId) {
        if (SettingUtil.getInstance().getIsNoPhotoMode() && NetWorkUtil.isMobileConnected(context)) {
            view.setImageResource(defaultResId);
        } else {
            Glide.with(context)
                    .load(url)
                    .transition(withCrossFade())
                    .apply(new RequestOptions().centerCrop())
                    .into(view);
        }
    }

    /**
     * 带加载异常图片
     */
    public static void loadCenterCrop(Context context, String url, ImageView view, int defaultResId, int errorResId) {
        if (SettingUtil.getInstance().getIsNoPhotoMode() && NetWorkUtil.isMobileConnected(context)) {
            view.setImageResource(defaultResId);
        } else {
            GlideUtils.circleImage(context,url,view);
        }
    }

    /**
     * 带监听处理
     */
    public static void loadCenterCrop(Context context, String url, ImageView view, RequestListener listener) {
        GlideUtils.circleImage(context,url,view);
    }

    public static void loadNormal(Context context, String url, ImageView view) {
        GlideUtils.Image(context,url,view);
    }
}
