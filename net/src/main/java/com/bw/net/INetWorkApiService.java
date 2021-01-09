package com.bw.net;

import com.bw.net.bean.MediaProfileBean;
import com.bw.net.bean.MediaWendaBean;
import com.bw.net.bean.MultiMediaArticleBean;
import com.bw.net.bean.MultiNewsArticleBean;
import com.bw.net.bean.NewsArticeBean1;
import com.bw.net.bean.NewsArticeBean2;
import com.bw.net.bean.NewsCommentBean;
import com.bw.net.bean.NewsContentBean;
import com.bw.net.bean.PhotoArticleBean;
import com.bw.net.bean.SearchRecommentBean;
import com.bw.net.bean.SearchResultBean;
import com.bw.net.bean.SearchSuggestionBean;
import com.bw.net.bean.SearchVideoInfoBean;
import com.bw.net.bean.VideoContentBean;
import com.bw.net.bean.WendaArticleBean;
import com.bw.net.bean.WendaContentBean;


import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface INetWorkApiService {


    /**
     * 获取头条号文章
     * http://www.toutiao.com/pgc/ma/?media_id=头条号&page_type=1&count=20&version=2&platform=pc&as=479BB4B7254C150&cp=585DB1871ED64E1&max_behot_time=时间
     * 手机版
     * http://toutiao.com/pgc/ma/?page_type=0&max_behot_time=&media_id=6547479326&output=json&is_json=1&count=20&from=user_profile_app&version=2&as=479BB4B7254C150&cp=58E7182DD50EFE1&callback=jsonp4
     */
    @GET("pgc/ma/?page_type=1&count=20&version=2&platform=pc&as=479BB4B7254C150&cp=585DB1871ED64E1")
    Observable<ResponseBody> getMediaArticle(
            @Query("media_id") String mediaId,
            @Query("max_behot_time") int time
    );

    /**
     * 获取评论请求参数
     */
    @GET
    @Headers("User-Agent:" + Contents.USER_AGENT_MOBILE)
    Call<ResponseBody> getCommentParameter(@Url String url);



    /**
     * 头条号主页信息
     * https://is.snssdk.com/user/profile/homepage/v3/json/?media_id=4377795668&to_html=0&source=article_top_author&refer=all
     *
     * @param mediaId 头条号ID
     */
    @GET("user/profile/homepage/v3/json/?to_html=0&source=article_top_author&refer=all&aid=13")
    Observable<MediaProfileBean> getMediaProfile(
            @Query("media_id") String mediaId);



    /**
     * 获取头条号文章
     * https://is.snssdk.com/pgc/ma/?page_type=1&max_behot_time=1495181160&media_id=52445544609&output=json&is_json=1&count=10&from=user_profile_app&version=2&as=479BB4B7254C150&cp=585DB1871ED64E1
     * @param mediaId      头条号ID
     * @param maxBehotTime 时间轴
     */
    @GET("pgc/ma/?page_type=1&output=json&is_json=1&count=20&from=user_profile_app&version=2")
    Observable<MultiMediaArticleBean> getMediaArticle(
            @Query("media_id") String mediaId,
            @Query("max_behot_time") String maxBehotTime,
            @Query("as") String as,
            @Query("cp") String cp);

    @GET("pgc/ma/?page_type=0&output=json&is_json=1&count=10&from=user_profile_app&version=2")
    Observable<MultiMediaArticleBean> getMediaVideo(
            @Query("media_id") String mediaId,
            @Query("max_behot_time") String maxBehotTime,
            @Query("as") String as,
            @Query("cp") String cp);

    /**
     * 获取头条号问答
     * https://is.snssdk.com/wenda/profile/wendatab/brow/?other_id=6619635172&format=json&from_channel=media_channel
     *
     * @param mediaId 头条号ID
     */
    @GET("wenda/profile/wendatab/brow/?format=json&from_channel=media_channel")
    Observable<MediaWendaBean> getMediaWenda(
            @Query("other_id") String mediaId);


    /**
     * 获取头条号动态
     * https://is.snssdk.com/dongtai/list/v11/?user_id=6619635172&max_cursor=1494916016999
     *
     * @param mediaId   头条号ID
     * @param maxCursor 偏移量
     */
    @GET("dongtai/list/v11/?")
    Call<ResponseBody> getMediaDongtai(
            @Query("user_id") String mediaId,
            @Query("max_cursor") int maxCursor);

    /**
     * 获取个性化新闻
     * 深圳 http://is.snssdk.com/api/news/feed/v58/?iid=5034850950&device_id=6096495334&category=news_society
     * 深圳 http://lf.snssdk.com/api/news/feed/v58/?iid=12507202490&device_id=37487219424&category=news_society
     * 天津 http://ib.snssdk.com/api/news/feed/v58/?
     * 北京 http://iu.snssdk.com/api/news/feed/v58/?
     * @param iid      用户ID
     * @param deviceId 设备ID
     * @param category 新闻/图片/视频栏目
     */
    @GET("api/news/feed/v58/?iid=5034850950&device_id=6096495334&category=news_society")
    Observable<NewsArticeBean1> getNewsArticle();

    @GET("api/news/feed/v62/?iid=5034850950&device_id=6096495334&refer=1&count=20&aid=13")
    Observable<MultiNewsArticleBean> getNewsArticle(
            @Query("category") String category,
            @Query("max_behot_time") String maxBehotTime);


    @GET("api/news/feed/v62/?iid=12507202490&device_id=37487219424&refer=1&count=20&aid=13")
    Observable<MultiNewsArticleBean> getNewsArticle2(
            @Query("category") String category,
            @Query("max_behot_time") String maxBehotTime);


    /**
     * 获取新闻评论
     * 按热度排序
     * http://is.snssdk.com/article/v53/tab_comments/?group_id=6314103921648926977&offset=0&tab_index=0
     * 按时间排序
     * http://is.snssdk.com/article/v53/tab_comments/?group_id=6314103921648926977&offset=0&tab_index=1
     *
     * @param groupId 新闻ID
     * @param offset  偏移量
     */
    @GET("article/v53/tab_comments/")
    Observable<NewsCommentBean> getNewsComment(
            @Query("group_id") String groupId,
            @Query("offset") int offset);


    /**
     * 获取搜索建议
     * http://is.snssdk.com/2/article/search_sug/?keyword=3&from=search_tab&iid=10344168417&device_id=36394312781
     *
     * @param keyword 搜索内容
     */
    @GET("2/article/search_sug/?from=search_tab&iid=10344168417&device_id=36394312781")
    Observable<SearchSuggestionBean> getSearchSuggestion(@Query("keyword") String keyword);


    /**
     * 获取搜索结果
     * http://is.snssdk.com/api/2/wap/search_content/?from=search_tab&keyword=123&iid=10344168417&device_id=36394312781&count=10&cur_tab=1&format=json&offset=20
     *
     * @param keyword 搜索内容
     * @param curTab  搜索栏目 1综合 2视频 3图集 4用户 5问答
     * @param offset  偏移量
     */
    @GET("api/2/wap/search_content/?from=search_tab&iid=12507202490&device_id=37487219424&count=10&format=json")
    Observable<SearchResultBean> getSearchResult(
            @Query("keyword") String keyword,
            @Query("cur_tab") String curTab,
            @Query("offset") int offset);

    @GET("api/2/wap/search_content/?from=search_tab&iid=12507202490&device_id=37487219424&count=10&format=json")
    Observable<ResponseBody> getSearchResult2(
            @Query("keyword") String keyword,
            @Query("cur_tab") String curTab,
            @Query("offset") int offset);


    /**
     * 获取搜索推荐
     * http://is.snssdk.com/search/suggest/wap/initial_page/?from=feed&sug_category=__all__&iid=10344168417&device_id=36394312781&format=json
     */
    @GET("search/suggest/wap/initial_page/?from=feed&sug_category=__all__&iid=10344168417&device_id=36394312781&format=json")
    Observable<SearchRecommentBean> getSearchRecomment();

    /**
     * 获取搜索视频内容
     * https://m.365yg.com/i6436151402837312001/info/
     */
    @GET
    Observable<SearchVideoInfoBean> getSearchVideoInfo(@Url String url);


    /**
     * 获取视频标题等信息
     * http://is.snssdk.com/api/news/feed/v53/?category=subv_cute&refer=1&count=20&max_behot_time=1499321562&iid=11776029171&device_id=36394312781
     */
    @GET("news/feed/v62/?iid=5034850950&device_id=6096495334&refer=1&count=20&aid=13")
    Observable<MultiNewsArticleBean> getVideoArticle(
            @Query("category") String category,
            @Query("max_behot_time") String maxBehotTime);


    /**
     * 获取视频信息
     * Api 生成较复杂 详情查看 {@linkplain com.meiji.toutiao.module.video.content.VideoContentPresenter#doLoadVideoData(String)}
     * http://ib.365yg.com/video/urls/v/1/toutiao/mp4/视频ID?r=17位随机数&s=加密结果
     */
    @GET
    Observable<VideoContentBean> getVideoContent(@Url String url);

    /**
     * 获取头条问答标题等信息
     * http://is.snssdk.com/wenda/v1/native/feedbrow/?category=question_and_answer&wd_version=5&count=20&max_behot_time=1495245397?iid=10344168417&device_id=36394312781
     * @param maxBehotTime 时间轴
     */
    @GET("wenda/v1/native/feedbrow/?iid=10344168417&device_id=36394312781&category=question_and_answer&wd_version=5&count=20&aid=13")
    Observable<WendaArticleBean> getWendaArticle(
            @Query("max_behot_time") String maxBehotTime);

    /**
     * 获取头条问答优质回答
     * http://is.snssdk.com/wenda/v1/question/brow/?iid=10344168417&device_id=36394312781
     *
     * @param qid 问答ID
     */
    @POST("wenda/v1/question/brow/?iid=10344168417&device_id=36394312781")
    @FormUrlEncoded
    Observable<WendaContentBean> getWendaNiceContent(@Field("qid") String qid);


    /**
     * 获取头条问答优质回答(加载更多)
     * http://is.snssdk.com/wenda/v1/question/loadmore/?iid=10344168417&device_id=36394312781
     *
     * @param qid    问答ID
     * @param offset 偏移量
     */
    @POST("wenda/v1/question/loadmore/?iid=10344168417&device_id=36394312781")
    @FormUrlEncoded
    Observable<WendaContentBean> getWendaNiceContentLoadMore(
            @Field("qid") String qid,
            @Field("offset") int offset);

    /**
     * 获取头条问答普通回答
     * http://is.snssdk.com/wenda/v1/questionother/brow/?iid=10344168417&device_id=36394312781
     *
     * @param qid 问答ID
     */
    @POST("wenda/v1/questionother/brow/?iid=10344168417&device_id=36394312781")
    @FormUrlEncoded
    Observable<WendaContentBean> getWendaNormalContent(@Field("qid") String qid);

    /**
     * 获取头条问答普通回答(加载更多)
     * http://is.snssdk.com/wenda/v1/questionother/loadmore/?iid=10344168417&device_id=36394312781
     *
     * @param qid    问答ID
     * @param offset 偏移量
     */
    @POST("wenda/v1/questionother/loadmore/?iid=10344168417&device_id=36394312781")
    @FormUrlEncoded
    Observable<WendaContentBean> getWendaNormalContentLoadMore(
            @Field("qid") String qid,
            @Field("offset") int offset);

    /**
     * 获取头条问答回答正文
     */
    @GET
    @Headers("User-Agent:" + Contents.USER_AGENT_MOBILE)
    Observable<ResponseBody> getWendaAnsDetail(@Url String url);


    //分割线==============================================================


    /**
     * 获取新闻内容的API
     */
    @GET
    @Headers("User-Agent:" + Contents.USER_AGENT_MOBILE)
    Call<ResponseBody> getNewsContentRedirectUrl(@Url String url);


    /**
     * 获取新闻HTML内容
     * http://m.toutiao.com/i6364969235889783298/info/
     */
    @GET("/i6364969235889783298/info/")
    Observable<NewsContentBean> getNewsContent();


    /**
     * 获取新闻评论
     * http://www.toutiao.com/api/comment/list/?group_id=头条号&item_id=文章号&offset=偏移量&count=数量
     */
    @GET("api/comment/list/?count=10")
    Call<ResponseBody> getNewsComment(
            @Query("group_id") String groupId,
            @Query("item_id") String itemId,
            @Query("offset") int offset);


    /**
     * 获取图片标题等信息
     * http://www.toutiao.com/api/article/feed/?category=类型&as=A115C8457F69B85&cp=585F294B8845EE1&_=时间&count=30
     */
    @GET("api/pc/feed/?as=A115C8457F69B85&cp=585F294B8845EE1&_signature=l")
    Observable<PhotoArticleBean> getPhotoArticle(
            @Query("category") String category,
            @Query("max_behot_time") String time);

    /**
     * 获取图片内容HTML内容
     * 抓取 url 较复杂
     * 详情查看 {@linkplain com.meiji.toutiao.module.photo.content.PhotoContentPresenter#doLoadData(String...)}
     */
    @GET()
    @Headers("User-Agent:" + Contents.USER_AGENT_PC)
    Call<ResponseBody> getPhotoContentHTML(@Url String url);

    /**
     * 获取搜索文章标题等信息
     * http://www.toutiao.com/search_content/?format=json&keyword=关键词&autoload=true&count=20&cur_tab=1&offset=偏移量
     */
    @GET("search_content/?format=json&autoload=true&count=20&cur_tab=1")
    Call<ResponseBody> getSearch(
            @Query("keyword") String keyword,
            @Query("offset") int offset);


//    /**
//     * 获取视频标题等信息
//     * http://toutiao.com/api/article/recent/?source=2&category=类型&as=A105177907376A5&cp=5797C7865AD54E1&count=20"
//     */
//    @GET("api/article/recent/?source=2&as=A105177907376A5&cp=5797C7865AD54E1&count=30")
//    Observable<ResponseBody> getVideoArticle(
//            @Query("category") String category,
//            @Query("_") String time);
//
//    /**
//     * 获取视频信息
//     * Api 生成较复杂 详情查看 {@linkplain com.meiji.toutiao.module.video.content.VideoContentPresenter#doLoadVideoData(String)}
//     * http://ib.365yg.com/video/urls/v/1/toutiao/mp4/视频ID?r=17位随机数&s=加密结果
//     */
//    @GET
//    Observable<VideoContentBean> getVideoContent(@Url String url);
//

}
