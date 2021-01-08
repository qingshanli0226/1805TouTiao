package com.bw.net.bean;

import java.util.List;

public class SearchRecommentBean {


    /**
     * data : {"ab_fields":null,"hot_words":[],"suggest_word_list":[{"type":"recom","word":"一位资深高管谈哈登"},{"type":"recom","word":"石家庄增50本土确诊"},{"type":"recom","word":"曝三星或为苹果供货"},{"type":"recom","word":"比利奇执教北京国安"},{"type":"recom","word":"鲍尔遭NBA联盟警告"},{"type":"recom","word":"曝吴曦已续约苏宁队"}]}
     * message : success
     */

    private DataBean data;
    private String message;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * ab_fields : null
         * hot_words : []
         * suggest_word_list : [{"type":"recom","word":"一位资深高管谈哈登"},{"type":"recom","word":"石家庄增50本土确诊"},{"type":"recom","word":"曝三星或为苹果供货"},{"type":"recom","word":"比利奇执教北京国安"},{"type":"recom","word":"鲍尔遭NBA联盟警告"},{"type":"recom","word":"曝吴曦已续约苏宁队"}]
         */

        private Object ab_fields;
        private List<?> hot_words;
        private List<SuggestWordListBean> suggest_word_list;

        public Object getAb_fields() {
            return ab_fields;
        }

        public void setAb_fields(Object ab_fields) {
            this.ab_fields = ab_fields;
        }

        public List<?> getHot_words() {
            return hot_words;
        }

        public void setHot_words(List<?> hot_words) {
            this.hot_words = hot_words;
        }

        public List<SuggestWordListBean> getSuggest_word_list() {
            return suggest_word_list;
        }

        public void setSuggest_word_list(List<SuggestWordListBean> suggest_word_list) {
            this.suggest_word_list = suggest_word_list;
        }

        public static class SuggestWordListBean {
            /**
             * type : recom
             * word : 一位资深高管谈哈登
             */

            private String type;
            private String word;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getWord() {
                return word;
            }

            public void setWord(String word) {
                this.word = word;
            }
        }
    }
}
