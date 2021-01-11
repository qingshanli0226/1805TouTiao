package com.example.onemyapp.home.fragment;

import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.deom.News;
import com.example.framewrok.base.base.BaseFragment;
import com.example.framewrok.base.base.BaseRvAdapter;
import com.example.framewrok.base.journalism.JournalismCountroller;
import com.example.framewrok.base.journalism.JournalismImpl;
import com.example.net.bean.JournalismBean;
import com.example.onemyapp.R;
import com.example.onemyapp.apter.HomeAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;



public class FinanceFragment extends BaseFragment<JournalismImpl, JournalismCountroller.JournalismView> implements JournalismCountroller.JournalismView , BaseRvAdapter.IBaseRecyclerLinsterner {
        private RecyclerView recyle;
        private HomeAdapter homeAdapter;
//        ArrayList<JournalismBean.DataBean> arrayList=new ArrayList<>();
        @Override
        protected int getLayoutid() {
            return R.layout.financefragment;
        }

        @Override
        protected void intView(View inflate) {
            recyle = (RecyclerView) inflate.findViewById(R.id.recyle);
            recyle.setLayoutManager(new LinearLayoutManager(getContext()));
            homeAdapter=new HomeAdapter();
            recyle.setAdapter(homeAdapter);
        }
        @Override
        protected void inPresone () {
            prine = new JournalismImpl();
        }

        @Override
        protected void inData () {
            prine.NewsShow();

        }

        @Override
        protected void ondestroy () {




    }
    @Override
    public void onJournalismView (JournalismBean dataBeans){
        List<JournalismBean.DataBean> data = dataBeans.getData();
        for (int i = 0; i < data.size(); i++) {
            String content = data.get(i).getContent();
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
                News news = new News(anAbstract, article_url, avatar_url, name, title, url);
                List<News> dataList = new ArrayList<>();
                dataList.add(news);
//                homeAdapter.updatelist(dataList);
                homeAdapter.setBaseRVAdapterlinterner(this);
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

    @Override
    public void onItemclick(int position) {

    }
}
