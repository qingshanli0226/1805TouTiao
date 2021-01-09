package com.bw.a1805atoutiao.ui.fragment.newsframent;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bw.a1805atoutiao.R;
import com.bw.bean.NewsBean;
import com.bw.common.Constants;
import com.bw.framework.base.BaseFragment;
import com.bw.framework.mvptest.control.Control;
import com.bw.framework.mvptest.presenter.NewsPresenter;

import java.util.HashMap;
//http://is.snssdk.com/api/news/feed/v62/?iid=5034850950&device_id=6096495334&refer=1&count=20&aid=13&category=&max_behot_time=1609986645
public class LoadFragment extends BaseFragment<NewsPresenter> implements Control.newsControlView {
    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {
//        System.setProperty("http.proxyHost", "my.proxyhost.com");
//        System.setProperty("http.proxyPort", "1234");

        //Log.e("time",""+System.currentTimeMillis());
        HashMap<String,String> map=new HashMap<>();
        map.put("iid","12507202490");
        map.put("device_id","37487219424");
        map.put("count","20");
        map.put("category","news_hots");
        map.put("max_behot_time",System.currentTimeMillis()+"");
        mPresenter.news(Constants.BASE_NEWS_FEED,map);
    }

    @Override
    protected void initView(View view) {

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
          NewsBean newsBeans=(NewsBean) objects[0];
        Toast.makeText(getContext(), ""+newsBeans.getData().get(2).getContent(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void error(String msg) {
        Log.e("error",""+msg);
    }
}
