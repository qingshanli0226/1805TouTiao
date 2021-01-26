package com.toutiao.bawei.a1805toutiao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.toutiao.bawei.a1805toutiao.anr.AnrActivity;
import com.toutiao.bawei.a1805toutiao.customview.TranlateActivity;
import com.toutiao.bawei.a1805toutiao.handler.HandlerActivity;
import com.toutiao.bawei.a1805toutiao.lazy.LazyActivity;
import com.toutiao.bawei.a1805toutiao.mvvm.DBActivity;
import com.toutiao.bawei.a1805toutiao.mvvm.MVVMActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnThread).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ThreadActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btnMVVM).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MVVMActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btnHandler).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,HandlerActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btnLazy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LazyActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btnAnr).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AnrActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btnTranslate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TranlateActivity.class);
                startActivity(intent);
            }
        });

    }
}
