package com.bw.bean;

import com.flyco.tablayout.listener.CustomTabEntity;

public class CusTab implements CustomTabEntity {
    private String title;
    private int image1;
    private int image2;

    public CusTab(String title, int image1, int image2) {
        this.title = title;
        this.image1 = image1;
        this.image2 = image2;
    }

    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return image2;
    }

    @Override
    public int getTabUnselectedIcon() {
        return image1;
    }
}
