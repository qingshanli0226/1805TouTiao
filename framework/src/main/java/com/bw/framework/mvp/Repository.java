package com.bw.framework.mvp;

public abstract class Repository<M extends IModel> {

         protected M mModel;

         protected abstract void createModel();

         public Repository(){
              createModel();
         }
}
