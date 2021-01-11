package com.bw.a1805atoutiao.ui.fragment.newsframent;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bw.a1805atoutiao.R;
import com.bw.a1805atoutiao.adapter.NewsRecycleAdapter;
import com.bw.bean.News;
import com.bw.common.Constants;
import com.bw.framework.base.BaseFragment;
import com.bw.framework.mvptest.control.Control;
import com.bw.framework.mvptest.presenter.NewsPresenter;
import com.bw.framework.url.SetUrl;

import java.util.List;

//http://is.snssdk.com/api/news/feed/v62/?iid=5034850950&device_id=6096495334&refer=1&count=20&aid=13&category=&max_behot_time=1609986645
public class LoadFragment extends BaseFragment<NewsPresenter> implements Control.newsControlView {
    private SwipeRefreshLayout loadSwipe;
    private NewsRecycleAdapter newsRecycleAdapter;
    private RecyclerView loadRecyclew;
    @Override
    protected void initEvent() {
          loadSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
              @Override
              public void onRefresh() {

                  mPresenter.news(Constants.BASE_NEWS_FEED, SetUrl.getInstance().seturl("news_sports"));
              }
          });
    }

    @Override
    protected void initData() {
//        System.setProperty("http.proxyHost", "my.proxyhost.com");
//        System.setProperty("http.proxyPort", "1234");

        loadSwipe.setRefreshing(true);
        //Log.e("time",""+System.currentTimeMillis());


        mPresenter.news(Constants.BASE_NEWS_FEED,SetUrl.getInstance().seturl("video"));

        newsRecycleAdapter=new NewsRecycleAdapter();
    }




    @Override
    protected void initView(View view) {

        loadRecyclew = view.findViewById(R.id.load_recyclew);

        loadSwipe = view.findViewById(R.id.load_swipe);


    }

    @Override
    protected int getlayoutid() {
        return R.layout.fragment_load;
    }

    @Override
    protected void createPresenter() {
          mPresenter=new NewsPresenter(this);
    }

    @Override
    public void success(Object... objects) {
        loadSwipe.setRefreshing(false);
        List<News> list=(List<News>)objects[0];
        Log.e("wk",list.get(0).getAnAbstract());
        loadRecyclew.setLayoutManager(new LinearLayoutManager(getContext()));
        loadRecyclew.setAdapter(newsRecycleAdapter);
        newsRecycleAdapter.updataData(list);
        if (!loadSwipe.isRefreshing()){
            Toast.makeText(getContext(), "获取数据成功", Toast.LENGTH_SHORT).show();
        }



    }

    @Override
    public void error(String msg) {
        loadSwipe.setRefreshing(false);
        Toast.makeText(getContext(), ""+msg, Toast.LENGTH_SHORT).show();
    }
}
