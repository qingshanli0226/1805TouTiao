package com.example.onemyapp.home.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.framewrok.base.base.BaseFragment;
import com.example.onemyapp.activity.LableActivity;
import com.example.onemyapp.R;
import com.example.onemyapp.bean.LabelBean;
import com.example.onemyapp.home.adapter.MyHomePager;
import com.google.android.material.tabs.TabLayout;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyHomePager homePager;
    private List<Fragment> fragments=new ArrayList<>();
    private GameFragment gameFragment=new GameFragment();
    private HotSpotFragment hotSpotFragment=new HotSpotFragment();
    private List<String> tabList=new ArrayList<>();
    private ImageView slidemenu;
    private TextView text;
    private ImageView imgAdd;
    ArrayList<Fragment> fragmentlist=new ArrayList<>();


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


        homePager=new MyHomePager(getChildFragmentManager(),fragments,tabList);
        viewPager.setAdapter(homePager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

    }

    @Override
    protected void inPresone() {

    }

    @Override
    protected void inData() {
        EventBus.getDefault().register(this);
        Toast.makeText(getContext(), "1111", Toast.LENGTH_SHORT).show();
        final SlidingMenu slidingMenu=new SlidingMenu(getActivity());
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.slidemenu, null);
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
        imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), LableActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onstart() {

    }

    @Override
    protected void onstop() {

    }
    public static String title;
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Message(LabelBean labelBean){
         tabList.add(labelBean.getTitle());
         fragments.add(new HotSpotFragment());

         Log.e("FFFFFFFFFFF",""+labelBean.toString());
         homePager.notifyDataSetChanged();
        title = labelBean.getTitle_id();
        EventBus.getDefault().post(title);

    }
    @Override
    protected void ondestroy() {
        EventBus.getDefault().unregister(this);
    }
}
