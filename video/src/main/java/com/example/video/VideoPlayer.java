package com.example.video;


import android.util.Base64;
import android.util.Log;

import com.example.framewrok.base.JsonCallBack;
import com.example.net.bean.NetBeans;

import com.lzy.okgo.OkGo;

import com.lzy.okgo.model.Response;


import org.greenrobot.eventbus.EventBus;

import java.util.Random;

import java.util.zip.CRC32;



public class VideoPlayer {

    public static String getVideoContentApi(String videoid) {
        String VIDEO_HOST = "http://ib.365yg.com";
        String VIDEO_URL = "/video/urls/v/1/toutiao/mp4/%s?r=%s";
        String r = getRandom();
        String s = String.format(VIDEO_URL, videoid, r);
        // 将/video/urls/v/1/toutiao/mp4/{videoid}?r={Math.random()} 进行crc32加密
        CRC32 crc32 = new CRC32();
        crc32.update(s.getBytes());
        String crcString = crc32.getValue() + "";
        String url = VIDEO_HOST + s + "&s=" + crcString;
        Log.e("sssss",""+s);
        Log.e("crcString",""+crcString);
        return url;
    }

    public static String getRandom() {
        Random random = new Random();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            result.append(random.nextInt(10));
        }
        return result.toString();
    }
    public static void   PlayerVideo(String id){
        String url = getVideoContentApi(id);
        Log.e("QQQQQurl",""+url);
      OkGo.<NetBeans>get(url).execute(new JsonCallBack<NetBeans>(NetBeans.class) {
          @Override
          public void onSuccess(Response<NetBeans> response) {
              NetBeans body = response.body();

              NetBeans.DataBean.VideoListBean video_list = body.getData().getVideo_list();
              Log.e("OOOOO",""+video_list.getVideo_1().getSize());
              if (video_list.getVideo_3() != null) {
                  String base64 = video_list.getVideo_3().getMain_url();
                  String url1 = (new String(Base64.decode(base64.getBytes(), Base64.DEFAULT)));
                  Log.d("OOOOO", "getVideoUrls: " + url1);
                  EventBus.getDefault().post(url1);
              }

              if (video_list.getVideo_2() != null) {
                  String base64 = video_list.getVideo_2().getMain_url();
                  String url1 = (new String(Base64.decode(base64.getBytes(), Base64.DEFAULT)));
                  Log.d("OOOOO", "getVideoUrls: " + url1);
                  EventBus.getDefault().post(url1);
              }

              if (video_list.getVideo_1() != null) {
                  String base64 = video_list.getVideo_1().getMain_url();
                  String url1 = (new String(Base64.decode(base64.getBytes(), Base64.DEFAULT)));
                  Log.d("OOOOO", "getVideoUrls: " + url1);
                  EventBus.getDefault().post(url1);
              }
          }
      });

    }

}
