package com.song.net;

import com.song.net.api.ElseApi;
import com.song.net.api.MobileMediaApi;
import com.song.net.api.MobileNewsApi;
import com.song.net.api.MobileSearchApi;
import com.song.net.api.MobileVideoApi;
import com.song.net.api.MobileWendaApi;
import com.song.net.api.NewsApi;
import com.song.net.api.PhotoApi;
import com.song.net.api.VideoApi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    private static ElseApi elseApi;
    private static MobileMediaApi mobileMediaApi;
    private static MobileNewsApi mobileNewsApi;
    private static MobileSearchApi mobileSearchApi;
    private static MobileVideoApi mobileVideoApi;
    private static MobileWendaApi mobileWendaApi;
    private static NewsApi newsApi;
    private static PhotoApi photoApi;
    private static VideoApi videoApi;

    private RetrofitHelper(){
    }




    public static ElseApi getElseApi() {
        if(elseApi == null){
            elseApi = createElse();
        }
        return elseApi;
    }

    public static MobileMediaApi getMobileMediaApi() {
        if(mobileMediaApi == null){
            mobileMediaApi = createMobileMedia();
        }
        return mobileMediaApi;
    }

    private static MobileMediaApi createMobileMedia() {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlHelper.BASE_M_MEDIA_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        MobileMediaApi mobileMediaApi = retrofit.create(MobileMediaApi.class);
        return mobileMediaApi;
    }

    public static MobileNewsApi getMobileNewsApi() {
        if(mobileNewsApi == null){
            mobileNewsApi = createMobileNews();
        }
        return mobileNewsApi;
    }

    private static MobileNewsApi createMobileNews() {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlHelper.BASE_M_MEDIA_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        MobileNewsApi mobileNewsApi = retrofit.create(MobileNewsApi.class);
        return mobileNewsApi;
    }

    public static MobileSearchApi getMobileSearchApi() {
        if(mobileSearchApi == null){
            mobileSearchApi = createMobileSearch();
        }
        return mobileSearchApi;
    }

    private static MobileSearchApi createMobileSearch() {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlHelper.BASE_M_MEDIA_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        MobileSearchApi mobileSearchApi = retrofit.create(MobileSearchApi.class);
        return mobileSearchApi;
    }

    public static MobileVideoApi getMobileVideoApi() {
        if(mobileVideoApi == null){
            mobileVideoApi = createMobileVideo();
        }
        return mobileVideoApi;
    }

    private static MobileVideoApi createMobileVideo() {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlHelper.BASE_M_MEDIA_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        MobileVideoApi mobileVideoApi = retrofit.create(MobileVideoApi.class);
        return mobileVideoApi;
    }

    public static MobileWendaApi getMobileWendaApi() {
        if(mobileWendaApi == null){
            mobileWendaApi = createMobileWenda();
        }
        return mobileWendaApi;
    }

    private static MobileWendaApi createMobileWenda() {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlHelper.BASE_M_MEDIA_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        MobileWendaApi mobileWendaApi = retrofit.create(MobileWendaApi.class);
        return mobileWendaApi;
    }

    public static NewsApi getNewsApi() {
        if(newsApi == null){
            newsApi = createNews();
        }
        return newsApi;
    }

    private static NewsApi createNews() {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        NewsApi newsApi = retrofit.create(NewsApi.class);
        return newsApi;
    }

    public static PhotoApi getPhotoApi() {
        if(photoApi == null){
            photoApi = createPhoto();
        }
        return photoApi;
    }

    private static PhotoApi createPhoto() {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlHelper.BASE_PHOTO_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        PhotoApi photoApi = retrofit.create(PhotoApi.class);
        return photoApi;
    }

    public static VideoApi getVideoApi() {
        if(videoApi == null){
            videoApi = createVideo();
        }
        return videoApi;
    }

    private static VideoApi createVideo() {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        VideoApi videoApi = retrofit.create(VideoApi.class);
        return videoApi;
    }

    private static ElseApi createElse() {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(UrlHelper.BASE_M_NEWS_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        ElseApi elseApi = retrofit.create(ElseApi.class);
        return elseApi;
    }
}
