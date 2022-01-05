package com.example.testapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

import java.util.Objects;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Settings");

        if(findViewById(R.id.idFrameLayout) != null){
            if(savedInstanceState != null){
                return;
            }
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.idFrameLayout, new SettingsFragment())
                    .commit();
        }
    }
    public void onDestroy() {

        super.onDestroy();
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            // Indicate here the XML resource you created above that holds the preferences
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
        }
    }
}