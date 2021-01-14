package com.example.sevenlandh.image.contract;

import com.example.common.picture.PictureBean;
import com.example.freamwork.mvp.BasePresenter;
import com.example.freamwork.mvp.IView;

public class ImageContract {
    public interface ImageView extends IView{

        void onImageView(PictureBean pictureBean);

    }
    public static abstract class ImagePresenter extends BasePresenter<ImageContract.ImageView>{
        public abstract void getImage(String catrgory ,String time);
    }
}
