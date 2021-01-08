package com.bw.net.bean;

import java.util.List;

public class WendaContentBean {


    /**
     * err_no : 0
     * err_tips :
     * offset : 0
     * api_param : {"enter_from":"","origin_from":""}
     * ans_list : []
     * has_more : false
     * related_question_banner_type : 0
     * related_question_reason_url : sslocal://detail?groupid=6765352884386136589
     * can_answer : true
     * candidate_invite_user : []
     * module_list : [{"day_icon_url":"http://p3-tt-ipv6.byteimg.com/origin/1bf50001abbc1c7f8dba","night_icon_url":"http://p6-tt-ipv6.byteimg.com/origin/1bf40001abebc0717135","text":"更多问答","schema":"sslocal://feed?api_param=%7B%22enter_from%22%3A%22%22%2C%22origin_from%22%3A%22%22%2C%22source%22%3A%22question_brow%22%7D&category=question_and_answer&concern_id=6260258266329123329&name=%E5%9B%9E%E7%AD%94&type=4","icon_type":2}]
     * module_count : 1
     * question_header_content_fold_max_count : 1
     * show_format : {"font_size":"18","show_module":1,"answer_full_context_color":0}
     * question : {"qid":"11","post_answer_url":"sslocal://wenda_post?extra_publisher_default_tab_index=0&qTitle=&qid=11","is_follow":false,"nice_ans_count":0,"normal_ans_count":0,"follow_count":0,"create_time":0,"can_edit":true,"show_edit":true,"can_public_edit":false,"show_public_edit":false,"can_delete":false,"show_delete":true,"show_tag_module":false,"title":"","concern_tag_list":[],"user":{"uname":"","avatar_url":"","user_id":"0","is_verify":0,"user_intro":"","is_following":0,"user_auth_info":"","schema":"sslocal://profile?category_name=answer_hot&from_page=list_question_author&group_id=11&refer=wenda&uid=0","user_schema":"sslocal://profile?category_name=answer_hot&from_page=list_question_author&group_id=11&refer=wenda&uid=0","desc_icon_url":""},"share_data":{"content":"0个回答，0人收藏","image_url":"http://p3-tt-ipv6.byteimg.com/origin/18a300102cab5d8d0e05","share_url":"https://m.zjurl.cn/question/11/?app=news_article&app_id=0","title":"(0个回答) - 悟空问答"},"content":{"text":"","thumb_image_list":[],"large_image_list":[],"origin_image_list":null,"rich_text":"","content_rich_span":"{\"links\":[]}"},"fold_reason":{"open_url":"sslocal://detail?groupid=6293724675596402946","title":"为什么折叠?"},"is_anonymous":0,"share_info":{"share_type":{"pyq":0,"qq":0,"qzone":0,"wx":0},"token_type":1,"share_url":"https://m.zjurl.cn/question/11/?app=news_article&app_id=0","title":"(0个回答) - 悟空问答"},"count_statistics":[{"count_name":"收藏量","count_num":"0","count_type":1}],"hidden_answer":"","qid_type":"unsub_qid","tips":{"tips_type":0,"tips_text":"","tips_schema":"","tips_button_text":""},"dispute_info":null,"is_public_edit":false,"show_modify_record":false,"modify_record_schema":"","public_edit_reasons":null,"need_user_name":false,"show_count":0,"show_text":"","can_not_edit_reason":""}
     * has_profit : false
     * repost_params : {"repost_type":218,"fw_id":11,"fw_id_type":1026,"fw_user_id":0,"opt_id":11,"opt_id_type":1026,"schema":"","title":"","cover_url":"http://p3-tt-ipv6.byteimg.com/origin/18a300102cab5d8d0e05"}
     */

    private int err_no;
    private String err_tips;
    private int offset;
    private String api_param;
    private boolean has_more;
    private int related_question_banner_type;
    private String related_question_reason_url;
    private boolean can_answer;
    private int module_count;
    private int question_header_content_fold_max_count;
    private ShowFormatBean show_format;
    private QuestionBean question;
    private boolean has_profit;
    private RepostParamsBean repost_params;
    private List<?> ans_list;
    private List<?> candidate_invite_user;
    private List<ModuleListBean> module_list;

    public int getErr_no() {
        return err_no;
    }

