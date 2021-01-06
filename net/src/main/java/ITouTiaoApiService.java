import bean.NewsBean;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ITouTiaoApiService {
    @GET("api/news/feed/v58/?iid=12507202490&device_id=37487219424&category=news_society")
    Observable<NewsBean> getnews();
}
