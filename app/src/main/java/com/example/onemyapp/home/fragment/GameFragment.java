package com.example.onemyapp.home.fragment;

import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.deom.News;
import com.example.framewrok.base.base.BaseFragment;
import com.example.framewrok.base.base.BaseRvAdapter;
import com.example.framewrok.base.journalism.JournalismCountroller;
import com.example.framewrok.base.journalism.JournalismImpl;
import com.example.net.bean.JournalismBean;
import com.example.onemyapp.R;

import com.example.onemyapp.apter.HomeAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameFragment extends BaseFragment<JournalismImpl, JournalismCountroller.JournalismView> implements JournalismCountroller.JournalismView, BaseRvAdapter.IBaseRecyclerLinsterner {
    private RecyclerView recyle;
<<<<<<< HEAD
    ArrayList<News> arrayList=new ArrayList<>();
     RecommendApter recommendApter;

    @Override
    protected void onregister() {

    }

=======
    private News news;
    private  List<Object> dataList=new ArrayList<>();
    private HomeAdapter homeAdapter;
>>>>>>> gtl
    @Override
    protected int getLayoutid() {
        return R.layout.gamefragment;
    }

    @Override
    protected void intView(View view) {
        recyle = (RecyclerView) view.findViewById(R.id.recyle);
        recyle.setLayoutManager(new LinearLayoutManager(getContext()));
        homeAdapter=new HomeAdapter();
        recyle.setAdapter(homeAdapter);
    }

    @Override
    protected void inPresone() {
        prine=new JournalismImpl();

    }
//?iid=12507202490&device_id=37487219424&category=news_hots
    @Override
    protected void inData() {
        prine.NewsShow();
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

    @Override
    public void onJournalismView(JournalismBean dataBeans) {
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
