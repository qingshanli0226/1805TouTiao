package com.example.video;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.framewrok.base.MyHomePager;
import com.example.framewrok.base.base.BaseFragment;
import com.google.android.material.tabs.TabLayout;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class VideoFragment extends BaseFragment {
    private List<Fragment> fragments=new ArrayList<>();
    private List<String> tabList=new ArrayList<>();
    private TabLayout tabLayout;
    private ImageView imgAdd;
    private ViewPager viewPager;
    MyHomePager homePager;

    @Override
    protected void onregister() {

    }

    @Override
    protected int getLayoutid() {
        return R.layout.videofragment;
    }

    @Override
    protected void intView(View inflate) {
        tabLayout = (TabLayout)inflate. findViewById(R.id.tabLayout);
        imgAdd = (ImageView)inflate.findViewById(R.id.imgAdd);
        viewPager = (ViewPager) inflate.findViewById(R.id.viewPager);
    }

    @Override
    protected void inPresone() {

    }
       ArrayList<String> arrayList=new ArrayList<>();
    @Override
    protected void inData() {
        final String[] stringArray = getContext().getResources().getStringArray(com.example.framewrok.R.array.mobile_video_name);
        final String[] stringArray1 = getContext().getResources().getStringArray(com.example.framewrok.R.array.mobile_video_id);
         for (int i=0;i<stringArray.length;i++){
                  fragments.add(new OmnipotenceFragment());
                  tabList.add(stringArray[i]);
         }
        homePager=new MyHomePager(getChildFragmentManager(),fragments,tabList);
        viewPager.setAdapter(homePager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
         tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
             @Override
             public void onTabSelected(TabLayout.Tab tab) {

                 for (int i=0;i<stringArray1.length;i++){
                     if (tab.getPosition()==i){

                          Log.e("QQQQQQQQ",""+stringArray1[i].toString());
                          VideoBean videoBean=new VideoBean(stringArray[i],stringArray1[i]);
                         EventBus.getDefault().post(videoBean);
                         break;
                     }
                 }
             }

             @Override
             public void onTabUnselected(TabLayout.Tab tab) {

             }

             @Override
             public void onTabReselected(TabLayout.Tab tab) {

             }
         });
    }

    @Override
    protected void onstart() {

    }

    @Override
    protected void onstop() {

    }

    @Override
    protected void ondestroy() {

    }
}
