package com.example.webpage;

import android.content.Intent;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.framewrok.base.base.BaseActivity;
@Route(path = "/path/WebViewActivity")
public class WebViewActivity extends BaseActivity {
    private WebView web;



    @Override
    protected int getlayoutId() {
        return R.layout.web;
    }

    @Override
    protected void intView() {
        web = (WebView) findViewById(R.id.web);
    }

    @Override
    protected void inPresone() {

    }

    @Override
    protected void inData() {
        Intent intent=getIntent();
        String url = intent.getStringExtra("url");
        Log.e("urls",url);
        WebSettings settings = web.getSettings();
        settings.setUseWideViewPort(false);
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setJavaScriptEnabled(true);
        web.setWebChromeClient(new WebChromeClient());
        web.setWebViewClient(new WebViewClient());
        web.loadUrl(url);
    }

    @Override
    protected void ondestroy() {

    }
}
