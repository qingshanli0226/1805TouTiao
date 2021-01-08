package com.kuaishou.bawei.net;

import com.kuaishou.bawei.net.bean.FindVideoBean;
import com.kuaishou.bawei.net.bean.GiftBean;
import com.kuaishou.bawei.net.bean.MVVMItemBean;
import com.kuaishou.bawei.net.bean.OrderInfoBean;
import com.kuaishou.bawei.net.bean.VideoBean;
import com.kuaishou.bawei.net.bean.LoginBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

//定义Retrofit网络接口,该网络接口如果在MVP框架中，可以将该接口等价于IMode
public interface INetworkApiService {

    @POST("register") //代表Post请求
    @FormUrlEncoded  //Post请求的参数是表单形式
    //代表注册请求返回的数据类型RegisterBean
    //Observable是一个类，可以启动子线程进行网络请求
    Observable<BaseBean<String>> register(@FieldMap Map<String, String> params);//表单参数放到HashMap里，并且使用@FiledMap注解

    @POST("login")
    @FormUrlEncoded
    Observable<BaseBean<LoginBean>> login(@FieldMap HashMap<String, String> params);

    //自动登录接口
    @POST("autoLogin")
    @FormUrlEncoded
    Observable<BaseBean<LoginBean>> autoLogin(@FieldMap HashMap<String, String> params);

    //绑定电话
    @POST("updatePhone")
    @FormUrlEncoded
    Observable<BaseBean<String>> bindPhone(@FieldMap HashMap<String,String> params);

    //获取关注列表数据
    @GET("findFocusVideo")
    Observable<BaseBean<List<VideoBean>>> findFocusVideo();
    //获取发现列表数据
    @GET("findVideo")
    Observable<BaseBean<List<VideoBean>>> findVideo();
    @GET("findVideo")
    Observable<BaseBean<List<MVVMItemBean>>> findMVVMVideo();
    //获取同城列表数据
    @GET("findCityVideo")
    Observable<BaseBean<List<VideoBean>>> findCityVideo();
    //获取礼物列表
    @GET("atguigu/json/gif.json")
    Observable<BaseBean<List<GiftBean>>> getGift();

    //参数是json格式的Post请求
    @POST("getOrderInfo")
    Observable<BaseBean<OrderInfoBean>> getOrderInfo(@Body RequestBody requestBody);

    //绑定电话
    @POST("updateMoney")
    @FormUrlEncoded
    Observable<BaseBean<String>> updateMoney(@FieldMap HashMap<String,String> params);

    //
    @GET
    @Streaming
    Observable<ResponseBody> downloadFile(@Url String url);//URl注解，需要传递一个完整的文件路径

    //定义上传文件的接口
    @Multipart
    @POST("upload")
    Observable<BaseBean<String>> uploadFile(@Part("body") RequestBody body, @Part MultipartBody.Part file);
}
