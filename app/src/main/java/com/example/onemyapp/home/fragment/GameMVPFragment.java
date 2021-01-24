package com.example.onemyapp.home.fragment;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.framewrok.base.base.BaseMVPFragment;
import com.example.framewrok.base.base.BaseRvAdapter;
import com.example.framewrok.base.journalism.JournalismCountroller;
import com.example.framewrok.base.journalism.JournalismImpl;
import com.example.framewrok.base.net.NetConnectManager;
import com.example.net.bean.JournalismBean;
import com.example.onemyapp.R;

import com.example.onemyapp.home.adapter.HomeAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameMVPFragment extends BaseMVPFragment<JournalismImpl, JournalismCountroller.JournalismView> implements JournalismCountroller.JournalismView, BaseRvAdapter.IBaseRecyclerLinsterner {
    private RecyclerView recyle;
    private  List<Object> dataList=new ArrayList<>();
    HashMap<String,String> map;
    @Override
    protected void onregister() {

    }

    @Override
    protected void initHttpData() {
        if (NetConnectManager.getInstance().isConnected()){
            presenter.NewsShow("","api/news/feed/v58/",map,loadingPage);
            Toast.makeText(getContext(), "当前网络连接", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getContext(), "当前无网络连接", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDisConnected() {
        super.onDisConnected();
        Toast.makeText(getContext(), "当前无网络连接", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onConnected() {
        super.onConnected();
        presenter.NewsShow("","api/news/feed/v58/",map,loadingPage);
    }

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
        presenter=new JournalismImpl();


    }
//?iid=12507202490&device_id=37487219424&category=news_hots
    @Override
    protected void inData() {
        map=new HashMap<>();
        map.put("iid","12507202490");
        map.put("device_id","37487219424");
        map.put("category","");
        presenter.NewsShow("","api/news/feed/v58/",map,loadingPage);
        homeAdapter=new HomeAdapter();
        recyle.setAdapter(homeAdapter);
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
    private HomeAdapter homeAdapter;
    @Override
    public void onJournalismView(JournalismBean dataBeans) {
        Log.e("=======","123");
        dataList.add(dataBeans.getData());
        homeAdapter.updatelist(dataList);
        homeAdapter.setBaseRVAdapterlinterner(this);
//        for (int i=0;i<dataBeans.getData().size();i++){
//            Log.e("=======",""+dataBeans.getData().get(i).getContent());
//            try {
//                JSONObject jsonObject=new JSONObject(dataBeans.getData().get(i).getContent()+"");
//                String anAbstract = jsonObject.getString("abstract");//内容
//                Log.e("anAbstract",""+anAbstract);
//                String article_url = jsonObject.getString("article_url");//网址
//                Log.e("article_urlSSSSSS",""+article_url);
//                String media_info = jsonObject.getString("media_info");
//                Log.e("media_infoAAAAAAA",""+media_info);
//                JSONObject jsonObject1=new JSONObject(media_info);
//                String avatar_url = jsonObject1.getString("avatar_url");//头像
//                Log.e("avatar_urlSSSSSS",""+avatar_url);
//                String name = jsonObject1.getString("name");//姓名
//                Log.e("nameSSSSSS",""+name);
//                String share_info = jsonObject.getString("share_info");
//                JSONObject jsonObject2=new JSONObject(share_info);
//                String title = jsonObject2.getString("title");
//                Log.e("titleSSSSS",""+title);//标题
//                String middle_image = jsonObject.getString("middle_image");
//                JSONObject jsonObject3=new JSONObject(middle_image);
//                String url = jsonObject3.getString("url");//图片
//                Log.e("url===============",""+url);
//                News news = new News(anAbstract, article_url, avatar_url, name, title, url);
//                arrayList.add(news);
//                recommendApter.notifyDataSetChanged();
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }



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
