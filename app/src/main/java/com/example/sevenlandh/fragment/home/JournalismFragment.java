package com.example.sevenlandh.fragment.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.viewpager.widget.ViewPager;

import com.example.freamwork.mvp.BaseFragment;
import com.example.sevenlandh.App;
import com.example.sevenlandh.R;
import com.example.sevenlandh.activity.DetailsActivity;
import com.example.sevenlandh.adapter.JournalismTabAdapter;
import com.example.sevenlandh.entity.DaoEntity;
import com.example.sevenlandh.entity.DaoEntityDao;
import com.example.sevenlandh.entity.DaoSession;
import com.google.android.material.tabs.TabLayout;
import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

public class JournalismFragment extends BaseFragment {

    private TabLayout journalTab;
    private ViewPager journalVp;
    private ArrayList<String> list_tab=new ArrayList<>();
    private ImageView homeToobarList;
    private JournalismTabAdapter journalismTabAdapter;
    private ImageView imgAdd;
    private DaoEntityDao daoEntityDao;
    private DaoEntity daoEntity;
    @Override
    protected int bandLayout() {
        return R.layout.fragment_journalism;
    }
    @Override
    protected void initEvent() {
        homeToobarList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().postSticky("0");
            }
        });
        imgAdd.setOnClickListener(new View.OnClickListener() {//跳转添加标签界面
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), DetailsActivity.class));
            }
        });
    }
    @Override
    protected void initData(Bundle savedInstanceState) {
        DaoSession daoSession= ((App) getActivity().getApplication()).getDaoSession();
        daoEntityDao  = daoSession.getDaoEntityDao();
        list_tab.clear();

        list_tab.add("育儿");
        list_tab.add("手机");
        list_tab.add("政务");
        list_tab.add("文化");
        list_tab.add("情感");

        for (int i = 0; i < list_tab.size(); i++) {
            daoEntity = new DaoEntity(null, list_tab.get(i));

        }
        daoEntityDao.insert(daoEntity);

        journalismTabAdapter=new JournalismTabAdapter(getFragmentManager(),list_tab);
        journalVp.setAdapter(journalismTabAdapter);
        journalTab.setupWithViewPager(journalVp);

    }
    @Override
    protected void initView() {
        journalTab = F(R.id.journal_tab);
        journalVp = F(R.id.journal_vp);
        imgAdd = F(R.id.img_add);
        homeToobarList = F(R.id.home_toobar_list);
    }
}