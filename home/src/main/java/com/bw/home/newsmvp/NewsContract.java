package com.bw.home.newsmvp;

import com.bw.framework.base.BasePresenter;
import com.bw.framework.base.IView;
import com.bw.net.bean.NewsContentBean;

public class NewsContract {

    public interface newsView extends IView{
        void getNewsOk(NewsContentBean newsContentBean);
    }

    public abstract static class newsPresenter extends BasePresenter<newsView>{

        public abstract void newsData();

    }
}
