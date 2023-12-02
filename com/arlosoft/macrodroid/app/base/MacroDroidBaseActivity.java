package com.arlosoft.macrodroid.app.base;

import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import androidx.core.os.LocaleListCompat;
import com.arlosoft.macrodroid.PasswordProtection;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import java.util.Locale;

/* loaded from: classes3.dex */
public abstract class MacroDroidBaseActivity extends AppCompatActivity {

    /* renamed from: c  reason: collision with root package name */
    private boolean f5698c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5699d = false;

    /* renamed from: e  reason: collision with root package name */
    private int f5700e = -1;

    private void h() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_BACKGROUND_LOCATION") != 0) {
            this.f5700e = 0;
        } else if (this.f5700e == 0) {
            this.f5700e = 1;
            k();
        }
    }

    private synchronized void k() {
        Macro.setMacroDroidEnabledState(false);
        MacroStore.getInstance().updateEnabledStateOfAllCompletedMacros();
        Macro.setMacroDroidEnabledState(true);
        MacroStore.getInstance().updateEnabledStateOfAllCompletedMacros();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int i() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    @Override // android.app.Activity
    public boolean isDestroyed() {
        return super.isDestroyed();
    }

    public boolean isDestroyedOrFinishing() {
        if (!isFinishing() && !isDestroyed()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean j() {
        return this.f5698c;
    }

    protected boolean l() {
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!this.f5698c) {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Settings.getForceLocaleAtStartup(this)) {
            setLocale(Settings.getLocale(this));
            Settings.setSettingsForceLocaleAtStartup(this, false);
        }
        if (!getResources().getBoolean(R.bool.is_tablet)) {
            try {
                setRequestedOrientation(1);
            } catch (IllegalStateException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.f5699d = true;
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i4, KeyEvent keyEvent) {
        try {
            if (!this.f5698c) {
                if (i4 == 82 && "LGE".equalsIgnoreCase(Build.BRAND)) {
                    return true;
                }
                return super.onKeyDown(i4, keyEvent);
            }
            return super.onKeyDown(i4, keyEvent);
        } catch (IllegalStateException unused) {
            return true;
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i4, KeyEvent keyEvent) {
        try {
            if (!this.f5698c) {
                if (i4 == 82 && "LGE".equalsIgnoreCase(Build.BRAND)) {
                    openOptionsMenu();
                    return true;
                }
                return super.onKeyUp(i4, keyEvent);
            }
            return super.onKeyUp(i4, keyEvent);
        } catch (IllegalStateException unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        PasswordProtection.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        FirebaseAnalyticsEventLogger.log("Activity resumed: " + getClass().getSimpleName());
        this.f5698c = false;
        this.f5699d = false;
        h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onResumeFragments() {
        super.onResumeFragments();
        if (l()) {
            PasswordProtection.onResumeFragments(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        this.f5698c = true;
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i4) {
        super.setContentView(i4);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    public void setLocale(Locale locale) {
        AppCompatDelegate.setApplicationLocales(LocaleListCompat.create(locale));
    }
}
