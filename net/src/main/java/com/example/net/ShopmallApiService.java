package com.example.net;

import com.example.common.news.NewsBean;
import com.example.common.picture.PictureBean;
import com.example.common.search.SearchBean;
import com.example.common.search.SearchDataBean;
import com.example.common.video.VideoBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ShopmallApiService {

//IS
    //获取推荐  &category=__all__&max_behot_time=1609981326
    @GET("api/news/feed/v62/?iid=5034850950&device_id=6096495334&refer=1&count=20&aid=13")
    Observable<NewsBean>getrecommend(@Query("category") String category,@Query("max_behot_time")String time);

    //搜索热推
    @GET("search/suggest/wap/initial_page/?from=feed&sug_category=__all__&iid=10344168417&device_id=36394312781&format=json")
    Observable<SearchBean>getsearch();
    //搜索
    @GET("2/article/search_sug/?from=search_tab&iid=10344168417&device_id=36394312781")
    Observable<SearchDataBean>getsearchdata(@Query("keyword")String keyword);
  /*  //具体搜索
    @GET("api/2/wap/search_content/?from=search_tab&iid=12507202490&device_id=37487219424&count=10&format=json&keyword=%E7%89%B9%E6%9C%97%E6%99%AE%E6%9C%80%E6%96%B0%E5%BF%AB%E8%AE%AF&cur_tab=1&offset=0")
*/
//IF
    //获取视频 &category=subv_life&max_behot_time=1609981326
    @GET("api/news/feed/v62/?iid=12507202490&device_id=37487219424&refer=1&count=20&aid=13")
    Observable<VideoBean>getviode(@Query("category") String category, @Query("max_behot_time")String time);



    //获取图片全部  category=%E7%BB%84%E5%9B%BE&max_behot_time=1609981992
    @GET("api/pc/feed/?as=A115C8457F69B85&cp=585F294B8845EE1&_signature=l&")
    Observable<PictureBean>getpicture(@Query("category") String category,@Query("max_behot_time")String time);







}
