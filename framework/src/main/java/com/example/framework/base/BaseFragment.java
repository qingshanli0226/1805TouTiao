package com.example.framework.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.framework.R;
import com.example.framework.view.LogingPage;
import com.example.framework.view.ToolBar;

public abstract class BaseFragment extends Fragment implements ToolBar.IToolBarClickListenter {
    private LogingPage logingPage;
    protected ToolBar toolbar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        logingPage = new LogingPage(getContext()) {
            @Override
            protected int getlayoutid() {
                return getlayoutids();
            }
        };
//        toolbar =findViewById(R.id.toolbar);//在这里实例化toolbar
//        toolbar.setiToolBarClickListenter(this);
        return logingPage;
    }
    //注解。表示一个资源id，不能随便传递一个整型
    public <T extends View> T findViewById(@IdRes int id) {
        return logingPage.findViewById(id);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }
    protected abstract void initView();

    protected abstract int getlayoutids();
    public void showloading(){
        logingPage.loadingPage();
    }
    public void hideLoading(){
        logingPage.showsucessPage();
    }
    public void showerror(String errorName){
        logingPage.showError(errorName);
    }
    public void showEnpty(){
        logingPage.showEnptyPage();
    }
    @Override
    public void onLeftClick() {

    }

    @Override
    public void onRightClick() {

    }
}
