package com.bw.a1805atoutiao.ui.activity;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bw.a1805atoutiao.R;
import com.bw.a1805atoutiao.adapter.TagNotShowAdapter;
import com.bw.a1805atoutiao.adapter.TagShowAdapter;
import com.bw.framework.base.BaseActivity;
import com.bw.framework.bean.TitleBean;
import com.bw.framework.callback.ITagNotShowItemClickListener;
import com.bw.framework.manager.TitleManage;

import java.util.List;

public class TagManageActivity extends BaseActivity {
    private Toolbar tagToobar;
    private RecyclerView showRecycle;
    private RecyclerView notshowRecycle;
    private TagShowAdapter tagShowAdapter;
    private TagNotShowAdapter tagNotShowAdapter;
    private TextView editTag;
    private boolean isShow=false;
    @Override
    protected void initEvent() {

        //返回键
        tagToobar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 finish();
            }
        });

        //点击编辑
        editTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (isShow){
                   isShow=false;
                   editTag.setText(R.string.tag_edit_name);
                   tagShowAdapter.setShow(isShow);
               }else {
                   isShow=true;
                   editTag.setText(R.string.tag_finish_name);
                   tagShowAdapter.setShow(isShow);
               }
            }
        });
        //不显示的标题监听
        tagNotShowAdapter.setOnItemNotShowItemClickListener(new ITagNotShowItemClickListener() {
            @Override
            public void onItemClick(TitleBean titleBean, int position) {
                if (isShow){
                    Toast.makeText(TagManageActivity.this, titleBean.getTitle()+""+position, Toast.LENGTH_SHORT).show();
                    titleBean.setIsShow(true);
                    tagNotShowAdapter.removeOneData(titleBean);
                    tagShowAdapter.addOneData(titleBean);
                    TitleManage.getInstance().update(titleBean,position);
                }

            }
        });

        //显示的标题监听
        tagShowAdapter.setOnItemShowItemClickListener(new ITagNotShowItemClickListener() {
            @Override
            public void onItemClick(TitleBean titleBean, int position) {
                if (isShow){
                    Toast.makeText(TagManageActivity.this, titleBean.getTitle()+""+position, Toast.LENGTH_SHORT).show();
                    titleBean.setIsShow(false);
                    tagShowAdapter.removeOneData(titleBean);
                    tagNotShowAdapter.addOneData(titleBean);
                    TitleManage.getInstance().update(titleBean,position);
                }

            }
        });
    }

    @Override
    protected void initData() {
        tagToobar.setTitle(R.string.tag_tuo_name);
        tagToobar.setNavigationIcon(R.drawable.ic_back_write_24dp);
        tagToobar.setTitleTextColor(Color.WHITE);


        tagShowAdapter=new TagShowAdapter();
        tagNotShowAdapter=new TagNotShowAdapter();
        //显示的列表
        List<TitleBean> showTitleBeans = TitleManage.getInstance().getShowTitleBeans();
        showRecycle.setAdapter(tagShowAdapter);
        tagShowAdapter.updataData(showTitleBeans);

        //不显示的列表
        List<TitleBean> notShowTitleBeans = TitleManage.getInstance().getNotShowTitleBeans();
        notshowRecycle.setAdapter(tagNotShowAdapter);
        tagNotShowAdapter.updataData(notShowTitleBeans);
    }

    @Override
    protected void initView() {


        editTag = findViewById(R.id.edit_tag);

        tagToobar = findViewById(R.id.tag_toobar);
        showRecycle = findViewById(R.id.show_recycle);
        notshowRecycle = findViewById(R.id.notshow_recycle);
        showRecycle.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL));
        notshowRecycle.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL));
    }

    @Override
    protected void createPresenter() {

    }

    @Override
    protected int getlayoutid() {
        return R.layout.activity_tag_manage;
    }
}