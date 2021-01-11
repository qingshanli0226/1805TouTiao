package com.example.onemyapp.home.fragment;

import android.util.Log;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bawei.deom.News;
import com.example.framewrok.base.base.BaseFragment;
import com.example.framewrok.base.journalism.JournalismCountroller;
import com.example.framewrok.base.journalism.JournalismImpl;
import com.example.net.bean.JournalismBean;
import com.example.onemyapp.R;
import com.example.onemyapp.apter.RecommendApter;
import com.example.onemyapp.bean.LabelBean;
import com.example.onemyapp.home.adapter.MyHomePager;
import com.google.android.material.tabs.TabLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameFragment extends BaseFragment<JournalismImpl, JournalismCountroller.JournalismView> implements JournalismCountroller.JournalismView {
    private RecyclerView recyle;
    ArrayList<News> arrayList=new ArrayList<>();
     RecommendApter recommendApter;
    @Override
    protected int getLayoutid() {
        return R.layout.gamefragment;
    }

    @Override
    protected void intView(View view) {
        recyle = (RecyclerView) view.findViewById(R.id.recyle);

    }

    @Override
    protected void inPresone() {
        prine=new JournalismImpl();

    }
//?iid=12507202490&device_id=37487219424&category=news_hots
    @Override
    protected void inData() {
        HashMap<String,String> map=new HashMap<>();
        map.put("iid","12507202490");
        map.put("device_id","37487219424");
        map.put("category","news_entertainment");
        prine.NewsShow("api/news/feed/v58/",map);
       recommendApter=new RecommendApter(R.layout.newsviewimg,arrayList);
       recyle.setAdapter(recommendApter);
       recyle.setLayoutManager(new LinearLayoutManager(getContext()));
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
        for (int i=0;i<dataBeans.getData().size();i++){
            Log.e("=======",""+dataBeans.getData().get(i).getContent());
            try {
                JSONObject jsonObject=new JSONObject(dataBeans.getData().get(i).getContent()+"");
                String anAbstract = jsonObject.getString("abstract");//内容
                Log.e("anAbstract",""+anAbstract);
                String article_url = jsonObject.getString("article_url");//网址
                Log.e("article_urlSSSSSS",""+article_url);
                String media_info = jsonObject.getString("media_info");
                Log.e("media_infoAAAAAAA",""+media_info);
                JSONObject jsonObject1=new JSONObject(media_info);
                String avatar_url = jsonObject1.getString("avatar_url");//头像
                Log.e("avatar_urlSSSSSS",""+avatar_url);
                String name = jsonObject1.getString("name");//姓名
                Log.e("nameSSSSSS",""+name);
                String share_info = jsonObject.getString("share_info");
                JSONObject jsonObject2=new JSONObject(share_info);
                String title = jsonObject2.getString("title");
                Log.e("titleSSSSS",""+title);//标题
                String middle_image = jsonObject.getString("middle_image");
                JSONObject jsonObject3=new JSONObject(middle_image);
                String url = jsonObject3.getString("url");//图片
                Log.e("url===============",""+url);
                News news = new News(anAbstract, article_url, avatar_url, name, title, url);
                arrayList.add(news);
                recommendApter.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }



    }

    @Override
    public void loading() {

    }

    @Override
    public void hideloading() {

    }
}
