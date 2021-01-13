package com.song.setting;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.song.common.MyToolBar;
import com.song.fromwork.BaseActivity;
import com.song.setting.view.SettingFragment;

@Route(path = "/setting/SettingActivity")
public class SettingActivity extends BaseActivity implements MyToolBar.IToolBarClickListner {

    public static final String EXTRA_SHOW_FRAGMENT = "show_fragment";
    public static final String EXTRA_SHOW_FRAGMENT_ARGUMENTS = "show_fragment_args";
    public static final String EXTRA_SHOW_FRAGMENT_TITLE = "show_fragment_title";

    private FrameLayout frameLayout;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        String initFragment = getIntent().getStringExtra(EXTRA_SHOW_FRAGMENT);
        Bundle initArguments = getIntent().getBundleExtra(EXTRA_SHOW_FRAGMENT_ARGUMENTS);
        String initTitle = getIntent().getStringExtra(EXTRA_SHOW_FRAGMENT_TITLE);

        if (TextUtils.isEmpty(initFragment)) {
            setupFragment(SettingFragment.class.getName(), initArguments);
        } else {
            setupFragment(initFragment, initArguments);
        }
    }

    private void setupFragment(String fragmentName, Bundle args) {
        android.app.Fragment fragment = android.app.Fragment.instantiate(this, fragmentName, args);
        android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.replace(R.id.container, fragment);
        transaction.commitAllowingStateLoss();
    }

    public void startWithFragment(String fragmentName, Bundle args, Fragment resultTo, int resultRequestCode, String title) {
        Intent intent = onBuildStartFragmentIntent(fragmentName, args, title);
        if (resultTo == null) {
            startActivity(intent);
        } else {
            resultTo.startActivityForResult(intent, resultRequestCode);
        }
    }

    public Intent onBuildStartFragmentIntent(String fragmentName, Bundle args, String title) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setClass(this, getClass());
        intent.putExtra(EXTRA_SHOW_FRAGMENT, fragmentName);
        intent.putExtra(EXTRA_SHOW_FRAGMENT_ARGUMENTS, args);
        intent.putExtra(EXTRA_SHOW_FRAGMENT_TITLE, title);
        return intent;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_setting;
    }

    @Override
    public void onLeftClick() {
        super.onLeftClick();
    }

    @Override
    public void onRightClick() {
        Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
    }
}
