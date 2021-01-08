package com.bw.a1805atoutiao;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceActivity;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bw.framework.view.LoadingPage;

public class SettingActivity extends PreferenceActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        addPreferencesFromResource(R.xml.pref_general);


    }
}
