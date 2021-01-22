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
    private NewsHandler newsHandler;
    private NewsHandler newsHandler2;
    private MyHandler myHandler;
    private NewsHandler priorityHandler;
    private NewsHandler mainNewsHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("1:LQS", " 主线程 threadId:" + Thread.currentThread().getId());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        //initThreadWithHandler();

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

        processMessageByNewsHandler();
        findViewById(R.id.btnSendNewsMessage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNewsMessage();
            }
        });

        findViewById(R.id.btnPriority).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testPriority();
            }
        });

        findViewById(R.id.btnDelayNewsHandler).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testDelay();
            }
        });
        findViewById(R.id.btnMainHandler).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsLooper.prepare();
                mainNewsHandler = new NewsHandler() {
                    @Override
                    public void handleMessage(NewsMessage newsMessage) {
                        super.handleMessage(newsMessage);
                        Log.d("LQS", " main Newshandler handleMessage" + newsMessage.what);
                    }
                };
                NewsLooper.loop();
            }
        });
        findViewById(R.id.btnSendMessage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainNewsHandler.sendEmptyMessage(888888);
            }
        });

    }

    private void testDelay() {
        NewsMessage newsMessage = new NewsMessage();
        newsMessage.what = 3000;
        Log.d("LQS", "3000发送一条延迟5秒的消息");
        myHandler.sendDelayedMessage(newsMessage, 5*1000);
        Log.d("LQS", "20000发送一条无延迟的消息");

        myHandler.sendEmptyMessage(20000);
        NewsMessage newsMessage1 = new NewsMessage();
        newsMessage1.what = 6000;
        Log.d("LQS", "6000发送一条延迟2秒消息");
        myHandler.sendDelayedMessage(newsMessage1, 2*1000);
        NewsMessage newsMessage2 = new NewsMessage();
        newsMessage2.what = 7000;
        Log.d("LQS", "7000发送一条延迟6秒消息");
        myHandler.sendDelayedMessage(newsMessage2, 6*1000);
    }


    private void testPriority() {
        priorityHandler.sendEmptyMessage(10000);
    }

    private void sendNewsMessage() {

        NewsMessage newsMessage = new NewsMessage();
        newsMessage.what = 100;
        newsHandler.sendMessage(newsMessage);
        NewsMessage newsMessage2 = new NewsMessage();
        newsMessage2.what = 200;
        newsHandler.sendMessage(newsMessage2);

        newsHandler.post(new Runnable() {
            @Override
            public void run() {
                Log.d("newsHandler 2:LQS", " runnable threadId:" + Thread.currentThread().getId());
            }
        });


        myHandler.sendEmptyMessage(500);
    }

    private void processMessageByNewsHandler() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("LQS 第一个子线程Id:", Thread.currentThread().getId()+"");
                NewsLooper.prepare();
                //Handler在那个实例化，该Handler发送的消息将由该线程处理
                newsHandler = new NewsHandler() {
                    @Override
                    public void handleMessage(NewsMessage newsMessage) {
                        Log.d("newsHandler 4:LQS", newsMessage.what+"" + " threadId:" + Thread.currentThread().getId());
                    }
                };

                priorityHandler = new NewsHandler(new NewsHandler.CallBack() {
                    @Override
                    public boolean handleMessage(NewsMessage newsMessage) {
                        Log.d("LQS", "------callBack handleMessage 优先处理了消息:" + newsMessage.what);

                        return true;
                    }
                }) {
                    @Override
                    public void handleMessage(NewsMessage msg) {
                        Log.d("LQS", "------Handler handleMessage 处理了消息:" + msg.what);
                        //实现自己的代码
                    }
                };
                NewsLooper.loop();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("LQS 第二个子线程Id:", Thread.currentThread().getId()+"");
                NewsLooper.prepare();
                myHandler = new MyHandler();
                NewsLooper.loop();
            }
        }).start();
    }


    //定义一个类继承NewsHandler
    private class MyHandler extends NewsHandler {
        @Override
        public void handleMessage(NewsMessage newsMessage) {
            Log.d("MyHandler 6:LQS", newsMessage.what+"" + " threadId:" + Thread.currentThread().getId());
        }
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
                threadHandler = new Handler() {//实例化Handler，因为该Handler是在子线程中实例化的，那么，它将会从子线程的私有存储空间里，拿到子线程的Looper,引用子线程looper的Messagequeue
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //当页面销毁时，关闭handler发送的消息
        newsHandler.removeAllMessageAndCallBacks();
        myHandler.removeAllMessageAndCallBacks();
    }
}
