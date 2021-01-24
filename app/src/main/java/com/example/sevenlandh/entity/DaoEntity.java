package com.example.sevenlandh.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DaoEntity {

    @Id(autoincrement = true)
    private Long id;
    private String title;
    @Generated(hash = 103538741)
    public DaoEntity(Long id, String title) {
        this.id = id;
        this.title = title;
    }
    @Generated(hash = 1100100161)
    public DaoEntity() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}

