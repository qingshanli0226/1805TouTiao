package com.bw.framework.glide;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;


public class GlideUtils {
      //加载圆形图片
      public static void circleImage(Context context, Object url, ImageView imageView){
          Glide.with(context)
                  .load(url)
                  .transform(new CenterCrop(),new CircleCrop())
                  .into(imageView);
      }

      //加载正常的图片
      public static void Image(Context context, Object url, ImageView imageView){
          Glide.with(context)
                  .load(url)
                  .transform(new CenterCrop())
                  .into(imageView);
      }

}
