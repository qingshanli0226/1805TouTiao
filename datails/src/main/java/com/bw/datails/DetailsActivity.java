package com.bw.datails;

import android.content.Intent;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.widget.Toolbar;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bw.framework.base.BaseActivity;
@Route(path = "/Details/DetailsActivity")
public class DetailsActivity extends BaseActivity {
    private WebView detailsWeb;
    private Toolbar detailsToolbar;
    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        Log.e("1111",""+url);
        detailsWeb.loadUrl(url);

        detailsWeb.setWebViewClient(new WebViewClient(){

        });

        detailsWeb.setWebChromeClient(new WebChromeClient(){

        });
        WebSettings settings = detailsWeb.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);

        detailsToolbar.setNavigationIcon(R.drawable.ic_back_write_24dp);
        detailsToolbar.inflateMenu(R.menu.title_menu);
    }

    @Override
    protected void initView() {


        detailsWeb = findViewById(R.id.details_web);

        detailsToolbar = findViewById(R.id.details_toolbar);


    }

    @Override
    protected void createPresenter() {

    }

    @Override
    protected int getlayoutid() {
        return R.layout.activity_details;
    }

}
