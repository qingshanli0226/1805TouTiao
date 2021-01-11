package com.example.framewrok.base.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.framewrok.base.IPrine;
import com.example.framewrok.base.IView;

public abstract class BaseFragment<Prine extends IPrine,PView extends IView> extends Fragment {
    public Prine prine;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onregister();
    }

    protected abstract void onregister();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayoutid(), null);
        intView(inflate);
        inPresone();
        inData();
        if (prine!=null){
            prine.attach((PView)this);
        }
        return inflate;
    }
    protected abstract int getLayoutid();
    protected abstract void intView(View inflate);
    protected abstract void inPresone();
    protected abstract void inData();

    @Override
    public void onStart() {
        super.onStart();
        onstart();
    }

    protected abstract void onstart();

    @Override
    public void onStop() {
        super.onStop();
        onstop();
    }

    protected abstract void onstop();

    @Override
    public void onDestroy() {
        super.onDestroy();
        ondestroy();
    }

    protected abstract void ondestroy();

}
