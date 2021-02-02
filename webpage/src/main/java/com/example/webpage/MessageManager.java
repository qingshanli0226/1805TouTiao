package com.example.webpage;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.bawei.deom.RetorfitConfig;
import com.example.framewrok.base.MyServer;
import com.example.net.bean.MessageBean;

import java.util.ArrayList;
import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MessageManager {
    public static MessageManager messageManager;

    private Context context;
      public static MessageManager getInstance(){
          if (messageManager==null){
              messageManager=new MessageManager();
          }
          return messageManager;
      }
      public void init(Context context){
          this.context=context;

      }

    public void message(String id) {
//        Intent intent=new Intent(context, MyServer.class);
//        context.startService(intent);
//        String id = context.getSharedPreferences("news_id", context.MODE_PRIVATE).getString("news_id", "123");
        //  http://is.snssdk.com/article/v53/tab_comments/?group_id=6923777977222169095&offset=0
        //http://is.snssdk.com/
       // http://is.snssdk.com/article/v53/tab_comments/?group_id=6924427079031357960&offset=0
       // http://is.snssdk.com/article/v53/tab_comments?group_id=6923133698023883267&offset=0
            HashMap<String,String> map=new HashMap<>();
            map.put("group_id",id);
            map.put("offset","0");
            RetorfitConfig.getBaseInterface("").message("article/v53/tab_comments/",map)
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
}
