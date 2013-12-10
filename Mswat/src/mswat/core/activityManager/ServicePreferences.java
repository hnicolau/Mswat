package mswat.core.activityManager;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceGroup;
import android.preference.PreferenceManager;
import android.util.Log;
public class ServicePreferences extends PreferenceActivity implements OnSharedPreferenceChangeListener {
	public static final String LOG = "log";
	public static final String CONTROLLER = "controller";
	public static final String AUDIO = "audio";
	public static final String 	VISUAL = "visual";


	@Override
	@SuppressWarnings("deprecation")
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		addPreferencesFromResource(R.xml.preferences);
		getPreferenceScreen().getSharedPreferences()
        .registerOnSharedPreferenceChangeListener(this);
	}

	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
    }
}