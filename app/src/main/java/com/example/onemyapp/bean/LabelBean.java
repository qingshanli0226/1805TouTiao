package com.example.onemyapp.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class LabelBean {
    @Id(autoincrement = true)
    Long id;
    String title;
    String title_id;
    @Generated(hash = 90957363)
    public LabelBean(Long id, String title, String title_id) {
        this.id = id;
        this.title = title;
        this.title_id = title_id;
    }
    @Generated(hash = 1285554626)
    public LabelBean() {
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
    public String getTitle_id() {
        return this.title_id;
    }
    public void setTitle_id(String title_id) {
        this.title_id = title_id;
    }

    @Override
    public String toString() {
        return "LabelBean{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", title_id='" + title_id + '\'' +
                '}';
    }
}
