package com.bawei.deom;

import com.example.net.bean.HotNews;
import com.example.net.bean.ImagesBean;
import com.example.net.bean.JournalismBean;
import com.example.net.bean.VideoBean;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface BaseInterface {
//    ("?iid=12507202490&device_id=37487219424&category=news_hots")
// http://is.snssdk.com/api/news/feed/v62/?iid=5034850950&device_id=6096495334&refer=1&count=20&aid=13&category=subv_voice&max_behot_time=1610965739

    @GET//推荐
    Observable<JournalismBean>journalis(@Url String url, @QueryMap HashMap<String,String> map);
    @GET
    Observable<VideoBean>video(@Url String url, @QueryMap HashMap<String,String> map);
}
