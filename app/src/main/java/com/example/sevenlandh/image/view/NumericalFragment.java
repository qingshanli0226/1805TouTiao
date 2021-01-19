package com.example.sevenlandh.image.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.common.picture.PictureBean;
import com.example.details.DisplayWebView;
import com.example.freamwork.mvp.BaseMVPFragment;
import com.example.sevenlandh.R;
import com.example.sevenlandh.image.adapter.ImageAdapter;
import com.example.sevenlandh.image.contract.ImageContract;
import com.example.sevenlandh.image.presenter.ImagePresenterImpl;

import java.util.List;


public class NumericalFragment extends BaseMVPFragment<ImagePresenterImpl,ImageContract.ImageView> implements ImageContract.ImageView {
    private RecyclerView imageRv;



    @Override
    protected void initPresenterData() {
        iPresenter.getImage("组图",getTime());
    }

    public String getTime(){
        long time = System.currentTimeMillis()/1000;
        String s = String.valueOf(time);
        return s;
    }

    @Override
    protected void initPresenter() {
        iPresenter = new ImagePresenterImpl();
    }

    @Override
    protected int bandLayout() {
        return  R.layout.fragment_numerical;
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initView() {
        imageRv = F(R.id.image_rv);
        imageRv.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    @Override
    public void onImageView(PictureBean pictureBean) {
        final List<PictureBean.DataBean> data = pictureBean.getData();
        ImageAdapter imageAdapter = new ImageAdapter(R.layout.item_image, data);
        imageRv.setAdapter(imageAdapter);
        imageAdapter.notifyDataSetChanged();
        imageAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getContext(), DisplayWebView.class);
                intent.putExtra("url","https://www.toutiao.com"+data.get(position).getSource_url());
                startActivity(intent);
            }
        });

    }
}