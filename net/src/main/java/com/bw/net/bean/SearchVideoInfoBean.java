package com.bw.net.bean;

import java.util.List;

public class SearchVideoInfoBean {

    /**
     * _ck : {}
     * data : {"gid":"6436151402837312001","group_source":2,"publish_time":"1498533274","title":"日本推出的\u201c黑暗料理\u201d看上去很恐怖，吃起来一言难尽","content":"<p><div class=\"tt-video-box\" tt-videoid='aa97c92d453047b9aff3fecac5470edc' tt-poster='http://p98.pstatp.com/large/2a400004ade483b3b9b4'>视频加载中...<\/div><script src=\"https://s0.pstatp.com/tt_player/tt.player.js?v=20160723\"><\/script><\/p><p>咖喱 勇者斗恶龙 超辣咖喱 美食 零食 特色小吃 黑暗料理 食物 日本<\/p>","creator_uid":55757463302,"media_id":"1560094012081153","detail_source":"爱开箱","media_user":{"screen_name":"爱开箱","no_display_pgc_icon":false,"avatar_url":"https://p1.pstatp.com/thumb/363f000ee6e665a33458","id":55757463302,"user_auth_info":{"auth_type":"0","auth_info":"优质生活领域创作者","other_auth":{"interest":"优质生活领域创作者"}},"follower_count":"777091","video_count":"472"},"labels":[{"label":"日本地震最新消息","stress_type":0},{"label":"走进日本普通人家","stress_type":0},{"label":"花姐一言难尽","stress_type":0},{"label":"日本旅游有感","stress_type":0},{"label":"一言难尽mv","stress_type":0},{"label":"一言难尽张宇","stress_type":0},{"label":"日本洪水木屋","stress_type":0},{"label":"一言难尽现场版","stress_type":0}],"url":"http://toutiao.com/group/6436151402837312001/","high_quality_flag":"0","impression_count":"75191","is_original":true,"is_pgc_article":true,"is_rumor":false,"source":"爱开箱","comment_count":14,"digg_count":161,"repost_count":926,"logo_show_strategy":"normal","follower_count":"777091","video_play_count":98866,"poster_url":"https://p1.pstatp.com/large/2a400004ade483b3b9b4","in_process":false,"video_id":"aa97c92d453047b9aff3fecac5470edc","is_live_end":false,"video_duration":305}
     * success : true
     */

    private CkBean _ck;
    private DataBean data;
    private boolean success;

    public CkBean get_ck() {
        return _ck;
    }

