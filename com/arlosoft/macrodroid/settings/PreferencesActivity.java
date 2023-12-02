package com.arlosoft.macrodroid.settings;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceScreen;
import com.arlosoft.macrodroid.PasswordProtection;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity;

/* loaded from: classes3.dex */
public class PreferencesActivity extends MacroDroidBaseActivity implements PreferenceFragmentCompat.OnPreferenceStartScreenCallback {
    public static final String EXTRA_SHORTCUT = "shortcut";
    public static final int SHORTCUT_MEDIA_V2_OPTIONS = 3;
    public static final int SHORTCUT_NOTIFICATION_BAR_OPTIONS = 4;
    public static final int SHORTCUT_READ_SCREEN_CONTENTS_UPDATE_RATE = 5;
    public static final int SHORTCUT_SMTP_CONFIG = 2;
    public static final int SHORTCUT_SPEAK_TEXT_OPTIONS = 4;

    /* renamed from: f  reason: collision with root package name */
    private Toolbar f13434f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f13435g;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fragment_top_level_preferences);
        this.f13435g = (TextView) findViewById(R.id.title);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.f13434f = toolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        this.f13435g.setText(R.string.settings);
        this.f13435g.setGravity(3);
        if (!getResources().getBoolean(R.bool.is_tablet)) {
            try {
                setRequestedOrientation(1);
            } catch (IllegalStateException unused) {
            }
        }
        if (bundle == null) {
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(PreferencesFragment.FRAGMENT_TAG);
            if (findFragmentByTag == null) {
                findFragmentByTag = new PreferencesFragment();
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt(EXTRA_SHORTCUT, getIntent().getIntExtra(EXTRA_SHORTCUT, 0));
            findFragmentByTag.setArguments(bundle2);
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.replace(R.id.content, findFragmentByTag, PreferencesFragment.FRAGMENT_TAG);
            beginTransaction.commit();
            int i4 = bundle2.getInt(EXTRA_SHORTCUT, 0);
            if (i4 > 0) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            if (i4 == 5) {
                                setTitle(R.string.read_screen_update_rate);
                                return;
                            }
                            return;
                        }
                        setTitle(R.string.action_speak_text);
                        return;
                    }
                    setTitle(R.string.trigger_media_button_v2);
                    return;
                }
                setTitle(R.string.smtp_server);
            }
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    @Override // androidx.preference.PreferenceFragmentCompat.OnPreferenceStartScreenCallback
    public boolean onPreferenceStartScreen(PreferenceFragmentCompat preferenceFragmentCompat, PreferenceScreen preferenceScreen) {
        if (!isDestroyedOrFinishing()) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            PreferencesFragment preferencesFragment = new PreferencesFragment();
            Bundle bundle = new Bundle();
            bundle.putString("androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT", preferenceScreen.getKey());
            preferencesFragment.setArguments(bundle);
            beginTransaction.replace(R.id.content, preferencesFragment, preferenceScreen.getKey());
            beginTransaction.addToBackStack(preferenceScreen.getKey());
            beginTransaction.commit();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        PasswordProtection.onResumeFragments(this);
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        this.f13435g.setText(charSequence);
    }
}
