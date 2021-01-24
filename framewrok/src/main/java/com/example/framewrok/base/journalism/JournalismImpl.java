package com.example.framewrok.base.journalism;

import android.util.Log;

import com.bawei.deom.ClassInterface;
import com.example.framewrok.base.view.LoadingPage;
import com.example.net.bean.JournalismBean;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class JournalismImpl extends JournalismCountroller.JournalismShow {

    @Override
<<<<<<< HEAD
    public void NewsShow() {
           ClassInterface.getBaseInterface().journalis()
           .subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread())
           .subscribe(new Observer<JournalismBean>() {
               @Override
               public void onSubscribe(Disposable d) {
=======
    public void NewsShow(String s, String url, HashMap<String,String> map, final LoadingPage loadingPage) {
        if (s.equals("")){
>>>>>>> one

            ClassInterface.getBaseInterface(s).journalis(url,map)
                    .delay(3, TimeUnit.SECONDS)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe(new Consumer<Disposable>() {
                        @Override
                        public void accept(Disposable disposable) throws Exception {
                         loadingPage.showLoadingPage();
                        }
                    })
                    .doFinally(new Action() {
                        @Override
                        public void run() throws Exception {

                        }
                    })
                    .subscribe(new Observer<JournalismBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(JournalismBean journalismBean) {
                            pView.onJournalismView(journalismBean);
                            loadingPage.showSuccessView();
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
