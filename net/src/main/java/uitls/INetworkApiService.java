package uitls;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
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


    //下载文件的网络接口
    @GET
    @Streaming
    Call<ResponseBody> downloadFile(@Url String url);//URl注解，需要传递一个完整的文件路径


}
