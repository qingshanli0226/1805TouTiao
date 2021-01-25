package service;

import android.text.style.ImageSpan;

import java.util.HashMap;

import bean.ImagesBean;
import bean.NewsBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface INetPhotoApiService {
    @GET("api/pc/feed/?as=A115C8457F69B85&cp=585F294B8845EE1&_signature=l&")
    //图片页面
    Observable<ImagesBean> getImages(@Query("category") String category,@Query("max_behot_time")String time);
}
