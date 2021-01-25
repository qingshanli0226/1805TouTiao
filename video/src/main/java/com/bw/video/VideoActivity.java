package com.bw.video;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bw.framework.base.BaseActivity;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;


public class VideoActivity extends BaseActivity {
    private StandardGSYVideoPlayer videoPlayer;
    private TextView tvTitle;
    private ImageView ixMenu;
    private TextView tvDur;
    private TextView tvAbstract;
    private LinearLayout llShare;
    private LinearLayout llDl;
    private ImageView ivAvatar;
    private TextView tvExtra;

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {
        videoPlayer.setUp("http://vfx.mtime.cn/Video/2019/03/09/mp4/190309153658147087.mp4",true,"");
        
        videoPlayer.startPlayLogic();
    }

    @Override
    protected void initView() {
        videoPlayer = (StandardGSYVideoPlayer) findViewById(R.id.video_player);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        ixMenu = (ImageView) findViewById(R.id.ix_menu);
        tvDur = (TextView) findViewById(R.id.tv_dur);
        tvAbstract = (TextView) findViewById(R.id.tv_abstract);
        llShare = (LinearLayout) findViewById(R.id.ll_share);
        llDl = (LinearLayout) findViewById(R.id.ll_dl);
        ivAvatar = (ImageView) findViewById(R.id.iv_avatar);
        tvExtra = (TextView) findViewById(R.id.tv_extra);
    }

    @Override
    protected void createPresenter() {

    }

    @Override
    protected int getlayoutid() {
        return R.layout.item_video_header;
    }
}
