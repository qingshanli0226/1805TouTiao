package service;

import android.text.style.ImageSpan;

import java.util.HashMap;

import bean.ImagesBean;
import bean.NewsBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface INetPhotoApiService {
    @GET
    //图片页面
    Observable<ImagesBean> getImages(@Url String url, @QueryMap HashMap<String,String> map);
}
