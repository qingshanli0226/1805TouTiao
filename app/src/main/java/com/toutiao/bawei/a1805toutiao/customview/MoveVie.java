package com.toutiao.bawei.a1805toutiao.customview;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.toutiao.bawei.a1805toutiao.R;

public class MoveVie extends RelativeLayout {
    private Context context;
    private LinearLayout moveArea;
    private IMoveListnener iMoveListnener;
    public void registerMoveListener(IMoveListnener iMoveListnener) {
        this.iMoveListnener = iMoveListnener;
    }
    public MoveVie(Context context) {
        super(context);
    }

    public MoveVie(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    private void init() {
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.view_move, this);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
         super.onInterceptTouchEvent(ev);
         return true;
    }

    int lastx,lasty;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastx = (int) event.getRawX();
                lasty = (int) event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                int dx = (int) (event.getRawX() - lastx);
                int dy = (int) (event.getRawY() - lasty);
                Log.d("LQS", "dx " + dx + " dy " + dy);

                if (iMoveListnener!=null) {
                    iMoveListnener.onMove(dx,dy);
                }


                lastx = (int) event.getRawX();
                lasty = (int) event.getRawY();
                break;
        }
        return true;
    }

    public MoveVie(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public interface IMoveListnener {
        void onMove(int dx, int dy);
    }



}
