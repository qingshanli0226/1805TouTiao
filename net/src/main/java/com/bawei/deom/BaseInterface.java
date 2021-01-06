package com.bawei.deom;

import com.example.net.bean.JournalismBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface BaseInterface {
    @GET("refer=1&count=20&loc_mode=4&device_id=34960436458&iid=13136511752")
    Observable<JournalismBean>journalis();
}
