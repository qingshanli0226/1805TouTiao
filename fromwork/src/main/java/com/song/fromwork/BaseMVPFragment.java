package com.song.fromwork;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class BaseMVPFragment<T extends IPresenter, V extends IView> extends BaseFragment {

    protected T iHpptPresenter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initPresenter();
        iHpptPresenter.attach((V) this);
        initHttpData();
    }

    protected abstract void initPresenter();

    protected abstract void initHttpData();

    @Override
    public void onDestroy() {
        super.onDestroy();
        iHpptPresenter.detach();
    }
}
