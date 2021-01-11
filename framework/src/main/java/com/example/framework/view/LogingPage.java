package com.example.framework.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;

import com.example.framework.R;



//在积累中定义加载页面，错误页面，空白页面
public abstract class LogingPage extends FrameLayout {
    private View loadinggView;
    private View erroyView;
    private TextView erroyTv;
    private View emptyView;
    private View sucessView;
    public LogingPage(@NonNull Context context) {
        super(context);
        init(context);
    }
    public LogingPage(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LogingPage(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public View getSucessView(){
        return sucessView;
    }
    private void init(Context context) {
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        erroyView = layoutInflater.inflate(R.layout.view_error, null);
        addView(erroyView,layoutParams);
        erroyTv = erroyView.findViewById(R.id.errorTv);

        emptyView = layoutInflater.inflate(R.layout.view_empty,null);
        addView(emptyView,layoutParams);

        sucessView = layoutInflater.inflate(getlayoutid(),null);
        addView(sucessView,layoutParams);//将正确的布局界面添加到布局当中

        loadinggView = layoutInflater.inflate(R.layout.view_loading,null);
        loadinggView.setBackgroundColor(Color.TRANSPARENT);//背景透明
        addView(loadinggView,layoutParams);//添加到framelayout

        //默认显示sucessView页面
        showsucessPage();
    }
    //显示真确的页面
    public void showsucessPage(){
        erroyView.setVisibility(GONE);
        sucessView.setVisibility(VISIBLE);
        loadinggView.setVisibility(GONE);
        emptyView.setVisibility(GONE);
    }
    //显示loading页面
    public void loadingPage(){
        erroyView.setVisibility(GONE);
        sucessView.setVisibility(VISIBLE);
        loadinggView.setVisibility(VISIBLE);
        emptyView.setVisibility(GONE);
    }
    //显示错误页面
    public void showError(String errorshow){
        erroyTv.setText(errorshow);
        erroyView.setVisibility(VISIBLE);
        sucessView.setVisibility(GONE);
        loadinggView.setVisibility(GONE);
        emptyView.setVisibility(GONE);
    }
    //显示空白界面
    public void showEnptyPage(){
        erroyView.setVisibility(GONE);
        sucessView.setVisibility(GONE);
        loadinggView.setVisibility(GONE);
        emptyView.setVisibility(VISIBLE);
    }
    protected abstract int getlayoutid();

}
