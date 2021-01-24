package service;


import java.util.HashMap;

import bean.NewsBean;
import bean.VideosBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface INetNewsApiService {
//    ("?iid=12507202490&device_id=37487219424&category=news_hots")
// http://is.snssdk.com/api/news/feed/v62/?iid=5034850950&device_id=6096495334&refer=1&count=20&aid=13&category=subv_voice&max_behot_time=1610965739
    //下载文件的网络接口
    @GET//推荐
    Observable<NewsBean>journalis(@Url String url, @QueryMap HashMap<String,String> map);
    @GET
    Observable<VideosBean>video(@Url String url, @QueryMap HashMap<String,String> map);
}
