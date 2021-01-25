package com.example.onemyapp.home.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.framewrok.base.base.BaseMVPFragment;
import com.example.framewrok.base.base.BaseRvAdapter;
import com.example.framewrok.base.journalism.JournalismCountroller;
import com.example.framewrok.base.journalism.JournalismImpl;
import com.example.framewrok.base.net.NetConnectManager;
import com.example.net.bean.JournalismBean;
import com.example.onemyapp.R;

import com.example.onemyapp.home.adapter.HomeAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameMVPFragment extends BaseMVPFragment<JournalismImpl, JournalismCountroller.JournalismView> implements JournalismCountroller.JournalismView, BaseRvAdapter.IBaseRecyclerLinsterner {
    private RecyclerView recyle;
    private  List<Object> dataList=new ArrayList<>();
    HashMap<String,String> map;
    @Override
    protected void onregister(Bundle savedInstanceState) {

    }

    @Override
    protected void initHttpData() {
        if (NetConnectManager.getInstance().isConnected()){
            presenter.NewsShow("","api/news/feed/v58/",map,loadingPage);
            Toast.makeText(getContext(), "当前网络连接", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getContext(), "当前无网络连接", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDisConnected() {
        super.onDisConnected();
        Toast.makeText(getContext(), "当前无网络连接", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onConnected() {
        super.onConnected();
        presenter.NewsShow("","api/news/feed/v58/",map,loadingPage);
    }

    @Override
    protected int getLayoutid() {
        return R.layout.gamefragment;

    }

    @Override
    protected void intView(View view) {
        recyle = (RecyclerView) view.findViewById(R.id.recyle);

    }

    @Override
    protected void inPresone() {
        presenter=new JournalismImpl();


    }
//?iid=12507202490&device_id=37487219424&category=news_hots
    @Override
    protected void inData() {
        map=new HashMap<>();
        map.put("iid","12507202490");
        map.put("device_id","37487219424");
        map.put("category","");
        presenter.NewsShow("","api/news/feed/v58/",map,loadingPage);
        homeAdapter=new HomeAdapter();
        recyle.setAdapter(homeAdapter);
        recyle.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected void onstart() {

    }

    @Override
    protected void onstop() {

    }

    @Override
    protected void ondestroy() {

    }
    private HomeAdapter homeAdapter;
    @Override
    public void onJournalismView(JournalismBean dataBeans) {
        Log.e("=======","123");
        dataList.add(dataBeans.getData());
        homeAdapter.updatelist(dataList);
        homeAdapter.setBaseRVAdapterlinterner(this);




    }

    @Override
    public void loading() {

    }

    @Override
    public void hideloading() {

    }

    @Override
    public void onItemclick(int position) {

    }
}
