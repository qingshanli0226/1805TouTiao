package uitls;

import bean.ImagesBean;
import bean.NewsBean;
import bean.VideosBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ITouTiaoApiService {

    @GET("api/news/feed/v62/")
    Observable<NewsBean> getNews(@Query("iid")String iid, @Query("device_id")String device_id, @Query("refer")String refer, @Query("count")String count, @Query("aid")String aid, @Query("category")String category, @Query("max_behot_time")String max_behot_time);

    @GET("api/pc/feed/")
    Observable<ImagesBean> getImages(@Query("as")String as,@Query("cp")String cp,@Query("_signature")String _signature,@Query("category")String category,@Query("max_behot_time")String max_behot_time);

    @GET("api/news/feed/v62/")
    Observable<VideosBean> getVideos(@Query("iid")String iid,@Query("device_id")String device_id,@Query("refer")String refer,@Query("count")String count,@Query("aid")String aid,@Query("category")String category,@Query("max_behot_time")String max_behot_time);

}
