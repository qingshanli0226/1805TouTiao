package com.example.news;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class NewsDetailsActivity extends AppCompatActivity {

    private WebView newsWeb;
    private ProgressBar newsPro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        initView();

        Intent intent = getIntent();
        String newsPath = intent.getStringExtra("NewsPath");
        Log.i("wft", "onCreate: "+newsPath);

        newsWeb.loadUrl(newsPath);
        WebSettings settings = newsWeb.getSettings();
        settings.setJavaScriptCanOpenWindowsAutomatically(true);//设
        settings.setJavaScriptEnabled(true);
        newsWeb.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                newsPro.setVisibility(View.VISIBLE);

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                newsPro.setVisibility(View.GONE);

            }
        });

    }

    private void initView() {
        newsWeb = (WebView) findViewById(R.id.newsWeb);
        newsPro = (ProgressBar) findViewById(R.id.newsPro);
    }
}