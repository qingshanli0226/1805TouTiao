package com.bw.net.bean;

import java.util.List;

public class SearchResultBean {


    /**
     * count : 0
     * return_count : 0
     * query_id : 6595885014645216520
     * has_more : 0
     * request_id : 202101071334560100140470682404D8D7
     * search_id : 202101071334560100140470682404D8D7
     * cur_ts : 1609997696
     * offset : 10
     * message : success
     * pd : synthesis
     * show_tabs : 1
     * keyword : 5
     * city : 天津
     * log_pb : {"impr_id":"202101071334560100140470682404D8D7","is_incognito":0}
     * data : null
     * data_head : [{"challenge_code":1367,"cell_type":71,"keyword":"5","url":"sslocal://search?keyword=5&from=&source=search_tab"}]
     * ab_fields : {"ab_hotboard_showShare":1,"app_video_autoplay":0,"isPrediction":1,"lightapp_new_style":0,"s_layer":2}
     * latency : 0
     * search_type : 2
     * tab_rank : null
     * temp_type : 0
     * tab_list : null
     * stability_error : 0
     * synthesis_stability_error : 0
     * gray_page_switch : false
     * status : 0
     * is_before_ack : 0
     */

    private int count;
    private int return_count;
    private String query_id;
    private int has_more;
    private String request_id;
    private String search_id;
    private int cur_ts;
    private int offset;
    private String message;
    private String pd;
    private int show_tabs;
    private String keyword;
    private String city;
    private LogPbBean log_pb;
    private Object data;
    private AbFieldsBean ab_fields;
    private int latency;
    private int search_type;
    private Object tab_rank;
    private int temp_type;
    private Object tab_list;
    private int stability_error;
    private int synthesis_stability_error;
    private boolean gray_page_switch;
    private int status;
    private int is_before_ack;
    private List<DataHeadBean> data_head;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getReturn_count() {
        return return_count;
    }

    public void setReturn_count(int return_count) {
        this.return_count = return_count;
    }

    public String getQuery_id() {
        return query_id;
    }

    public void setQuery_id(String query_id) {
        this.query_id = query_id;
    }

    public int getHas_more() {
        return has_more;
    }

    public void setHas_more(int has_more) {
        this.has_more = has_more;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public String getSearch_id() {
        return search_id;
    }

    public void setSearch_id(String search_id) {
        this.search_id = search_id;
    }

    public int getCur_ts() {
        return cur_ts;
    }

    public void setCur_ts(int cur_ts) {
        this.cur_ts = cur_ts;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPd() {
        return pd;
    }

    public void setPd(String pd) {
        this.pd = pd;
    }

    public int getShow_tabs() {
        return show_tabs;
    }

    public void setShow_tabs(int show_tabs) {
        this.show_tabs = show_tabs;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LogPbBean getLog_pb() {
        return log_pb;
    }

    public void setLog_pb(LogPbBean log_pb) {
        this.log_pb = log_pb;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public AbFieldsBean getAb_fields() {
        return ab_fields;
    }

    public void setAb_fields(AbFieldsBean ab_fields) {
        this.ab_fields = ab_fields;
    }

    public int getLatency() {
        return latency;
    }

    public void setLatency(int latency) {
        this.latency = latency;
    }

    public int getSearch_type() {
        return search_type;
    }

    public void setSearch_type(int search_type) {
        this.search_type = search_type;
    }

    public Object getTab_rank() {
        return tab_rank;
    }

    public void setTab_rank(Object tab_rank) {
        this.tab_rank = tab_rank;
    }

    public int getTemp_type() {
        return temp_type;
    }

    public void setTemp_type(int temp_type) {
        this.temp_type = temp_type;
    }

    public Object getTab_list() {
        return tab_list;
    }

    public void setTab_list(Object tab_list) {
        this.tab_list = tab_list;
    }

    public int getStability_error() {
        return stability_error;
    }

    public void setStability_error(int stability_error) {
        this.stability_error = stability_error;
    }

    public int getSynthesis_stability_error() {
        return synthesis_stability_error;
    }

    public void setSynthesis_stability_error(int synthesis_stability_error) {
        this.synthesis_stability_error = synthesis_stability_error;
    }

    public boolean isGray_page_switch() {
        return gray_page_switch;
    }

    public void setGray_page_switch(boolean gray_page_switch) {
        this.gray_page_switch = gray_page_switch;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIs_before_ack() {
        return is_before_ack;
    }

    public void setIs_before_ack(int is_before_ack) {
        this.is_before_ack = is_before_ack;
    }

    public List<DataHeadBean> getData_head() {
        return data_head;
    }

    public void setData_head(List<DataHeadBean> data_head) {
        this.data_head = data_head;
    }

    public static class LogPbBean {
        /**
         * impr_id : 202101071334560100140470682404D8D7
         * is_incognito : 0
         */

        private String impr_id;
        private int is_incognito;

        public String getImpr_id() {
            return impr_id;
        }

        public void setImpr_id(String impr_id) {
            this.impr_id = impr_id;
        }

        public int getIs_incognito() {
            return is_incognito;
        }

        public void setIs_incognito(int is_incognito) {
            this.is_incognito = is_incognito;
        }
    }

    public static class AbFieldsBean {
        /**
         * ab_hotboard_showShare : 1
         * app_video_autoplay : 0
         * isPrediction : 1
         * lightapp_new_style : 0
         * s_layer : 2
         */

        private int ab_hotboard_showShare;
        private int app_video_autoplay;
        private int isPrediction;
        private int lightapp_new_style;
        private int s_layer;

        public int getAb_hotboard_showShare() {
            return ab_hotboard_showShare;
        }

        public void setAb_hotboard_showShare(int ab_hotboard_showShare) {
            this.ab_hotboard_showShare = ab_hotboard_showShare;
        }

        public int getApp_video_autoplay() {
            return app_video_autoplay;
        }

        public void setApp_video_autoplay(int app_video_autoplay) {
            this.app_video_autoplay = app_video_autoplay;
        }

        public int getIsPrediction() {
            return isPrediction;
        }

        public void setIsPrediction(int isPrediction) {
            this.isPrediction = isPrediction;
        }

        public int getLightapp_new_style() {
            return lightapp_new_style;
        }

        public void setLightapp_new_style(int lightapp_new_style) {
            this.lightapp_new_style = lightapp_new_style;
        }

        public int getS_layer() {
            return s_layer;
        }

        public void setS_layer(int s_layer) {
            this.s_layer = s_layer;
        }
    }

    public static class DataHeadBean {
        /**
         * challenge_code : 1367
         * cell_type : 71
         * keyword : 5
         * url : sslocal://search?keyword=5&from=&source=search_tab
         */

        private int challenge_code;
        private int cell_type;
        private String keyword;
        private String url;

        public int getChallenge_code() {
            return challenge_code;
        }

        public void setChallenge_code(int challenge_code) {
            this.challenge_code = challenge_code;
        }

        public int getCell_type() {
            return cell_type;
        }

        public void setCell_type(int cell_type) {
            this.cell_type = cell_type;
        }

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
