package com.example.webpage;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.framewrok.base.base.BaseActivity;
@Route(path = "/path/WebViewActivity")
public class WebViewActivity extends BaseActivity {
    private WebView web;
    private ImageView message;









    @Override
    protected int getlayoutId() {
        return R.layout.web;
    }

    @Override
    protected void intView() {
        web = (WebView) findViewById(R.id.web);
        message = (ImageView) findViewById(R.id.message);

    }

    @Override
    protected void inPresone() {

    }

    @Override
    protected void inData() {
        final Intent intent=getIntent();
        String url = intent.getStringExtra("url");
        final String id = intent.getStringExtra("id");
        Log.e("ids",id);
        WebSettings settings = web.getSettings();
        settings.setUseWideViewPort(false);
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setJavaScriptEnabled(true);
        web.setWebChromeClient(new WebChromeClient());
        web.setWebViewClient(new WebViewClient());
        web.loadUrl(url);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(WebViewActivity.this,MessageActivity.class);
                intent1.putExtra("id",id);
                startActivity(intent1);

            }
        });
    }

    @Override
    protected void ondestroy() {

    }
}
