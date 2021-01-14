package com.example.news.ui.activity;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.framework.base.BaseActivity;
import com.example.framework.view.ToolBar;
import com.example.news.R;
import com.example.news.adpter.MineAdpter;

import java.util.ArrayList;
import java.util.List;

/**
 * 拖拽排序的类
 */
public class DragsortActivity extends BaseActivity {
    private ToolBar toolbar;
    private TextView tvTitle;
    private TextView tv;
    private TextView tvBtnEdit;
    private RecyclerView rvMine;
    private TextView tvYin;
    private RecyclerView rvYin;
    private List<String> mineString = new ArrayList<>();
    private MineAdpter mineAdpter;


    @Override
    protected void initView() {
        //初始化控件
        toolbar = findViewById(R.id.toolbar);
        tvTitle = findViewById(R.id.tv_title);
        tv = findViewById(R.id.tv);
        tvBtnEdit = findViewById(R.id.tv_btn_edit);
        rvMine = findViewById(R.id.rv_mine);
        tvYin = findViewById(R.id.tv_yin);
        rvYin = findViewById(R.id.rv_yin);
        //mineString 添加默认4条数据
        mineString.add("推荐");
        mineString.add("热点");
        mineString.add("视频");
        mineString.add("社会");
        mineString.add("娱乐");
        mineString.add("科技");
        mineString.add("回答");
        mineString.add("汽车");
        //rvMine默认有4条数据
        mineAdpter = new MineAdpter(R.layout.item_search_sug_text,mineString);
        rvMine.setAdapter(mineAdpter);
        rvMine.setLayoutManager(new GridLayoutManager(this,4));
    }

    @Override
    protected int getlayoutids() {
        return R.layout.activity_dragsort;
    }
}
