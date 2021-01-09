package com.example.sevenlandh.fragment.journalism;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.common.news.NewsBean;
import com.example.freamwork.mvp.BaseMVPFragment;
import com.example.sevenlandh.R;
import com.example.sevenlandh.adapter.BringAdapter;
import com.example.sevenlandh.contract.BringContract;
import com.example.sevenlandh.presenter.BringPresenterImpl;

import java.util.List;


public class BringUpFragment extends BaseMVPFragment<BringPresenterImpl, BringContract.BringView> implements BringContract.BringView {
    private RecyclerView rv;
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
        List<NewsBean.DataBean> data = newsBean.getData();
        BringAdapter bringAdapter = new BringAdapter(R.layout.item_bring, data);
        rv.setAdapter(bringAdapter);
        bringAdapter.notifyDataSetChanged();
    }
}