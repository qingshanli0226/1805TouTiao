package com.song.picture;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.song.common.ErrorBean;
import com.song.fromwork.BaseListFragment;
import com.song.picture.presenter.IPhotoArticle;

import java.util.List;

import me.drakeet.multitype.MultiTypeAdapter;

public class PhotoArticleView extends BaseListFragment<IPhotoArticle.Presenter> implements IPhotoArticle.View {

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
        adapter = new MultiTypeAdapter(oldItems);
        //Register.registerPhotoArticleItem(adapter);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                if (canLoadMore) {
                    canLoadMore = false;
                    iHpptPresenter.doLoadMoreData();
                }
            }
        });
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

    @Override
    public void setPresenter(IPhotoArticle.Presenter presenter) {

    }

    @Override
    public void onSetAdapter(List<?> list) {

    }
}
