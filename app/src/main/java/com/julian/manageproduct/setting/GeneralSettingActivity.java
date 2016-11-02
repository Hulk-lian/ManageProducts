package com.julian.manageproduct.setting;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.julian.manageproduct.R;


public class GeneralSettingActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.general_setting);
    }
}
