package com.song.setting.view;


import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.song.fromwork.utils.SettingUtil;
import com.song.setting.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AutoNightModeFragment extends PreferenceFragment {

    private SettingUtil settingUtil = SettingUtil.getInstance();
    private String nightStartHour;
    private String nightStartMinute;
    private String dayStartHour;
    private String dayStartMinute;

    private Preference autoNight;
    private Preference autoDay;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_autonight);
        setHasOptionsMenu(true);

        autoNight = findPreference("auto_night");
        autoDay = findPreference("auto_day");

        setText();

        autoNight.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                TimePickerDialog dialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        settingUtil.setNightStartHour(i > 9 ? "" + i : "0" + i);
                        settingUtil.setNightStartMinute(i1 > 9 ? "" + i1 : "0" + i1);
                        setText();
                    }
                }, Integer.parseInt(nightStartHour), Integer.parseInt(nightStartMinute), true);
                dialog.show();
                dialog.getButton(DialogInterface.BUTTON_POSITIVE).setText(R.string.done);
                dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setText(R.string.cancel);
                return false;
            }
        });

        autoDay.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                TimePickerDialog dialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        settingUtil.setDayStartHour(i > 9 ? "" + i : "0" + i);
                        settingUtil.setDayStartMinute(i1 > 9 ? "" + i1 : "0" + i1);
                        setText();
                    }
                }, Integer.parseInt(dayStartHour), Integer.parseInt(dayStartMinute), true);
                dialog.show();
                dialog.getButton(DialogInterface.BUTTON_POSITIVE).setText(R.string.done);
                dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setText(R.string.cancel);
                return false;
            }
        });
    }

    private void setText() {
        nightStartHour = settingUtil.getNightStartHour();
        nightStartMinute = settingUtil.getNightStartMinute();
        dayStartHour = settingUtil.getDayStartHour();
        dayStartMinute = settingUtil.getDayStartMinute();

        autoNight.setSummary(nightStartHour + ":" + nightStartMinute);
        autoDay.setSummary(dayStartHour + ":" + dayStartMinute);
    }
}