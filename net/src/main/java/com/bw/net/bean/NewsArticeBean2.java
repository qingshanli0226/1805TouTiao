package com.bw.net.bean;

import java.util.List;

public class NewsArticeBean2 {


        private String anAbstract;
        private String article_url;
        private String avatar_url;
        private String name;
        private String title;
        private String url;

    public NewsArticeBean2(String anAbstract, String article_url, String avatar_url, String name, String title, String url) {
        this.anAbstract = anAbstract;
        this.article_url = article_url;
        this.avatar_url = avatar_url;
        this.name = name;
        this.title = title;
        this.url = url;
    }

    public String getAnAbstract() {
            return anAbstract;
        }

        public void setAnAbstract(String anAbstract) {
            this.anAbstract = anAbstract;
        }

        public String getArticle_url() {
            return article_url;
        }

        public void setArticle_url(String article_url) {
            this.article_url = article_url;
        }

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }


}
