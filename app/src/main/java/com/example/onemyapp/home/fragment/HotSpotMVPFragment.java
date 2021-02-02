package com.example.onemyapp.home.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bawei.deom.News;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.framewrok.base.base.BaseMVPFragment;
import com.example.framewrok.base.base.BaseRvAdapter;
import com.example.framewrok.base.journalism.JournalismCountroller;
import com.example.framewrok.base.journalism.JournalismImpl;
import com.example.net.bean.JournalismBean;
import com.example.net.bean.NewsBean;
import com.example.onemyapp.R;

import com.example.onemyapp.apter.RecommendAdapter;
import com.example.onemyapp.bean.DaoSession;
import com.example.onemyapp.bean.LabelBean;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;

public class HotSpotMVPFragment extends BaseMVPFragment<JournalismImpl, JournalismCountroller.JournalismView> implements JournalismCountroller.JournalismView, BaseRvAdapter.IBaseRecyclerLinsterner {
    private RecyclerView recyle;
    RecommendAdapter recommendApter;
    ArrayList<News> arrayList=new ArrayList<>();
    DaoSession daoSession;
   private HashMap<String,String>map;
//    private RecyclerView recyle;
//    private  List<Object> dataList=new ArrayList<>();
//    private HomeAdapter homeAdapter;

    @Override
    protected void onregister(Bundle savedInstanceState) {
        EventBus.getDefault().register(this);
    }

    @Override
    protected void initHttpData() {

    }

    @Override
    protected int getLayoutid() {
        return R.layout.hotspotfragment;
    }

    @Override
    protected void intView(View view) {
        recyle = (RecyclerView) view.findViewById(R.id.recyle);

    }

    @Override
    protected void inPresone() {
        presenter=new JournalismImpl();
    }

    @Override
    protected void inData() {


//        homeAdapter=new HomeAdapter();
//        recyle.setAdapter(homeAdapter);
//        recyle.setLayoutManager(new LinearLayoutManager(getContext()));
        recommendApter=new RecommendAdapter(R.layout.newsviewimg,arrayList);
        recyle.setAdapter(recommendApter);
        recyle.setLayoutManager(new LinearLayoutManager(getContext()));
        recommendApter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    ARouter.getInstance().build("/path/WebViewActivity").withString("url",arrayList.get(position).getArticle_url())
                            .withString("id",arrayList.get(position).getId())
                            .navigation();
            }
        });
    }

    @Override
    protected void onstart() {

    }

    @Override
    protected void onstop() {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Message(LabelBean labelBean){
//        map = new HashMap<>();
//        map.put("iid", "5034850950");
//        map.put("device_id", "6096495334");
//        map.put("refer", "1");
//        map.put("count", "20");
//        map.put("aid", "13");
//        map.put("category", videoBean.id);
//        Log.e("XXX", "" + videoBean.getId());
//        map.put("max_behot_time", "1611053318");
//        presenter.VideoShow("", "api/news/feed/v62/", map, loadingPage);
        map = new HashMap<>();
        map.put("iid", "5034850950");
        map.put("device_id", "6096495334");
        map.put("refer", "1");
        map.put("count", "20");
        map.put("aid", "13");
        map.put("category", labelBean.getTitle_id());
        map.put("max_behot_time", "1611053318");
        presenter.NewsShow("","api/news/feed/v58/",map,loadingPage);
        Log.e("titleids",labelBean.getTitle_id());
    }
    @Override
    protected void ondestroy() {

            EventBus.getDefault().unregister(this);


    }

    @Override
    public void onJournalismView(JournalismBean dataBeans) {

        for (int i = 0; i <dataBeans.getData().size(); i++) {
            Gson gson = new Gson();
            NewsBean newsBean2 = gson.fromJson(dataBeans.getData().get(i).getContent(), NewsBean.class);
            News news = new News(newsBean2.getAbstractX(), newsBean2.getArticle_url(),newsBean2.getUser_info().getAvatar_url(), newsBean2.getMedia_name(), newsBean2.getTitle(),newsBean2.getUser_info().getAvatar_url(),newsBean2.getItem_id()+"");
               arrayList.add(news);
               recommendApter.notifyDataSetChanged();
        }

    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.NewsShow("","api/news/feed/v58/",map,loadingPage);
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
