package com.example.sevenlandh.entity;

import com.flyco.tablayout.listener.CustomTabEntity;

public class HomeTabDownEntity implements CustomTabEntity {

    private String title;
    private int icon;
    private int un_Icon;

    public HomeTabDownEntity(String title, int icon, int un_Icon) {
        this.title = title;
        this.icon = icon;
        this.un_Icon = un_Icon;
    }

    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return icon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return un_Icon;
    }
}
