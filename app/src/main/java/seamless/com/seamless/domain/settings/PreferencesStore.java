package seamless.com.seamless.domain.settings;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesStore {

	private static final String PREF_NAME = "AdapterSettingsStore";
	private final SharedPreferences sharedPreferences;

	public PreferencesStore(final Context context) {
		sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
	}

	public void add(final String key, final String value) {
		SharedPreferences.Editor editor = this.sharedPreferences.edit();
		editor.putString(key, value);
		editor.apply();
	}

	public String fetch(final String key) {
		return this.sharedPreferences.getString(key, null);
	}

}
