package com.toutiao.bawei.a1805toutiao.customview;

import android.animation.ObjectAnimator;
import android.arch.lifecycle.GenericLifecycleObserver;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.toutiao.bawei.a1805toutiao.R;


//因为该自定义View里面包括很多控件，所有我们使用自定义View组件来实现。
public class TranslateView  extends FrameLayout {
    private Context context;
    private CustomRelativeLayout rootView;
    private LinearLayout controlView;
    private ImageView roundImg;
    private TranslateView instance;
    private int width = 200;//以像素为单位，布局里面的单位是dp
    public TranslateView(Context context) {
        super(context);
    }

    public TranslateView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
        instance = this;
    }

    public TranslateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private int dx;
    private int dy;


    private void init(Context context, AttributeSet attributeSet) {
        final LayoutInflater layoutInflater = LayoutInflater.from(context);
        //使用布局文件生成组件的布局，该组件布局中，默认只显示一张图片，其他的控件默认隐藏
        layoutInflater.inflate(R.layout.view_translate, this);
        rootView = findViewById(R.id.rootView);
        controlView = findViewById(R.id.controlArea);
        roundImg = findViewById(R.id.roundImg);
        findViewById(R.id.btn1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"点击了第一个按钮", Toast.LENGTH_SHORT).show();
            }
        });

        roundImg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startChangeToLarge();//点击时实现拉伸操作
            }
        });
        //给自定义的相对布局设置一个回调，监听手指滑动的坐标的改变。为什么可以监听到坐标的改变呢？因为你这个自定义布局是根布局，所有的事件分发，都是先分发到根布局
        rootView.registerMoveListener(new CustomRelativeLayout.IMoveListnener() {
            @Override
            public void onMove(int lastX, int lastY, int newX,int newY) {
                dx = newX - lastX;
                dy = newY - lastY;
                //改变组件的位置，相当于将组件的左侧，上侧，右侧，下侧根据这个滑动距离偏差都做出改变
                TranslateView.this.layout(TranslateView.this.getLeft()+dx,TranslateView.this.getTop()+dy,
                        TranslateView.this.getRight()+dx,TranslateView.this.getBottom()+dy);

                //将组件改变后的参数保存起来
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(TranslateView.this.width,TranslateView.this.getHeight());
                layoutParams.leftMargin = TranslateView.this.getLeft();
                layoutParams.topMargin = TranslateView.this.getTop();
                layoutParams.rightMargin = TranslateView.this.getRight();
                layoutParams.bottomMargin = TranslateView.this.getBottom();
                layoutParams.setMargins(TranslateView.this.getLeft(),TranslateView.this.getTop(),0,0);
                TranslateView.this.setLayoutParams(layoutParams);//通过该方法，存储到View里

            }
        });

        //通过lifeCycle来监听Activity的生命周期
        LifecycleOwner lifecycleOwner = (LifecycleOwner) context;
        lifecycleOwner.getLifecycle().addObserver(new GenericLifecycleObserver() {
            @Override
            public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                 if (event == Lifecycle.Event.ON_DESTROY) {//当页面销毁时，通过该回调可以接收到Lifecycle.Event.ON_DESTROY事件
                     Log.d("LQS", "==页面已经销毁，收到销毁事件");
                     handler.removeCallbacksAndMessages(null);//删除未处理的消息，避免内存泄漏问题
                 }
            }
        });

    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1://逐渐边长

                    if (width >= 700) {//如果宽度大于了700,则将控制控件显示出来，并且不再加宽该控件的宽度
                        controlView.setVisibility(VISIBLE);
                        return;
                    }

                    width = width + 10;//把宽度增大10个长度
                    //重新调用onMeasure方法，给控件设置新的宽度
                    requestLayout();//该方法会触发，onMeasure方法执行
                    handler.sendEmptyMessageDelayed(1, 10);//逐渐将宽度增加
                    break;
                case 2:
                    controlView.setVisibility(GONE);
                    if (width == 200) {
                        return;
                    }
                    width = width - 10;
                    requestLayout();
                    handler.sendEmptyMessageDelayed(2, 10);
                    break;
            }
        }
    };

    private void startChangeToLarge() {
        //当当前控件已经开始做拉伸了，或者说已经拉伸到最大的宽度，就没必要再次出发拉伸动作了
        if (handler.hasMessages(1) || width >= 700) {
            return;
        }
        controlView.setVisibility(GONE);
        handler.removeCallbacksAndMessages(null);//把之前的消息全部停止，全力做好控件的拉伸操作
        width = 200;
        requestLayout();
        handler.sendEmptyMessageDelayed(1, 10);

    }

    public void resetWidth(MotionEvent event) {
        //判断一下，当前手指触发的事件，它们的坐标是否在空间上，如果在控件上，不执行收缩操作。只让控件处理点击事件。
        if (isTouchInCurrentView(event)) {
            Log.d("LQS", "在控件上滑动，不需要执行收缩操作");
            return;
        }

        //如果handler已经开始做收缩操作，或者当前控件它的宽度已经是最小了，没必要再做收缩操作
        if (handler.hasMessages(2) || width == 200) {
            return;
        }
        handler.removeCallbacksAndMessages(null);//把之前的消息全部停止，全力做好控件的收缩操作
        handler.sendEmptyMessageDelayed(2, 10);//通过handler自定义收缩动画，完成收缩操作
    }

    private boolean isTouchInCurrentView(MotionEvent event) {
        //获取触摸事件的坐标
        int eventRawX = (int) event.getRawX();event.getX();
        int eventRawY = (int) event.getRawY();//事件的坐标
        //获取控件的坐标范围
        int[] viewLoc = new int[2];//存放控件的坐标值
        getLocationOnScreen(viewLoc);
        int left = viewLoc[0];//左侧坐标
        int top =  viewLoc[1];//顶部坐标
        int right = left + getMeasuredWidth();//右侧坐标
        int bottom = top + getMeasuredHeight();//底部坐标

        boolean isInView = eventRawX >= left && eventRawX <= right &&
                eventRawY >= top && eventRawY <= bottom;
        return isInView;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //设置一个默认的宽度,布局里的宽度不起作用,该宽度是一张图片的宽度
        setMeasuredDimension(width, MeasureSpec.getSize(heightMeasureSpec));

    }
}
