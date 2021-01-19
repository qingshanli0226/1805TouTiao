package com.example.a1805toutiao.ui.fragment;


import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;

import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.view.View;

import com.example.a1805toutiao.R;

/**
 * 设置界面的fragment
 */
public class PreSettingFragment extends PreferenceFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_genbref);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //调用PreferenceManager的getDefaultSharedPreferences方法获取PreferenceManager
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

    }
}
