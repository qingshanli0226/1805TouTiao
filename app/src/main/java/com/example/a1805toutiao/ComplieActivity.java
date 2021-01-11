package com.example.a1805toutiao;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a1805toutiao.adaper.ComplieAdaper;
import com.example.a1805toutiao.adaper.OtherlieAdaper;
import com.example.framework.base.BaseActivity;
import com.example.framework.dao.MessageMangerUlis;
import com.example.framework.dao.TouTiaoMessageGreenBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 编辑activity
 */
public class ComplieActivity extends BaseActivity {
    @BindView(R.id.complie_edit)
    Button complieEdit;
    @BindView(R.id.Rv_edit)
    RecyclerView RvEdit;
    @BindView(R.id.Rv_other)
    RecyclerView RvOther;
    private boolean isChange = false;
    private Long aLong;
    private List<TouTiaoMessageGreenBean> list = new ArrayList<>();
    private List<String> comList = new ArrayList<>();
    private List<String> editList = new ArrayList<>();
    private ComplieAdaper complieAdaper;
    private OtherlieAdaper otherlieAdaper;
    private MessageMangerUlis.IMessageListener messageListener = new MessageMangerUlis.IMessageListener() {
        @Override
        public void OnResult(boolean isSuccess, List<TouTiaoMessageGreenBean> touTiaoMessageGreenBeanDao) {
                list.addAll(touTiaoMessageGreenBeanDao);
        }
    };
    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        String[] stringArray = getResources().getStringArray(R.array.mobile_news_name);
        for (int  i = 0;i<stringArray.length;i++){
            if (i<7){
                comList.add(stringArray[i]);
            }else {
                Log.i("====","123456");
                editList.add(stringArray[i]);
            }
        }
        //读取数据库监听
        MessageMangerUlis.getInstance().queryMessage(messageListener);
        initAdaper();

    }

    @Override
    protected void initView() {
        //事先清理数据
        list.clear();
        comList.clear();
        ButterKnife.bind(this);
        RvEdit.setLayoutManager(new GridLayoutManager(this,4));
        RvOther.setLayoutManager(new GridLayoutManager(this,4));
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_complie;
    }

    @OnClick(R.id.complie_edit)
    public void onViewClicked() {
        if (isChange){
            complieEdit.setText("编辑");
            isChange  =  false;
        }else {
            complieEdit.setText("完成");
            isChange  = true;
        }
    }

    /**
     *    标题数据适配
     */
    private void initAdaper() {
        complieAdaper = new ComplieAdaper(R.layout.item_complie,comList);
        RvEdit.setAdapter(complieAdaper);
        complieAdaper.notifyDataSetChanged();

        otherlieAdaper = new OtherlieAdaper(R.layout.item_complie,editList);
        RvOther.setAdapter(otherlieAdaper);
        otherlieAdaper.notifyDataSetChanged();
    }
}