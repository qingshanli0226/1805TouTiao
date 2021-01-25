package com.song.picture.comment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.song.common.photo.LoadingBean;
import com.song.fromwork.BaseListFragment;
import com.song.fromwork.utils.SettingUtil;
import com.song.picture.DiffCallback;
import com.song.picture.R;
import com.uber.autodispose.AutoDisposeConverter;

import java.util.List;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class NewsCommentFragment extends BaseListFragment<INewsComment.Presenter> implements INewsComment.View {

    private static final String GROUP_ID = "groupId";
    private static final String ITEM_ID = "itemId";
    private static final String TAG = "NewsCommentFragment";
    private String groupId;
    private String itemId;

    public static NewsCommentFragment newInstance(String groupId, String itemId) {
        NewsCommentFragment instance = new NewsCommentFragment();
        Bundle bundle = new Bundle();
        bundle.putString(GROUP_ID, groupId);
        bundle.putString(ITEM_ID, itemId);
        instance.setArguments(bundle);
        return instance;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_list_toolbar;
    }

    @Override
    protected void initData() {
        Bundle arguments = getArguments();
        groupId = arguments.getString(GROUP_ID);
        itemId = arguments.getString(ITEM_ID);
        onLoadData();
    }

    @Override
    protected void initView() {
        toolBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.smoothScrollToPosition(0);
            }
        });
        toolBar.setBackgroundColor(SettingUtil.getInstance().getColor());

        adapter = new MultiTypeAdapter(oldItems);
        Register.registerNewsCommentItem(adapter);
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
        setHasOptionsMenu(true);
    }

    @Override
    public void onRefresh() {
        iHpptPresenter.doRefresh();
    }

    @Override
    public void onLoadData() {
        onShowLoading();
        iHpptPresenter.doLoadData(groupId, itemId);
    }

    @Override
    public void onSetAdapter(final List<?> list) {
        Items newItems = new Items(list);
        newItems.add(new LoadingBean());
        DiffCallback.create(oldItems, newItems, adapter);
        oldItems.clear();
        oldItems.addAll(newItems);
        canLoadMore = true;
        recyclerView.stopScroll();
    }

    @Override
    public void onShowNoMore() {

    }

    @Override
    public void onShowLoading() {

    }

    @Override
    public void onHideLoading() {

    }

    @Override
    public void onShowNetError() {

    }

    @Override
    public void setPresenter(INewsComment.Presenter presenter) {

    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initHttpData() {

    }

    @Override
    public <X> AutoDisposeConverter<X> bindAutoDispose() {
        return null;
    }

    @Override
    public void fetchData() {

    }
}
