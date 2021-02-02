package com.example.webpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.framewrok.base.base.BaseActivity;

public class MessageActivity extends BaseActivity {
    private RecyclerView messageRecyle;




    @Override
    protected int getlayoutId() {
        return R.layout.activity_message;
    }

    @Override
    protected void intView() {
        messageRecyle = (RecyclerView) findViewById(R.id.message_recyle);
    }

    @Override
    protected void inPresone() {

    }

    @Override
    protected void inData() {
        Intent intent=getIntent();
        String id = intent.getStringExtra("id");
        MessageManager.getInstance().message(id);

    }

    @Override
    protected void ondestroy() {

    }
}
