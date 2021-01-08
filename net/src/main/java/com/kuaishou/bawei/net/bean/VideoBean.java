package com.kuaishou.bawei.net.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

//是通过Parceable将一个对象序列化后，通过intent进行传递
public class VideoBean implements Parcelable {

    /**
     * vedioUrl : /video/bw2.mp4
     * vedioId : 8
     * userId : 10018
     * coverImg : http://img.pconline.com.cn/images/upload/upc/tx/photoblog/1109/24/c6/9067095_9067095_1316861219359.jpg
     */

    private String vedioUrl;
    private int vedioId;
    private int userId;
    private String coverImg;

    public String getVedioUrl() {
        return vedioUrl;
    }

    public void setVedioUrl(String vedioUrl) {
        this.vedioUrl = vedioUrl;
    }

    public int getVedioId() {
        return vedioId;
    }

    public void setVedioId(int vedioId) {
        this.vedioId = vedioId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    @Override
    public int describeContents() {
        return 0;//写个0即可
    }

    //进行序列化
    @Override
    public void writeToParcel(Parcel dest, int flags) {
         dest.writeString(vedioUrl);
         dest.writeInt(vedioId);
         dest.writeInt(userId);
         dest.writeString(coverImg);
    }

    public static final Creator<VideoBean> CREATOR = new Creator<VideoBean>() {
        @Override
        public VideoBean createFromParcel(Parcel source) {
            VideoBean videoBean = new VideoBean();
            videoBean.setVedioUrl(source.readString());
            videoBean.setVedioId(source.readInt());
            videoBean.setUserId(source.readInt());
            videoBean.setCoverImg(source.readString());
            return videoBean;
        }

        @Override
        public VideoBean[] newArray(int size) {
            return new VideoBean[size];
        }
    };
}
