package com.bw.net;

import com.bw.bean.NewsBean;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface IToutiaoService {
    //新闻
    @GET
    Observable<NewsBean> getNews(@Url String url,@QueryMap HashMap<String,String> map);

}
