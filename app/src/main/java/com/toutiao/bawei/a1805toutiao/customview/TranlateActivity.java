package com.toutiao.bawei.a1805toutiao.customview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

import com.toutiao.bawei.a1805toutiao.R;

public class TranlateActivity extends AppCompatActivity {
    private TranslateView translateView;
    private int lastY;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);
        translateView = findViewById(R.id.tranlateView);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastY = (int) ev.getRawY();
                break;

            case MotionEvent.ACTION_MOVE:
                if (ev.getRawY() < lastY) {//代表你的手指是向上滑动
                    translateView.resetWidth(ev);
                }
        }


        return super.dispatchTouchEvent(ev);
    }
}
