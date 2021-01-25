package com.example.onemyapp.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.framewrok.base.MyPagerAdapter;
import com.example.framewrok.base.base.BaseFragment;
import com.example.onemyapp.UiUtils;
import com.example.onemyapp.activity.LableActivity;
import com.example.onemyapp.R;
import com.example.onemyapp.bean.LabelBean;
import com.google.android.material.tabs.TabLayout;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class HomeMVPFragment extends BaseFragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyPagerAdapter homePager;
    private List<Fragment> fragments=new ArrayList<>();
    private GameMVPFragment gameFragment=new GameMVPFragment();
    private HotSpotMVPFragment hotSpotFragment=new HotSpotMVPFragment();
    private List<String> tabList=new ArrayList<>();
    private ImageView slidemenu;
    private TextView text;
    private ImageView imgAdd;
    ArrayList<Fragment> fragmentlist=new ArrayList<>();
    private int theme = 0;

    @Override
    protected void onregister(Bundle savedInstanceState) {
        EventBus.getDefault().register(this);
        if (savedInstanceState == null) {
//                如果么有
            theme = UiUtils.getAppTheme(getContext());
        }
        else {
            theme = savedInstanceState.getInt("theme");
        }
//        可以设置主题的 方法 在oncreate之前调用
        getActivity().setTheme(theme);



    }

    @Override
    protected void initHttpData() {

    }

    @Override
    protected int getLayoutid() {




        return R.layout.homefragment;
    }

    @Override
    protected void intView(View view) {
        imgAdd = (ImageView) view.findViewById(R.id.imgAdd);
        slidemenu = (ImageView) view.findViewById(R.id.slidemenu);
        text = (TextView) view.findViewById(R.id.text);
        viewPager=view.findViewById(R.id.viewPager);
        fragments.add(gameFragment);
        fragments.add(hotSpotFragment);

        tabLayout=view.findViewById(R.id.tabLayout);
        tabList.add("娱乐");
        tabList.add("热点");

        homePager=new MyPagerAdapter(getChildFragmentManager(),fragments,tabList);
        viewPager.setAdapter(homePager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
            imgAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getContext(),LableActivity.class);
                    startActivity(intent);
                }
            });
    }

    @Override
    protected void inPresone() {

    }

    @Override
    protected void inData() {

        Toast.makeText(getContext(), "1111", Toast.LENGTH_SHORT).show();
        final SlidingMenu slidingMenu=new SlidingMenu(getActivity());
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.slidemenu, null);
        TextView slide_cut = inflate.findViewById(R.id.slide_cut);
        slide_cut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UiUtils.switchAppTheme(getContext());
                load();
            }
        });
        slidingMenu.setBehindWidth(500);
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setMenu(inflate);
        slidingMenu.attachToActivity(getActivity(),SlidingMenu.SLIDING_CONTENT);
        slidemenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                slidingMenu.toggle();
            }
        });


    }
    //点击按钮时实现白天和黑夜的切换并实现效果
    public  void  Buttons (View view){
        UiUtils.switchAppTheme(getContext());
        load();
    }
    //    切换之间的动画
    public void load() {

        Intent intent = getActivity().getIntent();

        getActivity().overridePendingTransition(R.anim.in, R.anim.out);//进入动画

        getActivity().finish();

        getActivity().overridePendingTransition(R.anim.in, R.anim.out);
        startActivity(intent);

    }
    @Override
    protected void onstart() {

    }

    @Override
    protected void onstop() {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Message(LabelBean labelBean){

                          if (tabList.get(1).equals("热点")){
                              fragments.remove(1);
                              tabList.remove(1);
                          }
                              tabList.add(labelBean.getTitle());
                              fragments.add(new HotSpotMVPFragment());
                              homePager.notifyDataSetChanged();
         Log.e("111111111",""+tabList.get(1).toString());
    }

 

    @Override
    protected void ondestroy() {
     EventBus.getDefault().unregister(this);
    }
}
