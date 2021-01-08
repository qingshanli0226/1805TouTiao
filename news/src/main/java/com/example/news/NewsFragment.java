package com.example.news;


import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;

import com.example.framework.base.BaseFragment;
import com.example.framework.base.IPresenter;
import com.example.framework.base.IView;
import com.google.android.material.tabs.TabLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends BaseFragment<IPresenter, IView> {

    private TabLayout tabLayout;
    private String[] titles = new String[]{"推荐","热点","视频","社会","娱乐","科技","问答","汽车"};

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
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView(View inflate) {
        tabLayout = inflate.findViewById(R.id.newsTab);
    }
}
