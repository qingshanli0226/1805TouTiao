package com.bw.a1805atoutiao.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import com.bw.a1805atoutiao.R;
import com.bw.framework.manager.TitleManage;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends AppCompatActivity {
    private int num=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
            //初始化数据
            String[] stringArray = getResources().getStringArray(R.array.mobile_news_name);
            String[] stringArray1 = getResources().getStringArray(R.array.mobile_news_id);
            TitleManage.getInstance().initData(stringArray,stringArray1);

        String[] stringArray2 = getResources().getStringArray(R.array.mobile_video_name);
        String[] stringArray3 = getResources().getStringArray(R.array.mobile_video_id);
        TitleManage.getInstance().initVideo(stringArray2,stringArray3);

        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
               if (num==2){
                   Looper.prepare();
                   startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
                   timer.cancel();
                   Looper.loop();
               }
               num++;
            }
        },0,1000);
    }
}