package com.bw.home.fragment;

import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.framework.base.BaseFragment;
import com.bw.home.R;
import com.bw.home.newsadapter.NewsAdapter;
import com.bw.home.newsmvp.NewsArticleContract;
import com.bw.home.newsmvp.NewsPresenterImpl;
import com.bw.net.bean.NewsArticeBean1;
import com.bw.net.bean.NewsArticeBean2;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RecommenFragment extends BaseFragment<NewsArticleContract.newsView, NewsPresenterImpl> implements NewsArticleContract.newsView {
    private RecyclerView rvRecommen;

    private List<NewsArticeBean2> list = new ArrayList<>();
    private NewsAdapter newsAdapter;

    @Override
    protected void initData() {
        httpPresenter.newsData();
    }

    @Override
    protected void initPresenter() {
        httpPresenter = new NewsPresenterImpl();
    }

    @Override
    protected void initView() {
        rvRecommen = findViewById(R.id.rvRecommen);

        newsAdapter = new NewsAdapter(R.layout.item_news, list);
        rvRecommen.setAdapter(newsAdapter);
        rvRecommen.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recommen;
    }

    @Override
    public void getNewsOk(NewsArticeBean1 newsArticeBean1) {
        for (int i = 0; i < newsArticeBean1.getData().size(); i++) {

            Log.e("=======", "" + newsArticeBean1.getData().get(i).getContent());
            try {
                JSONObject jsonObject = new JSONObject(newsArticeBean1.getData().get(i).getContent() + "");
                String anAbstract = jsonObject.getString("abstract");//内容
                Log.e("===anAbstract:  ", "" + anAbstract);
                String article_url = jsonObject.getString("article_url");//网址
                Log.e("===article_url:  ", "" + article_url);
                String media_info = jsonObject.getString("media_info");
                Log.e("===media_info:  ", "" + media_info);
                JSONObject jsonObject1 = new JSONObject(media_info);
                String avatar_url = jsonObject1.getString("avatar_url");//头像
                Log.e("===avatar_url:  ", "" + avatar_url);
                String name = jsonObject1.getString("name");//姓名
                Log.e("===name:  ", "" + name);
                String share_info = jsonObject.getString("share_info");
                JSONObject jsonObject2 = new JSONObject(share_info);
                String title = jsonObject2.getString("title");
                Log.e("===title:  ", "" + title);//标题
                String middle_image = jsonObject.getString("middle_image");
                JSONObject jsonObject3 = new JSONObject(middle_image);
                String url = jsonObject3.getString("url");//图片
                Log.e("===url:  ", "" + url);
                NewsArticeBean2 news = new NewsArticeBean2(anAbstract, article_url, avatar_url, name, title, url);
                list.add(news);
                newsAdapter.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


}


    @Override
    public void onError(String message) {

    }

}
