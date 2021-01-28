package com.toutiao.bawei.a1805toutiao.customview;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.view.ViewGroup.LayoutParams;

//使用自定义布局。因为该布局里有很多控件，这些控件的所有事件都会经过该布局。如果在布局的UI上滑动手指，
// A：当滑动距离超过了一定的范围，我们就会拦截事件，之后，所有的事件都会被该布局的onTouchEvent方法获取到，布局里的控件将没有机会处理它的点击事件。
// B: 当手指滑动的距离没有超出范围，那么该布局将不会拦截事件，事件继续由该布局里的控件消费
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
                //当距离差超过10时，就认为是滑动而不是点击了
                if (Math.abs(ev.getRawX()-lastX) > 10 || (Math.abs(ev.getRawY() - lastY) > 10)) {
                    lastY = (int) ev.getRawY();
                    lastY = (int) ev.getRawY();
                    isIntercept = true;
                    return true;
                }
                break;
        }

        return super.onInterceptTouchEvent(ev);
    }

    //该方法被执行时，代表是布局已经拦截了事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (isIntercept && event.getAction() == MotionEvent.ACTION_MOVE) {
            if (iMoveListnener != null) {
                int newY = (int) event.getRawY();
                int newX = (int) event.getRawX();
                iMoveListnener.onMove(lastX, lastY, newX, newY);//通过回调函数将手指滑动的坐标改变通知给观察者,观察者可以通过该回调函数获取坐标的改变，调整该组件的位置
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
