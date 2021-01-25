package com.example.picture.fragment.contract;

import com.example.framework.base.BaseIPresenter;
import com.example.framework.base.IView;

import java.util.HashMap;
import java.util.List;

import bean.ImagesBean;

public class PhotoContract {
    public interface IPhotoView extends IView {
        void onSucess(List<ImagesBean.DataBean> list);
    }
    public static abstract class PhotoPrsenter extends BaseIPresenter<IPhotoView>{
        public abstract void getPhoto(String category,String behottime);
    }
}
