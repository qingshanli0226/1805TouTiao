package com.song.picture;

import android.annotation.SuppressLint;
import android.widget.TableLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.song.fromwork.BaseFragment;
import com.song.fromwork.BaseListFragment;
import com.song.fromwork.BasePagerAdapter;
import com.song.fromwork.utils.InitApp;
import com.song.fromwork.utils.SettingUtil;

import java.util.ArrayList;
import java.util.List;

public class PhotoFragment extends BaseFragment {

    private TabLayout tabLayoutPhoto;
    private ViewPager viewPagerPhoto;

    private static PhotoFragment instance;
    private List<Fragment> fragmentList = new ArrayList<>();

    private static int pageSize = InitApp.getAppContext().getResources().getStringArray(R.array.photo_id).length;
    private String categoryId[] = InitApp.getAppContext().getResources().getStringArray(R.array.photo_id);
    private String categoryName[] = InitApp.getAppContext().getResources().getStringArray(R.array.photo_name);

    private BasePagerAdapter adapter;

    public static PhotoFragment getInstance() {
        if (instance == null) {
            instance = new PhotoFragment();
        }
        return instance;
    }

    @Override
    protected void initData() {
        for (int i = 0; i < categoryId.length; i++) {
            Fragment fragment = PhotoArticleView.newInstance(categoryId[i]);
            fragmentList.add(fragment);
        }
        adapter = new BasePagerAdapter(getChildFragmentManager(), fragmentList, categoryName);
        viewPagerPhoto.setAdapter(adapter);
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

    public void onDoubleClick() {
        if (fragmentList != null && fragmentList.size() > 0) {
            int item = viewPagerPhoto.getCurrentItem();
            ((BaseListFragment) fragmentList.get(item)).onRefresh();
        }
    }

    @Override
    public void onDestroy() {
        if (instance != null) {
            instance = null;
        }
        super.onDestroy();
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
