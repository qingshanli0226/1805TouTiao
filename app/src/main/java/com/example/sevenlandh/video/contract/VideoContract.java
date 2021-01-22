package com.example.sevenlandh.video.contract;

import com.example.common.picture.PictureBean;
import com.example.common.video.VideoBean;
import com.example.freamwork.mvp.BasePresenter;
import com.example.freamwork.mvp.IView;

public class VideoContract {
    public interface VideoView extends IView{

        void onVideoView(VideoBean videoBean);

    }
    public static abstract class VideoPresenter extends BasePresenter<VideoContract.VideoView>{
        public abstract void getVideo(String catrgory ,String time);
    }
}
