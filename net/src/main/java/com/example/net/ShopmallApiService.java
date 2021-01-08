package com.example.net;

import com.example.common.news.NewsBean;
import com.example.common.picture.PictureBean;
import com.example.common.search.SearchBean;
import com.example.common.search.SearchDataBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ShopmallApiService {


    //获取推荐
    @GET("api/news/feed/v62/?iid=5034850950&device_id=6096495334&refer=1&count=20&aid=13&category=__all__&max_behot_time=1609981326")
    Observable<NewsBean>getrecommend();
    //获取科技
    @GET("api/news/feed/v62/?iid=5034850950&device_id=6096495334&refer=1&count=20&aid=13&category=news_tech&max_behot_time=1609981326")
    Observable<NewsBean>getscience();
    //获取问答
    @GET("api/news/feed/v62/?iid=5034850950&device_id=6096495334&refer=1&count=20&aid=13&category=question_and_answer&max_behot_time=1609981326")
    Observable<NewsBean>getquestions();
    //搜索热推
    @GET("search/suggest/wap/initial_page/?from=feed&sug_category=__all__&iid=10344168417&device_id=36394312781&format=json")
    Observable<SearchBean>getsearch();
    //搜索
    @GET("2/article/search_sug/?from=search_tab&iid=10344168417&device_id=36394312781")
    Observable<SearchDataBean>getsearchdata(@Query("keyword")String keyword);
  /*  //具体搜索
    @GET("api/2/wap/search_content/?from=search_tab&iid=12507202490&device_id=37487219424&count=10&format=json&keyword=%E7%89%B9%E6%9C%97%E6%99%AE%E6%9C%80%E6%96%B0%E5%BF%AB%E8%AE%AF&cur_tab=1&offset=0")
*/

    //获取视频
    @GET("api/news/feed/v62/?iid=12507202490&device_id=37487219424&refer=1&count=20&aid=13&category=subv_life&max_behot_time=1609981326")
    Observable<NewsBean>getviode();
    //获取视频
    @GET("api/news/feed/v62/?iid=12507202490&device_id=37487219424&refer=1&count=20&aid=13&category=news_society&max_behot_time=1609981326")
    Observable<NewsBean>getsociety();
    //获取视频
    @GET("api/news/feed/v62/?iid=12507202490&device_id=37487219424&refer=1&count=20&aid=13&category=news_tech&max_behot_time=1609981326")
    Observable<NewsBean>getrecreation();


    //获取图片全部
    @GET("api/pc/feed/?as=A115C8457F69B85&cp=585F294B8845EE1&_signature=l&category=%E7%BB%84%E5%9B%BE&max_behot_time=1609981992")
    Observable<PictureBean>getpicture();







}
