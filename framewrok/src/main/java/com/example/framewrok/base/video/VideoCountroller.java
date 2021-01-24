package com.example.framewrok.base.video;

import com.example.framewrok.base.BaseAroute;
import com.example.framewrok.base.IView;
import com.example.framewrok.base.view.LoadingPage;
import com.example.net.bean.JournalismBean;
import com.example.net.bean.VideoBean;

import java.util.HashMap;

public class VideoCountroller {
    public interface VideoView extends IView{
        void onVideoView(VideoBean dataBeans);
    }
    public  abstract static class ViewShow extends BaseAroute<VideoView>{
        public abstract void VideoShow(String s, String url, HashMap<String,String> map, LoadingPage loadingPage);
    }
}
