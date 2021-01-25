package com.song.fromwork;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;

import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.AutoDisposeConverter;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

public abstract class BaseMVPFragment<T extends IPresenter, V extends IView> extends BaseFragment implements IBaseView<T>{

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

    @Override
    public <X> AutoDisposeConverter<X> bindAutoDispose() {
        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider
                .from(this, Lifecycle.Event.ON_DESTROY));
    }
}
