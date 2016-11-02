package com.julian.manageproduct.setting;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceActivity;

import com.julian.manageproduct.R;


public class AccountSettingActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.account_setting);
    }
}
