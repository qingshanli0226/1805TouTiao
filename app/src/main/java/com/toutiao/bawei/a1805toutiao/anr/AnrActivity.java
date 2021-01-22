package com.toutiao.bawei.a1805toutiao.anr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.toutiao.bawei.a1805toutiao.R;

import java.util.ArrayList;
import java.util.List;

public class AnrActivity extends AppCompatActivity {
    private List<Bitmap> bitmapList = new ArrayList<>();

    private Handler handler = new Handler();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anr);

        findViewById(R.id.btnTroke).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Thread.sleep(1*2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        IntentFilter intentFilter = new IntentFilter("1805");
        registerReceiver(broadcastReceiver,intentFilter);
        //init();
        findViewById(R.id.btnReceive).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("1805");
                AnrActivity.this.sendBroadcast(intent);
            }
        });

        findViewById(R.id.btnLock).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lockAnr();
            }
        });
        findViewById(R.id.btnLock).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.d("LQS", "主线程后获取锁");
                doWork();
                return true;
            }
        });

        findViewById(R.id.btnTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d("LQS", "验证抖动导致的ANR");
            }
        });
    }

    private void testTrokAnr() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 1; i++) {
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.adr);
                    bitmapList.add(bitmap);
                    Bitmap bitmap1= BitmapFactory.decodeResource(getResources(),R.mipmap.adr1);
                    bitmapList.add(bitmap1);
                    Bitmap bitmap2= BitmapFactory.decodeResource(getResources(),R.mipmap.adr2);
                    bitmapList.add(bitmap2);
                    Bitmap bitmap3= BitmapFactory.decodeResource(getResources(),R.mipmap.adr3);
                    bitmapList.add(bitmap3);
                    Bitmap bitmap5 = BitmapFactory.decodeResource(getResources(),R.mipmap.adr5);
                    bitmapList.add(bitmap5);
                    Bitmap bitmap6= BitmapFactory.decodeResource(getResources(),R.mipmap.adr6);
                    bitmapList.add(bitmap6);
                    Bitmap bitmap7= BitmapFactory.decodeResource(getResources(),R.mipmap.adr7);
                    bitmapList.add(bitmap7);
                   /* Bitmap bitmap8= BitmapFactory.decodeResource(getResources(),R.mipmap.adr8);
                    bitmapList.add(bitmap8);
                    Bitmap bitmap4= BitmapFactory.decodeResource(getResources(),R.mipmap.adr4);
                    bitmapList.add(bitmap4);*/
                }
                for(;;) {
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.adr5);
                  /*  try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    bitmap.recycle();
                }
            }
        }).start();
    }

    private synchronized void doWork() {
        try {
            Log.d("LQS", "做耗时操作");
            Thread.sleep(50*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void lockAnr() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("LQS", "子线程先获取锁");
                doWork();
            }
        }).start();
    }

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            try {
                Log.d("LQS", "收到广播");
                Thread.sleep(2*1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };


    private void init() {
        for(;;) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.e);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bitmap.recycle();
        }


    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_UP) {
            Log.d("LQS", "dispatchTouchEvent.....开始处理抬起事件......");
            boolean result = super.dispatchTouchEvent(ev);
            Log.d("LQS", "dispatchTouchEvent.....处理抬起结果：" + result);
            return result;

        } else {
            if (ev.getAction() == MotionEvent.ACTION_DOWN) {
                Log.d("LQS", "dispatchTouchEvent.....开始处理向下点击事件......");
            } else if (ev.getAction() == MotionEvent.ACTION_MOVE) {
                Log.d("LQS", "dispatchTouchEvent.....开始处理滑动事件......");
            }
            return super.dispatchTouchEvent(ev);
        }
    }
}
