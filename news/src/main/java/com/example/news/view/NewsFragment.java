package com.example.news.view;


import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.framework.base.BaseFragment;
import com.example.framework.dao.DragBean;
import com.example.framework.manager.DragMananger;
import com.example.news.R;
import com.example.news.adpter.NewsDrAdpter;
import com.example.news.ui.fragment.view.NewsDrFragment;
import com.example.news.ui.activity.DragsortActivity;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
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
    }
    @Override
    protected void initDate() {
        //初始化创建Fragment 以及TableLayout
        DragMananger.getInstance().setiDropLister(new DragMananger.IDropLister() {
            @Override
            public void onsucess() {
                List<DragBean> dragList = DragMananger.getInstance().getDragList();
                Toast.makeText(getContext(), ""+dragList.size(), Toast.LENGTH_SHORT).show();
                for (int i = 0; i < dragList.size(); i++) {
                    if (dragList.size()>0){
                        stringList.add(dragList.get(i).getUname());
                        fragmentList.add(new NewsDrFragment());
                    }
                }
                newsDrAdpter = new NewsDrAdpter(getChildFragmentManager(),fragmentList,stringList);
                vr.setAdapter(newsDrAdpter);
                newsTab.setupWithViewPager(vr);
                vr.setOffscreenPageLimit(5);
            }
        });
        ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),DragsortActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected int getlayoutids() {
        return R.layout.fragment_news;
    }
}
