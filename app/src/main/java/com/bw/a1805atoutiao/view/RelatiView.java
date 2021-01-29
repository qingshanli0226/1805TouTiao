package com.bw.a1805atoutiao.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bw.a1805atoutiao.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class RelatiView extends RelativeLayout {
    private Context context;
    private LinearLayout linearLayout;
    private int initWidth=50;
    private int initHeight=50;
    private int width=50;
    private int height=50;
    private int totalLength=200;//最终长度
    private Handler handler=new Handler();
    private int leftMarin=15;
    private int topMarin=800;
    private Button button1;
    private Button button2;
    private Button button3;
    private boolean first;
    private boolean open=false;
    private RelativeLayout.LayoutParams layoutParams;
    private List<Button> buttonList;
    private Timer timerOpen;
    private Timer timerFinish;
    private boolean isIntercept=false;
    public RelatiView(Context context) {
        super(context);
    }

    public RelatiView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
    }


    public RelatiView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        linearLayout = (LinearLayout) getChildAt(1);
        setLinearLayoutLength(initWidth,leftMarin,topMarin);
        initView(linearLayout);
        initEvent();

    }

    private void initView(LinearLayout linearLayout) {
            buttonList=new ArrayList<>();
            button1= linearLayout.findViewById(R.id.button1);
            button2= linearLayout.findViewById(R.id.button2);
            button3= linearLayout.findViewById(R.id.button3);
            buttonList.add(button1);
            buttonList.add(button2);
            buttonList.add(button3);
    }

    private void initEvent() {
        linearLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "linear", Toast.LENGTH_SHORT).show();
                riseWidth();
            }
        });
    }


    private void riseWidth(){
        if (!open){
            open=true;
            if (timerFinish!=null){
                timerFinish.cancel();
            }
            int visibility = buttonList.get(0).getVisibility();
            if (visibility==View.VISIBLE){
                Log.e("show","显示");
            }
            timerOpen = new Timer();
            timerOpen.schedule(new TimerTask() {
                @Override
                public void run() {
                    width=width+3;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            setLinearLayoutLength(width,leftMarin,topMarin);
                            if (width>=totalLength){
                                for (Button button : buttonList) {
                                    button.setVisibility(VISIBLE);
                                }
                                timerOpen.cancel();
                            }
                        }
                    });
                }
            },0,10);
        }

    }

    public void lessenWidth(){
        if (open){
            open=false;
            if (timerOpen!=null){
                timerOpen.cancel();
            }

            timerFinish = new Timer();
            timerFinish.schedule(new TimerTask() {
                @Override
                public void run() {

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            if (first){
                                for (Button button : buttonList) {
                                    button.setVisibility(GONE);
                                }
                                first=false;
                            }

                            width=width-3;
                            setLinearLayoutLength(width,leftMarin,topMarin);
                            if (width<=initWidth){
                                first=true;
                                timerFinish.cancel();
                            }
                        }
                    });

                }
            },0,10);
        }

    }





    private void setLinearLayoutLength(int width,int left,int top){

                layoutParams = new RelativeLayout.LayoutParams(width, initHeight);
                layoutParams.setMargins(left,top,0,0);
                linearLayout.setLayoutParams(layoutParams);

    }

    public void setLinearLayoutMargin(int top,int left){
        handler.post(new Runnable() {
            @Override
            public void run() {
                layoutParams.setMargins(left,top,0,0);
                linearLayout.setLayoutParams(layoutParams);
            }
        });

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("hua", "down" + event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("hua", "move" + event.getY());
                lessenWidth();
                break;
            case MotionEvent.ACTION_UP:
                Log.e("hua", "up" + event.getY());
                break;
        }

        return true;
    }


}
