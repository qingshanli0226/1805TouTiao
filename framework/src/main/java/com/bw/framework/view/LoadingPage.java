package com.bw.framework.view;

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

import com.bw.framework.R;

public abstract class LoadingPage extends FrameLayout {
    private View loadingView;
    private View errorView;
    private View emptyView;
    private View successView;
    private TextView errorTv;

    public LoadingPage(@NonNull Context context) {
        super(context);
        init(context);
    }

    public LoadingPage(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LoadingPage(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(Context context) {
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        errorView = layoutInflater.inflate(R.layout.view_error, null);
        addView(errorView,layoutParams);
        errorTv = errorView.findViewById(R.id.errorTv);
        emptyView = layoutInflater.inflate(R.layout.view_empty,null);
        addView(emptyView,layoutParams);

        successView = layoutInflater.inflate(getSuccessLayoutId(),null);
        addView(successView,layoutParams);//添加正确页面
        loadingView = layoutInflater.inflate(R.layout.view_loading,null);
        loadingView.setBackgroundColor(Color.TRANSPARENT);
        addView(loadingView,layoutParams);

        //默认显示页面
        showSuccessView();
    }

    protected abstract int getSuccessLayoutId();

    public void showLoadingPage(){
        errorView.setVisibility(GONE);
        loadingView.setVisibility(VISIBLE);
        successView.setVisibility(VISIBLE);
        emptyView.setVisibility(GONE);
    }

    public void showErrorPage(String errorMsg){
        errorTv.setText(errorMsg);
        errorView.setVisibility(VISIBLE);
        loadingView.setVisibility(GONE);
        successView.setVisibility(GONE);
        emptyView.setVisibility(GONE);
    }

    public void showEmptyPage(){
        errorView.setVisibility(GONE);
        loadingView.setVisibility(GONE);
        successView.setVisibility(GONE);
        emptyView.setVisibility(VISIBLE);
    }

    private void showSuccessView() {
        errorView.setVisibility(GONE);
        loadingView.setVisibility(GONE);
        successView.setVisibility(VISIBLE);
        emptyView.setVisibility(GONE);
    }
}