    public void set_ck(CkBean _ck) {
        this._ck = _ck;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class CkBean {
    }

    public static class DataBean {
        /**
         * gid : 6436151402837312001
         * group_source : 2
         * publish_time : 1498533274
         * title : 日本推出的“黑暗料理”看上去很恐怖，吃起来一言难尽
         * content : <p><div class="tt-video-box" tt-videoid='aa97c92d453047b9aff3fecac5470edc' tt-poster='http://p98.pstatp.com/large/2a400004ade483b3b9b4'>视频加载中...</div><script src="https://s0.pstatp.com/tt_player/tt.player.js?v=20160723"></script></p><p>咖喱 勇者斗恶龙 超辣咖喱 美食 零食 特色小吃 黑暗料理 食物 日本</p>
         * creator_uid : 55757463302
         * media_id : 1560094012081153
         * detail_source : 爱开箱
         * media_user : {"screen_name":"爱开箱","no_display_pgc_icon":false,"avatar_url":"https://p1.pstatp.com/thumb/363f000ee6e665a33458","id":55757463302,"user_auth_info":{"auth_type":"0","auth_info":"优质生活领域创作者","other_auth":{"interest":"优质生活领域创作者"}},"follower_count":"777091","video_count":"472"}
         * labels : [{"label":"日本地震最新消息","stress_type":0},{"label":"走进日本普通人家","stress_type":0},{"label":"花姐一言难尽","stress_type":0},{"label":"日本旅游有感","stress_type":0},{"label":"一言难尽mv","stress_type":0},{"label":"一言难尽张宇","stress_type":0},{"label":"日本洪水木屋","stress_type":0},{"label":"一言难尽现场版","stress_type":0}]
         * url : http://toutiao.com/group/6436151402837312001/
         * high_quality_flag : 0
         * impression_count : 75191
         * is_original : true
         * is_pgc_article : true
         * is_rumor : false
         * source : 爱开箱
         * comment_count : 14
         * digg_count : 161
         * repost_count : 926
         * logo_show_strategy : normal
         * follower_count : 777091
         * video_play_count : 98866
         * poster_url : https://p1.pstatp.com/large/2a400004ade483b3b9b4
         * in_process : false
         * video_id : aa97c92d453047b9aff3fecac5470edc
         * is_live_end : false
         * video_duration : 305
         */

        private String gid;
        private int group_source;
        private String publish_time;
        private String title;
        private String content;
        private long creator_uid;
        private String media_id;
        private String detail_source;
        private MediaUserBean media_user;
        private String url;
        private String high_quality_flag;
        private String impression_count;
        private boolean is_original;
        private boolean is_pgc_article;
        private boolean is_rumor;
        private String source;
        private int comment_count;
        private int digg_count;
        private int repost_count;
        private String logo_show_strategy;
        private String follower_count;
        private int video_play_count;
        private String poster_url;
        private boolean in_process;
        private String video_id;
        private boolean is_live_end;
        private int video_duration;
        private List<LabelsBean> labels;

        public String getGid() {
            return gid;
        }

        public void setGid(String gid) {
            this.gid = gid;
        }

        public int getGroup_source() {
            return group_source;
        }

        public void setGroup_source(int group_source) {
            this.group_source = group_source;
        }

        public String getPublish_time() {
            return publish_time;
        }

        public void setPublish_time(String publish_time) {
            this.publish_time = publish_time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public long getCreator_uid() {
            return creator_uid;
        }

        public void setCreator_uid(long creator_uid) {
            this.creator_uid = creator_uid;
        }

        public String getMedia_id() {
            return media_id;
        }

        public void setMedia_id(String media_id) {
            this.media_id = media_id;
        }

        public String getDetail_source() {
            return detail_source;
        }

        public void setDetail_source(String detail_source) {
            this.detail_source = detail_source;
        }

        public MediaUserBean getMedia_user() {
            return media_user;
        }

        public void setMedia_user(MediaUserBean media_user) {
            this.media_user = media_user;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getHigh_quality_flag() {
            return high_quality_flag;
        }

        public void setHigh_quality_flag(String high_quality_flag) {
            this.high_quality_flag = high_quality_flag;
        }

        public String getImpression_count() {
            return impression_count;
        }

        public void setImpression_count(String impression_count) {
            this.impression_count = impression_count;
        }

        public boolean isIs_original() {
            return is_original;
        }

        public void setIs_original(boolean is_original) {
            this.is_original = is_original;
        }

        public boolean isIs_pgc_article() {
            return is_pgc_article;
        }

        public void setIs_pgc_article(boolean is_pgc_article) {
            this.is_pgc_article = is_pgc_article;
        }

        public boolean isIs_rumor() {
            return is_rumor;
        }

        public void setIs_rumor(boolean is_rumor) {
            this.is_rumor = is_rumor;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public int getComment_count() {
            return comment_count;
        }

        public void setComment_count(int comment_count) {
            this.comment_count = comment_count;
        }

        public int getDigg_count() {
            return digg_count;
        }

        public void setDigg_count(int digg_count) {
            this.digg_count = digg_count;
        }

        public int getRepost_count() {
            return repost_count;
        }

        public void setRepost_count(int repost_count) {
            this.repost_count = repost_count;
        }

        public String getLogo_show_strategy() {
            return logo_show_strategy;
        }

        public void setLogo_show_strategy(String logo_show_strategy) {
            this.logo_show_strategy = logo_show_strategy;
        }

        public String getFollower_count() {
            return follower_count;
        }

        public void setFollower_count(String follower_count) {
            this.follower_count = follower_count;
        }

        public int getVideo_play_count() {
            return video_play_count;
        }

        public void setVideo_play_count(int video_play_count) {
            this.video_play_count = video_play_count;
        }

        public String getPoster_url() {
            return poster_url;
        }

        public void setPoster_url(String poster_url) {
            this.poster_url = poster_url;
        }

        public boolean isIn_process() {
            return in_process;
        }

        public void setIn_process(boolean in_process) {
            this.in_process = in_process;
        }

        public String getVideo_id() {
            return video_id;
        }

        public void setVideo_id(String video_id) {
            this.video_id = video_id;
        }

        public boolean isIs_live_end() {
            return is_live_end;
        }

        public void setIs_live_end(boolean is_live_end) {
            this.is_live_end = is_live_end;
        }

        public int getVideo_duration() {
            return video_duration;
        }

        public void setVideo_duration(int video_duration) {
            this.video_duration = video_duration;
        }

        public List<LabelsBean> getLabels() {
            return labels;
        }

        public void setLabels(List<LabelsBean> labels) {
            this.labels = labels;
        }

        public static class MediaUserBean {
            /**
             * screen_name : 爱开箱
             * no_display_pgc_icon : false
             * avatar_url : https://p1.pstatp.com/thumb/363f000ee6e665a33458
             * id : 55757463302
             * user_auth_info : {"auth_type":"0","auth_info":"优质生活领域创作者","other_auth":{"interest":"优质生活领域创作者"}}
             * follower_count : 777091
             * video_count : 472
             */

            private String screen_name;
            private boolean no_display_pgc_icon;
            private String avatar_url;
            private long id;
            private UserAuthInfoBean user_auth_info;
            private String follower_count;
            private String video_count;

            public String getScreen_name() {
                return screen_name;
            }

            public void setScreen_name(String screen_name) {
                this.screen_name = screen_name;
            }

            public boolean isNo_display_pgc_icon() {
                return no_display_pgc_icon;
            }

            public void setNo_display_pgc_icon(boolean no_display_pgc_icon) {
                this.no_display_pgc_icon = no_display_pgc_icon;
            }

            public String getAvatar_url() {
                return avatar_url;
            }

            public void setAvatar_url(String avatar_url) {
                this.avatar_url = avatar_url;
            }

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public UserAuthInfoBean getUser_auth_info() {
                return user_auth_info;
            }

            public void setUser_auth_info(UserAuthInfoBean user_auth_info) {
                this.user_auth_info = user_auth_info;
            }

            public String getFollower_count() {
                return follower_count;
            }

            public void setFollower_count(String follower_count) {
                this.follower_count = follower_count;
            }

            public String getVideo_count() {
                return video_count;
            }

            public void setVideo_count(String video_count) {
                this.video_count = video_count;
            }

            public static class UserAuthInfoBean {
                /**
                 * auth_type : 0
                 * auth_info : 优质生活领域创作者
                 * other_auth : {"interest":"优质生活领域创作者"}
                 */

                private String auth_type;
                private String auth_info;
                private OtherAuthBean other_auth;

                public String getAuth_type() {
                    return auth_type;
                }

                public void setAuth_type(String auth_type) {
                    this.auth_type = auth_type;
                }

                public String getAuth_info() {
                    return auth_info;
                }

                public void setAuth_info(String auth_info) {
                    this.auth_info = auth_info;
                }

                public OtherAuthBean getOther_auth() {
                    return other_auth;
                }

                public void setOther_auth(OtherAuthBean other_auth) {
                    this.other_auth = other_auth;
                }

                public static class OtherAuthBean {
                    /**
                     * interest : 优质生活领域创作者
                     */

                    private String interest;

                    public String getInterest() {
                        return interest;
                    }

                    public void setInterest(String interest) {
                        this.interest = interest;
                    }
                }
            }
        }

        public static class LabelsBean {
            /**
             * label : 日本地震最新消息
             * stress_type : 0
             */

            private String label;
            private int stress_type;

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public int getStress_type() {
                return stress_type;
            }

            public void setStress_type(int stress_type) {
                this.stress_type = stress_type;
            }
        }
    }
}
