package com.toutiao.bawei.a1805toutiao.customview;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.view.ViewGroup.LayoutParams;

public class CustomRelativeLayout extends RelativeLayout {
    private int lastX, lastY;
    private boolean isIntercept = false;
    private int dX;
    private int dY;

    private IMoveListnener iMoveListnener;

    public void registerMoveListener(IMoveListnener iMoveListnener) {
        this.iMoveListnener = iMoveListnener;
    }
    public CustomRelativeLayout(Context context) {
        super(context);
    }

    public CustomRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    //继承系统布局，重新写拦截方法，当我们手指在这个控件上滑动的距离大于10，我们就拦截事件，让组件跟随手指滑动，否则的话，就不拦截，让组件里面的控件响应点击事件
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                isIntercept = false;
                lastX = (int) ev.getRawX();
                lastY = (int) ev.getRawY();

                break;
            case MotionEvent.ACTION_MOVE:
                if (Math.abs(ev.getRawX()-lastX) > 10 || (Math.abs(ev.getRawY() - lastY) > 10)) {
                    lastY = (int) ev.getRawY();
                    isIntercept = true;
                    return true;
                }
                break;
        }

        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (isIntercept && event.getAction() == MotionEvent.ACTION_MOVE) {
            if (iMoveListnener != null) {
                int newY = (int) event.getRawY();
                int newX = (int) event.getRawX();
                iMoveListnener.onMove(lastX, lastY, newX, newY);
                lastX = newX;
                lastY = newY;
            }
            return true;
        }
        return false;
    }

    public interface IMoveListnener {
        void onMove(int lastX, int lastY, int newX,int newY);
    }
}
