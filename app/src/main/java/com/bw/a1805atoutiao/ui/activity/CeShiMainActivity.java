package com.bw.a1805atoutiao.ui.activity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bw.a1805atoutiao.R;
import com.bw.a1805atoutiao.view.RelatiView;

import java.util.ArrayList;
import java.util.List;

public class CeShiMainActivity extends AppCompatActivity {

    private ListView listItem;
    private List<String> list = new ArrayList<>();
    private ArrayAdapter<String> arrayAdapter;
    private Toolbar bar;
    private ImageView image1;
    private RelatiView relative;
    private WebView weble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ce_shi_main);
        initView();
         weble.loadUrl("https://www.baidu.com/");
        weble.setWebChromeClient(new WebChromeClient());
        weble.setWebViewClient(new WebViewClient());
//        for (int i = 0; i < 30; i++) {
//            list.add("协调者布局" + i);
//        }
//
//        arrayAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, list);
//        listItem.setAdapter(arrayAdapter);
//        setSupportActionBar(bar);

        Glide.with(this)
                .load(R.mipmap.ic_launcher_round)
                .transform(new CircleCrop())
                .into(image1);


    }

    private void initView() {
//        listItem = findViewById(R.id.list_item);
//        bar = findViewById(R.id.bar);
        image1 = findViewById(R.id.image1);
        relative = findViewById(R.id.relative);
        weble = findViewById(R.id.weble);
    }




}