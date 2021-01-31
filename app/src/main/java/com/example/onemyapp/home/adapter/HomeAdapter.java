package com.example.onemyapp.home.adapter;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.deom.News;
import com.example.framewrok.base.base.BaseRvAdapter;
import com.example.net.bean.JournalismBean;
import com.example.net.bean.NewsBean;
import com.example.onemyapp.R;
import com.example.onemyapp.apter.LargeViewAdapter;
import com.example.onemyapp.apter.SmallViewAdapter;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends BaseRvAdapter<Object>{
    private final  int LARGE_TYPE=1;
    private List<News> newsBeans=new ArrayList<>();
    @Override
    protected int getLayoutid(int viewType) {
        switch (viewType){
            case LARGE_TYPE: return R.layout.newslargeview;
        }
        return R.layout.newslargeview;
    }

    @Override
    protected int getViewtype(int postion) {
        switch (postion){
            case 0: return LARGE_TYPE;
        }
        return LARGE_TYPE;
    }

    @Override
    protected void cover(BaseViewHolder holder, int position, Object newsBean) {
        switch (position){
            case 0:
                Log.i("---","gtl");

                List<JournalismBean.DataBean> newsLargeHot = (List<JournalismBean.DataBean>) newsBean;
                for (int i = 0; i < newsLargeHot.size(); i++) {
                    Gson gson = new Gson();
                    NewsBean newsBean1 = gson.fromJson(newsLargeHot.get(i).getContent(), NewsBean.class);
                    News news = new News(newsBean1.getAbstractX(), newsBean1.getArticle_url(),newsBean1.getUser_info().getAvatar_url(), newsBean1.getMedia_name(), newsBean1.getTitle(),newsBean1.getUser_info().getAvatar_url(),"");
                    newsBeans.add(news);
                    if (newsBeans.get(i).getAvatar_url()!=null){
                        disPlayNewsLargeHot(holder);
                    }else {
                        disPlayNewsSmallHot(holder);                    }
                }


                break;
            case 1:

                break;
        }
    }

    private void disPlayNewsLargeHot(BaseViewHolder holder) {
        Log.i("---","gtl");
        RecyclerView RvLargeView = holder.getView(R.id.RvLargeView);
        RvLargeView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
        LargeViewAdapter largeViewAdapter = new LargeViewAdapter();
        RvLargeView.setAdapter(largeViewAdapter);
        largeViewAdapter.updatelist(newsBeans);
        largeViewAdapter.notifyDataSetChanged();

    }

    private void disPlayNewsSmallHot( BaseViewHolder holder) {
        RecyclerView RvSmallView = holder.getView(R.id.RvLargeView);
        RvSmallView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
        SmallViewAdapter smallViewAdapter = new SmallViewAdapter();
        RvSmallView.setAdapter(smallViewAdapter);
        smallViewAdapter.updatelist(newsBeans);
        smallViewAdapter.notifyDataSetChanged();
    }
}
