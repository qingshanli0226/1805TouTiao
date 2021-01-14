package com.example.sevenlandh.bring.contract;

import com.example.common.news.NewsBean;
import com.example.freamwork.mvp.BasePresenter;
import com.example.freamwork.mvp.IView;

public class BringContract {
    public interface BringView extends IView{

        void onBringView(NewsBean newsBean);

    }
    public static abstract class BringPresenter extends BasePresenter<BringContract.BringView>{
        public abstract void getBring(String category,String time);
    }
}
