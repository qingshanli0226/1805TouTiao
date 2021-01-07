package com.example.framewrok.base.journalism;

import com.bawei.deom.ClassInterface;
import com.example.net.bean.JournalismBean;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class JournalismImpl extends JournalismCountroller.JournalismShow {

    @Override
    public void NewsShow() {
   ClassInterface.getBaseInterface().journalis()
           .subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread())
           .subscribe(new Observer<JournalismBean>() {
               @Override
               public void onSubscribe(Disposable d) {

               }

               @Override
               public void onNext(JournalismBean journalismBean) {
                         pView.onJournalismView(journalismBean.getData());
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
