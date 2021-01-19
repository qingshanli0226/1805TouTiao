package com.example.news.view;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.framework.base.BaseFragment;
import com.example.framework.base.BaseMVPFragment;
import com.example.framework.dao.DragBean;
import com.example.framework.manager.DragMananger;
import com.example.news.NewsDetailsActivity;
import com.example.news.R;
import com.example.news.adpter.Newadpter;
import com.example.news.adpter.NewsAdapter;
import com.example.news.adpter.NewsDrAdpter;
import com.example.news.contract.NewsContract;

import com.example.news.fragment.NewsDrFragment;
import com.example.news.presenter.NewsPresenterImpl;
import com.example.news.ui.activity.DragsortActivity;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class NewsFragment extends BaseFragment implements View.OnClickListener {
    private TabLayout newsTab;
    private ImageView ivAdd;
    private ViewPager vr;
    private List<String> stringList = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();
    private NewsDrAdpter newsDrAdpter;


    @Override
    public void onClick(View view) {

    }

    @Override
    protected void initView() {
        //初始化控件
        newsTab = findViewById(R.id.newsTab);
        ivAdd = findViewById(R.id.iv_add);
        vr = findViewById(R.id.vr);
        //初始化创建Fragment 以及TableLayout
        for (DragBean dragBean : DragMananger.getInstance().getDragList()) {
            stringList.add(dragBean.getUname());
            fragmentList.add(new NewsDrFragment());
        }
        newsDrAdpter = new NewsDrAdpter(getChildFragmentManager(),fragmentList,stringList);
        vr.setAdapter(newsDrAdpter);
        newsTab.setupWithViewPager(vr);
        vr.setOffscreenPageLimit(10);

    }

    @Override
    protected int getlayoutids() {
        return R.layout.fragment_news;
    }


//    private ImageView ivAdd;
//    private TabLayout tabLayout;
//    private String[] titles = new String[]{"推荐","热点","视频","社会","娱乐","科技","问答","汽车"};
//    private RecyclerView newsRec;
//    private NewsAdapter newsAdapter;
//    private Newadpter newAdapter;
//
//    @Override
//    protected void initData() {
//        for (int i = 0; i < titles.length; i++) {
//            tabLayout.addTab(tabLayout.newTab());
//        }
//        for (int i = 0; i < titles.length; i++) {
//            tabLayout.getTabAt(i).setText(titles[i]);
////        }
////        httpPresenter.getNewsInfo();
//        //点击进入拖拽排序列表
//        ivAdd.setOnClickListener(this);
//    }
//
//    @Override
//    protected void initView() {
//        tabLayout = findViewById(R.id.newsTab);
//        newsRec = findViewById(R.id.newsRec);
//        ivAdd = findViewById(R.id.iv_add);
//    }
//
//    @Override
//    protected void initPresenter() {
//        httpPresenter = new NewsPresenterImpl();
//    }
//
//    @Override
//    protected int getlayoutids() {
//        return R.layout.fragment_news;
//    }
//
//    @Override
//    public void onNews(final List<HashMap<String,String>> newBeans) {
//        //适配器进行适配
////        newsAdapter = new NewsAdapter(R.layout.item_news_article_img,newBeans);
////        newsRec.setAdapter(newsAdapter);
//
////        newsAdapter = new NewsAdapter();
////        newsAdapter.addOneData(newBeans);
////        newsRec.setAdapter(newsAdapter);
////        newsRec.setLayoutManager(new LinearLayoutManager(getContext()));
////        newAdapter =  new Newadpter(R.layout.item_news_article_img,newBeans);
////        newsRec.setAdapter(newAdapter);
////        newsRec.setLayoutManager(new LinearLayoutManager(getContext()));
////        //点击进入详情页面
////        newAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
////            @Override
////            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
////                String article_url = newBeans.get(position).get("article_url");
////                Intent intent = new Intent(getActivity(), NewsDetailsActivity.class);
////                intent.putExtra("NewsPath",article_url);
////                startActivity(intent);
////            }
////        });
//
//    }
//
//    /**
//     * 点击事件
//     * @param view
//     */
//    @Override
//    public void onClick(View view) {
//        if (view.getId() == R.id.iv_add) {
//            //跳转到搜索页面
//            Intent intent = new Intent(getContext(), DragsortActivity.class);
//            startActivity(intent);
//        }
//    }
}
