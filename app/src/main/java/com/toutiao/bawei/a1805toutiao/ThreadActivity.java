package com.toutiao.bawei.a1805toutiao;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadActivity extends AppCompatActivity {
    private int sumValue = 0;
    private TextView sumTv;
    private ReentrantLock lock = new ReentrantLock();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        sumTv = findViewById(R.id.sumTv);

        findViewById(R.id.btnAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSumClass();
            }
        });

    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    sumTv.setText("第一个线程"+ Sum.sum+"");
                    break;
                case 2:
                    sumTv.setText("第二个线程"+ Sum.sum+"");
                    break;
            }

        }
    };

    private void add() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i++ < 50000) {
                    synchronized (ThreadActivity.this) {
                        addSum();
                    }
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                handler.sendEmptyMessage(1);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int j = 0;
                while (j++ < 50000) {
                    synchronized (ThreadActivity.this) {
                        addSum();
                    }
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                handler.sendEmptyMessage(2);
            }
        }).start();



    }

    private void addSumClass() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Sum sum1 = new Sum();
                int i = 0;
                while (i++ < 50000) {
                    sum1.addSum();
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                handler.sendEmptyMessage(1);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Sum sum2 = new Sum();
                int j = 0;
                while (j++ < 50000) {
                    sum2.addSum();
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                handler.sendEmptyMessage(2);
            }
        }).start();
    }

    private void addSumWithLock() {
        lock.lock();//获取锁
        sumValue = sumValue + 1;
        lock.unlock();//释放锁
    }

    private synchronized void addSumWithSync() {
        sumValue = sumValue+1;
    }

    private void addSum() {
        sumValue = sumValue + 1;
    }
}
