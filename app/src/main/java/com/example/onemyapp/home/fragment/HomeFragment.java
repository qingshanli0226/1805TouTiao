package com.example.onemyapp.home.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.framewrok.base.base.BaseFragment;
import com.example.onemyapp.R;
import com.example.onemyapp.home.adapter.MyHomePager;
import com.google.android.material.tabs.TabLayout;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyHomePager homePager;
    private List<Fragment> fragments=new ArrayList<>();
    private GameFragment gameFragment=new GameFragment();
    private FinanceFragment financeFragment=new FinanceFragment();
    private HotSpotFragment hotSpotFragment=new HotSpotFragment();
    private SocietyFragment societyFragment=new SocietyFragment();
    private List<String> tabList=new ArrayList<>();
    private ImageView slidemenu;
    private TextView text;
    @Override
    protected int getLayoutid() {
        return R.layout.homefragment;
    }

    @Override
    protected void intView(View view) {
        slidemenu = (ImageView) view.findViewById(R.id.slidemenu);
        text = (TextView) view.findViewById(R.id.text);
        fragments.add(gameFragment);
        fragments.add(financeFragment);
        fragments.add(hotSpotFragment);
        fragments.add(societyFragment);
        tabLayout=view.findViewById(R.id.tabLayout);
        tabList.add("娱乐");
        tabList.add("财经");
        tabList.add("热点");
        tabList.add("社会");
        viewPager=view.findViewById(R.id.viewPager);
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
    }

    @Override
    protected void ondestroy() {

    }
}
