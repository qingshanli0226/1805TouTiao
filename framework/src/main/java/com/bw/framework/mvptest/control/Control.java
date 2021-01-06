package com.bw.framework.mvptest.control;

import com.bw.framework.mvp.IModel;
import com.bw.framework.mvp.IView;
import com.bw.framework.mvp.Presenter;
import com.bw.framework.mvp.Repository;

public interface Control {

    /**
     * 用户V层
     */
    interface userControlView extends IView{

    }


    /**
     * 用户M层
     */
    interface userControlModel extends IModel{

    }

    /**
     * 用户仓库层
     */
    abstract class userControlRepository extends Repository<userControlModel>{

    }

    /**
     * 用户P层
     */
    abstract class userControlPresenter extends Presenter<userControlView,userControlRepository>{

        public userControlPresenter(userControlView userControlView) {
            super(userControlView);
        }
    }
}
