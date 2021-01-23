package com.example.a1805toutiao;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.a1805toutiao.adaper.ComplieAdaper;
import com.example.a1805toutiao.adaper.OtherlieAdaper;
import com.example.a1805toutiao.news.type.NewsTypeFragment;
import com.example.framework.base.BaseActivity;
import com.example.framework.dao.TouTiaoMessageGreenBean;
import com.example.framework.manager.MessageManager;
import com.example.framework.manager.NewsFragmentManager;
import com.example.framework.manager.listener.IMessageListener;
import com.example.framework.view.TouTiaoRecycleView;
import com.google.android.material.appbar.AppBarLayout;

import java.util.List;
import java.util.concurrent.locks.Lock;

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
    TouTiaoRecycleView RvEdit;
    @BindView(R.id.Rv_other)
    TouTiaoRecycleView RvOther;
    @BindView(R.id.toolbar_left_iv)
    ImageView toolbarLeftIv;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    AppBarLayout toolbar;
    private boolean isChange = false;
    private Long aLong;
    private ComplieAdaper complieAdaper;
    private OtherlieAdaper otherlieAdaper;

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initListener() {
        toolbarLeftIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ComplieActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        complieEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isChange) {
                    complieEdit.setText("编辑");
                    isChange = false;

                } else {
                    complieEdit.setText("完成");
                    isChange = true;
                }
                complieAdaper.setEdit(isChange);
                complieAdaper.notifyDataSetChanged();
            }
        });
        complieAdaper.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                if (!isChange) {
                    complieEdit.setText("完成");
                    isChange = true;
                    complieAdaper.setEdit(isChange);
                    complieAdaper.notifyDataSetChanged();
                }

                return true;
            }
        });
        complieAdaper.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if(isChange){
                    if(position>-1){
                        MessageManager.getInstance().tabDelete(position, new IMessageListener() {
                            @Override
                            public void OnResult(boolean isSuccess, List<TouTiaoMessageGreenBean> touTiaoMessageGreenBeanDao) {
                                if(isSuccess){
                                    NewsFragmentManager.getInstance().deleteFragment(position);
                                    complieAdaper.notifyItemRemoved(position);
                                    otherlieAdaper.notifyItemInserted(0);
                                }
                            }
                        });
                    }
                }
            }
        });
        otherlieAdaper.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if(isChange){
                    if(position>-1){
                        MessageManager.getInstance().tabAdd(position, new IMessageListener() {
                            @Override
                            public void OnResult(boolean isSuccess, List<TouTiaoMessageGreenBean> touTiaoMessageGreenBeanDao) {
                                if(isSuccess){
                                    List<TouTiaoMessageGreenBean> comList = MessageManager.getInstance().getComList();
                                    TouTiaoMessageGreenBean bean = comList.get(comList.size()-1);
                                    int index = NewsFragmentManager.getInstance().getAllTags().indexOf(bean.getTilte());
                                    if(index!=-1){
                                        Fragment fragment = NewsFragmentManager.getInstance().getAllFragments().get(index);
                                        NewsFragmentManager.getInstance().addFragment(bean.getTilte(),fragment);

                                    }else {
                                        NewsFragmentManager.getInstance().addFragment(bean.getTilte(),new NewsTypeFragment(Math.toIntExact(bean.getId()),bean.getTag()));
                                    }
                                    logI("Yoyo",""+NewsFragmentManager.getInstance().getVisibleFragments().size());
                                    complieAdaper.notifyItemInserted(MessageManager.getInstance().getComList().size());
                                    otherlieAdaper.notifyItemRemoved(position);
                                }
                            }
                        });
                    }
                }
            }
        });
    }

    @Override
    protected void initData() {
        RvOther.setNestedScrollingEnabled(false);

    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        RvEdit.setLayoutManager(new GridLayoutManager(this, 4));
        RvOther.setLayoutManager(new GridLayoutManager(this, 4));
        toolbarTitle.setText(getString(R.string.title_item_drag));
        toolbarLeftIv.setImageResource(R.drawable.back);
        toolbar.setBackgroundColor(getColor(R.color.themeColor));
        toolbarTitle.setTextSize(20);
        initAdaper();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_complie;
    }



    /**
     * 标题数据适配
     */
    private void initAdaper() {
        complieAdaper = new ComplieAdaper(R.layout.item_complie, MessageManager.getInstance().getComList());
        RvEdit.setAdapter(complieAdaper);
        complieAdaper.notifyDataSetChanged();

        otherlieAdaper = new OtherlieAdaper(R.layout.item_complie, MessageManager.getInstance().getEditList());
        RvOther.setAdapter(otherlieAdaper);
        otherlieAdaper.notifyDataSetChanged();
    }

}