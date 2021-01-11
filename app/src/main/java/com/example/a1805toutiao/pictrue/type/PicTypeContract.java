package com.example.a1805toutiao.pictrue.type;

import com.example.framework.base.BasePresenter;
import com.example.framework.base.IView;
import com.example.net.bean.photo.PhotoArticleBean;

public interface PicTypeContract {
    interface IPicTypeView extends IView{
        void onPicTypeLoadOk(PhotoArticleBean bean);
    }
    public abstract class PicTypePresenter extends BasePresenter<IPicTypeView>{
        public abstract void loadPic(String type,String time);
    }
}
