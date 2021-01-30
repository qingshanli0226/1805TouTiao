package com.example.ui.fragment.contract;

import com.example.framework.base.BaseIPresenter;
import com.example.framework.base.IPresenter;
import com.example.framework.base.IView;

import java.util.HashMap;

public class VideoContract{
    public interface IVideoView extends IView{
        void onvideo();
    }
    public abstract static class IVideoPresenter extends BaseIPresenter<IVideoView> {
        public abstract void getvideo(String url, HashMap<String,String> map);
    }
}
