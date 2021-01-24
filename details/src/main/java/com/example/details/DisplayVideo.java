package com.example.details;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

public class DisplayVideo extends AppCompatActivity {
    private StandardGSYVideoPlayer gsy;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_video);
        gsy = (StandardGSYVideoPlayer) findViewById(R.id.gsy);
        gsy.setUp("http://v9-default.ixigua.com/f9b142cae0d34a4c7537b4a20c830b51/600b8fe5/video/tos/cn/tos-cn-ve-0022/ffb5d1504ec54acab74c4e82a5593786/?a=2012&br=6180&bt=2060&cd=0%7C0%7C0&cr=0&cs=0&cv=1&dr=0&ds=3&er=&l=20210123095403010012035146161C19A3&lr=&mime_type=video_mp4&pl=0&qs=0&rc=amVma3VtcHdvdjMzOTkzM0ApPDs0ZmY1NWVmNzZkaDc6OWdqajZmMmlhMWlfLS1gLi9zc2BiLjMxLjJiX2E1NF8xMS06Yw%3D%3D&vl=&vr=",true,null);
       gsy.startPlayLogic();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GSYVideoManager.releaseAllVideos();
    }
}