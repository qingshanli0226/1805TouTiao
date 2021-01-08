package com.toutiao.bawei.a1805toutiao.mvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.toutiao.bawei.a1805toutiao.R;
import com.toutiao.bawei.a1805toutiao.databinding.ActivityDbBinding;


public class DBActivity extends AppCompatActivity {
    private ActivityDbBinding activityDbBinding;
    private int ageValue = 10;
    private Student student;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityDbBinding = DataBindingUtil.setContentView(this,R.layout.activity_db);

        student = new Student();
        student.setName("1805");
        student.setAddress("tianjin");
        student.setAge(ageValue);
        student.setClassRoom("1805");
        student.setId("020");
        student.setSex("nan");
        student.setAvatar("http://49.233.0.68:8080/atguigu/img/1474370572805.jpg");
        activityDbBinding.setStudent(student);
        activityDbBinding.setDbActivity(this);
    }

    public void onAddClick(int step) {
        ageValue = ageValue+step;
        student.setAge(ageValue);
    }
}
