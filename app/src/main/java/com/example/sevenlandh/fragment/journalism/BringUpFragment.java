package com.example.sevenlandh.fragment.journalism;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.common.news.NewsBean;
import com.example.common.news.NewsDataBean;
import com.example.freamwork.mvp.BaseMVPFragment;
import com.example.sevenlandh.R;
import com.example.sevenlandh.activity.BringWebView;
import com.example.sevenlandh.adapter.BringAdapter;
import com.example.sevenlandh.contract.BringContract;
import com.example.sevenlandh.presenter.BringPresenterImpl;
import com.google.gson.Gson;

import java.util.List;


public class BringUpFragment extends BaseMVPFragment<BringPresenterImpl, BringContract.BringView> implements BringContract.BringView {
    private RecyclerView rv;
    private  BringAdapter bringAdapter;
    private List<NewsBean.DataBean> data;
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
        rv.setLayoutManager(new LinearLayoutManager(getContext()));


    }
    @Override
    protected void initPresenterData() {
        iPresenter.getBring();
    }
    @Override
    protected void initPresenter() {
        iPresenter = new BringPresenterImpl();
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
                intent.putExtra("url",newsDataBean.getDisplay_url());
                startActivity(intent);
            }
        });
    }
}