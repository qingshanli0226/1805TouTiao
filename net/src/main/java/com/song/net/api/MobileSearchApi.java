package com.song.net.api;

import com.song.net.mode.mobile.search.SearchRecommentBean;
import com.song.net.mode.mobile.search.SearchSuggestionBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MobileSearchApi {
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
}
