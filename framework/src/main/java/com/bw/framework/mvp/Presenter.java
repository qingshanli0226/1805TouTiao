package com.bw.framework.mvp;

import java.lang.ref.SoftReference;

public abstract class Presenter<V extends IView,R extends Repository> {

           protected R mRepository;
        /**
          * 软引用，预防v层内存泄漏
         */
        protected SoftReference<V> mView;

        /**
         * 初始化p
         */
          protected abstract void createRepository();

           public Presenter(V v){
                mView=new SoftReference<>(v);
                createRepository();
           }
}
