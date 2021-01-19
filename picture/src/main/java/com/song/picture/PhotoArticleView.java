package com.song.picture;


import android.os.Bundle;

import com.song.common.ErrorBean;
import com.song.fromwork.BaseMVPFragment;
import com.song.picture.presenter.IPhotoArticle;
import com.song.picture.presenter.PhotoImpl;

public class PhotoArticleView extends BaseMVPFragment<PhotoImpl, IPhotoArticle.View> implements IPhotoArticle.View {

    private static final String STRING = "PhotoArticleView";
    private String categoryId;

    public static PhotoArticleView newInstance(String categoryId) {
        Bundle bundle = new Bundle();
        bundle.putString(STRING, categoryId);
        PhotoArticleView instance = new PhotoArticleView();
        instance.setArguments(bundle);
        return instance;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initHttpData() {

    }

    @Override
    protected void initData() {
        categoryId = getArguments().getString(STRING);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    public void onLoadData() {

    }

    @Override
    public void hideLoading(boolean isSuccess, ErrorBean errorBean) {

    }

    @Override
    public void showEmpty() {

    }
}
