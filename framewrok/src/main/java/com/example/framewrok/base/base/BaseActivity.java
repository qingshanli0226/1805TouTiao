package com.example.framewrok.base.base;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.framewrok.base.IPrine;
import com.example.framewrok.base.IView;

public abstract class BaseActivity <Prine extends IPrine,PView extends IView> extends AppCompatActivity {
     public Prine prine;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getlayoutId());
        intView();
        inPresone();
        inData();
        if (prine!=null){
            prine.attach((PView)this);
        }


    }
    protected abstract int getlayoutId();
    protected abstract void intView();
    protected abstract void inPresone();
    protected abstract void inData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ondestroy();
    }

    protected abstract void ondestroy();

}
