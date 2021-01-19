package com.example.framewrok.base.journalism;

import android.util.Log;

import com.bawei.deom.ClassInterface;
import com.example.net.bean.JournalismBean;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class JournalismImpl extends JournalismCountroller.JournalismShow {

    @Override
    public void NewsShow(String s,String url,HashMap<String,String> map) {
        if (s.equals("")){
            Log.e("map",map.toString());
            ClassInterface.getBaseInterface(s).journalis(url,map)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<JournalismBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(JournalismBean journalismBean) {
                            pView.onJournalismView(journalismBean);
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
}
