package com.song.news.fragment.contract;

import com.song.fromwork.BasePresenter;
import com.song.fromwork.IView;
import com.song.net.mode.mobile.wenda.WendaArticleBean;
import com.song.net.mode.mobile.wenda.WendaArticleDataBean;

import java.util.List;

public class WendaContract {
    public interface IWendaView extends IView{
        void onLoadData(List<WendaArticleDataBean> wendaArticleDataBeans);
        void onRefresh(List<WendaArticleDataBean> wendaArticleDataBeans);
    }

    public abstract static class IWendaPresenter extends BasePresenter<IWendaView>{
        public abstract void doLoadData();
        public abstract void doLoadMoreData();
        public abstract void doRefresh();
    }
}
