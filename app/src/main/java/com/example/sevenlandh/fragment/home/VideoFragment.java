package com.example.sevenlandh.fragment.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.freamwork.mvp.BaseFragment;
import com.example.sevenlandh.R;

import org.greenrobot.eventbus.EventBus;


public class VideoFragment extends BaseFragment {
    private ImageView homeToobarList;
    @Override
    protected int bandLayout() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initView() {
        homeToobarList = F(R.id.home_toobar_list);
        homeToobarList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().postSticky("0");
            }
        });
    }
}