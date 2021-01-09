package com.bw.framework.mvptest.control;

import com.bw.framework.callback.INews;
import com.bw.framework.mvp.IModel;
import com.bw.framework.mvp.IView;
import com.bw.framework.mvp.Presenter;
import com.bw.framework.mvp.Repository;

import java.util.HashMap;

public interface Control {

    /**
     * 用户V层
     */
    interface userControlView extends IView{

    }

    /**
     * 新闻V层
     */
    interface newsControlView extends IView{
          void success(Object...objects);
          void error(String msg);
    }


    /**
     * 用户M层
     */
    interface userControlModel extends IModel{

    }

    /**
     * 新闻M层
     */
    interface newsControlModel extends IModel{
           void news(String url, HashMap<String,String> map, INews iNews);
    }

    /**
     * 用户仓库层
     */
    abstract class userControlRepository extends Repository<userControlModel>{

    }

    /**
     * 新闻仓库层
     */
    abstract class newsControlRepository extends Repository<newsControlModel>{
        public abstract void news(String url, HashMap<String,String> map, INews iNews);
    }

    /**
     * 用户P层
     */
    abstract class userControlPresenter extends Presenter<userControlView,userControlRepository>{

        public userControlPresenter(userControlView userControlView) {
            super(userControlView);
        }
    }

    /**
     * 新闻P层
     */
    abstract class newsControlPresenter extends Presenter<newsControlView,newsControlRepository>{


        public newsControlPresenter(newsControlView newsControlView) {
            super(newsControlView);
        }
        public abstract void news(String url, HashMap<String,String> map);
    }
}
