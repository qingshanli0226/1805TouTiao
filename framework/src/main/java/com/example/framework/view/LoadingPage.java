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

import com.example.framework.R;

public abstract
class LoadingPage extends FrameLayout {
    private View errorView;
    private View loadingView;
    private View emptyView;
    private View successView;
    private TextView errorTv;
    private TextView emptyTv;
    private Context context;

    /**
     * 外界获取正常view的方法
     * @return
     */
    public View getSuccessView() {
        return successView;
    }

    public LoadingPage(@NonNull Context context) {
        super(context);
        init(context);
        this.context=context;
    }

    public LoadingPage(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
        this.context=context;
    }

    public LoadingPage(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
        this.context=context;
    }

    public void init(Context context){
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        errorView = LayoutInflater.from(context).inflate(R.layout.view_error, null);
        errorTv = errorView.findViewById(R.id.error_tv);
        addView(errorView,params);

        loadingView = LayoutInflater.from(context).inflate(R.layout.view_loading, null);
        loadingView.setBackgroundColor(Color.TRANSPARENT);
        addView(loadingView,params);

        emptyView = LayoutInflater.from(context).inflate(R.layout.view_empty, null);
        emptyTv = emptyView.findViewById(R.id.empty_tv);
        addView(emptyView,params);

        successView = LayoutInflater.from(context).inflate(getSuccessLayoutId(), null);
        addView(successView,params);

        showSuccessView();
    }

    protected abstract int getSuccessLayoutId();
    public void showLoadingpage(){
        emptyView.setVisibility(GONE);
        loadingView.setVisibility(VISIBLE);
        errorView.setVisibility(GONE);

        successView.setVisibility(GONE);
    }

    public void showErrorPage(String Errormsg){
        errorTv.setText(Errormsg);
        emptyView.setVisibility(GONE);
        loadingView.setVisibility(GONE);
        errorView.setVisibility(VISIBLE);
        successView.setVisibility(GONE);
    }

    public void showEmptyContentPage(){
        emptyTv.setText(R.string.no_more_content);
        emptyView.setVisibility(VISIBLE);
        loadingView.setVisibility(GONE);
        errorView.setVisibility(GONE);
        successView.setVisibility(GONE);
    }
    public void showEmptyCommentPage(){
        emptyTv.setText(R.string.no_more_comment);
        emptyView.setVisibility(VISIBLE);
        loadingView.setVisibility(GONE);
        errorView.setVisibility(GONE);
        successView.setVisibility(GONE);
    }
    //显示正确页面
    public void showSuccessView() {
        emptyView.setVisibility(GONE);
        loadingView.setVisibility(GONE);
        errorView.setVisibility(GONE);
        successView.setVisibility(VISIBLE);
    }


}
