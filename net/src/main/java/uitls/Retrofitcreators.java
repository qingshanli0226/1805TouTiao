package uitls;

import com.Constans;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import service.INetNewsApiService;
import service.INetPhotoApiService;
import service.INetdownApiService;

public class Retrofitcreators {
    private static INetNewsApiService baseInterface;
    private static INetdownApiService iNetworkApiService;
    private static INetPhotoApiService iNetPhotoApiService;
    //新闻页面的Api
    public static INetNewsApiService getBaseInterface(){
        if (baseInterface==null){
            baseInterface=getBaseUserInterface();
        }
        return baseInterface;
    }
    //Glide下载Api
    public static INetdownApiService getNetworkApiService() {
        if (iNetworkApiService == null) {
            iNetworkApiService = createNetworkApiService();
        }

        return iNetworkApiService;
    }
    //图片页面的Api
    public static INetPhotoApiService getiNetPhotoApiService(){
        if (iNetPhotoApiService == null){
            iNetPhotoApiService = createNetPhotoService();
        }
        return iNetPhotoApiService;
    }

    private static INetPhotoApiService createNetPhotoService() {
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .writeTimeout(5000, TimeUnit.SECONDS)
                .readTimeout(5000,TimeUnit.SECONDS)
                .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(com.Constans.PHOTO_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        INetPhotoApiService iNetPhotoApiService = retrofit.create(INetPhotoApiService.class);
        return  iNetPhotoApiService;
    }

    private static INetdownApiService createNetworkApiService() {
        //Retrofit底层封装是okhttpclient
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5,TimeUnit.SECONDS)//超时连接
                .readTimeout(5,TimeUnit.SECONDS)//读超时连接
                .writeTimeout(5,TimeUnit.SECONDS)//写超时连接
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))//打印log
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(com.Constans.BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //创建实现该接口的一个类,就是说该类实现了INetworkAPIService接口
        INetdownApiService iNetworkApiService = retrofit.create(INetdownApiService.class);

        return iNetworkApiService;
    }

    public static INetNewsApiService getBaseUserInterface() {
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .writeTimeout(5000, TimeUnit.SECONDS)
                .readTimeout(5000,TimeUnit.SECONDS)
                .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
         Retrofit retrofit=new Retrofit.Builder()
                 .baseUrl(Constans.URL_S)
                 .client(okHttpClient)
                 .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                 .addConverterFactory(GsonConverterFactory.create())
                 .build();
         INetNewsApiService baseInterface = retrofit.create(INetNewsApiService.class);
         return  baseInterface;
     }


}
