package uitls;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofitcreators {
    private static INetPresetenterWork baseInterface;
    public static INetPresetenterWork getBaseInterface(){
        if (baseInterface==null){
            baseInterface=getBaseUserInterface();
        }
        return baseInterface;
    }

    public static INetPresetenterWork getBaseUserInterface() {
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .writeTimeout(5000, TimeUnit.SECONDS)
                .readTimeout(5000,TimeUnit.SECONDS)
                .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
         Retrofit retrofit=new Retrofit.Builder()
                 .baseUrl(Confing.UrlS)
                 .client(okHttpClient)
                 .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                 .addConverterFactory(GsonConverterFactory.create())
                 .build();
         INetPresetenterWork baseInterface = retrofit.create(INetPresetenterWork.class);
         return  baseInterface;
     }


}
