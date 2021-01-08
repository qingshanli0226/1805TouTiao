package com.example.news;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.example.framework.base.BaseFragment;
import com.example.framework.base.IPresenter;
import com.example.framework.base.IView;
import com.example.news.contract.NewsContract;
import com.example.news.presenter.NewsPresenterImpl;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

import bean.NewsBean;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends BaseFragment<NewsPresenterImpl, NewsContract.INewsView>implements NewsContract.INewsView {

    private TabLayout tabLayout;
    private String[] titles = new String[]{"推荐","热点","视频","社会","娱乐","科技","问答","汽车"};
    private RecyclerView newsRec;
    private NewsAdapter newsAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initData() {
        for (int i = 0; i < titles.length; i++) {
            tabLayout.addTab(tabLayout.newTab());
        }
        for (int i = 0; i < titles.length; i++) {
            tabLayout.getTabAt(i).setText(titles[i]);
        }
        httpPresenter.getNewsInfo();
    }

    @Override
    protected void initPresenter() {
        httpPresenter = new NewsPresenterImpl();
    }

    @Override
    protected void initView(View inflate) {
        tabLayout = inflate.findViewById(R.id.newsTab);
        newsRec = inflate.findViewById(R.id.newsRec);
    }

    @Override
    public void onNews(List<NewsBean.DataBean> newBeans) {
        Log.i("newFragment", "onNews: "+newBeans.get(1).getContent()+newBeans.get(0).getCode());
        Log.i("6666", "onNews: "+newBeans.get(0).getCode());
        newsAdapter = new NewsAdapter(R.layout.news_item,newBeans);
        newsRec.setAdapter(newsAdapter);
        newsRec.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
