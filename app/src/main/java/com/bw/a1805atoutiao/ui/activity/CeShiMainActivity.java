package com.bw.a1805atoutiao.ui.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bw.a1805atoutiao.R;

import java.util.ArrayList;
import java.util.List;

public class CeShiMainActivity extends AppCompatActivity {

    private ListView listItem;
    private List<String> list = new ArrayList<>();
    private ArrayAdapter<String> arrayAdapter;
    private Toolbar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ce_shi_main);
        initView();

        for (int i = 0; i < 30; i++) {
            list.add("协调者布局" + i);
        }
        arrayAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, list);
        listItem.setAdapter(arrayAdapter);
        setSupportActionBar(bar);
    }

    private void initView() {
        listItem = findViewById(R.id.list_item);
        bar = findViewById(R.id.bar);
    }
}