package com.toutiao.bawei.a1805toutiao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		for(int i=0;i<10;i++){}
        Log.i("Yoyo", "onCreate: five");

        Log.d("LQS", " 添加log");

        Log.d("ZLD","重中之重");

        Log.d("zzz","重拳出击");

        Log.d("wk","aadas");

        Log.e("###","六组打印");

        Log.i("", "onCreate: "+"王富塘666");

    }
}
