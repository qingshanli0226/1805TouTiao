package com.example.news;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import com.example.framework.base.BaseFragment;
import com.example.news.contract.NewsContract;
import com.example.news.presenter.NewsPresenterImpl;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
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
    private List<HashMap<String,String>> hashMaps = new ArrayList<>();
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


        for (int i = 0; i < newBeans.size(); i++) {
            String content = newBeans.get(i).getContent();
            Log.i("wft", "onNews: "+content);
            try {
                JSONObject jsonObject = new JSONObject(content);
                String anAbstract = jsonObject.getString("abstract");
                String article_url = jsonObject.getString("article_url");
                String media_info = jsonObject.getString("media_info");
                HashMap hashMap = new HashMap<>();
                hashMap.put("anAbstract",anAbstract);
                hashMap.put("article_url",article_url);
                hashMap.put("media_info",media_info);
                hashMaps.add(hashMap);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        newsAdapter = new NewsAdapter(R.layout.news_item,hashMaps);
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
