package uitls;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpRetrofitManager {

    private static HttpRetrofitManager httpRetrofitManager;

    public HttpRetrofitManager getHttpRetrofitManager() {
        if (httpRetrofitManager==null){
            httpRetrofitManager = new HttpRetrofitManager();
        }
        return httpRetrofitManager;
    }

    private static Retrofit retrofit;

    public static Retrofit getRetrofit(String pathHead) {
        if (retrofit==null){
            createRetrofit(pathHead);
        }
        return retrofit;
    }

    private static void createRetrofit(String pathHead) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        Retrofit build = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(pathHead)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofit = build;


    }
}
