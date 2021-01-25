package com.song.picture.comment;

import android.content.Intent;

import com.song.fromwork.BaseActivity;
import com.song.fromwork.utils.InitApp;
import com.song.picture.R;

public class NewsCommentActivity extends BaseActivity {

    private static final String TAG = "NewsCommentActivity";
    private static final String ARG_GROUPID = "groupId";
    private static final String ARG_ITEMID = "itemId";

    public static void launch(String groupId, String itemId) {
        InitApp.getAppContext().startActivity(new Intent(InitApp.getAppContext(), NewsCommentActivity.class)
                .putExtra(ARG_GROUPID, groupId)
                .putExtra(ARG_ITEMID, itemId)
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
                        NewsCommentFragment.newInstance(intent.getStringExtra(ARG_GROUPID), intent.getStringExtra(ARG_ITEMID)))
                .commit();
    }

    @Override
    protected int layoutId() {
        return R.layout.container;
    }
}
