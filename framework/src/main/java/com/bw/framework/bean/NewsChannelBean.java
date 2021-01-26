package com.bw.framework.bean;

import androidx.annotation.NonNull;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by Meiji on 2017/3/10.
 */

@Entity
public class NewsChannelBean implements Comparable<NewsChannelBean>{

    @Id(autoincrement = true)
    Long id;
    
    private String channelId;
    private String channelName;
    private int isEnable;
    private int position;

    @Generated(hash = 254855441)
    public NewsChannelBean(Long id, String channelId, String channelName, int isEnable, int position) {
        this.id = id;
        this.channelId = channelId;
        this.channelName = channelName;
        this.isEnable = isEnable;
        this.position = position;
    }

    @Generated(hash = 654711517)
    public NewsChannelBean() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        NewsChannelBean bean = (NewsChannelBean) o;

        if (isEnable != bean.isEnable)
            return false;
        if (position != bean.position)
            return false;
        if (channelId != null ? !channelId.equals(bean.channelId) : bean.channelId != null)
            return false;
        return channelName != null ? channelName.equals(bean.channelName) : bean.channelName == null;

    }

    @Override
    public int hashCode() {
        int result = channelId != null ? channelId.hashCode() : 0;
        result = 31 * result + (channelName != null ? channelName.hashCode() : 0);
        result = 31 * result + isEnable;
        result = 31 * result + position;
        return result;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public int getIsEnable() {
        return this.isEnable;
    }

    public void setIsEnable(int isEnable) {
        this.isEnable = isEnable;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public int compareTo(@NonNull NewsChannelBean o) {
        return this.position - o.getPosition();
    }

}
