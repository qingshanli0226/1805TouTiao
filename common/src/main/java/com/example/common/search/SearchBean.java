package com.example.common.search;

import java.util.List;

public class SearchBean {

    /**
     * data : {"ab_fields":null,"hot_words":[],"suggest_word_list":[{"type":"recom","word":"北京多地低温创纪录"},{"type":"recom","word":"男星郭汉柱谈体重"},{"type":"recom","word":"资深东部高管谈哈登"},{"type":"recom","word":"冀51例本土确诊轨迹"},{"type":"recom","word":"地平线完成C2轮融资"},{"type":"recom","word":"广厦男篮钱德勒离队"}]}
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
         * suggest_word_list : [{"type":"recom","word":"北京多地低温创纪录"},{"type":"recom","word":"男星郭汉柱谈体重"},{"type":"recom","word":"资深东部高管谈哈登"},{"type":"recom","word":"冀51例本土确诊轨迹"},{"type":"recom","word":"地平线完成C2轮融资"},{"type":"recom","word":"广厦男篮钱德勒离队"}]
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
             * word : 北京多地低温创纪录
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

