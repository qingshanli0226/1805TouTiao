package com.example.onemyapp.apter;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.deom.News;
import com.example.framewrok.base.base.BaseRvAdapter;
import com.example.net.bean.JournalismBean;
import com.example.net.bean.NewsBean;
import com.example.onemyapp.R;
import com.example.onemyapp.home.adapter.LargeViewAdapter;
import com.example.onemyapp.home.adapter.SmallViewAdapter;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends BaseRvAdapter<Object>{
    private final  int SMALL_TYPE=0;
    private final  int LARGE_TYPE=1;
    private List<NewsBean> newsBeans=new ArrayList<>();
    @Override
    protected int getLayoutid(int viewType) {
        switch (viewType){
//            case SMALL_TYPE: return R.layout.newssmallview;
            case LARGE_TYPE: return R.layout.newslargeview;
        }
        return R.layout.newslargeview;
    }

    @Override
    protected int getViewtype(int postion) {
        switch (postion){
//            case 0: return SMALL_TYPE;
            case 0: return LARGE_TYPE;
        }
        return LARGE_TYPE;
    }

    @Override
    protected void cover(BaseViewHolder holder, int position, Object newsBean) {
        switch (position){
            case 0:
                Log.i("---","gtl");
//                    disPlayNewsSmallHot(newsBean,holder);
                break;
            case 1:
                List<JournalismBean.DataBean> newsLargeHot = (List<JournalismBean.DataBean>) newsBean;
                for (int i = 0; i < newsLargeHot.size(); i++) {
                    Gson gson = new Gson();
                    NewsBean newsBean1 = gson.fromJson(newsLargeHot.get(i).getContent(), NewsBean.class);
                    newsBeans.add(newsBean1);
                    if (newsBeans.get(i).getUrl()!=null){
                        disPlayNewsLargeHot(newsBean,holder);
                    }else {
                        disPlayNewsSmallHot(newsBean,holder);
                    }
                }
                break;
        }
    }

    private void disPlayNewsLargeHot(Object newsBean, BaseViewHolder holder) {
        Log.i("---","gtl");

        RecyclerView RvLargeView = holder.getView(R.id.RvLargeView);
        RvLargeView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
        LargeViewAdapter largeViewAdapter = new LargeViewAdapter();
        RvLargeView.setAdapter(largeViewAdapter);
        largeViewAdapter.updatelist(newsBeans);
    }

    private void disPlayNewsSmallHot(Object newsBean, BaseViewHolder holder) {

        RecyclerView RvSmallView = holder.getView(R.id.RvSmallView);
        RvSmallView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
        SmallViewAdapter smallViewAdapter = new SmallViewAdapter();
        RvSmallView.setAdapter(smallViewAdapter);
        smallViewAdapter.updatelist(newsBeans);
    }
}
