package com.example.a1805toutiao.video.type;

import com.example.framework.base.BasePresenter;
import com.example.framework.base.IView;
import com.example.net.bean.news.MultiNewsArticleBean;

public
interface VoideTypeContract {
    interface IVoideTypeView extends IView{
        void onVoideTypeLoadOk(MultiNewsArticleBean multiNewsArticleBean);
    }

    abstract class VoideTypePresenter extends BasePresenter<IVoideTypeView>{
        public abstract void  loadVoide(String type,String time);
    }
}
