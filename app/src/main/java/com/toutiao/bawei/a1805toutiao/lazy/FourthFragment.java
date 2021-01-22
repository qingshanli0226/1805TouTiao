package com.toutiao.bawei.a1805toutiao.lazy;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.toutiao.bawei.a1805toutiao.R;

public class FourthFragment extends BaseFragment {
    private int num = 0;
    private boolean isDataInitialized = false;
    @Override
    protected void lazyLoadData() {
        Log.d("LQS", getClass().getSimpleName() + " lazyLoadData...............................................");
        if (!isDataInitialized) {//如果之前没有加载过数据，开始加载数据,并将标记置为true;
            num = num + 500;
            isDataInitialized = true;
            contentTv.setText("hello the cruel world! " + num);
        } else {//如果数据已经加载过，直接显示数据，没必要再重复加载
            contentTv.setText("hello the cruel world! " + num);
        }
    }

    private TextView contentTv;
    @Override
    protected void initView(View rootView) {
        contentTv = rootView.findViewById(R.id.contentTv);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_fourth;
    }
}
