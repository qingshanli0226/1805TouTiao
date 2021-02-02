package com.example.framewrok.base;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.bawei.deom.RetorfitConfig;
import com.example.net.bean.MessageBean;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MyServer extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
       String id = getSharedPreferences("news_id", MODE_PRIVATE).getString("news_id", "123");
      //  http://is.snssdk.com/article/v53/tab_comments/?group_id=6923777977222169095&offset=0
        //http://is.snssdk.com/
        if (id !=null && id.equals("123")){
            HashMap<String,String> map=new HashMap<>();
            map.put("group_id",id);
            map.put("offset","0");
            RetorfitConfig.getBaseInterface("").message("article/v53/tab_comments",map)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<MessageBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(MessageBean messageBean) {
                            Log.e("messagesssss",messageBean.toString());
                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }


        return super.onStartCommand(intent, flags, startId);
    }
}
