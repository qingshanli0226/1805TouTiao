package com.bw.a1805atoutiao.ui.fragment.newsframent;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bw.a1805atoutiao.R;
import com.bw.a1805atoutiao.adapter.NewsRecycleAdapter;
import com.bw.bean.News;
import com.bw.common.Constants;
import com.bw.framework.base.BaseFragment;
import com.bw.framework.base.BaseRVAdapter;
import com.bw.framework.manager.TitleManage;
import com.bw.framework.mvptest.control.Control;
import com.bw.framework.mvptest.presenter.NewsPresenter;
import com.bw.framework.url.SetUrl;

import java.util.List;

//http://is.snssdk.com/api/news/feed/v62/?iid=5034850950&device_id=6096495334&refer=1&count=20&aid=13&category=&max_behot_time=1609986645
public class LoadFragment extends BaseFragment<NewsPresenter> implements Control.newsControlView,TitleManage.titleChangeListener {
    private SwipeRefreshLayout loadSwipe;
    private NewsRecycleAdapter newsRecycleAdapter;
    private RecyclerView loadRecyclew;
    private String path;
    @Override
    protected void initEvent() {
          loadSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
              @Override
              public void onRefresh() {

                  mPresenter.news(Constants.BASE_NEWS_FEED, SetUrl.getInstance().seturl(path+""));
              }
          });



    }

    @Override
    protected void initData() {


         ARouter.getInstance().inject(this);
//        System.setProperty("http.proxyHost", "my.proxyhost.com");
//        System.setProperty("http.proxyPort", "1234");

        loadSwipe.setRefreshing(true);
        //Log.e("time",""+System.currentTimeMillis());

        String url = TitleManage.getInstance().getDataTitleBeans().get(0).getUrl();
        mPresenter.news(Constants.BASE_NEWS_FEED,SetUrl.getInstance().seturl(url+""));
        path=url;

        newsRecycleAdapter=new NewsRecycleAdapter();


        TitleManage.getInstance().registerChangeListener(this);
    }




    @Override
    protected void initView(View view) {

        loadRecyclew = view.findViewById(R.id.load_recyclew);

        loadSwipe = view.findViewById(R.id.load_swipe);

        loadRecyclew.setLayoutManager(new LinearLayoutManager(getContext()));
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
        final List<News> list=(List<News>)objects[0];


               loadRecyclew.setAdapter(newsRecycleAdapter);
               newsRecycleAdapter.updataData(list);
               loadSwipe.setRefreshing(false);

              newsRecycleAdapter.setiRecyclerViewItemClickListener(new BaseRVAdapter.IRecyclerViewItemClickListener() {
                  @Override
                  public void onItemClick(int position) {
                       ARouter.getInstance().build("/Details/DetailsActivity").withString("url",list.get(position).getArticle_url()).navigation();
                  }
              });




    }

    @Override
    public void error(String msg) {
        loadSwipe.setRefreshing(false);
        Toast.makeText(getContext(), ""+msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        TitleManage.getInstance().unChangeListener(this);
        Log.d("tui","已销毁！"+this);
    }

    @Override
    public void titleUrl(String url) {
        loadSwipe.setRefreshing(true);
        path=url;
        mPresenter.news(Constants.BASE_NEWS_FEED,SetUrl.getInstance().seturl(url+""));
        Log.e("url","网址"+url);
    }

    @Override
    public void addTitle(String title) {

    }

    @Override
    public void removeTitle(String title, int position) {

    }

    @Override
    public void titlePosition(int position1, int position2) {

    }
}
