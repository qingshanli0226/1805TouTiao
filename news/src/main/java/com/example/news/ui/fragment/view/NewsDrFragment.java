package com.example.news.ui.fragment.view;


import android.content.Intent;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.View;
import android.widget.TextView;

import com.Constans;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.framework.base.BaseMVPFragment;
import com.example.framework.dao.DragBean;
import com.example.framework.manager.DragMananger;
import com.example.news.NewsDetailsActivity;
import com.example.news.R;
import com.example.news.adpter.Newadpter;
import com.example.news.ui.fragment.contract.NewsContract;
import com.example.news.ui.fragment.presenter.NewsPresenterImpl;

import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsDrFragment extends BaseMVPFragment<NewsPresenterImpl, NewsContract.INewsView> implements NewsContract.INewsView {
    private HashMap<String,String> hashMap = new HashMap<>();
    private SwipeRefreshLayout refesh;
    private RecyclerView rvNews;
    private TextView tvText;
    private Newadpter newrAdapter;

    @Override
    protected void initDate() {

    }

    @Override
    protected void initView() {
        //初始化控件
        rvNews = findViewById(R.id.rv_news);
        refesh = findViewById(R.id.refesh);

    }

    @Override
    protected int getlayoutids() {
        return R.layout.fragment_news_dr;
    }


    @Override
    protected void initHttpDate() {
        //请求数据
        hashmap();
        httpPresenter.getNewsInfo(Constans.BASE_NEWS_FEED,hashMap);
        refesh.setRefreshing(true);
        //刷新数据
        refesh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                hashmap();
                httpPresenter.getNewsInfo(Constans.BASE_NEWS_FEED,hashMap);
                newrAdapter.notifyDataSetChanged();
            }
        });
    }

    private void hashmap() {
        List<DragBean> dragList = DragMananger.getInstance().getDragList();
        hashMap.put("iid","12507202490");
        hashMap.put("device_id","37487219424");
        hashMap.put("count","20");
        hashMap.put("category",dragList.get(0).getTitleid()+"");
        hashMap.put("max_behot_time",""+System.currentTimeMillis());
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initPresenter() {
        httpPresenter = new NewsPresenterImpl();
    }

    @Override
    public void onNews(final List<HashMap<String, String>> newBeans) {
        refesh.setRefreshing(false);
        //适配器进行适配
        newrAdapter =  new Newadpter(R.layout.item_news_article_img,newBeans);
        rvNews.setAdapter(newrAdapter);
        rvNews.setLayoutManager(new LinearLayoutManager(getContext()));
        //点击进入详情页面
        newrAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String article_url = newBeans.get(position).get("article_url");
                Intent intent = new Intent(getActivity(), NewsDetailsActivity.class);
                intent.putExtra("NewsPath",article_url);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onError(String message) {
    }

    @Override
    public void showError(String message) {
        showerror(message);
    }

    @Override
    public void showEmpty() {
        showEnpty();
    }

    @Override
    public void showLoading() {
        showloading();
    }

    @Override
    public void hidesLoading() {
        hideLoading();
    }
}
