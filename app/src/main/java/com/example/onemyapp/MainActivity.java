package com.example.onemyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.example.framewrok.base.base.BaseActivity;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class MainActivity extends BaseActivity {
    @Override
    protected int getlayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void intView() {

    }

    @Override
    protected void inPresone() {

    }

    @Override
    protected void inData() {
        SlidingMenu slidingMenu=new SlidingMenu(MainActivity.this);
        View inflate = LayoutInflater.from(MainActivity.this).inflate(R.layout.slidemenu, null);
        slidingMenu.setBehindWidth(400);
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setMenu(inflate);
        slidingMenu.attachToActivity(MainActivity.this,SlidingMenu.SLIDING_CONTENT);
    }

    @Override
    protected void ondestroy() {

    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        Log.e("==========","============");
//        Log.e("==========","============");
//        Log.e("==========","============");
//        Log.e("==========","============");
//        Log.e("==========","============");
//        Log.e("==========","============");
//
//        Log.i("---","111");
//
//    }
}
