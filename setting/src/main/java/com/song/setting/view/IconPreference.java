package com.song.setting.view;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;

import com.afollestad.materialdialogs.color.CircleView;
import com.song.fromwork.utils.SettingUtil;
import com.song.setting.R;


public class IconPreference extends Preference {

    private CircleView circleImageView;

    public IconPreference(Context context, AttributeSet attrs) {
        super(context, attrs);

        setWidgetLayoutResource(R.layout.item_icon_preference_preview);
    }

    @Override
    protected void onBindView(View view) {
        super.onBindView(view);
        int color = SettingUtil.getInstance().getColor();
        circleImageView = view.findViewById(R.id.iv_preview);
        circleImageView.setBackgroundColor(color);
    }

    public void setView() {
        int color = SettingUtil.getInstance().getColor();
        circleImageView.setBackgroundColor(color);
    }
}