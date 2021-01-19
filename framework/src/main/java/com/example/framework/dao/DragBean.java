package com.example.framework.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DragBean {
    @Id(autoincrement = true)
    Long uid;
    String uname;
    String titleid;
    boolean isDisplay;
    @Generated(hash = 1823211727)
    public DragBean(Long uid, String uname, String titleid, boolean isDisplay) {
        this.uid = uid;
        this.uname = uname;
        this.titleid = titleid;
        this.isDisplay = isDisplay;
    }
    @Generated(hash = 2071352715)
    public DragBean() {
    }
    public Long getUid() {
        return this.uid;
    }
    public void setUid(Long uid) {
        this.uid = uid;
    }
    public String getUname() {
        return this.uname;
    }
    public void setUname(String uname) {
        this.uname = uname;
    }
    public String getTitleid() {
        return this.titleid;
    }
    public void setTitleid(String titleid) {
        this.titleid = titleid;
    }
    public boolean getIsDisplay() {
        return this.isDisplay;
    }
    public void setIsDisplay(boolean isDisplay) {
        this.isDisplay = isDisplay;
    }
}
