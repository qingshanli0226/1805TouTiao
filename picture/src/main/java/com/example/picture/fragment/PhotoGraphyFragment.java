package com.example.picture.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.framework.base.BaseLazyFragment;
import com.example.picture.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhotoGraphyFragment extends BaseLazyFragment {



    @Override
    protected void lazyLoadDate() {

    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initDate() {
        super.initDate();
    }

    @Override
    protected int getlayoutids() {
        return R.layout.fragment_photo_graphy;
    }
}
