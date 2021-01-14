package com.toutiao.bawei.a1805toutiao.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.toutiao.bawei.a1805toutiao.R;

public class HandlerActivity extends AppCompatActivity {
    private Handler threadHandler;
    private TextView xrTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        initThreadWithHandler();

        findViewById(R.id.btnHandler).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendHandlerMessageWithManyThreads();
            }
        });
        xrTv =findViewById(R.id.xrTv);
        findViewById(R.id.btnDelay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doDelayMessage();
            }
        });
    }

    private void doDelayMessage() {
        handlerA.sendEmptyMessageDelayed(5, 0);
        handlerA.sendEmptyMessageDelayed(6, 2000);
        handlerA.sendEmptyMessageDelayed(7,1000);
        handlerA.sendEmptyMessageDelayed(8,0);
        handlerA.sendEmptyMessageDelayed(9,5000);

    }

    private void initThreadWithHandler() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();//创建一个Looper实例，并且把实例存放到子线程的私有存储空间里
                threadHandler = new Handler(Looper.getMainLooper()) {//实例化Handler，因为该Handler是在子线程中实例化的，那么，它将会从子线程的私有存储空间里，拿到子线程的Looper,引用子线程looper的Messagequeue
                    @Override
                    public void handleMessage(Message msg) {
                        switch (msg.what) {
                            case 2:
                                xrTv.setText("子线程.....");
                                Log.d("LQS", "2" + "消息处理" + " 是否是主线程:" + getLooper().equals(Looper.getMainLooper()));
                                break;
                        }
                    }
                };
                Looper.loop();//使用当前子线程的looper，去循环遍历MessageQueue
            }
        }).start();
    }

    private Handler handlerA = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.d("LQS A", msg.what + " 消息处理" + " 是否是主线程:" + getLooper().equals(Looper.getMainLooper()));
        }
    };
    private Handler handlerB = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.d("LQS B", msg.what + " 消息处理" + " 是否是主线程:" + getLooper().equals(Looper.getMainLooper()));
        }
    };

    private void sendHandlerMessageWithManyThreads() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 50; i++) {
                    handlerA.sendEmptyMessage(1);
                    Message message = new Message();
                    message.what = 1;
                    handlerA.post(new Runnable() {
                        @Override
                        public void run() {

                        }
                    });
                    handlerA.sendEmptyMessageDelayed(1,1000);
                    handlerA.sendMessage(message);
                    handlerB.sendEmptyMessage(2);
                    handlerA.sendEmptyMessage(1);
                    handlerB.sendEmptyMessage(2);
                    handlerA.sendEmptyMessage(1);
                    handlerB.sendEmptyMessage(2);
                    handlerA.sendEmptyMessage(1);
                    handlerB.sendEmptyMessage(2);
                    handlerA.sendEmptyMessage(1);
                    handlerB.sendEmptyMessage(2);
                }
            }
        }).start();
    }
}
