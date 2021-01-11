package com.example.onemyapp.apter;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.deom.News;
import com.example.framewrok.base.base.BaseRvAdapter;
import com.example.onemyapp.R;
import com.example.onemyapp.home.adapter.LargeViewAdapter;
import com.example.onemyapp.home.adapter.SmallViewAdapter;

import java.util.List;

public class HomeAdapter extends BaseRvAdapter<Object>{
    private final  int SMALL_TYPE=0;
    private final  int LARGE_TYPE=1;
    @Override
    protected int getLayoutid(int viewType) {
        switch (viewType){

            case SMALL_TYPE: return R.layout.newssmallview;
            case LARGE_TYPE: return R.layout.newslargeview;
        }
        return R.layout.newsview;
    }

    @Override
    protected int getViewtype(int postion) {
        switch (postion){
            case 0: return SMALL_TYPE;
            case 1: return LARGE_TYPE;
        }
        return SMALL_TYPE;
    }

    @Override
    protected void cover(BaseViewHolder holder, int position, Object newsBean) {
        switch (position){
            case 0:
                Log.i("---","gtl");
                    disPlayNewsSmallHot(newsBean,holder);
                break;
            case 1:
                    disPlayNewsLargeHot(newsBean,holder);
                break;
        }
    }

    private void disPlayNewsLargeHot(Object newsBean, BaseViewHolder holder) {
        Log.i("---","gtl");
        List<News> newsLargeHot = (List<News>) newsBean;
        Log.i("---",""+((List<News>) newsBean).size());
        RecyclerView RvLargeView = holder.getView(R.id.RvLargeView);
        RvLargeView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
        LargeViewAdapter largeViewAdapter = new LargeViewAdapter();
        RvLargeView.setAdapter(largeViewAdapter);
        largeViewAdapter.updatelist(newsLargeHot);
    }

    private void disPlayNewsSmallHot( Object newsBean, BaseViewHolder holder) {
        List<News> newsSmallHot = (List<News>) newsBean;
        RecyclerView RvSmallView = holder.getView(R.id.RvSmallView);
        RvSmallView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
        SmallViewAdapter smallViewAdapter = new SmallViewAdapter();
        RvSmallView.setAdapter(smallViewAdapter);
        smallViewAdapter.updatelist(newsSmallHot);
    }
}
