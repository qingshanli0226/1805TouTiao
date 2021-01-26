package com.example.framework.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;

import com.example.framework.R;

/**
 * 自定义中包含很多控件，所以这里要使用自定义view组件来实现
 */
public class TranslateView extends RelativeLayout {
    private RelativeLayout rootView;
    private ImageView roundImg;
    private LinearLayout controlArea;
    private ImageView iv1;
    private ImageView iv2;
    private ImageView iv3;
    //以像素为单位，布局中的单位是dp
    private int width = 200;


    public TranslateView(Context context) {
        super(context);
    }

    public TranslateView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }


    public TranslateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    //初始化布局
    private void init(Context context) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        layoutInflater.inflate(R.layout.view_translate, this);
        rootView = findViewById(R.id.root_view);
        roundImg = findViewById(R.id.roundImg);
        controlArea = findViewById(R.id.controlArea);
        iv1 = findViewById(R.id.iv_1);
        iv2 = findViewById(R.id.iv_2);
        iv3 = findViewById(R.id.iv_3);
        roundImg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startChangeToLarge();
            }
        });
    }
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1: //慢慢的变长
                    //如果宽度大于700，则将控件显示出来，并且不再增加控件的长度
                    if (width>=700){
                        controlArea.setVisibility(VISIBLE);
                        return;
                    }
                    width = width+10;//把宽度增加10个长度
                    //重新执行onMeasure，重新设置宽度
                    //该方法会出发onMeasure
                    requestLayout();
                    //逐渐将宽度增加
                    handler.sendEmptyMessageDelayed(1,10);
                    break;
                case 2://恢复原来的模样
                    controlArea.setVisibility(GONE);
                    if (width == 200){
                        return;
                    }
                    width = width -10;//把宽度减少10个长度
                    //重新执行onMeasure，重新设置宽度
                    //该方法会出发onMeasure
                    requestLayout();
                    //逐渐将宽度减少
                    handler.sendEmptyMessageDelayed(2,10);
                    break;
            }
        }
    };
    private void startChangeToLarge() {
        //如果当前控件已经进行了拉伸，或者已经拉伸到最大的长度，没必要再次触发拉伸长度了
        if (handler.hasMessages(1) || width >= 700){
            return;
        }
        controlArea.setVisibility(GONE);
        //把之前的消息全部停止，做好接应拉伸的准备
        handler.removeCallbacksAndMessages(null);
        width = 200;
        requestLayout();
        handler.sendEmptyMessageDelayed(1,10);
    }
    public void resetWidh(MotionEvent event){
        //判断一下，当前手指是否在控件上面，如果在控件上，不执行收缩
        if (isTouchInVenten(event)){
            Log.e("ZLD_1.26","在控件上滑动不执行缩放");
            return;
        }
        //如果当前控件已经进行了拉伸，或者已经拉伸到最大的长度，没必要再做收缩操作
        if (handler.hasMessages(2) || width == 200){
            return;
        }
        //把之前的消息全部停止，做好接应拉伸的准备
        handler.removeCallbacksAndMessages(null);
        handler.sendEmptyMessageDelayed(2,10);
    }

    private boolean isTouchInVenten(MotionEvent event) {
        //获取触摸事件的坐标
        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();
        //获取控件坐标的范围
        int[] viewLoc = new int[2];
        getLocationOnScreen(viewLoc);
        //左侧坐标
        int left = viewLoc[0];
        //顶部坐标
        int top = viewLoc[1];
        //右侧图标
        int right = left + getMeasuredWidth();
        //底部图标
        int bottom = top + getMeasuredHeight();
        boolean isviewLoc = rawX >= left && rawX <= right && rawY >= top && rawY <= bottom;
        return isviewLoc;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //设置一个默认的高度，布局当中的宽度不起作用
        setMeasuredDimension(width,MeasureSpec.getSize(heightMeasureSpec));
    }
}
