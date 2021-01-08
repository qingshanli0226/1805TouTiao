package com.example.sevenlandh.fragment.journalism;

import android.os.Bundle;

import com.example.freamwork.mvp.BaseMVPFragment;
import com.example.sevenlandh.R;
import com.example.sevenlandh.contract.BringContract;
import com.example.sevenlandh.presenter.BringPresenterImpl;


public class BringUpFragment extends BaseMVPFragment<BringPresenterImpl, BringContract.BringView> implements BringContract.BringView {
    @Override
    protected int bandLayout() {
        return R.layout.fragment_bring_up;
    }
    @Override
    protected void initEvent() {
    }
    @Override
    protected void initData(Bundle savedInstanceState) {
    }
    @Override
    protected void initView() {
    }
    @Override
    protected void initPresenterData() {
    }
    @Override
    protected void initPresenter() {
    }
}