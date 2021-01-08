package com.example.framework.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class TouTiaoViewPager extends ViewPager {
    private boolean canScroll=true;

    public void setCanScroll(boolean canScroll) {
        this.canScroll = canScroll;
    }

    public TouTiaoViewPager(@NonNull Context context) {
        super(context);
    }

    public TouTiaoViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return canScroll&&super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return canScroll&&super.onInterceptTouchEvent(ev);
    }
}
