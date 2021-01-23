package com.example.news.ui.activity;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.framework.base.BaseActivity;
import com.example.framework.dao.DragBean;
import com.example.framework.manager.DragMananger;
import com.example.framework.view.ToolBar;
import com.example.news.R;
import com.example.news.adpter.DragAdpter;
import com.example.news.adpter.EditAdpter;

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
    private DragAdpter mineAdpter;
    private EditAdpter editAdpter;

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
        //我的页面的布局
        List<DragBean> dragList = DragMananger.getInstance().getDragList();
        mineAdpter = new DragAdpter(R.layout.item_search_sug_text,dragList);
        rvMine.setAdapter(mineAdpter);
        rvMine.setLayoutManager(new GridLayoutManager(this,4));
        //隐藏页面的布局
        List<DragBean> editList = DragMananger.getInstance().getEditList();
        editAdpter = new EditAdpter(R.layout.item_search_sug_text,editList);
        rvYin.setAdapter(editAdpter);
        rvYin.setLayoutManager(new GridLayoutManager(this,4));
        toolbar.setiToolBarClickListenter(this);//注册toolbar监听
    }

    @Override
    protected int getlayoutids() {
        return R.layout.activity_dragsort;
    }

    @Override
    public void onLeftClick() {
        super.onLeftClick();
        DragsortActivity.this.finish();
    }
}
