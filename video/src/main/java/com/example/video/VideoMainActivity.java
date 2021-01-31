package com.example.video;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.example.framewrok.base.base.BaseActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Base64;
import android.util.Log;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Random;
import java.util.zip.CRC32;

public class VideoMainActivity extends BaseActivity {
    private StandardGSYVideoPlayer shu;

    @Override
    protected int getlayoutId() {
        return R.layout.activity_video_main;
    }

    @Override
    protected void intView() {
        shu = (StandardGSYVideoPlayer) findViewById(R.id.shu);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void inPresone() {

    }

    @Override
    protected void inData() {
        Intent intent=getIntent();
        String stringExtra = intent.getStringExtra("video_id");
        Log.e("FFFFFFF",""+stringExtra);
      VideoPlayer.PlayerVideo(stringExtra);


//
//        Log.e("播放",s+"");
//     shu.setUp(s,true,null);
//     shu.startPlayLogic();
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Message(String  url) {
     Log.e("播放",url+"");
     shu.setUp(url,true,null);
     shu.startPlayLogic();
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void ondestroy() {
        shu.stopNestedScroll();
        EventBus.getDefault().unregister(this);
    }

}
