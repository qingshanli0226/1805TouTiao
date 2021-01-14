package com.example.sevenlandh.image.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.common.picture.PictureBean;
import com.example.freamwork.mvp.BaseFragment;
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
        List<PictureBean.DataBean> data = pictureBean.getData();
        ImageAdapter imageAdapter = new ImageAdapter(R.layout.item_image, data);
        imageRv.setAdapter(imageAdapter);
        imageAdapter.notifyDataSetChanged();

    }
}