package com.song.picture.content;

import android.content.Intent;

import com.song.fromwork.BaseActivity;
import com.song.fromwork.utils.InitApp;
import com.song.net.mode.mobile.news.MultiNewsArticleDataBean;
import com.song.picture.R;

public class NewsContentActivity extends BaseActivity {

    private static final String TAG = "NewsContentActivity";
    private static final String IMG = "img";

    public static void launch(MultiNewsArticleDataBean bean) {
        InitApp.getAppContext().startActivity(new Intent(InitApp.getAppContext(), NewsContentActivity.class)
                .putExtra(TAG, bean)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    public static void launch(MultiNewsArticleDataBean bean, String imgUrl) {
        InitApp.getAppContext().startActivity(new Intent(InitApp.getAppContext(), NewsContentActivity.class)
                .putExtra(TAG, bean)
                .putExtra(IMG, imgUrl)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container,
                        NewsContentFragment.newInstance(intent.getParcelableExtra(TAG), intent.getStringExtra(IMG)))
                .commit();
    }

    @Override
    protected int layoutId() {
        return R.layout.container;
    }
}
