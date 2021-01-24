package com.example.video;

public class VideoBean {
    String name;
    String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VideoBean(String name, String id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "VideoBean{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