    public void setErr_no(int err_no) {
        this.err_no = err_no;
    }

    public String getErr_tips() {
        return err_tips;
    }

    public void setErr_tips(String err_tips) {
        this.err_tips = err_tips;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getApi_param() {
        return api_param;
    }

    public void setApi_param(String api_param) {
        this.api_param = api_param;
    }

    public boolean isHas_more() {
        return has_more;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }

    public int getRelated_question_banner_type() {
        return related_question_banner_type;
    }

    public void setRelated_question_banner_type(int related_question_banner_type) {
        this.related_question_banner_type = related_question_banner_type;
    }

    public String getRelated_question_reason_url() {
        return related_question_reason_url;
    }

    public void setRelated_question_reason_url(String related_question_reason_url) {
        this.related_question_reason_url = related_question_reason_url;
    }

    public boolean isCan_answer() {
        return can_answer;
    }

    public void setCan_answer(boolean can_answer) {
        this.can_answer = can_answer;
    }

    public int getModule_count() {
        return module_count;
    }

    public void setModule_count(int module_count) {
        this.module_count = module_count;
    }

    public int getQuestion_header_content_fold_max_count() {
        return question_header_content_fold_max_count;
    }

    public void setQuestion_header_content_fold_max_count(int question_header_content_fold_max_count) {
        this.question_header_content_fold_max_count = question_header_content_fold_max_count;
    }

    public ShowFormatBean getShow_format() {
        return show_format;
    }

    public void setShow_format(ShowFormatBean show_format) {
        this.show_format = show_format;
    }

    public QuestionBean getQuestion() {
        return question;
    }

    public void setQuestion(QuestionBean question) {
        this.question = question;
    }

    public boolean isHas_profit() {
        return has_profit;
    }

    public void setHas_profit(boolean has_profit) {
        this.has_profit = has_profit;
    }

    public RepostParamsBean getRepost_params() {
        return repost_params;
    }

    public void setRepost_params(RepostParamsBean repost_params) {
        this.repost_params = repost_params;
    }

    public List<?> getAns_list() {
        return ans_list;
    }

    public void setAns_list(List<?> ans_list) {
        this.ans_list = ans_list;
    }

    public List<?> getCandidate_invite_user() {
        return candidate_invite_user;
    }

    public void setCandidate_invite_user(List<?> candidate_invite_user) {
        this.candidate_invite_user = candidate_invite_user;
    }

    public List<ModuleListBean> getModule_list() {
        return module_list;
    }

    public void setModule_list(List<ModuleListBean> module_list) {
        this.module_list = module_list;
    }

    public static class ShowFormatBean {
        /**
         * font_size : 18
         * show_module : 1
         * answer_full_context_color : 0
         */

        private String font_size;
        private int show_module;
        private int answer_full_context_color;

        public String getFont_size() {
            return font_size;
        }

        public void setFont_size(String font_size) {
            this.font_size = font_size;
        }

        public int getShow_module() {
            return show_module;
        }

        public void setShow_module(int show_module) {
            this.show_module = show_module;
        }

        public int getAnswer_full_context_color() {
            return answer_full_context_color;
        }

        public void setAnswer_full_context_color(int answer_full_context_color) {
            this.answer_full_context_color = answer_full_context_color;
        }
    }

    public static class QuestionBean {
        /**
         * qid : 11
         * post_answer_url : sslocal://wenda_post?extra_publisher_default_tab_index=0&qTitle=&qid=11
         * is_follow : false
         * nice_ans_count : 0
         * normal_ans_count : 0
         * follow_count : 0
         * create_time : 0
         * can_edit : true
         * show_edit : true
         * can_public_edit : false
         * show_public_edit : false
         * can_delete : false
         * show_delete : true
         * show_tag_module : false
         * title :
         * concern_tag_list : []
         * user : {"uname":"","avatar_url":"","user_id":"0","is_verify":0,"user_intro":"","is_following":0,"user_auth_info":"","schema":"sslocal://profile?category_name=answer_hot&from_page=list_question_author&group_id=11&refer=wenda&uid=0","user_schema":"sslocal://profile?category_name=answer_hot&from_page=list_question_author&group_id=11&refer=wenda&uid=0","desc_icon_url":""}
         * share_data : {"content":"0个回答，0人收藏","image_url":"http://p3-tt-ipv6.byteimg.com/origin/18a300102cab5d8d0e05","share_url":"https://m.zjurl.cn/question/11/?app=news_article&app_id=0","title":"(0个回答) - 悟空问答"}
         * content : {"text":"","thumb_image_list":[],"large_image_list":[],"origin_image_list":null,"rich_text":"","content_rich_span":"{\"links\":[]}"}
         * fold_reason : {"open_url":"sslocal://detail?groupid=6293724675596402946","title":"为什么折叠?"}
         * is_anonymous : 0
         * share_info : {"share_type":{"pyq":0,"qq":0,"qzone":0,"wx":0},"token_type":1,"share_url":"https://m.zjurl.cn/question/11/?app=news_article&app_id=0","title":"(0个回答) - 悟空问答"}
         * count_statistics : [{"count_name":"收藏量","count_num":"0","count_type":1}]
         * hidden_answer :
         * qid_type : unsub_qid
         * tips : {"tips_type":0,"tips_text":"","tips_schema":"","tips_button_text":""}
         * dispute_info : null
         * is_public_edit : false
         * show_modify_record : false
         * modify_record_schema :
         * public_edit_reasons : null
         * need_user_name : false
         * show_count : 0
         * show_text :
         * can_not_edit_reason :
         */

        private String qid;
        private String post_answer_url;
        private boolean is_follow;
        private int nice_ans_count;
        private int normal_ans_count;
        private int follow_count;
        private int create_time;
        private boolean can_edit;
        private boolean show_edit;
        private boolean can_public_edit;
        private boolean show_public_edit;
        private boolean can_delete;
        private boolean show_delete;
        private boolean show_tag_module;
        private String title;
        private UserBean user;
        private ShareDataBean share_data;
        private ContentBean content;
        private FoldReasonBean fold_reason;
        private int is_anonymous;
        private ShareInfoBean share_info;
        private String hidden_answer;
        private String qid_type;
        private TipsBean tips;
        private Object dispute_info;
        private boolean is_public_edit;
        private boolean show_modify_record;
        private String modify_record_schema;
        private Object public_edit_reasons;
        private boolean need_user_name;
        private int show_count;
        private String show_text;
        private String can_not_edit_reason;
        private List<?> concern_tag_list;
        private List<CountStatisticsBean> count_statistics;

        public String getQid() {
            return qid;
        }

        public void setQid(String qid) {
            this.qid = qid;
        }

        public String getPost_answer_url() {
            return post_answer_url;
        }

        public void setPost_answer_url(String post_answer_url) {
            this.post_answer_url = post_answer_url;
        }

        public boolean isIs_follow() {
            return is_follow;
        }

        public void setIs_follow(boolean is_follow) {
            this.is_follow = is_follow;
        }

        public int getNice_ans_count() {
            return nice_ans_count;
        }

        public void setNice_ans_count(int nice_ans_count) {
            this.nice_ans_count = nice_ans_count;
        }

        public int getNormal_ans_count() {
            return normal_ans_count;
        }

        public void setNormal_ans_count(int normal_ans_count) {
            this.normal_ans_count = normal_ans_count;
        }

        public int getFollow_count() {
            return follow_count;
        }

        public void setFollow_count(int follow_count) {
            this.follow_count = follow_count;
        }

        public int getCreate_time() {
            return create_time;
        }

        public void setCreate_time(int create_time) {
            this.create_time = create_time;
        }

        public boolean isCan_edit() {
            return can_edit;
        }

        public void setCan_edit(boolean can_edit) {
            this.can_edit = can_edit;
        }

        public boolean isShow_edit() {
            return show_edit;
        }

        public void setShow_edit(boolean show_edit) {
            this.show_edit = show_edit;
        }

        public boolean isCan_public_edit() {
            return can_public_edit;
        }

        public void setCan_public_edit(boolean can_public_edit) {
            this.can_public_edit = can_public_edit;
        }

        public boolean isShow_public_edit() {
            return show_public_edit;
        }

        public void setShow_public_edit(boolean show_public_edit) {
            this.show_public_edit = show_public_edit;
        }

        public boolean isCan_delete() {
            return can_delete;
        }

        public void setCan_delete(boolean can_delete) {
            this.can_delete = can_delete;
        }

        public boolean isShow_delete() {
            return show_delete;
        }

        public void setShow_delete(boolean show_delete) {
            this.show_delete = show_delete;
        }

        public boolean isShow_tag_module() {
            return show_tag_module;
        }

        public void setShow_tag_module(boolean show_tag_module) {
            this.show_tag_module = show_tag_module;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public ShareDataBean getShare_data() {
            return share_data;
        }

        public void setShare_data(ShareDataBean share_data) {
            this.share_data = share_data;
        }

        public ContentBean getContent() {
            return content;
        }

        public void setContent(ContentBean content) {
            this.content = content;
        }

        public FoldReasonBean getFold_reason() {
            return fold_reason;
        }

        public void setFold_reason(FoldReasonBean fold_reason) {
            this.fold_reason = fold_reason;
        }

        public int getIs_anonymous() {
            return is_anonymous;
        }

        public void setIs_anonymous(int is_anonymous) {
            this.is_anonymous = is_anonymous;
        }

        public ShareInfoBean getShare_info() {
            return share_info;
        }

        public void setShare_info(ShareInfoBean share_info) {
            this.share_info = share_info;
        }

        public String getHidden_answer() {
            return hidden_answer;
        }

        public void setHidden_answer(String hidden_answer) {
            this.hidden_answer = hidden_answer;
        }

        public String getQid_type() {
            return qid_type;
        }

        public void setQid_type(String qid_type) {
            this.qid_type = qid_type;
        }

        public TipsBean getTips() {
            return tips;
        }

        public void setTips(TipsBean tips) {
            this.tips = tips;
        }

        public Object getDispute_info() {
            return dispute_info;
        }

        public void setDispute_info(Object dispute_info) {
            this.dispute_info = dispute_info;
        }

        public boolean isIs_public_edit() {
            return is_public_edit;
        }

        public void setIs_public_edit(boolean is_public_edit) {
            this.is_public_edit = is_public_edit;
        }

        public boolean isShow_modify_record() {
            return show_modify_record;
        }

        public void setShow_modify_record(boolean show_modify_record) {
            this.show_modify_record = show_modify_record;
        }

        public String getModify_record_schema() {
            return modify_record_schema;
        }

        public void setModify_record_schema(String modify_record_schema) {
            this.modify_record_schema = modify_record_schema;
        }

        public Object getPublic_edit_reasons() {
            return public_edit_reasons;
        }

        public void setPublic_edit_reasons(Object public_edit_reasons) {
            this.public_edit_reasons = public_edit_reasons;
        }

        public boolean isNeed_user_name() {
            return need_user_name;
        }

        public void setNeed_user_name(boolean need_user_name) {
            this.need_user_name = need_user_name;
        }

        public int getShow_count() {
            return show_count;
        }

        public void setShow_count(int show_count) {
            this.show_count = show_count;
        }

        public String getShow_text() {
            return show_text;
        }

        public void setShow_text(String show_text) {
            this.show_text = show_text;
        }

        public String getCan_not_edit_reason() {
            return can_not_edit_reason;
        }

        public void setCan_not_edit_reason(String can_not_edit_reason) {
            this.can_not_edit_reason = can_not_edit_reason;
        }

        public List<?> getConcern_tag_list() {
            return concern_tag_list;
        }

        public void setConcern_tag_list(List<?> concern_tag_list) {
            this.concern_tag_list = concern_tag_list;
        }

        public List<CountStatisticsBean> getCount_statistics() {
            return count_statistics;
        }

        public void setCount_statistics(List<CountStatisticsBean> count_statistics) {
            this.count_statistics = count_statistics;
        }

        public static class UserBean {
            /**
             * uname :
             * avatar_url :
             * user_id : 0
             * is_verify : 0
             * user_intro :
             * is_following : 0
             * user_auth_info :
             * schema : sslocal://profile?category_name=answer_hot&from_page=list_question_author&group_id=11&refer=wenda&uid=0
             * user_schema : sslocal://profile?category_name=answer_hot&from_page=list_question_author&group_id=11&refer=wenda&uid=0
             * desc_icon_url :
             */

            private String uname;
            private String avatar_url;
            private String user_id;
            private int is_verify;
            private String user_intro;
            private int is_following;
            private String user_auth_info;
            private String schema;
            private String user_schema;
            private String desc_icon_url;

            public String getUname() {
                return uname;
            }

            public void setUname(String uname) {
                this.uname = uname;
            }

            public String getAvatar_url() {
                return avatar_url;
            }

            public void setAvatar_url(String avatar_url) {
                this.avatar_url = avatar_url;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public int getIs_verify() {
                return is_verify;
            }

            public void setIs_verify(int is_verify) {
                this.is_verify = is_verify;
            }

            public String getUser_intro() {
                return user_intro;
            }

            public void setUser_intro(String user_intro) {
                this.user_intro = user_intro;
            }

            public int getIs_following() {
                return is_following;
            }

            public void setIs_following(int is_following) {
                this.is_following = is_following;
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

            public String getUser_schema() {
                return user_schema;
            }

            public void setUser_schema(String user_schema) {
                this.user_schema = user_schema;
            }

            public String getDesc_icon_url() {
                return desc_icon_url;
            }

            public void setDesc_icon_url(String desc_icon_url) {
                this.desc_icon_url = desc_icon_url;
            }
        }

        public static class ShareDataBean {
            /**
             * content : 0个回答，0人收藏
             * image_url : http://p3-tt-ipv6.byteimg.com/origin/18a300102cab5d8d0e05
             * share_url : https://m.zjurl.cn/question/11/?app=news_article&app_id=0
             * title : (0个回答) - 悟空问答
             */

            private String content;
            private String image_url;
            private String share_url;
            private String title;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getImage_url() {
                return image_url;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
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
        }

        public static class ContentBean {
            /**
             * text :
             * thumb_image_list : []
             * large_image_list : []
             * origin_image_list : null
             * rich_text :
             * content_rich_span : {"links":[]}
             */

            private String text;
            private Object origin_image_list;
            private String rich_text;
            private String content_rich_span;
            private List<?> thumb_image_list;
            private List<?> large_image_list;

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public Object getOrigin_image_list() {
                return origin_image_list;
            }

            public void setOrigin_image_list(Object origin_image_list) {
                this.origin_image_list = origin_image_list;
            }

            public String getRich_text() {
                return rich_text;
            }

            public void setRich_text(String rich_text) {
                this.rich_text = rich_text;
            }

            public String getContent_rich_span() {
                return content_rich_span;
            }

            public void setContent_rich_span(String content_rich_span) {
                this.content_rich_span = content_rich_span;
            }

            public List<?> getThumb_image_list() {
                return thumb_image_list;
            }

            public void setThumb_image_list(List<?> thumb_image_list) {
                this.thumb_image_list = thumb_image_list;
            }

            public List<?> getLarge_image_list() {
                return large_image_list;
            }

            public void setLarge_image_list(List<?> large_image_list) {
                this.large_image_list = large_image_list;
            }
        }

        public static class FoldReasonBean {
            /**
             * open_url : sslocal://detail?groupid=6293724675596402946
             * title : 为什么折叠?
             */

            private String open_url;
            private String title;

            public String getOpen_url() {
                return open_url;
            }

            public void setOpen_url(String open_url) {
                this.open_url = open_url;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }

        public static class ShareInfoBean {
            /**
             * share_type : {"pyq":0,"qq":0,"qzone":0,"wx":0}
             * token_type : 1
             * share_url : https://m.zjurl.cn/question/11/?app=news_article&app_id=0
             * title : (0个回答) - 悟空问答
             */

            private ShareTypeBean share_type;
            private int token_type;
            private String share_url;
            private String title;

            public ShareTypeBean getShare_type() {
                return share_type;
            }

            public void setShare_type(ShareTypeBean share_type) {
                this.share_type = share_type;
            }

            public int getToken_type() {
                return token_type;
            }

            public void setToken_type(int token_type) {
                this.token_type = token_type;
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

            public static class ShareTypeBean {
                /**
                 * pyq : 0
                 * qq : 0
                 * qzone : 0
                 * wx : 0
                 */

                private int pyq;
                private int qq;
                private int qzone;
                private int wx;

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

        public static class TipsBean {
            /**
             * tips_type : 0
             * tips_text :
             * tips_schema :
             * tips_button_text :
             */

            private int tips_type;
            private String tips_text;
            private String tips_schema;
            private String tips_button_text;

            public int getTips_type() {
                return tips_type;
            }

            public void setTips_type(int tips_type) {
                this.tips_type = tips_type;
            }

            public String getTips_text() {
                return tips_text;
            }

            public void setTips_text(String tips_text) {
                this.tips_text = tips_text;
            }

            public String getTips_schema() {
                return tips_schema;
            }

            public void setTips_schema(String tips_schema) {
                this.tips_schema = tips_schema;
            }

            public String getTips_button_text() {
                return tips_button_text;
            }

            public void setTips_button_text(String tips_button_text) {
                this.tips_button_text = tips_button_text;
            }
        }

        public static class CountStatisticsBean {
            /**
             * count_name : 收藏量
             * count_num : 0
             * count_type : 1
             */

            private String count_name;
            private String count_num;
            private int count_type;

            public String getCount_name() {
                return count_name;
            }

            public void setCount_name(String count_name) {
                this.count_name = count_name;
            }

            public String getCount_num() {
                return count_num;
            }

            public void setCount_num(String count_num) {
                this.count_num = count_num;
            }

            public int getCount_type() {
                return count_type;
            }

            public void setCount_type(int count_type) {
                this.count_type = count_type;
            }
        }
    }

    public static class RepostParamsBean {
        /**
         * repost_type : 218
         * fw_id : 11
         * fw_id_type : 1026
         * fw_user_id : 0
         * opt_id : 11
         * opt_id_type : 1026
         * schema :
         * title :
         * cover_url : http://p3-tt-ipv6.byteimg.com/origin/18a300102cab5d8d0e05
         */

        private int repost_type;
        private int fw_id;
        private int fw_id_type;
        private int fw_user_id;
        private int opt_id;
        private int opt_id_type;
        private String schema;
        private String title;
        private String cover_url;

        public int getRepost_type() {
            return repost_type;
        }

        public void setRepost_type(int repost_type) {
            this.repost_type = repost_type;
        }

        public int getFw_id() {
            return fw_id;
        }

        public void setFw_id(int fw_id) {
            this.fw_id = fw_id;
        }

        public int getFw_id_type() {
            return fw_id_type;
        }

        public void setFw_id_type(int fw_id_type) {
            this.fw_id_type = fw_id_type;
        }

        public int getFw_user_id() {
            return fw_user_id;
        }

        public void setFw_user_id(int fw_user_id) {
            this.fw_user_id = fw_user_id;
        }

        public int getOpt_id() {
            return opt_id;
        }

        public void setOpt_id(int opt_id) {
            this.opt_id = opt_id;
        }

        public int getOpt_id_type() {
            return opt_id_type;
        }

        public void setOpt_id_type(int opt_id_type) {
            this.opt_id_type = opt_id_type;
        }

        public String getSchema() {
            return schema;
        }

        public void setSchema(String schema) {
            this.schema = schema;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCover_url() {
            return cover_url;
        }

        public void setCover_url(String cover_url) {
            this.cover_url = cover_url;
        }
    }

    public static class ModuleListBean {
        /**
         * day_icon_url : http://p3-tt-ipv6.byteimg.com/origin/1bf50001abbc1c7f8dba
         * night_icon_url : http://p6-tt-ipv6.byteimg.com/origin/1bf40001abebc0717135
         * text : 更多问答
         * schema : sslocal://feed?api_param=%7B%22enter_from%22%3A%22%22%2C%22origin_from%22%3A%22%22%2C%22source%22%3A%22question_brow%22%7D&category=question_and_answer&concern_id=6260258266329123329&name=%E5%9B%9E%E7%AD%94&type=4
         * icon_type : 2
         */

        private String day_icon_url;
        private String night_icon_url;
        private String text;
        private String schema;
        private int icon_type;

        public String getDay_icon_url() {
            return day_icon_url;
        }

        public void setDay_icon_url(String day_icon_url) {
            this.day_icon_url = day_icon_url;
        }

        public String getNight_icon_url() {
            return night_icon_url;
        }

        public void setNight_icon_url(String night_icon_url) {
            this.night_icon_url = night_icon_url;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getSchema() {
            return schema;
        }

        public void setSchema(String schema) {
            this.schema = schema;
        }

        public int getIcon_type() {
            return icon_type;
        }

        public void setIcon_type(int icon_type) {
            this.icon_type = icon_type;
        }
    }
}
