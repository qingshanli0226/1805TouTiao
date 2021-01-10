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
                String anAbstract = jsonObject.getString("abstract");//内容
                String article_url = jsonObject.getString("article_url");//网址
                String behot_time = jsonObject.getString("behot_time");//时间
                String media_info = jsonObject.getString("media_info");
                JSONObject jsonObject1 = new JSONObject(media_info);
                String avatar_url = jsonObject1.getString("avatar_url");//头像
                String name = jsonObject1.getString("name");//姓名
                String share_info = jsonObject.getString("share_info");
                JSONObject jsonObject2 = new JSONObject(share_info);
                String title = jsonObject2.getString("title");//标题
                String middle_image = jsonObject.getString("middle_image");
                JSONObject jsonObject3 = new JSONObject(middle_image);
                String url = jsonObject3.getString("url");//图片
                HashMap hashMap = new HashMap<>();
                hashMap.put("anAbstract",anAbstract);
                hashMap.put("article_url",article_url);
                hashMap.put("media_info",media_info);
                hashMap.put("avatar_url",avatar_url);
                hashMap.put("name",name);
                hashMap.put("title",title);
                hashMap.put("behot_time",behot_time);
                hashMap.put("url",url);
                hashMaps.add(hashMap);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        newsAdapter = new NewsAdapter(R.layout.item_news_article_img,hashMaps);
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
