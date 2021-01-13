package com.example.net.bean;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class NewsBean {

    /**
     * abstract : 十五年前的夏天，时任浙江省委书记的习近平考察浙江安吉余村时，创见性地提出了“绿水青山就是金山银山”的重要科学理念，一场改变中国经济社会发展观的变革由此开始。
     * action_list : [{"action":1,"desc":"","extra":{}},{"action":3,"desc":"","extra":{}},{"action":7,"desc":"","extra":{}},{"action":9,"desc":"","extra":{}}]
     * aggr_type : 1
     * allow_download : false
     * article_sub_type : 0
     * article_type : 0
     * article_url : http://app.cctv.com/special/cportal/detail/arti/index.html?id=ArtihKCjsNAfdfbhmxSm3L6f201018
     * article_version : 0
     * ban_comment : 0
     * ban_immersive : 0
     * behot_time : 1610021725
     * bury_count : 0
     * bury_style_show : 0
     * cell_flag : 268697611
     * cell_layout_style : 1
     * cell_type : 0
     * comment_count : 60
     * content_decoration :
     * cursor : 1610021725000
     * digg_count : 3591
     * display_url : http://toutiao.com/group/6914783712185942536/
     * feed_title : 跟着总书记一起建设美丽中国
     * filter_words : [{"id":"8:0","name":"看过了","is_selected":false},{"id":"9:1","name":"内容太水","is_selected":false},{"id":"5:9300275","name":"拉黑作者:央视新闻","is_selected":false},{"id":"1:1733187203","name":"不想看:十九大","is_selected":false},{"id":"6:66317141","name":"不想看:创见资讯","is_selected":false},{"id":"6:2624769182","name":"不想看:美好，一直在身边","is_selected":false}]
     * forward_info : {"forward_count":6}
     * group_id : 6914783712185942536
     * group_source : 2
     * has_m3u8_video : false
     * has_mp4_video : 0
     * has_video : false
     * hot : 0
     * ignore_web_transform : 1
     * interaction_data :
     * is_key_video : false
     * is_stick : true
     * is_subject : false
     * item_id : 6914783712185942536
     * item_version : 0
     * label : 置顶
     * label_extra : {"is_redirect":false,"redirect_url":"","icon_url":{},"style_type":0}
     * label_style : 1
     * level : 0
     * log_pb : {"impr_id":"20210107201606010011061156170B6C70","is_following":"0"}
     * media_info : {"avatar_url":"http://p26-tt.byteimg.com/large/pgc-image/e851d72f00744176ab596f32f376e408","name":"央视新闻","user_verified":true,"media_id":4492956276,"user_id":4492956276,"verified_content":"","is_star_user":false,"recommend_reason":"","recommend_type":0,"follow":false}
     * media_name : 央视新闻
     * need_client_impr_recycle : 1
     * publish_time : 1609973542
     * read_count : 192800
     * repin_count : 1010
     * rid : 20210107201606010011061156170B6C70
     * share_count : 872
     * share_info : {"share_url":"https://m.toutiaocdn.com/group/6914783712185942536/?app=news_article&is_hit_share_recommend=0","title":"系列时政微视频丨时代创见\u2014\u2014跟着总书记一起建设美丽中国 - 今日头条","description":null,"cover_image":null,"share_type":{"pyq":2,"qq":0,"qzone":0,"wx":0},"weixin_cover_image":null,"token_type":1,"on_suppress":0,"hidden_url":null,"video_url":null,"share_control":null}
     * share_type : 2
     * share_url : https://m.toutiaocdn.com/group/6914783712185942536/?app=news_article&is_hit_share_recommend=0
     * show_dislike : false
     * show_portrait : false
     * show_portrait_article : false
     * small_image : null
     * source : 央视新闻
     * source_icon_style : 1
     * source_open_url : sslocal://profile?refer=video&uid=4492956276
     * stick_label : 置顶
     * stick_style : 1
     * tag : general_positive_video
     * tag_id : 6914783712185942536
     * tip : 0
     * title : 系列时政微视频丨时代创见——跟着总书记一起建设美丽中国
     * ugc_recommend : {"activity":"","reason":"中央电视台新闻中心官方账号"}
     * url : http://app.cctv.com/special/cportal/detail/arti/index.html?id=ArtihKCjsNAfdfbhmxSm3L6f201018
     * user_info : {"avatar_url":"https://sf6-ttcdn-tos.pstatp.com/img/pgc-image/e851d72f00744176ab596f32f376e408~120x256.image","name":"央视新闻","description":"中央广播电视总台新闻新媒体中心官方账号","user_id":4492956276,"user_verified":true,"verified_content":"中央电视台新闻中心官方账号","follow":false,"follower_count":0,"user_auth_info":"{\"auth_type\":\"0\",\"auth_info\":\"中央电视台新闻中心官方账号\"}","schema":"sslocal://profile?uid=4492956276&refer=all","living_count":0}
     * user_repin : 0
     * user_verified : 1
     * verified_content : 中央电视台新闻中心官方账号
     * video_style : 0
     * xi_related : false
     */

    @SerializedName("abstract")
    private String abstractX;
    private int aggr_type;
    private boolean allow_download;
    private int article_sub_type;
    private int article_type;
    private String article_url;
    private int article_version;
    private int ban_comment;
    private int ban_immersive;
    private int behot_time;
    private int bury_count;
    private int bury_style_show;
    private int cell_flag;
    private int cell_layout_style;
    private int cell_type;
    private int comment_count;
    private String content_decoration;
    private long cursor;
    private int digg_count;
    private String display_url;
    private String feed_title;
    private ForwardInfoBean forward_info;
    private long group_id;
    private int group_source;
    private boolean has_m3u8_video;
    private int has_mp4_video;
    private boolean has_video;
    private int hot;
    private int ignore_web_transform;
    private String interaction_data;
    private boolean is_key_video;
    private boolean is_stick;
    private boolean is_subject;
    private long item_id;
    private int item_version;
    private String label;
    private LabelExtraBean label_extra;
    private int label_style;
    private int level;
    private LogPbBean log_pb;
    private MediaInfoBean media_info;
    private String media_name;
    private int need_client_impr_recycle;
    private int publish_time;
    private int read_count;
    private int repin_count;
    private String rid;
    private int share_count;
    private ShareInfoBean share_info;
    private int share_type;
    private String share_url;
    private boolean show_dislike;
    private boolean show_portrait;
    private boolean show_portrait_article;
    private Object small_image;
    private String source;
    private int source_icon_style;
    private String source_open_url;
    private String stick_label;
    private int stick_style;
    private String tag;
    private long tag_id;
    private int tip;
    private String title;
    private UgcRecommendBean ugc_recommend;
    private String url;
    private UserInfoBean user_info;
    private int user_repin;
    private int user_verified;
    private String verified_content;
    private int video_style;
    private boolean xi_related;
    private List<ActionListBean> action_list;
    private List<FilterWordsBean> filter_words;

    public static NewsBean objectFromData(String str) {

        return new Gson().fromJson(str, NewsBean.class);
    }

    public static NewsBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), NewsBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getAbstractX() {
        return abstractX;
    }

    public void setAbstractX(String abstractX) {
        this.abstractX = abstractX;
    }

    public int getAggr_type() {
        return aggr_type;
    }

    public void setAggr_type(int aggr_type) {
        this.aggr_type = aggr_type;
    }

    public boolean isAllow_download() {
        return allow_download;
    }

    public void setAllow_download(boolean allow_download) {
        this.allow_download = allow_download;
    }

    public int getArticle_sub_type() {
        return article_sub_type;
    }

    public void setArticle_sub_type(int article_sub_type) {
        this.article_sub_type = article_sub_type;
    }

    public int getArticle_type() {
        return article_type;
    }

    public void setArticle_type(int article_type) {
        this.article_type = article_type;
    }

    public String getArticle_url() {
        return article_url;
    }

    public void setArticle_url(String article_url) {
        this.article_url = article_url;
    }

    public int getArticle_version() {
        return article_version;
    }

    public void setArticle_version(int article_version) {
        this.article_version = article_version;
    }

    public int getBan_comment() {
        return ban_comment;
    }

    public void setBan_comment(int ban_comment) {
        this.ban_comment = ban_comment;
    }

    public int getBan_immersive() {
        return ban_immersive;
    }

    public void setBan_immersive(int ban_immersive) {
        this.ban_immersive = ban_immersive;
    }

    public int getBehot_time() {
        return behot_time;
    }

    public void setBehot_time(int behot_time) {
        this.behot_time = behot_time;
    }

    public int getBury_count() {
        return bury_count;
    }

    public void setBury_count(int bury_count) {
        this.bury_count = bury_count;
    }

    public int getBury_style_show() {
        return bury_style_show;
    }

    public void setBury_style_show(int bury_style_show) {
        this.bury_style_show = bury_style_show;
    }

    public int getCell_flag() {
        return cell_flag;
    }

    public void setCell_flag(int cell_flag) {
        this.cell_flag = cell_flag;
    }

    public int getCell_layout_style() {
        return cell_layout_style;
    }

    public void setCell_layout_style(int cell_layout_style) {
        this.cell_layout_style = cell_layout_style;
    }

    public int getCell_type() {
        return cell_type;
    }

    public void setCell_type(int cell_type) {
        this.cell_type = cell_type;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public String getContent_decoration() {
        return content_decoration;
    }

    public void setContent_decoration(String content_decoration) {
        this.content_decoration = content_decoration;
    }

    public long getCursor() {
        return cursor;
    }

    public void setCursor(long cursor) {
        this.cursor = cursor;
    }

    public int getDigg_count() {
        return digg_count;
    }

    public void setDigg_count(int digg_count) {
        this.digg_count = digg_count;
    }

    public String getDisplay_url() {
        return display_url;
    }

    public void setDisplay_url(String display_url) {
        this.display_url = display_url;
    }

    public String getFeed_title() {
        return feed_title;
    }

    public void setFeed_title(String feed_title) {
        this.feed_title = feed_title;
    }

    public ForwardInfoBean getForward_info() {
        return forward_info;
    }

    public void setForward_info(ForwardInfoBean forward_info) {
        this.forward_info = forward_info;
    }

    public long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(long group_id) {
        this.group_id = group_id;
    }

    public int getGroup_source() {
        return group_source;
    }

    public void setGroup_source(int group_source) {
        this.group_source = group_source;
    }

    public boolean isHas_m3u8_video() {
        return has_m3u8_video;
    }

    public void setHas_m3u8_video(boolean has_m3u8_video) {
        this.has_m3u8_video = has_m3u8_video;
    }

    public int getHas_mp4_video() {
        return has_mp4_video;
    }

    public void setHas_mp4_video(int has_mp4_video) {
        this.has_mp4_video = has_mp4_video;
    }

    public boolean isHas_video() {
        return has_video;
    }

    public void setHas_video(boolean has_video) {
        this.has_video = has_video;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public int getIgnore_web_transform() {
        return ignore_web_transform;
    }

    public void setIgnore_web_transform(int ignore_web_transform) {
        this.ignore_web_transform = ignore_web_transform;
    }

    public String getInteraction_data() {
        return interaction_data;
    }

    public void setInteraction_data(String interaction_data) {
        this.interaction_data = interaction_data;
    }

    public boolean isIs_key_video() {
        return is_key_video;
    }

    public void setIs_key_video(boolean is_key_video) {
        this.is_key_video = is_key_video;
    }

    public boolean isIs_stick() {
        return is_stick;
    }

    public void setIs_stick(boolean is_stick) {
        this.is_stick = is_stick;
    }

    public boolean isIs_subject() {
        return is_subject;
    }

    public void setIs_subject(boolean is_subject) {
        this.is_subject = is_subject;
    }

    public long getItem_id() {
        return item_id;
    }

    public void setItem_id(long item_id) {
        this.item_id = item_id;
    }

    public int getItem_version() {
        return item_version;
    }

    public void setItem_version(int item_version) {
        this.item_version = item_version;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public LabelExtraBean getLabel_extra() {
        return label_extra;
    }

    public void setLabel_extra(LabelExtraBean label_extra) {
        this.label_extra = label_extra;
    }

    public int getLabel_style() {
        return label_style;
    }

    public void setLabel_style(int label_style) {
        this.label_style = label_style;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public LogPbBean getLog_pb() {
        return log_pb;
    }

    public void setLog_pb(LogPbBean log_pb) {
        this.log_pb = log_pb;
    }

    public MediaInfoBean getMedia_info() {
        return media_info;
    }

    public void setMedia_info(MediaInfoBean media_info) {
        this.media_info = media_info;
    }

    public String getMedia_name() {
        return media_name;
    }

    public void setMedia_name(String media_name) {
        this.media_name = media_name;
    }

    public int getNeed_client_impr_recycle() {
        return need_client_impr_recycle;
    }

    public void setNeed_client_impr_recycle(int need_client_impr_recycle) {
        this.need_client_impr_recycle = need_client_impr_recycle;
    }

    public int getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(int publish_time) {
        this.publish_time = publish_time;
    }

    public int getRead_count() {
        return read_count;
    }

    public void setRead_count(int read_count) {
        this.read_count = read_count;
    }

    public int getRepin_count() {
        return repin_count;
    }

    public void setRepin_count(int repin_count) {
        this.repin_count = repin_count;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public int getShare_count() {
        return share_count;
    }

    public void setShare_count(int share_count) {
        this.share_count = share_count;
    }

    public ShareInfoBean getShare_info() {
        return share_info;
    }

    public void setShare_info(ShareInfoBean share_info) {
        this.share_info = share_info;
    }

    public int getShare_type() {
        return share_type;
    }

    public void setShare_type(int share_type) {
        this.share_type = share_type;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public boolean isShow_dislike() {
        return show_dislike;
    }

    public void setShow_dislike(boolean show_dislike) {
        this.show_dislike = show_dislike;
    }

    public boolean isShow_portrait() {
        return show_portrait;
    }

    public void setShow_portrait(boolean show_portrait) {
        this.show_portrait = show_portrait;
    }

    public boolean isShow_portrait_article() {
        return show_portrait_article;
    }

    public void setShow_portrait_article(boolean show_portrait_article) {
        this.show_portrait_article = show_portrait_article;
    }

    public Object getSmall_image() {
        return small_image;
    }

    public void setSmall_image(Object small_image) {
        this.small_image = small_image;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getSource_icon_style() {
        return source_icon_style;
    }

    public void setSource_icon_style(int source_icon_style) {
        this.source_icon_style = source_icon_style;
    }

    public String getSource_open_url() {
        return source_open_url;
    }

    public void setSource_open_url(String source_open_url) {
        this.source_open_url = source_open_url;
    }

    public String getStick_label() {
        return stick_label;
    }

    public void setStick_label(String stick_label) {
        this.stick_label = stick_label;
    }

    public int getStick_style() {
        return stick_style;
    }

    public void setStick_style(int stick_style) {
        this.stick_style = stick_style;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public long getTag_id() {
        return tag_id;
    }

    public void setTag_id(long tag_id) {
        this.tag_id = tag_id;
    }

    public int getTip() {
        return tip;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UgcRecommendBean getUgc_recommend() {
        return ugc_recommend;
    }

    public void setUgc_recommend(UgcRecommendBean ugc_recommend) {
        this.ugc_recommend = ugc_recommend;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public UserInfoBean getUser_info() {
        return user_info;
    }

    public void setUser_info(UserInfoBean user_info) {
        this.user_info = user_info;
    }

    public int getUser_repin() {
        return user_repin;
    }

    public void setUser_repin(int user_repin) {
        this.user_repin = user_repin;
    }

    public int getUser_verified() {
        return user_verified;
    }

    public void setUser_verified(int user_verified) {
        this.user_verified = user_verified;
    }

    public String getVerified_content() {
        return verified_content;
    }

    public void setVerified_content(String verified_content) {
        this.verified_content = verified_content;
    }

    public int getVideo_style() {
        return video_style;
    }

    public void setVideo_style(int video_style) {
        this.video_style = video_style;
    }

    public boolean isXi_related() {
        return xi_related;
    }

    public void setXi_related(boolean xi_related) {
        this.xi_related = xi_related;
    }

    public List<ActionListBean> getAction_list() {
        return action_list;
    }

    public void setAction_list(List<ActionListBean> action_list) {
        this.action_list = action_list;
    }

    public List<FilterWordsBean> getFilter_words() {
        return filter_words;
    }

    public void setFilter_words(List<FilterWordsBean> filter_words) {
        this.filter_words = filter_words;
    }

    public static class ForwardInfoBean {
        /**
         * forward_count : 6
         */

        private int forward_count;

        public static ForwardInfoBean objectFromData(String str) {

            return new Gson().fromJson(str, ForwardInfoBean.class);
        }

        public static ForwardInfoBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), ForwardInfoBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public int getForward_count() {
            return forward_count;
        }

        public void setForward_count(int forward_count) {
            this.forward_count = forward_count;
        }
    }

    public static class LabelExtraBean {
        /**
         * is_redirect : false
         * redirect_url :
         * icon_url : {}
         * style_type : 0
         */

        private boolean is_redirect;
        private String redirect_url;
        private IconUrlBean icon_url;
        private int style_type;

        public static LabelExtraBean objectFromData(String str) {

            return new Gson().fromJson(str, LabelExtraBean.class);
        }

        public static LabelExtraBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), LabelExtraBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public boolean isIs_redirect() {
            return is_redirect;
        }

        public void setIs_redirect(boolean is_redirect) {
            this.is_redirect = is_redirect;
        }

        public String getRedirect_url() {
            return redirect_url;
        }

        public void setRedirect_url(String redirect_url) {
            this.redirect_url = redirect_url;
        }

        public IconUrlBean getIcon_url() {
            return icon_url;
        }

        public void setIcon_url(IconUrlBean icon_url) {
            this.icon_url = icon_url;
        }

        public int getStyle_type() {
            return style_type;
        }

        public void setStyle_type(int style_type) {
            this.style_type = style_type;
        }

        public static class IconUrlBean {
            public static IconUrlBean objectFromData(String str) {

                return new Gson().fromJson(str, IconUrlBean.class);
            }

            public static IconUrlBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), IconUrlBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }
        }
    }

    public static class LogPbBean {
        /**
         * impr_id : 20210107201606010011061156170B6C70
         * is_following : 0
         */

        private String impr_id;
        private String is_following;

        public static LogPbBean objectFromData(String str) {

            return new Gson().fromJson(str, LogPbBean.class);
        }

        public static LogPbBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), LogPbBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public String getImpr_id() {
            return impr_id;
        }

        public void setImpr_id(String impr_id) {
            this.impr_id = impr_id;
        }

        public String getIs_following() {
            return is_following;
        }

        public void setIs_following(String is_following) {
            this.is_following = is_following;
        }
    }

    public static class MediaInfoBean {
        /**
         * avatar_url : http://p26-tt.byteimg.com/large/pgc-image/e851d72f00744176ab596f32f376e408
         * name : 央视新闻
         * user_verified : true
         * media_id : 4492956276
         * user_id : 4492956276
         * verified_content :
         * is_star_user : false
         * recommend_reason :
         * recommend_type : 0
         * follow : false
         */

        private String avatar_url;
        private String name;
        private boolean user_verified;
        private long media_id;
        private long user_id;
        private String verified_content;
        private boolean is_star_user;
        private String recommend_reason;
        private int recommend_type;
        private boolean follow;

        public static MediaInfoBean objectFromData(String str) {

            return new Gson().fromJson(str, MediaInfoBean.class);
        }

        public static MediaInfoBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), MediaInfoBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
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

        public boolean isUser_verified() {
            return user_verified;
        }

        public void setUser_verified(boolean user_verified) {
            this.user_verified = user_verified;
        }

        public long getMedia_id() {
            return media_id;
        }

        public void setMedia_id(long media_id) {
            this.media_id = media_id;
        }

        public long getUser_id() {
            return user_id;
        }

        public void setUser_id(long user_id) {
            this.user_id = user_id;
        }

        public String getVerified_content() {
            return verified_content;
        }

        public void setVerified_content(String verified_content) {
            this.verified_content = verified_content;
        }

        public boolean isIs_star_user() {
            return is_star_user;
        }

        public void setIs_star_user(boolean is_star_user) {
            this.is_star_user = is_star_user;
        }

        public String getRecommend_reason() {
            return recommend_reason;
        }

        public void setRecommend_reason(String recommend_reason) {
            this.recommend_reason = recommend_reason;
        }

        public int getRecommend_type() {
            return recommend_type;
        }

        public void setRecommend_type(int recommend_type) {
            this.recommend_type = recommend_type;
        }

        public boolean isFollow() {
            return follow;
        }

        public void setFollow(boolean follow) {
            this.follow = follow;
        }
    }

    public static class ShareInfoBean {
        /**
         * share_url : https://m.toutiaocdn.com/group/6914783712185942536/?app=news_article&is_hit_share_recommend=0
         * title : 系列时政微视频丨时代创见——跟着总书记一起建设美丽中国 - 今日头条
         * description : null
         * cover_image : null
         * share_type : {"pyq":2,"qq":0,"qzone":0,"wx":0}
         * weixin_cover_image : null
         * token_type : 1
         * on_suppress : 0
         * hidden_url : null
         * video_url : null
         * share_control : null
         */

        private String share_url;
        private String title;
        private Object description;
        private Object cover_image;
        private ShareTypeBean share_type;
        private Object weixin_cover_image;
        private int token_type;
        private int on_suppress;
        private Object hidden_url;
        private Object video_url;
        private Object share_control;

        public static ShareInfoBean objectFromData(String str) {

            return new Gson().fromJson(str, ShareInfoBean.class);
        }

        public static ShareInfoBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), ShareInfoBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public Object getCover_image() {
            return cover_image;
        }

        public void setCover_image(Object cover_image) {
            this.cover_image = cover_image;
        }

        public ShareTypeBean getShare_type() {
            return share_type;
        }

        public void setShare_type(ShareTypeBean share_type) {
            this.share_type = share_type;
        }

        public Object getWeixin_cover_image() {
            return weixin_cover_image;
        }

        public void setWeixin_cover_image(Object weixin_cover_image) {
            this.weixin_cover_image = weixin_cover_image;
        }

        public int getToken_type() {
            return token_type;
        }

        public void setToken_type(int token_type) {
            this.token_type = token_type;
        }

        public int getOn_suppress() {
            return on_suppress;
        }

        public void setOn_suppress(int on_suppress) {
            this.on_suppress = on_suppress;
        }

        public Object getHidden_url() {
            return hidden_url;
        }

        public void setHidden_url(Object hidden_url) {
            this.hidden_url = hidden_url;
        }

        public Object getVideo_url() {
            return video_url;
        }

        public void setVideo_url(Object video_url) {
            this.video_url = video_url;
        }

        public Object getShare_control() {
            return share_control;
        }

        public void setShare_control(Object share_control) {
            this.share_control = share_control;
        }

        public static class ShareTypeBean {
            /**
             * pyq : 2
             * qq : 0
             * qzone : 0
             * wx : 0
             */

            private int pyq;
            private int qq;
            private int qzone;
            private int wx;

            public static ShareTypeBean objectFromData(String str) {

                return new Gson().fromJson(str, ShareTypeBean.class);
            }

            public static ShareTypeBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), ShareTypeBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public int getPyq() {
                return pyq;
            }

            public void setPyq(int pyq) {
                this.pyq = pyq;
            }

            public int getQq() {
                return qq;
            }

            public void setQq(int qq) {
                this.qq = qq;
            }

            public int getQzone() {
                return qzone;
            }

            public void setQzone(int qzone) {
                this.qzone = qzone;
            }

            public int getWx() {
                return wx;
            }

            public void setWx(int wx) {
                this.wx = wx;
            }
        }
    }

    public static class UgcRecommendBean {
        /**
         * activity :
         * reason : 中央电视台新闻中心官方账号
         */

        private String activity;
        private String reason;

        public static UgcRecommendBean objectFromData(String str) {

            return new Gson().fromJson(str, UgcRecommendBean.class);
        }

        public static UgcRecommendBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), UgcRecommendBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public String getActivity() {
            return activity;
        }

        public void setActivity(String activity) {
            this.activity = activity;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }
    }

    public static class UserInfoBean {
        /**
         * avatar_url : https://sf6-ttcdn-tos.pstatp.com/img/pgc-image/e851d72f00744176ab596f32f376e408~120x256.image
         * name : 央视新闻
         * description : 中央广播电视总台新闻新媒体中心官方账号
         * user_id : 4492956276
         * user_verified : true
         * verified_content : 中央电视台新闻中心官方账号
         * follow : false
         * follower_count : 0
         * user_auth_info : {"auth_type":"0","auth_info":"中央电视台新闻中心官方账号"}
         * schema : sslocal://profile?uid=4492956276&refer=all
         * living_count : 0
         */

        private String avatar_url;
        private String name;
        private String description;
        private long user_id;
        private boolean user_verified;
        private String verified_content;
        private boolean follow;
        private int follower_count;
        private String user_auth_info;
        private String schema;
        private int living_count;

        public static UserInfoBean objectFromData(String str) {

            return new Gson().fromJson(str, UserInfoBean.class);
        }

        public static UserInfoBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), UserInfoBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public long getUser_id() {
            return user_id;
        }

        public void setUser_id(long user_id) {
            this.user_id = user_id;
        }

        public boolean isUser_verified() {
            return user_verified;
        }

        public void setUser_verified(boolean user_verified) {
            this.user_verified = user_verified;
        }

        public String getVerified_content() {
            return verified_content;
        }

        public void setVerified_content(String verified_content) {
            this.verified_content = verified_content;
        }

        public boolean isFollow() {
            return follow;
        }

        public void setFollow(boolean follow) {
            this.follow = follow;
        }

        public int getFollower_count() {
            return follower_count;
        }

        public void setFollower_count(int follower_count) {
            this.follower_count = follower_count;
        }

        public String getUser_auth_info() {
            return user_auth_info;
        }

        public void setUser_auth_info(String user_auth_info) {
            this.user_auth_info = user_auth_info;
        }

        public String getSchema() {
            return schema;
        }

        public void setSchema(String schema) {
            this.schema = schema;
        }

        public int getLiving_count() {
            return living_count;
        }

        public void setLiving_count(int living_count) {
            this.living_count = living_count;
        }
    }

    public static class ActionListBean {
        /**
         * action : 1
         * desc :
         * extra : {}
         */

        private int action;
        private String desc;
        private ExtraBean extra;

        public static ActionListBean objectFromData(String str) {

            return new Gson().fromJson(str, ActionListBean.class);
        }

        public static ActionListBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), ActionListBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public int getAction() {
            return action;
        }

        public void setAction(int action) {
            this.action = action;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public ExtraBean getExtra() {
            return extra;
        }

        public void setExtra(ExtraBean extra) {
            this.extra = extra;
        }

        public static class ExtraBean {
            public static ExtraBean objectFromData(String str) {

                return new Gson().fromJson(str, ExtraBean.class);
            }

            public static ExtraBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), ExtraBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }
        }
    }

    public static class FilterWordsBean {
        /**
         * id : 8:0
         * name : 看过了
         * is_selected : false
         */

        private String id;
        private String name;
        private boolean is_selected;

        public static FilterWordsBean objectFromData(String str) {

            return new Gson().fromJson(str, FilterWordsBean.class);
        }

        public static FilterWordsBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), FilterWordsBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isIs_selected() {
            return is_selected;
        }

        public void setIs_selected(boolean is_selected) {
            this.is_selected = is_selected;
        }
    }
}
