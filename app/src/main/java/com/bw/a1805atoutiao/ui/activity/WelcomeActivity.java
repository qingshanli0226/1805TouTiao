package com.bw.a1805atoutiao.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import com.bw.a1805atoutiao.R;
import com.bw.framework.manage.TitleManage;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends AppCompatActivity {
    private int num=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        TitleManage.getInstance().selectAll();
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