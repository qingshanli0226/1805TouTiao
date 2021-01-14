package com.example.sevenlandh.bring.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.common.news.NewsBean;
import com.example.common.news.NewsDataBean;
import com.example.details.BringWebView;
import com.example.freamwork.mvp.BaseMVPFragment;
import com.example.sevenlandh.R;
import com.example.sevenlandh.bring.adapter.BringAdapter;
import com.example.sevenlandh.bring.contract.BringContract;
import com.example.sevenlandh.bring.presenter.BringPresenterImpl;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.List;


public class BringUpFragment extends BaseMVPFragment<BringPresenterImpl, BringContract.BringView> implements BringContract.BringView {
    private RecyclerView rv;
    private  BringAdapter bringAdapter;
    private List<NewsBean.DataBean> data;
    private SmartRefreshLayout bringsm;


    @Override
    protected int bandLayout() {
        return R.layout.fragment_bring_up;
    }
    @Override
    protected void initEvent() {

    }
    @Override
    protected void initData(Bundle savedInstanceState) {


    }
    @Override
    protected void initView() {
        rv = F(R.id.rv);
        bringsm = F(R.id.bringsm);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        bringsm.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                bringsm.finishLoadMore();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                bringsm.finishRefresh();
            }
        });

    }
    @Override
    protected void initPresenterData() {
        iPresenter.getBring("_all_",getTime());
    }
    @Override
    protected void initPresenter() {
        iPresenter = new BringPresenterImpl();
    }
    public String getTime(){
        long time = System.currentTimeMillis()/1000;
        String s = String.valueOf(time);
        return s;
    }

    @Override
    public void onBringView(NewsBean newsBean) {
         data = newsBean.getData();
         bringAdapter = new BringAdapter(R.layout.item_bring, data);
        rv.setAdapter(bringAdapter);
        bringAdapter.notifyDataSetChanged();
        bringAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                NewsDataBean newsDataBean = new Gson().fromJson(data.get(position).getContent(), NewsDataBean.class);
                Intent intent = new Intent(getContext(), BringWebView.class);
                intent.putExtra("url",newsDataBean.getUrl());
                startActivity(intent);
            }
        });
    }
}