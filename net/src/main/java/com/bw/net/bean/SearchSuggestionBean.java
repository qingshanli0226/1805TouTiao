package com.bw.net.bean;

import java.util.List;

public class SearchSuggestionBean {


    /**
     * data : [{"info":{"wordid":"6823570056195085582"},"keyword":"2021年春节假期最新通知"},{"info":{"wordid":"6585150165970081028"},"keyword":"2021年"},{"info":{"wordid":"6882693966878479620"},"keyword":"2021春节疫情还会封城吗"},{"info":{"wordid":"6546656133698819341"},"keyword":"2021"},{"info":{"wordid":"6800719545792222475"},"keyword":"2021放假时间安排"},{"info":{"wordid":"6662753054346974472"},"keyword":"2020粮补每亩多少钱"},{"info":{"wordid":"6800700932238611725"},"keyword":"2020养老金上涨方案"},{"info":{"wordid":"6542263715423589646"},"keyword":"2020"},{"info":{"wordid":"6752855559327733003"},"keyword":"2021退休金调整"},{"info":{"wordid":"6743209258348713227"},"keyword":"2021拆迁村子名单"}]
     * info : {"impr_id":"202101071326450102040482080B046EFF"}
     * message : success
     */

    private InfoBean info;
    private String message;
    private List<DataBean> data;

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class InfoBean {
        /**
         * impr_id : 202101071326450102040482080B046EFF
         */

        private String impr_id;

        public String getImpr_id() {
            return impr_id;
        }

        public void setImpr_id(String impr_id) {
            this.impr_id = impr_id;
        }
    }

    public static class DataBean {
        /**
         * info : {"wordid":"6823570056195085582"}
         * keyword : 2021年春节假期最新通知
         */

        private InfoBeanX info;
        private String keyword;

        public InfoBeanX getInfo() {
            return info;
        }

        public void setInfo(InfoBeanX info) {
            this.info = info;
        }

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public static class InfoBeanX {
            /**
             * wordid : 6823570056195085582
             */

            private String wordid;

            public String getWordid() {
                return wordid;
            }

            public void setWordid(String wordid) {
                this.wordid = wordid;
            }
        }
    }
}
