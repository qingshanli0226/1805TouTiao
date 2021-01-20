package com.example.framework.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public
class TouTiaoMessageGreenBean {
    @Id(autoincrement = true)
    Long id;

    String tilte;

    boolean isShow;

    String tag;

    @Generated(hash = 864166931)
    public TouTiaoMessageGreenBean(Long id, String tilte, boolean isShow,
            String tag) {
        this.id = id;
        this.tilte = tilte;
        this.isShow = isShow;
        this.tag = tag;
    }

    @Generated(hash = 1519048916)
    public TouTiaoMessageGreenBean() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTilte() {
        return this.tilte;
    }

    public void setTilte(String tilte) {
        this.tilte = tilte;
    }

    public boolean getIsShow() {
        return this.isShow;
    }

    public void setIsShow(boolean isShow) {
        this.isShow = isShow;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
   


}
