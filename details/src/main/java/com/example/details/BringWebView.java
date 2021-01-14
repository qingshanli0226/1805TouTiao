package com.example.details;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BringWebView extends AppCompatActivity {


    private WebView bringwebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bring_web_view);


        initView();
    }

    private void initView() {
        bringwebview = (WebView) findViewById(R.id.bringwebview);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        bringwebview.loadUrl(url);
        bringwebview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String request) {
                view.loadUrl(request);
                return true;
            }
        });
        //声明WebSettings子类
        WebSettings webSettings = bringwebview.getSettings();

        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1
        ) {
            webSettings.setMediaPlaybackRequiresUserGesture(true);
        }

        //设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
    }
}