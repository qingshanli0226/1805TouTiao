package com.toutiao.bawei.a1805toutiao;

import java.util.List;

public class News {

    /**
     * message : success
     * data : []
     * total_number : 0
     * has_more : false
     * login_status : 0
     * show_et_status : 0
     * post_content_hint : 分享今日新鲜事
     * has_more_to_refresh : true
     * action_to_last_stick : 0
     * feed_flag : 0
     * tips : {"type":"","display_duration":0,"display_info":"","open_url":"","web_url":"","download_url":"","app_name":"","package_name":""}
     * is_use_bytedance_stream : true
     * get_offline_pool : false
     * location : null
     * api_base_info : null
     * show_last_read : false
     * last_response_extra : {"data":"eyJoYXNfZm9sbG93aW5nIjpmYWxzZX0"}
     */

    private String message;
    private int total_number;
    private boolean has_more;
    private int login_status;
    private int show_et_status;
    private String post_content_hint;
    private boolean has_more_to_refresh;
    private int action_to_last_stick;
    private int feed_flag;
    private TipsBean tips;
    private boolean is_use_bytedance_stream;
    private boolean get_offline_pool;
    private Object location;
    private Object api_base_info;
    private boolean show_last_read;
    private LastResponseExtraBean last_response_extra;
    private List<?> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTotal_number() {
        return total_number;
    }

    public void setTotal_number(int total_number) {
        this.total_number = total_number;
    }

    public boolean isHas_more() {
        return has_more;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }

    public int getLogin_status() {
        return login_status;
    }

    public void setLogin_status(int login_status) {
        this.login_status = login_status;
    }

    public int getShow_et_status() {
        return show_et_status;
    }

    public void setShow_et_status(int show_et_status) {
        this.show_et_status = show_et_status;
    }

    public String getPost_content_hint() {
        return post_content_hint;
    }

    public void setPost_content_hint(String post_content_hint) {
        this.post_content_hint = post_content_hint;
    }

    public boolean isHas_more_to_refresh() {
        return has_more_to_refresh;
    }

    public void setHas_more_to_refresh(boolean has_more_to_refresh) {
        this.has_more_to_refresh = has_more_to_refresh;
    }

    public int getAction_to_last_stick() {
        return action_to_last_stick;
    }

    public void setAction_to_last_stick(int action_to_last_stick) {
        this.action_to_last_stick = action_to_last_stick;
    }

    public int getFeed_flag() {
        return feed_flag;
    }

    public void setFeed_flag(int feed_flag) {
        this.feed_flag = feed_flag;
    }

    public TipsBean getTips() {
        return tips;
    }

    public void setTips(TipsBean tips) {
        this.tips = tips;
    }

    public boolean isIs_use_bytedance_stream() {
        return is_use_bytedance_stream;
    }

    public void setIs_use_bytedance_stream(boolean is_use_bytedance_stream) {
        this.is_use_bytedance_stream = is_use_bytedance_stream;
    }

    public boolean isGet_offline_pool() {
        return get_offline_pool;
    }

    public void setGet_offline_pool(boolean get_offline_pool) {
        this.get_offline_pool = get_offline_pool;
    }

    public Object getLocation() {
        return location;
    }

    public void setLocation(Object location) {
        this.location = location;
    }

    public Object getApi_base_info() {
        return api_base_info;
    }

    public void setApi_base_info(Object api_base_info) {
        this.api_base_info = api_base_info;
    }

    public boolean isShow_last_read() {
        return show_last_read;
    }

    public void setShow_last_read(boolean show_last_read) {
        this.show_last_read = show_last_read;
    }

    public LastResponseExtraBean getLast_response_extra() {
        return last_response_extra;
    }

    public void setLast_response_extra(LastResponseExtraBean last_response_extra) {
        this.last_response_extra = last_response_extra;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public static class TipsBean {
        /**
         * type :
         * display_duration : 0
         * display_info :
         * open_url :
         * web_url :
         * download_url :
         * app_name :
         * package_name :
         */

        private String type;
        private int display_duration;
        private String display_info;
        private String open_url;
        private String web_url;
        private String download_url;
        private String app_name;
        private String package_name;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getDisplay_duration() {
            return display_duration;
        }

        public void setDisplay_duration(int display_duration) {
            this.display_duration = display_duration;
        }

        public String getDisplay_info() {
            return display_info;
        }

        public void setDisplay_info(String display_info) {
            this.display_info = display_info;
        }

        public String getOpen_url() {
            return open_url;
        }

        public void setOpen_url(String open_url) {
            this.open_url = open_url;
        }

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }

        public String getDownload_url() {
            return download_url;
        }

        public void setDownload_url(String download_url) {
            this.download_url = download_url;
        }

        public String getApp_name() {
            return app_name;
        }

        public void setApp_name(String app_name) {
            this.app_name = app_name;
        }

        public String getPackage_name() {
            return package_name;
        }

        public void setPackage_name(String package_name) {
            this.package_name = package_name;
        }
    }

    public static class LastResponseExtraBean {
        /**
         * data : eyJoYXNfZm9sbG93aW5nIjpmYWxzZX0
         */

        private String data;

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }
}
