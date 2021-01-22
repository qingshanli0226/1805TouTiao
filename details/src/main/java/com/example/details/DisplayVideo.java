package com.example.details;

import androidx.appcompat.app.AppCompatActivity;

import android.opengl.GLSurfaceView;
import android.os.Bundle;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

public class DisplayVideo extends AppCompatActivity {
    private StandardGSYVideoPlayer gsy;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_video);
        gsy = (StandardGSYVideoPlayer) findViewById(R.id.gsy);
        gsy.setUp("http://vfx.mtime.cn/Video/2019/03/19/mp4/190319125415785691.mp4",true,null);
       gsy.startPlayLogic();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GSYVideoManager.releaseAllVideos();
    }
}