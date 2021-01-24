package com.example.video;

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

public class VideoMainActivity extends BaseActivity {
    private StandardGSYVideoPlayer shu;

    @Override
    protected int getlayoutId() {
        return R.layout.activity_video_main;
    }

    @Override
    protected void intView() {
        shu = (StandardGSYVideoPlayer) findViewById(R.id.shu);
    }

    @Override
    protected void inPresone() {

    }

    @Override
    protected void inData() {
        String base64 ="aHR0cDovL3Y2LjM2NXlnLmNvbS92aWRlby9tLzExNDRjM2IwMDAwMGMxZTUxYjAxZDVmMjIwYTQzMzIxNTI0ZDA5NDQyNTkwMjk2ZTU0MjdiNzk0Y2UvP0V4cGlyZXM9MTQ5MDkzMDczNiZBV1NBY2Nlc3NLZXlJZD1xaDBoOVRkY0VNb1Myb1BqN2FLWCZTaWduYXR1cmU9WWNmakZDNnMxSHFhQ0NxeVZMd3ZkRWNlcXg0JTNE";

        String url1 = (new String(Base64.decode(base64.getBytes(), Base64.DEFAULT)));
        Log.e("播放",url1+"");
     shu.setUp("https://www.toutiao.com/a6914783712185942536/?app=news_article&is_hit_share_recommend=0",true,null);
     shu.startPlayLogic();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void ondestroy() {
        shu.stopNestedScroll();
    }
}
