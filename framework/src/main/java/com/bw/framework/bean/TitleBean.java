package com.bw.framework.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class TitleBean {
      @Id(autoincrement = true)
      private Long id;
      private String title;
      private String url;
      boolean isShow;
      @Generated(hash = 1481087702)
      public TitleBean(Long id, String title, String url, boolean isShow) {
          this.id = id;
          this.title = title;
          this.url = url;
          this.isShow = isShow;
      }
      @Generated(hash = 970439350)
      public TitleBean() {
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
      public String getUrl() {
          return this.url;
      }
      public void setUrl(String url) {
          this.url = url;
      }
      public boolean getIsShow() {
          return this.isShow;
      }
      public void setIsShow(boolean isShow) {
          this.isShow = isShow;
      }

}
