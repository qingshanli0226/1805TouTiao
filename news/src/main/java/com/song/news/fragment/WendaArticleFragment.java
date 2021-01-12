package com.song.news.fragment;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.song.common.ErrorBean;
import com.song.fromwork.BaseMVPFragment;
import com.song.net.mode.mobile.wenda.WendaArticleDataBean;
import com.song.news.R;
import com.song.news.fragment.contract.WendaContract;
import com.song.news.fragment.contract.WendaImpl;

import java.util.ArrayList;
import java.util.List;

public class WendaArticleFragment extends BaseMVPFragment<WendaImpl, WendaContract.IWendaView> implements WendaContract.IWendaView {
    private RecyclerView wendaNewsRv;
//    private SmartRefreshLayout smt;

    private List<WendaArticleDataBean> list = new ArrayList<>();
    private WendaArticleAdapter adapter;

    int index = 0;

    public static WendaArticleFragment newInstance(){
        return new WendaArticleFragment();
    }

    @Override
    protected void initPresenter() {
        iHpptPresenter = new WendaImpl();
    }

    @Override
    protected void initHttpData() {
        iHpptPresenter.doLoadData();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        wendaNewsRv = (RecyclerView) findViewById(R.id.wenda_news_rv);
//        smt = (SmartRefreshLayout) findViewById(R.id.smt);
        adapter = new WendaArticleAdapter();
        wendaNewsRv.setLayoutManager(new LinearLayoutManager(getContext()));
        wendaNewsRv.setAdapter(adapter);
        adapter.updataData(list);
//        smt.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
//            @Override
//            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
//                iHpptPresenter.doLoadMoreData();
//                smt.finishLoadMore();
//            }
//
//            @Override
//            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
//                iHpptPresenter.doRefresh();
//                smt.finishRefresh();
//            }
//        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wenda_article;
    }

    @Override
    public void onLoadData(List<WendaArticleDataBean> wendaArticleDataBeans) {

//        Log.i("TAG", "onLoadData: "+wendaArticleDataBeans.toString());

        list.addAll(wendaArticleDataBeans);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh(List<WendaArticleDataBean> wendaArticleDataBeans) {
        Log.i("TAG", "onLoadData: "+wendaArticleDataBeans.toString());
//        list = wendaArticleDataBeans;
//        adapter.notifyDataSetChanged();
    }

    @Override
    public void hideLoading(boolean isSuccess, ErrorBean errorBean) {

        hideLoadingPage(isSuccess,errorBean);
    }

    @Override
    public void showEmpty() {

    }
}
