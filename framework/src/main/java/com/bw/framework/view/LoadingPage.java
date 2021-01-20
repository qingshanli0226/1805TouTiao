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
    private View erroyView;
    private TextView erroyTv;
    private View emptyView;
    private View sucessView;

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

    public View getSucessView() {
        return sucessView;
    }

    private void init(Context context) {

        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        erroyView = layoutInflater.inflate(R.layout.view_error, null);
        addView(erroyView,layoutParams);
        erroyTv = erroyView.findViewById(R.id.errorTv);

        emptyView = layoutInflater.inflate(R.layout.view_empty, null);
        addView(emptyView,layoutParams);
        erroyTv = emptyView.findViewById(R.id.errorTv);

        sucessView = layoutInflater.inflate(getsuccessId(),null);
        addView(sucessView,layoutParams);

        loadingView = layoutInflater.inflate(R.layout.view_loading, null);
        loadingView.setBackgroundColor(Color.RED);
        addView(loadingView,layoutParams);

        showsuccessPage();


    }

    //显示loading页面
    public void loadingPage(){
        erroyView.setVisibility(GONE);
        sucessView.setVisibility(VISIBLE);
        loadingView.setVisibility(VISIBLE);
        emptyView.setVisibility(GONE);
    }
    //显示错误页面
    public void showError(String errorshow){
        erroyTv.setText(errorshow);
        erroyView.setVisibility(VISIBLE);
        sucessView.setVisibility(GONE);
        loadingView.setVisibility(GONE);
        emptyView.setVisibility(GONE);
    }


    //显示空白界面
    public void showEnptyPage(){
        erroyView.setVisibility(GONE);
        sucessView.setVisibility(GONE);
        loadingView.setVisibility(GONE);
        emptyView.setVisibility(VISIBLE);
    }

    //显示正确页面
    public void showsuccessPage(){
        erroyView.setVisibility(GONE);
        sucessView.setVisibility(VISIBLE);
        loadingView.setVisibility(GONE);
        emptyView.setVisibility(GONE);
    }

    protected abstract int getsuccessId();
}
