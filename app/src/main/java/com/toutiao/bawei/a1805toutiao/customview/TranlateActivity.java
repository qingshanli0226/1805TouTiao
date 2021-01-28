package com.toutiao.bawei.a1805toutiao.customview;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

import com.toutiao.bawei.a1805toutiao.R;

//AppcompatActivity里面实现了接口getLifeCyle,通过该方法可以注册一个回调监听页面的生命周期
public class TranlateActivity extends AppCompatActivity {
    private TranslateView translateView;
    private int lastY;
    private int i = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);
        translateView = findViewById(R.id.tranlateView);
    }

    //该页面的所有滑动事件，都会经过该函数。该函数可以获取到页面所有滑动事件
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastY = (int) ev.getRawY();
                break;

            case MotionEvent.ACTION_MOVE:
                if (ev.getRawY() < lastY) {//代表你的手指是向上滑动，立刻去告诉自定义View有必要时可以去执行收缩操作,如果该组件处于拉伸状态，就执行收缩
                   translateView.resetWidth(ev);
                }
        }


        return super.dispatchTouchEvent(ev);
    }
}
