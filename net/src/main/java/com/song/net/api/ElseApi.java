package com.song.net.api;

import com.song.net.UrlHelper;
import com.song.net.mode.mobile.news.MultiNewsArticleBean;
import com.song.net.mode.mobile.search.SearchVideoInfoBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ElseApi {

    /**
     * 获取个性化新闻
     * 深圳 http://is.snssdk.com/api/news/feed/v58/?iid=5034850950&device_id=6096495334&category=news_society
     * 深圳 http://lf.snssdk.com/api/news/feed/v58/?iid=12507202490&device_id=37487219424&category=news_society
     * 天津 http://ib.snssdk.com/api/news/feed/v58/?
     * 北京 http://iu.snssdk.com/api/news/feed/v58/?
     *
     * @param iid      用户ID
     * @param deviceId 设备ID
     * @param category 新闻/图片/视频栏目
     */
    @GET("api/news/feed/v62/?iid=12507202490&device_id=37487219424&refer=1&count=20&aid=13")
    Observable<MultiNewsArticleBean> getNewsArticle2(
            @Query("category") String category,
            @Query("max_behot_time") String maxBehotTime);

    /**
     * 获取搜索视频内容
     * https://m.365yg.com/i6436151402837312001/info/
     */
    @GET
    Observable<SearchVideoInfoBean> getSearchVideoInfo(@Url String url);


    /**
     * 获取图片内容HTML内容
     * 抓取 url 较复杂
     * 详情查看 {@linkplain com.meiji.toutiao.module.photo.content.PhotoContentPresenter#doLoadData(String...)}
     */
    @GET()
    @Headers("User-Agent:" + UrlHelper.USER_AGENT_PC)
    Observable<ResponseBody> getPhotoContentHTML(@Url String url);

    /**
     * 获取头条问答回答正文
     */
    @GET
    @Headers("User-Agent:" + UrlHelper.USER_AGENT_MOBILE)
    Observable<ResponseBody> getWendaAnsDetail(@Url String url);
}
