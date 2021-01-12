package com.toutiao.bawei.a1805toutiao.mvvm;

import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.toutiao.bawei.a1805toutiao.glide.NewsGlide;

public class Student {

    private String name;
    private String sex;
    private String classRoom;
    private ObservableField<Integer> age = new ObservableField<>();
    private String address;
    private String id;
    private String avatar;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public ObservableField<Integer> getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @BindingAdapter("imageUrl")
    public static void setSrc(ImageView imageView,String url) {
        //Glide.with(imageView.getContext()).load(url).into(imageView);
        NewsGlide.with(imageView.getContext()).load(url).into(imageView);
    }
}
