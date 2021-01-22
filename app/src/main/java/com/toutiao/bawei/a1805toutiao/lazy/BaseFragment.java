package com.toutiao.bawei.a1805toutiao.lazy;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public abstract class BaseFragment extends Fragment {
    protected TextView contentTv;
    private final String TAG = getClass().getSimpleName() + ": ";
    private boolean isVisile = false;//设置一个标记位，标识当前Fragment是否对用户可见
    private boolean isViewCreated = false;//标识当前Fragment的控件是否已经初始化完毕

    //准备获取数据时，要保证两点：1，Fragment，对用户是可见的   2，Fragement的View已经初始化完毕


    //方法。该方法被调用时，会传递一个参数过来，该参数为true时，代表着，这个Fragment正被用户看到，当改参数为false时，代表着用户没有看到该Fragment
    //通过该方法实现ViewPager+Fragment的懒加载功能
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isVisile = isVisibleToUser;
        Log.d("LQS", TAG + "setUserVisibleHint..........." + isVisibleToUser);
        if (isVisile && isViewCreated) {//当两个条件都满足时，才开始加载数据
            lazyLoadData();
        }
    }

    //准备获取数据
    protected abstract void lazyLoadData();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("LQS", TAG + "onAttach...........");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("LQS", TAG + "onCreate...........");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        Log.d("LQS", TAG + "onCreateView...........");
        //进行网络请求获取数据，显示到UI控件上
        View rootView = inflater.inflate(getLayoutId(), container,false);
        initView(rootView);
        isViewCreated = true;
        if (isViewCreated && isVisile) {
            lazyLoadData();
        }
        return rootView;
    }

    protected abstract void initView(View rootView);

    public abstract int getLayoutId();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("LQS", TAG + "onViewCreated...........");
        //lazyLoadData();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("LQS", TAG + "onActivityCreated...........");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("LQS", TAG + "onStart...........");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("LQS", TAG + "onResume...........");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("LQS", TAG + "onPause...........");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("LQS", TAG + "onStop...........");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("LQS", TAG + "onDestroyView...........");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("LQS", TAG + "onDestroy...........");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("LQS", TAG + "onDetach...........");

    }
}
