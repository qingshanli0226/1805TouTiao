package com.song.setting.view;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.afollestad.materialdialogs.color.ColorChooserDialog;
import com.song.fromwork.utils.SettingUtil;
import com.song.setting.R;
import com.song.setting.SettingActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    private static SettingFragment settingFragment;
    private SettingActivity context;
    private IconPreference colorPreview;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_general);
        context = (SettingActivity) getActivity();
        setHasOptionsMenu(true);
        setText();

        findPreference("auto_nightMode").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                context.startWithFragment(AutoNightModeFragment.class.getName(), null, null, 0, null);
                return true;
            }
        });

        findPreference("text_size").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                context.startWithFragment(TextSizeFragment.class.getName(), null, null, 0, null);
                return true;
            }
        });

//        findPreference("custom_icon").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
//            @Override
//            public boolean onPreferenceChange(Preference preference, Object o) {
//                int selectValue = Integer.parseInt((String) o);
//                int drawable = Constant.ICONS_DRAWABLES[selectValue];
//
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                    ActivityManager.TaskDescription tDesc = new ActivityManager.TaskDescription(
//                            getString(R.string.app_name),
//                            BitmapFactory.decodeResource(getResources(), drawable),
//                            SettingUtil.getInstance().getColor());
//                    context.setTaskDescription(tDesc);
//                }
//
//                return true;
//            }
//        });

        findPreference("color").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                new ColorChooserDialog.Builder(context, R.string.choose_theme_color)
                        .backButton(R.string.back)
                        .cancelButton(R.string.cancel)
                        .doneButton(R.string.done)
                        .customButton(R.string.custom)
                        .presetsButton(R.string.back)
                        .allowUserColorInputAlpha(false)
                        .show(context);
                return false;
            }
        });

        colorPreview = (IconPreference) findPreference("color");

        findPreference("nav_bar").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                int color = SettingUtil.getInstance().getColor();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    if (SettingUtil.getInstance().getNavBar()){

                    }
                }
                return false;
            }
        });

        findPreference("clearCache").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {

                return false;
            }
        });

        String version = "当前版本";

    }

    private void setText() {

    }

    public static SettingFragment getInstance() {
        if (settingFragment == null) {
            synchronized (SettingFragment.class) {
                if (settingFragment == null) {
                    settingFragment = new SettingFragment();
                }
            }
        }
        return settingFragment;
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        if (s.equals("color")){
            colorPreview.setView();
        }
        if (s.equals("slidable")){
            context.recreate();
        }
    }
}
