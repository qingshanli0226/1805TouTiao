package com.song.picture;

import android.annotation.SuppressLint;
import android.widget.TableLayout;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.song.fromwork.BaseFragment;
import com.song.fromwork.utils.InitApp;
import com.song.fromwork.utils.SettingUtil;

public class PhotoFragment extends BaseFragment {

    private TabLayout tabLayoutPhoto;
    private ViewPager viewPagerPhoto;

    private static PhotoFragment instance;

    private static int pageSize = InitApp.getAppContext().getResources().getStringArray(R.array.photo_id).length;
    private String categoryId[] = InitApp.getAppContext().getResources().getStringArray(R.array.photo_id);

    public static PhotoFragment getInstance() {
        if (instance == null) {
            instance = new PhotoFragment();
        }
        return instance;
    }

    @Override
    protected void initData() {

    }

    @SuppressLint("WrongConstant")
    @Override
    protected void initView() {

        tabLayoutPhoto = findViewById(R.id.tab_layout_photo);
        viewPagerPhoto = findViewById(R.id.view_pager_photo);

        tabLayoutPhoto.setupWithViewPager(viewPagerPhoto);
        tabLayoutPhoto.setTabMode(TableLayout.LAYOUT_MODE_CLIP_BOUNDS);
        tabLayoutPhoto.setBackgroundColor(SettingUtil.getInstance().getColor());
        viewPagerPhoto.setOffscreenPageLimit(0);


    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_photo;
    }

    @Override
    public void onResume() {
        super.onResume();
        tabLayoutPhoto.setBackgroundColor(SettingUtil.getInstance().getColor());
    }
}
