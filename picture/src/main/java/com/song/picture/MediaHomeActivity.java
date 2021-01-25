package com.song.picture;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.text.TextUtils;

import androidx.core.widget.ContentLoadingProgressBar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrConfig;
import com.r0adkll.slidr.model.SlidrInterface;
import com.song.common.ErrorAction;
import com.song.fromwork.BaseActivity;
import com.song.fromwork.BasePagerAdapter;
import com.song.fromwork.utils.InitApp;
import com.song.fromwork.utils.RetrofitFactory;
import com.song.fromwork.utils.SettingUtil;
import com.song.net.Constant;
import com.song.net.api.MobileMediaApi;
import com.song.net.mode.mobile.media.MediaProfileBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MediaHomeActivity extends BaseActivity {

    private static final String ARG_MEDIAID = "mediaId";
    private String mediaId = null;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ContentLoadingProgressBar progressBar;
    protected SlidrInterface slidrInterface;

    public static void launch(String MediaId) {
        InitApp.getAppContext().startActivity(new Intent(InitApp.getAppContext(), MediaHomeActivity.class)
                .putExtra(ARG_MEDIAID, MediaId)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }


    protected void initSlidable() {
        int isSlidable = SettingUtil.getInstance().getSlidable();
        if (isSlidable != Constant.SLIDABLE_DISABLE) {
            SlidrConfig config = new SlidrConfig.Builder()
                    .edge(isSlidable == Constant.SLIDABLE_EDGE)
                    .build();
            slidrInterface = Slidr.attach(this, config);
        }
    }

    protected void initView() {
        initSlidable();
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        tabLayout.setBackgroundColor(SettingUtil.getInstance().getColor());
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        progressBar = findViewById(R.id.pb_progress);
        int color = SettingUtil.getInstance().getColor();
        progressBar.getIndeterminateDrawable().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
        progressBar.show();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    if (slidrInterface != null) {
                        slidrInterface.unlock();
                    }
                } else {
                    if (slidrInterface != null) {
                        slidrInterface.lock();
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_media_home;
    }

    protected void initData() {
        Intent intent = getIntent();
        this.mediaId = intent.getStringExtra(ARG_MEDIAID);
        if (TextUtils.isEmpty(mediaId)) {
            onError();
            return;
        }

        RetrofitFactory.getRetrofit().create(MobileMediaApi.class)
                .getMediaProfile(mediaId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(this.bindAutoDispose())
                .subscribe(bean -> {
                    String name = bean.getData().getName();
                    List<MediaProfileBean.DataBean.TopTabBean> topTab = bean.getData().getTop_tab();
                    if (null != topTab && topTab.size() < 0) {
                        onError();
                        return;
                    }
                    initTabLayout(bean.getData());
                }, throwable -> {
                    onError();
                    ErrorAction.print(throwable);
                });
    }

    private void initTabLayout(MediaProfileBean.DataBean dataBean) {
        List<Fragment> fragmentList = new ArrayList<>();
        List<String> titleList = new ArrayList<>();
        List<MediaProfileBean.DataBean.TopTabBean> topTab = dataBean.getTop_tab();
        for (MediaProfileBean.DataBean.TopTabBean bean : topTab) {
//            if (bean.getType().equals("all")) {
//                fragmentList.add(MediaArticleFragment.newInstance(dataBean));
//                titleList.add(bean.getShow_name());
//            }
//            if (bean.getType().equals("video")) {
//                fragmentList.add(MediaVideoFragment.newInstance(mediaId));
//                titleList.add(bean.getShow_name());
//            }
//            if (bean.getType().equals("wenda")) {
//                fragmentList.add(MediaWendaFragment.newInstance(dataBean.getUser_id() + ""));
//                titleList.add(bean.getShow_name());
//            }
        }
        BasePagerAdapter pagerAdapter = new BasePagerAdapter(getSupportFragmentManager(), fragmentList, titleList);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(topTab.size());
        progressBar.hide();
    }

    private void onError() {
        progressBar.hide();
        Snackbar.make(progressBar, "发生错误", Snackbar.LENGTH_INDEFINITE).show();
    }
}
