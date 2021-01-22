package com.example.sevenlandh.video.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.common.video.VideoBean;
import com.example.common.video.VideoDataBean;
import com.example.details.DisplayVideo;
import com.example.details.DisplayWebView;
import com.example.freamwork.mvp.BaseMVPFragment;
import com.example.sevenlandh.R;
import com.example.sevenlandh.image.contract.ImageContract;
import com.example.sevenlandh.image.presenter.ImagePresenterImpl;
import com.example.sevenlandh.video.adapter.VideoAdapter;
import com.example.sevenlandh.video.contract.VideoContract;
import com.example.sevenlandh.video.presenter.VideoPresenterImpl;
import com.google.gson.Gson;

import java.util.List;


public class RecommendVideo extends BaseMVPFragment<VideoPresenterImpl, VideoContract.VideoView> implements VideoContract.VideoView {
    private RecyclerView videoRv;


    @Override
    protected int bandLayout() {
        return R.layout.fragment_recommend_video;
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initView() {
        videoRv = F(R.id.video_rv);
        videoRv.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected void initPresenterData() {
        iPresenter.getVideo("subv_life",getTime());
    }
    public String getTime(){
        long time = System.currentTimeMillis()/1000;
        String s = String.valueOf(time);
        return s;
    }
    @Override
    protected void initPresenter() {
       iPresenter = new VideoPresenterImpl();
    }

    @Override
    public void onVideoView(VideoBean videoBean) {
        final List<VideoBean.DataBean> data = videoBean.getData();new VideoAdapter(R.layout.item_video,data);
        if (data==null){
            iPresenter.getVideo("subv_life",getTime());
        }
        VideoAdapter videoAdapter = new VideoAdapter(R.layout.item_video, data);
        videoRv.setAdapter(videoAdapter);
        videoAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getContext(), DisplayWebView.class);
                VideoDataBean videoDataBean = new Gson().fromJson(data.get(position).getContent(), VideoDataBean.class);
                intent.putExtra("url",videoDataBean.getDisplay_url());
                startActivity(intent);
            }
        });



    }
}