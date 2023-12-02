package com.arlosoft.macrodroid.settings;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.AppOpsManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.LocaleList;
import android.os.PowerManager;
import android.speech.tts.TextToSpeech;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.SwitchCompat;
import androidx.collection.ArraySet;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.CheckBoxPreference;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;
import com.arlosoft.macrodroid.BuildConfig;
import com.arlosoft.macrodroid.DonateActivity;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.accessibility.KeepAccessibilityServicesRunningActivity;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.action.RecordMicrophoneAction;
import com.arlosoft.macrodroid.action.SpeakTextAction;
import com.arlosoft.macrodroid.action.outputservices.TwitterOutput;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity;
import com.arlosoft.macrodroid.common.ApplicationChecker;
import com.arlosoft.macrodroid.common.EncryptedEditTextPreference;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.PebbleHelper;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.privacy.PrivacyActivity;
import com.arlosoft.macrodroid.quicksettings.QuickSettingsActivity;
import com.arlosoft.macrodroid.settings.PreferencesFragment;
import com.arlosoft.macrodroid.triggers.ApplicationLaunchedTrigger;
import com.arlosoft.macrodroid.triggers.FlipDeviceTrigger;
import com.arlosoft.macrodroid.triggers.IncomingSMSTrigger;
import com.arlosoft.macrodroid.triggers.LocationTrigger;
import com.arlosoft.macrodroid.triggers.ProximityTrigger;
import com.arlosoft.macrodroid.triggers.ShakeDeviceTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.activities.LocationChooserActivity;
import com.arlosoft.macrodroid.triggers.receivers.ShakeEventListener;
import com.arlosoft.macrodroid.utils.GmailHelper;
import com.arlosoft.macrodroid.utils.UninstallHelper;
import com.google.android.gms.common.AccountPicker;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.mlkit.nl.translate.TranslateLanguage;
import dev.skomlach.biometric.compat.BiometricPromptCompat;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public class PreferencesFragment extends PreferenceFragmentCompat {
    public static final String FRAGMENT_TAG = "my_preference_fragment";
    public static final int REQUEST_LOCATION_SUNRISE_SUNSET = 3;
    public static final int REQUEST_LOCATION_WEATHER = 2;

    /* renamed from: b  reason: collision with root package name */
    private TextToSpeech f13436b;

    /* renamed from: c  reason: collision with root package name */
    private TextToSpeech f13437c;

    /* renamed from: d  reason: collision with root package name */
    private String f13438d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Preference.OnPreferenceChangeListener {
        a() {
        }

        @Override // androidx.preference.Preference.OnPreferenceChangeListener
        public boolean onPreferenceChange(Preference preference, Object obj) {
            Settings.setUseInboxIncomingSMS(PreferencesFragment.this.getContext(), ((Boolean) obj).booleanValue());
            List<Macro> enabledMacros = MacroStore.getInstance().getEnabledMacros();
            ArrayList<Trigger> arrayList = new ArrayList();
            for (Macro macro : enabledMacros) {
                Iterator<Trigger> it = macro.getTriggerList().iterator();
                while (it.hasNext()) {
                    Trigger next = it.next();
                    if ((next instanceof IncomingSMSTrigger) && next.isEnabled()) {
                        next.disableTriggerThreadSafe();
                        arrayList.add(next);
                    }
                }
            }
            for (Trigger trigger : arrayList) {
                trigger.enableTriggerThreadSafe();
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Preference f13440a;

        b(Preference preference) {
            this.f13440a = preference;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            ToastCompat.makeText(PreferencesFragment.this.getActivity().getApplicationContext(), (int) R.string.helper_file_removed, 0).show();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (Util.removeSystemHelperApk(PreferencesFragment.this.getActivity())) {
                PreferencesFragment.this.getActivity().runOnUiThread(new Runnable() { // from class: com.arlosoft.macrodroid.settings.c2
                    @Override // java.lang.Runnable
                    public final void run() {
                        PreferencesFragment.b.this.b();
                    }
                });
                PreferencesFragment.this.getPreferenceScreen().removePreference(this.f13440a);
                Settings.setSystemHelperInstalledVersion(PreferencesFragment.this.getActivity(), -1);
                return;
            }
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to remove helper file"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements Preference.OnPreferenceClickListener {
        c() {
        }

        @Override // androidx.preference.Preference.OnPreferenceClickListener
        public boolean onPreferenceClick(Preference preference) {
            AccountPicker.AccountChooserOptions.Builder allowableAccountsTypes = new AccountPicker.AccountChooserOptions.Builder().setAllowableAccountsTypes(Arrays.asList("com.google"));
            String emailGmailAddress = Settings.getEmailGmailAddress(PreferencesFragment.this.requireContext());
            if (emailGmailAddress != null) {
                allowableAccountsTypes.setSelectedAccount(new Account(emailGmailAddress, "com.google"));
            }
            PreferencesFragment.this.startActivityForResult(AccountPicker.newChooseAccountIntent(allowableAccountsTypes.build()), 1);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class f implements Comparable<f> {

        /* renamed from: a  reason: collision with root package name */
        public String f13451a;

        /* renamed from: b  reason: collision with root package name */
        public String f13452b;

        public f(String str, String str2) {
            this.f13451a = str;
            this.f13452b = str2;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(f fVar) {
            return this.f13451a.compareTo(fVar.f13451a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean A0(Preference preference) {
        startActivity(new Intent(getActivity(), KeepAccessibilityServicesRunningActivity.class));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean B0(Preference preference, Object obj) {
        File file = new File(Environment.getExternalStorageDirectory(), "MacroDroid/Photos/.nomedia");
        if (obj.toString().equals("false")) {
            if (!file.exists()) {
                file.mkdirs();
                return true;
            }
            return true;
        } else if (file.exists()) {
            file.delete();
            return true;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean C0(Preference preference, Object obj) {
        File file = new File(Environment.getExternalStorageDirectory(), RecordMicrophoneAction.RECORDINGS_DIRECTORY);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(Environment.getExternalStorageDirectory() + RemoteSettings.FORWARD_SLASH_STRING + RecordMicrophoneAction.RECORDINGS_DIRECTORY, ".nomedia");
        if (((Boolean) obj).booleanValue()) {
            if (!file2.exists()) {
                try {
                    file2.createNewFile();
                    return true;
                } catch (Exception unused) {
                    return true;
                }
            }
            return true;
        } else if (file2.exists()) {
            file2.delete();
            return true;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean D0(Preference preference) {
        FlipDeviceTrigger.updateTriggerState(getActivity());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean E0(Preference preference) {
        Intent intent = new Intent(getActivity(), LocationChooserActivity.class);
        intent.putExtra("title", getString(R.string.weather_location));
        try {
            String weatherLatLon = Settings.getWeatherLatLon(requireActivity());
            String substring = weatherLatLon.substring(weatherLatLon.indexOf("lat=") + 4, weatherLatLon.indexOf("&lon="));
            String substring2 = weatherLatLon.substring(weatherLatLon.indexOf("&lon=") + 5);
            intent.putExtra(LocationChooserActivity.EXTRA_LAT, Double.valueOf(substring));
            intent.putExtra(LocationChooserActivity.EXTRA_LON, Double.valueOf(substring2));
        } catch (Exception unused) {
        }
        startActivityForResult(intent, 2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean F0(Preference preference, Object obj) {
        getActivity().sendBroadcast(new Intent(Util.WEATHER_UPDATE_RATE_INTENT));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean G0(Preference preference) {
        Intent intent = new Intent(getActivity(), LocationChooserActivity.class);
        intent.putExtra("title", getString(R.string.sunrise_sunset_location));
        try {
            String sunriseSunsetLatLon = Settings.getSunriseSunsetLatLon(requireActivity());
            String substring = sunriseSunsetLatLon.substring(0, sunriseSunsetLatLon.indexOf(","));
            String substring2 = sunriseSunsetLatLon.substring(sunriseSunsetLatLon.indexOf(",") + 1);
            intent.putExtra(LocationChooserActivity.EXTRA_LAT, Double.valueOf(substring));
            intent.putExtra(LocationChooserActivity.EXTRA_LON, Double.valueOf(substring2));
        } catch (Exception unused) {
        }
        startActivityForResult(intent, 3);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H0(DialogInterface dialogInterface, int i4) {
        Intent intent = new Intent("android.settings.USAGE_ACCESS_SETTINGS");
        intent.addFlags(268435456);
        try {
            getActivity().startActivityForResult(intent, 0);
        } catch (Exception unused) {
            ToastCompat.makeText(getActivity().getApplicationContext(), (CharSequence) getString(R.string.cannot_launch_accessibility_settings), 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean I0(Preference preference, Object obj) {
        if (obj instanceof Boolean) {
            Settings.setAPI22AppLaunchTrigger(getActivity(), ((Boolean) obj).booleanValue());
        }
        List<Macro> enabledMacros = MacroStore.getInstance().getEnabledMacros();
        for (Macro macro : enabledMacros) {
            Iterator<Trigger> it = macro.getTriggerList().iterator();
            while (it.hasNext()) {
                Trigger next = it.next();
                if (next instanceof ApplicationLaunchedTrigger) {
                    next.disableTriggerThreadSafe();
                }
            }
        }
        for (Macro macro2 : enabledMacros) {
            Iterator<Trigger> it2 = macro2.getTriggerList().iterator();
            while (it2.hasNext()) {
                Trigger next2 = it2.next();
                if (next2 instanceof ApplicationLaunchedTrigger) {
                    next2.enableTriggerThreadSafe();
                }
            }
        }
        if (((Boolean) obj).booleanValue()) {
            boolean z3 = false;
            try {
                ApplicationInfo applicationInfo = getContext().getPackageManager().getApplicationInfo(getContext().getPackageName(), 0);
                if (((AppOpsManager) getContext().getSystemService("appops")).checkOpNoThrow("android:get_usage_stats", applicationInfo.uid, applicationInfo.packageName) == 0) {
                    z3 = true;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            if (!z3) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.usage_access_required);
                builder.setMessage(R.string.usage_access_required_description);
                builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.settings.l1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) {
                        PreferencesFragment.this.H0(dialogInterface, i4);
                    }
                });
                builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
                builder.show();
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean J0(Preference preference, Object obj) {
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerList().iterator();
            while (it.hasNext()) {
                Trigger next = it.next();
                if ((next instanceof ProximityTrigger) && macro.isEnabled()) {
                    next.disableTriggerThreadSafe();
                    next.enableTriggerThreadSafe();
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean K0(String[] strArr, f[] fVarArr, Preference preference, Object obj) {
        LocaleList adjustedDefault;
        Locale locale;
        int size;
        Locale locale2;
        Configuration configuration = getActivity().getResources().getConfiguration();
        int i4 = 0;
        while (true) {
            if (i4 < strArr.length) {
                if (strArr[i4].equals(obj)) {
                    break;
                }
                i4++;
            } else {
                i4 = 0;
                break;
            }
        }
        if (i4 == 0) {
            Settings.setForcedLanguageCode(getActivity(), null);
            if (Build.VERSION.SDK_INT >= 24) {
                adjustedDefault = LocaleList.getAdjustedDefault();
                locale = adjustedDefault.get(0);
                if (TextUtils.isEmpty(locale.getDisplayCountry())) {
                    size = adjustedDefault.size();
                    if (size > 1) {
                        locale2 = adjustedDefault.get(1);
                        configuration.locale = locale2;
                    }
                }
                configuration.locale = Locale.getDefault();
            } else {
                configuration.locale = Locale.getDefault();
            }
        } else {
            String str = fVarArr[i4 - 1].f13452b;
            if (str.startsWith(TranslateLanguage.CHINESE)) {
                str = TranslateLanguage.CHINESE;
            }
            Settings.setForcedLanguageCode(getActivity(), str);
            configuration.locale = Locale.forLanguageTag(str);
        }
        Locale.setDefault(configuration.locale);
        getActivity().getApplicationContext().getResources().updateConfiguration(configuration, getActivity().getApplicationContext().getResources().getDisplayMetrics());
        MacroDroidApplication.Companion.setLocale(configuration.locale);
        MacroDroidApplication.getInstance().forceLanguage();
        Settings.setCategories(getActivity(), null);
        ((MacroDroidBaseActivity) requireActivity()).setLocale(configuration.locale);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean L0(Preference preference, Object obj) {
        AppCompatDelegate.setDefaultNightMode(Integer.parseInt((String) obj));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean M0(Preference preference) {
        startActivity(new Intent(getActivity(), DonateActivity.class));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean N0(Preference preference) {
        TwitterOutput.setupTwitter(getActivity(), null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean O0(Preference preference, Object obj) {
        ShakeEventListener.setShakeSensitivity((String) obj);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean P0(Preference preference, Object obj) {
        ShakeEventListener.setShakeSensitivity((String) obj);
        return true;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: MarkMethodsForInline
        java.lang.IndexOutOfBoundsException: Index: 0
        	at java.base/java.util.Collections$EmptyList.get(Collections.java:4586)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
        */
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean Q0(androidx.preference.Preference r0, java.lang.Object r1) {
        /*
            resetAllShakeTriggerMacros()
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.settings.PreferencesFragment.Q0(androidx.preference.Preference, java.lang.Object):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean R0(Preference preference, Object obj) {
        getActivity().sendBroadcast(new Intent(Util.CELL_TOWER_UPDATE_RATE_INTENT));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean S0(Preference preference, Object obj) {
        if (getActivity() != null) {
            getActivity().sendBroadcast(new Intent(Util.ACTIVITY_RECOGNITION_UPDATE_RATE_INTENT));
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean T0(Preference preference, Object obj) {
        getActivity().sendBroadcast(new Intent(Util.WIFI_BACKGROUND_SCAN_RATE_INTENT));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean U0(Preference preference, Object obj) {
        getActivity().sendBroadcast(new Intent(Util.LIGHT_SENSOR_BACKGROUND_SCAN_RATE_INTENT));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean V0(Preference preference, Object obj) {
        getActivity().sendBroadcast(new Intent(Util.LOC_UPDATE_RATE_INTENT));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean W0(ListPreference listPreference, Preference preference, Object obj) {
        int i4;
        int intValue = Integer.valueOf(obj.toString()).intValue();
        Settings.setMagicTextDefaultBrackets(requireContext(), intValue);
        if (intValue == MagicText.DEFAULT_BRACKETS_CURLY) {
            i4 = R.string.magic_text_curly_brackets;
        } else {
            i4 = R.string.magic_text_square_brackets;
        }
        listPreference.setSummary(getString(i4));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean X0(Preference preference) {
        if (ContextCompat.checkSelfPermission(getActivity(), "android.permission.CAMERA") != 0) {
            requestPermissions(new String[]{"android.permission.CAMERA"}, 11);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean Y0(Preference preference) {
        k0();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean Z0(Preference preference) {
        PebbleHelper.installPebbleApp(getActivity());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a1(Preference preference, Preference preference2) {
        new b(preference).start();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean b1(Preference preference) {
        startActivity(new Intent(getActivity(), PrivacyActivity.class));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean c1(Preference preference) {
        UninstallHelper.uninstallMacroDroid(requireContext());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean d1(Preference preference) {
        startActivity(new Intent(getActivity(), QuickSettingsActivity.class));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean e1(Preference preference) {
        startActivity(new Intent(getActivity(), QuickSettingsActivity.class));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean f1(Preference preference, Object obj) {
        if (!MacroDroidApplication.getInstance().premiumStatusHandler.getPremiumStatus().isPro()) {
            try {
                if (Double.valueOf(Double.parseDouble((String) obj)).doubleValue() < 2.0d) {
                    Settings.setReadScreenContentsUpdateRateMs(requireContext(), ExifInterface.GPS_MEASUREMENT_2D);
                    return false;
                }
                return true;
            } catch (Exception unused) {
                Settings.setReadScreenContentsUpdateRateMs(requireContext(), ExifInterface.GPS_MEASUREMENT_2D);
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean g1(Preference preference) {
        ToastCompat.makeText(requireContext(), (int) R.string.restore_all_help_cards_done_popup, 0).show();
        Settings.enableAllInfoCards(requireContext());
        return true;
    }

    private void h0() {
        PackageManager packageManager = getActivity().getPackageManager();
        PreferenceScreen preferenceScreen = (PreferenceScreen) findPreference(Settings.PREFERENCE_TAKE_PICTURE_ACTION);
        if (preferenceScreen != null) {
            if (!packageManager.hasSystemFeature("android.hardware.camera")) {
                getPreferenceScreen().removePreference(preferenceScreen);
                return;
            }
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            int i4 = -1;
            int i5 = -1;
            for (int i6 = 0; i6 < Camera.getNumberOfCameras(); i6++) {
                Camera.getCameraInfo(i6, cameraInfo);
                int i7 = cameraInfo.facing;
                if (i7 == 0) {
                    i4 = i6;
                } else if (i7 == 1) {
                    i5 = i6;
                }
            }
            ListPreference listPreference = (ListPreference) findPreference("preferences:rear_camera_resolution");
            ListPreference listPreference2 = (ListPreference) findPreference("preferences:front_camera_resolution");
            if (i4 == -1) {
                preferenceScreen.removePreference(listPreference);
            } else {
                t1(i4, listPreference);
            }
            if (i5 == -1) {
                preferenceScreen.removePreference(listPreference2);
            } else {
                t1(i5, listPreference2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean h1(Preference preference) {
        startActivity(new Intent(getActivity(), EditCategoriesActivity.class));
        return true;
    }

    private void i0() {
        Preference findPreference = findPreference(Settings.PREFERENCE_EMAIL_GMAIL_ACCOUNT);
        if (findPreference != null) {
            try {
                String emailGmailAddress = Settings.getEmailGmailAddress(requireContext());
                if (emailGmailAddress == null) {
                    startActivityForResult(AccountPicker.newChooseAccountIntent(new AccountPicker.AccountChooserOptions.Builder().setAllowableAccountsTypes(Arrays.asList("com.google")).build()), 1);
                } else {
                    findPreference.setSummary(emailGmailAddress);
                }
            } catch (Exception unused) {
                ToastCompat.makeText(getActivity(), (int) R.string.macrodroid_error, 0).show();
            }
            findPreference.setOnPreferenceClickListener(new c());
        }
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPreference(Settings.PREFERENCE_EMAIL_USE_PASSWORD);
        final EncryptedEditTextPreference encryptedEditTextPreference = (EncryptedEditTextPreference) findPreference(Settings.PREFERENCE_EMAIL_PASSWORD);
        if (encryptedEditTextPreference != null) {
            encryptedEditTextPreference.setVisible(checkBoxPreference.isChecked());
            encryptedEditTextPreference.setOnBindEditTextListener(new EditTextPreference.OnBindEditTextListener() { // from class: com.arlosoft.macrodroid.settings.h0
                @Override // androidx.preference.EditTextPreference.OnBindEditTextListener
                public final void onBindEditText(EditText editText) {
                    PreferencesFragment.this.m0(encryptedEditTextPreference, editText);
                }
            });
            checkBoxPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.arlosoft.macrodroid.settings.s0
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    boolean n02;
                    n02 = PreferencesFragment.n0(EncryptedEditTextPreference.this, preference, obj);
                    return n02;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i1(ViewGroup viewGroup, ViewGroup viewGroup2, TextView textView, TextView textView2, Spinner spinner, CompoundButton compoundButton, boolean z3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = 0;
        if (z3) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        viewGroup.setVisibility(i4);
        if (z3) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        viewGroup2.setVisibility(i5);
        if (z3) {
            i6 = 0;
        } else {
            i6 = 8;
        }
        textView.setVisibility(i6);
        if (z3) {
            i7 = 0;
        } else {
            i7 = 8;
        }
        textView2.setVisibility(i7);
        if (!z3) {
            i8 = 8;
        }
        spinner.setVisibility(i8);
    }

    private void j0() {
        int i4;
        Preference findPreference = findPreference("preferences:ignore_battery_optimisations");
        if (findPreference != null) {
            if (Build.VERSION.SDK_INT < 23) {
                findPreference.setVisible(false);
            } else {
                if (getActivity().getPackageManager().queryIntentActivities(new Intent("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS"), 0).size() == 0) {
                    findPreference.setVisible(false);
                }
                findPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.arlosoft.macrodroid.settings.d1
                    @Override // androidx.preference.Preference.OnPreferenceClickListener
                    public final boolean onPreferenceClick(Preference preference) {
                        boolean o02;
                        o02 = PreferencesFragment.this.o0(preference);
                        return o02;
                    }
                });
            }
        }
        Preference findPreference2 = findPreference("preferences:helper_file");
        if (findPreference2 != null) {
            String macroDroidHelperVersionName = ApplicationChecker.getMacroDroidHelperVersionName();
            if (macroDroidHelperVersionName != null) {
                findPreference2.setSummary(String.format(getString(R.string.helper_file_version_is_installed), macroDroidHelperVersionName));
                findPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.arlosoft.macrodroid.settings.b0
                    @Override // androidx.preference.Preference.OnPreferenceClickListener
                    public final boolean onPreferenceClick(Preference preference) {
                        boolean p02;
                        p02 = PreferencesFragment.this.p0(preference);
                        return p02;
                    }
                });
            } else {
                findPreference2.setVisible(false);
            }
        }
        Preference findPreference3 = findPreference("preferences:keep_accessibility_running");
        if (findPreference3 != null) {
            findPreference3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.arlosoft.macrodroid.settings.n0
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean A0;
                    A0 = PreferencesFragment.this.A0(preference);
                    return A0;
                }
            });
        }
        ListPreference listPreference = (ListPreference) findPreference("preferences:dark_mode");
        if (listPreference != null) {
            listPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.arlosoft.macrodroid.settings.z0
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    boolean L0;
                    L0 = PreferencesFragment.L0(preference, obj);
                    return L0;
                }
            });
        }
        final ListPreference listPreference2 = (ListPreference) findPreference("preferences:magic_text_default_brackets");
        if (listPreference2 != null) {
            if (Integer.valueOf(listPreference2.getValue()).intValue() == MagicText.DEFAULT_BRACKETS_CURLY) {
                i4 = R.string.magic_text_curly_brackets;
            } else {
                i4 = R.string.magic_text_square_brackets;
            }
            listPreference2.setSummary(getString(i4));
            listPreference2.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.arlosoft.macrodroid.settings.c1
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    boolean W0;
                    W0 = PreferencesFragment.this.W0(listPreference2, preference, obj);
                    return W0;
                }
            });
        }
        Preference findPreference4 = findPreference("preferences:quick_settings_tiles");
        if (findPreference4 != null) {
            if (Build.VERSION.SDK_INT < 24) {
                findPreference4.setVisible(false);
            } else {
                findPreference4.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.arlosoft.macrodroid.settings.e1
                    @Override // androidx.preference.Preference.OnPreferenceClickListener
                    public final boolean onPreferenceClick(Preference preference) {
                        boolean d12;
                        d12 = PreferencesFragment.this.d1(preference);
                        return d12;
                    }
                });
            }
        }
        if (findPreference4 != null) {
            if (Build.VERSION.SDK_INT < 24) {
                findPreference4.setVisible(false);
            } else {
                findPreference4.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.arlosoft.macrodroid.settings.f1
                    @Override // androidx.preference.Preference.OnPreferenceClickListener
                    public final boolean onPreferenceClick(Preference preference) {
                        boolean e12;
                        e12 = PreferencesFragment.this.e1(preference);
                        return e12;
                    }
                });
            }
        }
        ListPreference listPreference3 = (ListPreference) findPreference(Settings.PREFERENCE_READ_SCREEN_CONTENTS_UPDATE_RATE);
        if (listPreference3 != null) {
            CharSequence[] entries = listPreference3.getEntries();
            if (!MacroDroidApplication.getInstance().premiumStatusHandler.getPremiumStatus().isPro()) {
                for (int i5 = 0; i5 < entries.length; i5++) {
                    if (Double.valueOf(Double.parseDouble(entries[i5].toString())).doubleValue() < 2.0d) {
                        entries[i5] = ((Object) entries[i5]) + " (" + getString(R.string.pro_version_only_short) + ")";
                    }
                }
            }
            listPreference3.setEntries(entries);
            listPreference3.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.arlosoft.macrodroid.settings.g1
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    boolean f12;
                    f12 = PreferencesFragment.this.f1(preference, obj);
                    return f12;
                }
            });
        }
        Preference findPreference5 = findPreference("preferences:restore_all_help_info_cards");
        if (findPreference5 != null) {
            findPreference5.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.arlosoft.macrodroid.settings.h1
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean g12;
                    g12 = PreferencesFragment.this.g1(preference);
                    return g12;
                }
            });
        }
        Preference findPreference6 = findPreference(Settings.PREFERENCE_EDIT_CATEGORIES);
        if (findPreference6 != null) {
            findPreference6.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.arlosoft.macrodroid.settings.i1
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean h12;
                    h12 = PreferencesFragment.this.h1(preference);
                    return h12;
                }
            });
        }
        Preference findPreference7 = findPreference("preferences:notification_channels");
        if (findPreference7 != null) {
            if (Build.VERSION.SDK_INT < 26) {
                findPreference7.setVisible(false);
            } else {
                findPreference7.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.arlosoft.macrodroid.settings.o1
                    @Override // androidx.preference.Preference.OnPreferenceClickListener
                    public final boolean onPreferenceClick(Preference preference) {
                        boolean q02;
                        q02 = PreferencesFragment.this.q0(preference);
                        return q02;
                    }
                });
            }
        }
        Preference findPreference8 = findPreference(Settings.PREFERENCE_EDIT_CUSTOM_MODES);
        if (findPreference8 != null) {
            findPreference8.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.arlosoft.macrodroid.settings.x1
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean r02;
                    r02 = PreferencesFragment.this.r0(preference);
                    return r02;
                }
            });
        }
        ListPreference listPreference4 = (ListPreference) findPreference(Settings.PREFERENCE_TTS_ENGINE);
        if (listPreference4 != null) {
            TextToSpeech textToSpeech = new TextToSpeech(getContext().getApplicationContext(), null);
            this.f13437c = textToSpeech;
            List<TextToSpeech.EngineInfo> engines = textToSpeech.getEngines();
            int size = engines.size();
            String[] strArr = new String[size];
            String[] strArr2 = new String[engines.size()];
            String tTSEnginePackage = Settings.getTTSEnginePackage(getContext());
            if (tTSEnginePackage == null) {
                tTSEnginePackage = this.f13437c.getDefaultEngine();
            }
            int i6 = 0;
            for (int i7 = 0; i7 < engines.size(); i7++) {
                strArr[i7] = engines.get(i7).label;
                String str = engines.get(i7).name;
                strArr2[i7] = str;
                if (TextUtils.equals(tTSEnginePackage, str)) {
                    i6 = i7;
                }
            }
            listPreference4.setEntries(strArr);
            listPreference4.setEntryValues(strArr2);
            if (size > 0) {
                listPreference4.setValueIndex(i6);
            }
            listPreference4.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.arlosoft.macrodroid.settings.y1
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    boolean s02;
                    s02 = PreferencesFragment.this.s0(preference, obj);
                    return s02;
                }
            });
        }
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPreference("preferences:use_inbox_incoming_sms");
        if (checkBoxPreference != null) {
            checkBoxPreference.setOnPreferenceChangeListener(new a());
        }
        final EditTextPreference editTextPreference = (EditTextPreference) findPreference("preferences:smtp_password");
        if (editTextPreference != null) {
            editTextPreference.setOnBindEditTextListener(new EditTextPreference.OnBindEditTextListener() { // from class: com.arlosoft.macrodroid.settings.z1
                @Override // androidx.preference.EditTextPreference.OnBindEditTextListener
                public final void onBindEditText(EditText editText) {
                    PreferencesFragment.this.u0(editTextPreference, editText);
                }
            });
        }
        EditTextPreference editTextPreference2 = (EditTextPreference) findPreference(Settings.PREFERENCE_POWER_BUTTON_TOGGLE_TIMEOUT);
        if (editTextPreference2 != null) {
            editTextPreference2.setOnBindEditTextListener(new EditTextPreference.OnBindEditTextListener() { // from class: com.arlosoft.macrodroid.settings.a2
                @Override // androidx.preference.EditTextPreference.OnBindEditTextListener
                public final void onBindEditText(EditText editText) {
                    editText.setInputType(2);
                }
            });
        }
        final ListPreference listPreference5 = (ListPreference) findPreference(Settings.PREFERENCE_SPOKEN_LANGUAGE);
        if (listPreference5 != null) {
            listPreference5.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.arlosoft.macrodroid.settings.b2
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean w02;
                    w02 = PreferencesFragment.this.w0(preference);
                    return w02;
                }
            });
            listPreference5.setEnabled(false);
            this.f13436b = new TextToSpeech(MacroDroidApplication.getInstance(), new TextToSpeech.OnInitListener() { // from class: com.arlosoft.macrodroid.settings.x
                @Override // android.speech.tts.TextToSpeech.OnInitListener
                public final void onInit(int i8) {
                    PreferencesFragment.this.z0(listPreference5, i8);
                }
            });
        }
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) findPreference(Settings.PREFERENCE_PHOTO_IN_GALLERY);
        if (checkBoxPreference2 != null) {
            checkBoxPreference2.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.arlosoft.macrodroid.settings.y
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    boolean B0;
                    B0 = PreferencesFragment.B0(preference, obj);
                    return B0;
                }
            });
        }
        Preference findPreference9 = findPreference(Settings.PREFERENCE_HIDDEN_MICROPHONE_RECORDING);
        if (findPreference9 != null) {
            findPreference9.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.arlosoft.macrodroid.settings.z
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    boolean C0;
                    C0 = PreferencesFragment.C0(preference, obj);
                    return C0;
                }
            });
        }
        Preference findPreference10 = findPreference(Settings.PREFERENCE_FLIP_DEVICE_SCREEN_OFF);
        if (findPreference10 != null) {
            findPreference10.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.arlosoft.macrodroid.settings.a0
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean D0;
                    D0 = PreferencesFragment.this.D0(preference);
                    return D0;
                }
            });
        }
        Preference findPreference11 = findPreference(Settings.PREFERENCE_CONFIGURE_WEATHER_LOCATION);
        if (findPreference11 != null) {
            findPreference11.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.arlosoft.macrodroid.settings.c0
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean E0;
                    E0 = PreferencesFragment.this.E0(preference);
                    return E0;
                }
            });
        }
        ListPreference listPreference6 = (ListPreference) findPreference(Settings.PREFERENCE_WEATHER_UPDATE_RATE);
        if (listPreference6 != null) {
            listPreference6.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.arlosoft.macrodroid.settings.d0
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    boolean F0;
                    F0 = PreferencesFragment.this.F0(preference, obj);
                    return F0;
                }
            });
        }
        Preference findPreference12 = findPreference(Settings.PREFERENCE_CONFIGURE_SUNRISE_SUNSET_LOCATION);
        if (findPreference12 != null) {
            findPreference12.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.arlosoft.macrodroid.settings.e0
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean G0;
                    G0 = PreferencesFragment.this.G0(preference);
                    return G0;
                }
            });
        }
        if (Build.VERSION.SDK_INT != 21) {
            PreferenceGroup preferenceGroup = (PreferenceGroup) findPreference("preference:trigger_options_screen");
            PreferenceGroup preferenceGroup2 = (PreferenceGroup) findPreference("preferences:app_launched_screen");
            if (preferenceGroup != null && preferenceGroup2 != null) {
                preferenceGroup.removePreference(preferenceGroup2);
            }
        } else {
            CheckBoxPreference checkBoxPreference3 = (CheckBoxPreference) findPreference(Settings.PREFERENCE_FORCE_API_22_APP_LAUNCHED_TRIGGER);
            if (checkBoxPreference3 != null) {
                checkBoxPreference3.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.arlosoft.macrodroid.settings.f0
                    @Override // androidx.preference.Preference.OnPreferenceChangeListener
                    public final boolean onPreferenceChange(Preference preference, Object obj) {
                        boolean I0;
                        I0 = PreferencesFragment.this.I0(preference, obj);
                        return I0;
                    }
                });
            }
        }
        CheckBoxPreference checkBoxPreference4 = (CheckBoxPreference) findPreference(Settings.PREFERENCE_PROXIMITY_SENSOR_SCREEN_OFF);
        if (checkBoxPreference4 != null) {
            checkBoxPreference4.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.arlosoft.macrodroid.settings.g0
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    boolean J0;
                    J0 = PreferencesFragment.J0(preference, obj);
                    return J0;
                }
            });
        }
        ListPreference listPreference7 = (ListPreference) findPreference(Settings.PREFERENCE_SET_LANGUAGE);
        if (listPreference7 != null) {
            String[] stringArray = getResources().getStringArray(R.array.languages);
            String[] stringArray2 = getResources().getStringArray(R.array.languages_codes);
            int length = stringArray.length;
            final f[] fVarArr = new f[length];
            for (int i8 = 0; i8 < stringArray.length; i8++) {
                fVarArr[i8] = new f(stringArray[i8], stringArray2[i8]);
            }
            Arrays.sort(fVarArr);
            final String[] strArr3 = new String[length + 1];
            strArr3[0] = getString(R.string.system_default);
            int i9 = 0;
            while (i9 < length) {
                int i10 = i9 + 1;
                strArr3[i10] = fVarArr[i9].f13451a;
                i9 = i10;
            }
            listPreference7.setEntries(strArr3);
            listPreference7.setEntryValues(strArr3);
            listPreference7.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.arlosoft.macrodroid.settings.i0
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    boolean K0;
                    K0 = PreferencesFragment.this.K0(strArr3, fVarArr, preference, obj);
                    return K0;
                }
            });
            if (listPreference7.getValue() == null) {
                listPreference7.setValueIndex(0);
            }
        }
        CheckBoxPreference checkBoxPreference5 = (CheckBoxPreference) findPreference(AppPreferencesKt.PREF_AUTO_TRANSLATE_TEMPLATES);
        if (checkBoxPreference5 != null) {
            Locale locale = Settings.getLocale(getActivity());
            if (!locale.getLanguage().startsWith(TranslateLanguage.SPANISH) || !locale.getLanguage().startsWith(TranslateLanguage.JAPANESE)) {
                checkBoxPreference5.setSummary(R.string.auto_translate_foreign_templates_to_english);
            }
        }
        Preference findPreference13 = findPreference(Settings.PREFERENCE_DONATE);
        if (findPreference13 != null) {
            findPreference13.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.arlosoft.macrodroid.settings.j0
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean M0;
                    M0 = PreferencesFragment.this.M0(preference);
                    return M0;
                }
            });
        }
        Preference findPreference14 = findPreference(Settings.PREFERENCE_TWITTER);
        if (findPreference14 != null) {
            findPreference14.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.arlosoft.macrodroid.settings.k0
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean N0;
                    N0 = PreferencesFragment.this.N0(preference);
                    return N0;
                }
            });
        }
        Preference findPreference15 = findPreference(Settings.PREFERENCE_HOME_SCREEN_TILES_PER_ROW_LANDSCAPE);
        if (findPreference15 != null && !getResources().getBoolean(R.bool.is_tablet)) {
            findPreference15.setVisible(false);
        }
        Preference findPreference16 = findPreference(Settings.PREFERENCE_FACEBOOK);
        if (findPreference16 != null) {
            findPreference16.setVisible(false);
        }
        boolean booleanExtra = getActivity().getIntent().getBooleanExtra(Util.LAUNCH_FACEBOOK_EXTRA, false);
        boolean booleanExtra2 = getActivity().getIntent().getBooleanExtra(Util.LAUNCH_TWITTER_EXTRA, false);
        if (!booleanExtra && booleanExtra2) {
            TwitterOutput.setupTwitter(getActivity(), null);
        }
        ListPreference listPreference8 = (ListPreference) findPreference(Settings.PREFERENCE_SHAKE_SENSITIVITY);
        if (listPreference8 != null) {
            listPreference8.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.arlosoft.macrodroid.settings.l0
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    boolean O0;
                    O0 = PreferencesFragment.O0(preference, obj);
                    return O0;
                }
            });
        }
        ListPreference listPreference9 = (ListPreference) findPreference(Settings.PREFERENCE_SHAKE_SAMPLE_FREQUENCY);
        if (listPreference9 != null) {
            listPreference9.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.arlosoft.macrodroid.settings.m0
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    boolean P0;
                    P0 = PreferencesFragment.P0(preference, obj);
                    return P0;
                }
            });
        }
        Preference findPreference17 = findPreference(Settings.PREFERENCE_SHAKE_SCREEN_OFF);
        if (findPreference17 != null) {
            findPreference17.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.arlosoft.macrodroid.settings.o0
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return PreferencesFragment.Q0(preference, obj);
                }
            });
        }
        ListPreference listPreference10 = (ListPreference) findPreference(Settings.PREFERENCE_CELL_TOWER_UPDATE_RATE);
        if (listPreference10 != null) {
            listPreference10.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.arlosoft.macrodroid.settings.p0
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    boolean R0;
                    R0 = PreferencesFragment.this.R0(preference, obj);
                    return R0;
                }
            });
        }
        ListPreference listPreference11 = (ListPreference) findPreference(Settings.PREFERENCE_ACTIVITY_RECOGNITION_UPDATE_RATE);
        if (listPreference11 != null) {
            listPreference11.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.arlosoft.macrodroid.settings.q0
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    boolean S0;
                    S0 = PreferencesFragment.this.S0(preference, obj);
                    return S0;
                }
            });
        }
        ListPreference listPreference12 = (ListPreference) findPreference(Settings.PREFERENCE_WIFI_BACKGROUND_SCAN_RATE);
        if (listPreference12 != null) {
            listPreference12.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.arlosoft.macrodroid.settings.r0
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    boolean T0;
                    T0 = PreferencesFragment.this.T0(preference, obj);
                    return T0;
                }
            });
        }
        ListPreference listPreference13 = (ListPreference) findPreference(Settings.PREFERENCE_LIGHT_SENSOR_BG_UPDATE_RATE);
        if (listPreference13 != null) {
            listPreference13.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.arlosoft.macrodroid.settings.t0
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    boolean U0;
                    U0 = PreferencesFragment.this.U0(preference, obj);
                    return U0;
                }
            });
        }
        ListPreference listPreference14 = (ListPreference) findPreference(Settings.PREFERENCE_LOC_UPDATE_RATE_SECONDS);
        if (listPreference14 != null) {
            listPreference14.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.arlosoft.macrodroid.settings.u0
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    boolean V0;
                    V0 = PreferencesFragment.this.V0(preference, obj);
                    return V0;
                }
            });
        }
        PreferenceScreen preferenceScreen = (PreferenceScreen) findPreference(Settings.PREFERENCE_TAKE_PICTURE_ACTION);
        if (preferenceScreen != null) {
            preferenceScreen.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.arlosoft.macrodroid.settings.v0
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean X0;
                    X0 = PreferencesFragment.this.X0(preference);
                    return X0;
                }
            });
        }
        String str2 = this.f13438d;
        if (str2 != null && str2.equals(Settings.PREFERENCE_TAKE_PICTURE_ACTION)) {
            try {
                h0();
            } catch (RuntimeException e4) {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("PreferencesFragment: Runtime exception calling configureCameraOptions: " + e4.getMessage()));
            }
        }
        Preference findPreference18 = findPreference(Settings.PREFERENCE_PASSWORD_PROTECT);
        if (findPreference18 != null) {
            findPreference18.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.arlosoft.macrodroid.settings.w0
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean Y0;
                    Y0 = PreferencesFragment.this.Y0(preference);
                    return Y0;
                }
            });
        }
        Preference findPreference19 = findPreference(Settings.PREFERENCE_PEBBLE_INSTALL_WATCH_APP);
        if (findPreference19 != null) {
            if (!ApplicationChecker.isPebbleInstalled()) {
                getPreferenceScreen().removePreference(findPreference19);
            }
            findPreference19.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.arlosoft.macrodroid.settings.x0
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean Z0;
                    Z0 = PreferencesFragment.this.Z0(preference);
                    return Z0;
                }
            });
        }
        final Preference findPreference20 = findPreference("preferences:remove_helper_file");
        if (findPreference20 != null) {
            findPreference20.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.arlosoft.macrodroid.settings.y0
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean a12;
                    a12 = PreferencesFragment.this.a1(findPreference20, preference);
                    return a12;
                }
            });
        }
        if (!Util.helperFileExists() && findPreference20 != null) {
            getPreferenceScreen().removePreference(findPreference20);
        }
        Preference findPreference21 = findPreference("preferences:privacy_policy");
        if (findPreference21 != null) {
            findPreference21.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.arlosoft.macrodroid.settings.a1
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean b12;
                    b12 = PreferencesFragment.this.b1(preference);
                    return b12;
                }
            });
        }
        Preference findPreference22 = findPreference(Settings.PREFERENCE_EXPORT_OPTION);
        if (findPreference22 != null) {
            getPreferenceScreen().removePreference(findPreference22);
        }
        Preference findPreference23 = findPreference("preferences:uninstall");
        if (findPreference23 != null) {
            findPreference23.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.arlosoft.macrodroid.settings.b1
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean c12;
                    c12 = PreferencesFragment.this.c1(preference);
                    return c12;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j1(SwitchCompat switchCompat, EditText editText, Button button, SwitchCompat switchCompat2, int[] iArr, Spinner spinner, AppCompatDialog appCompatDialog, View view) {
        if (switchCompat.isChecked()) {
            Settings.setPassword(getActivity(), editText.getText().toString());
        } else {
            Settings.setPassword(getActivity(), "");
            button.requestFocus();
        }
        Settings.setBiometricsEnabled(getActivity(), switchCompat2.isChecked());
        if (switchCompat2.isChecked()) {
            new ArraySet().add("macrodroid.com");
            BiometricPromptCompat.Companion.init(null);
        }
        Settings.setPasswordCheckDelaySeconds(getActivity(), iArr[spinner.getSelectedItemPosition()]);
        s1(!switchCompat.isChecked());
        appCompatDialog.cancel();
    }

    private void k0() {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), R.style.Theme_App_Dialog_Settings);
        appCompatDialog.setContentView(R.layout.password_entry_dialog);
        appCompatDialog.setTitle(R.string.configure_password);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        final Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.password_entry_dialog_password);
        EditText editText2 = (EditText) appCompatDialog.findViewById(R.id.password_entry_dialog_confirm);
        final SwitchCompat switchCompat = (SwitchCompat) appCompatDialog.findViewById(R.id.password_entry_dialog_switch);
        final ViewGroup viewGroup = (ViewGroup) appCompatDialog.findViewById(R.id.password_entry_passwords_layout);
        final ViewGroup viewGroup2 = (ViewGroup) appCompatDialog.findViewById(R.id.biometrics_layout);
        final SwitchCompat switchCompat2 = (SwitchCompat) appCompatDialog.findViewById(R.id.enable_biometrics_switch);
        final TextView textView = (TextView) appCompatDialog.findViewById(R.id.password_warning_text);
        final TextView textView2 = (TextView) appCompatDialog.findViewById(R.id.passwordDelayLabel);
        final Spinner spinner = (Spinner) appCompatDialog.findViewById(R.id.passwordDelaySpinner);
        final int[] intArray = requireContext().getResources().getIntArray(R.array.password_protection_delay_values_seconds);
        int passwordCheckDelaySeconds = Settings.getPasswordCheckDelaySeconds(requireContext());
        int i9 = 0;
        while (true) {
            if (i9 < intArray.length) {
                if (passwordCheckDelaySeconds == intArray[i9]) {
                    break;
                }
                i9++;
            } else {
                i9 = 0;
                break;
            }
        }
        spinner.setSelection(i9);
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.settings.q1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                PreferencesFragment.i1(viewGroup, viewGroup2, textView, textView2, spinner, compoundButton, z3);
            }
        });
        String password = Settings.getPassword(getActivity());
        boolean z3 = !TextUtils.isEmpty(password);
        if (z3) {
            switchCompat.setChecked(true);
            editText.setText(password);
            editText2.setText(password);
            button.setEnabled(true);
        } else {
            switchCompat.setChecked(false);
            button.setEnabled(false);
        }
        if (z3) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        viewGroup.setVisibility(i4);
        if (z3) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        viewGroup2.setVisibility(i5);
        if (z3) {
            i6 = 0;
        } else {
            i6 = 8;
        }
        textView.setVisibility(i6);
        if (z3) {
            i7 = 0;
        } else {
            i7 = 8;
        }
        textView2.setVisibility(i7);
        if (z3) {
            i8 = 0;
        } else {
            i8 = 8;
        }
        spinner.setVisibility(i8);
        switchCompat2.setChecked(Settings.getBiometricsEnabled(getActivity()));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.settings.r1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PreferencesFragment.this.j1(switchCompat, editText, button2, switchCompat2, intArray, spinner, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.settings.s1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        editText.addTextChangedListener(new d(button, editText, editText2));
        editText2.addTextChangedListener(new e(button, editText, editText2));
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CharSequence l0(EditText editText, Preference preference) {
        return r1(editText.getText().toString().length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean l1(Preference preference, Preference preference2, Object obj) {
        String str = (String) obj;
        preference.setSummary(str);
        GmailHelper.getInstance(getActivity()).updateAccountName(str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(EncryptedEditTextPreference encryptedEditTextPreference, final EditText editText) {
        editText.setInputType(129);
        encryptedEditTextPreference.setSummaryProvider(new Preference.SummaryProvider() { // from class: com.arlosoft.macrodroid.settings.p1
            @Override // androidx.preference.Preference.SummaryProvider
            public final CharSequence provideSummary(Preference preference) {
                CharSequence l02;
                l02 = PreferencesFragment.this.l0(editText, preference);
                return l02;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m1(DialogInterface dialogInterface, int i4) {
        Intent intent = new Intent();
        intent.setAction("android.speech.tts.engine.INSTALL_TTS_DATA");
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean n0(EncryptedEditTextPreference encryptedEditTextPreference, Preference preference, Object obj) {
        if (obj.toString().equals("true")) {
            encryptedEditTextPreference.setVisible(true);
        } else {
            encryptedEditTextPreference.setVisible(false);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean o0(Preference preference) {
        boolean isIgnoringBatteryOptimizations;
        Intent intent = new Intent();
        isIgnoringBatteryOptimizations = ((PowerManager) getActivity().getSystemService("power")).isIgnoringBatteryOptimizations(getActivity().getPackageName());
        if (isIgnoringBatteryOptimizations) {
            intent.setAction("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS");
        } else {
            intent.setAction("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
            intent.setData(Uri.parse("package:" + getActivity().getPackageName()));
        }
        try {
            startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            ToastCompat.makeText(getActivity().getApplicationContext(), (int) R.string.not_supported, 0).show();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o1(DialogInterface dialogInterface, int i4) {
        try {
            Intent intent = new Intent("com.android.settings.TTS_SETTINGS");
            intent.setFlags(268435456);
            requireActivity().startActivity(intent);
        } catch (Exception e4) {
            SystemLog.logError("Could not open TTS settings: " + e4.toString());
            ToastCompat.makeText(requireContext(), (int) R.string.error, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean p0(Preference preference) {
        Intent launchIntentForPackage = requireActivity().getPackageManager().getLaunchIntentForPackage("com.arlosoft.macrodroid.helper");
        if (launchIntentForPackage != null) {
            startActivity(launchIntentForPackage);
            return false;
        }
        SystemLog.logError("Could not launch helper app, no launch intent found");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean q0(Preference preference) {
        startActivity(new Intent(getActivity(), EditNotificationChannelsActivity.class));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.language_to_speak);
        builder.setMessage(R.string.speak_text_language_missing_info);
        builder.setNeutralButton(R.string.open_text_to_speech_settings, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.settings.t1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PreferencesFragment.this.o1(dialogInterface, i4);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.settings.u1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PreferencesFragment.p1(dialogInterface, i4);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean r0(Preference preference) {
        startActivity(new Intent(getActivity(), EditModesActivity.class));
        return true;
    }

    private String r1(int i4) {
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < i4; i5++) {
            sb.append("*");
        }
        return sb.toString();
    }

    public static void resetAllShakeTriggerMacros() {
        List<Macro> enabledMacros = MacroStore.getInstance().getEnabledMacros();
        for (Macro macro : enabledMacros) {
            Iterator<Trigger> it = macro.getTriggerList().iterator();
            while (it.hasNext()) {
                Trigger next = it.next();
                if ((next instanceof ShakeDeviceTrigger) && next.isEnabled() && macro.isEnabled()) {
                    next.disableTriggerThreadSafe();
                }
            }
        }
        for (Macro macro2 : enabledMacros) {
            Iterator<Trigger> it2 = macro2.getTriggerList().iterator();
            while (it2.hasNext()) {
                Trigger next2 = it2.next();
                if ((next2 instanceof ShakeDeviceTrigger) && next2.isEnabled() && macro2.isEnabled()) {
                    next2.enableTriggerThreadSafe();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean s0(Preference preference, Object obj) {
        Settings.setTTSEnginePackage(getContext(), (String) obj);
        ArrayList<Action> arrayList = new ArrayList();
        for (Macro macro : MacroStore.getInstance().getAllCompletedMacros()) {
            Iterator<Action> it = macro.getActions().iterator();
            while (it.hasNext()) {
                Action next = it.next();
                if ((next instanceof SpeakTextAction) && macro.isEnabled() && next.isEnabled()) {
                    next.disableActionThreadSafe();
                    arrayList.add(next);
                }
            }
        }
        for (Action action : arrayList) {
            action.enableActionThreadSafe();
        }
        return true;
    }

    private void s1(boolean z3) {
        int i4;
        PackageManager packageManager = requireActivity().getPackageManager();
        ComponentName componentName = new ComponentName(BuildConfig.APPLICATION_ID, "com.arlosoft.macrodroid.triggers.services.quicksettings.MacroDroidOnOffTileService");
        if (z3) {
            i4 = 1;
        } else {
            i4 = 2;
        }
        packageManager.setComponentEnabledSetting(componentName, i4, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CharSequence t0(EditText editText, Preference preference) {
        return r1(editText.getText().toString().length());
    }

    private void t1(int i4, ListPreference listPreference) {
        String[] strArr;
        int i5;
        String str;
        if (ContextCompat.checkSelfPermission(getActivity(), "android.permission.CAMERA") == 0) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i4, cameraInfo);
            try {
                Camera open = Camera.open(i4);
                Camera.Size pictureResolution = Settings.getPictureResolution(getActivity(), open, cameraInfo);
                open.release();
                str = pictureResolution.width + "," + pictureResolution.height;
            } catch (Exception unused) {
                str = "";
            }
            List<String> cameraResolutions = Settings.getCameraResolutions(getActivity(), i4);
            strArr = new String[cameraResolutions.size()];
            i5 = 0;
            for (int i6 = 0; i6 < cameraResolutions.size(); i6++) {
                String str2 = cameraResolutions.get(i6);
                strArr[i6] = str2;
                if (str.equals(str2)) {
                    i5 = i6;
                }
            }
        } else {
            strArr = new String[0];
            i5 = 0;
        }
        if (strArr.length == 0) {
            strArr = new String[]{getString(R.string.no_options_found)};
        }
        listPreference.setEntries(strArr);
        listPreference.setEntryValues(strArr);
        try {
            listPreference.setValueIndex(i5);
        } catch (ArrayIndexOutOfBoundsException e4) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("setupCameraResolutions failed: " + e4.getMessage()));
            listPreference.setValueIndex(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(EditTextPreference editTextPreference, final EditText editText) {
        editText.setInputType(129);
        editTextPreference.setSummaryProvider(new Preference.SummaryProvider() { // from class: com.arlosoft.macrodroid.settings.k1
            @Override // androidx.preference.Preference.SummaryProvider
            public final CharSequence provideSummary(Preference preference) {
                CharSequence t02;
                t02 = PreferencesFragment.this.t0(editText, preference);
                return t02;
            }
        });
    }

    private void u1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.no_speech_data_files);
        builder.setMessage(R.string.no_speech_info);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.settings.v1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PreferencesFragment.this.m1(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.settings.w1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PreferencesFragment.n1(dialogInterface, i4);
            }
        });
        builder.show();
    }

    private void v1() {
        new Handler().postDelayed(new Runnable() { // from class: com.arlosoft.macrodroid.settings.j1
            @Override // java.lang.Runnable
            public final void run() {
                PreferencesFragment.this.q1();
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean w0(Preference preference) {
        v1();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int x0(Locale locale, Locale locale2) {
        return locale.getDisplayName().compareTo(locale2.getDisplayName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean y0(String[] strArr, Preference preference, Object obj) {
        if (!strArr[0].equals(Settings.LANGUAGE_NONE) && ((String) obj).endsWith("(*)")) {
            u1();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0(ListPreference listPreference, int i4) {
        String[] strArr;
        final String[] strArr2;
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Locale spokenLocale = Settings.getSpokenLocale(MacroDroidApplication.getInstance());
            Locale[] localeArr = Settings.SUPPORTED_LOCALES;
            Arrays.sort(localeArr, new Comparator() { // from class: com.arlosoft.macrodroid.settings.m1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int x02;
                    x02 = PreferencesFragment.x0((Locale) obj, (Locale) obj2);
                    return x02;
                }
            });
            int i5 = 0;
            int i6 = -1;
            int i7 = 0;
            int i8 = 0;
            while (i5 < localeArr.length) {
                TextToSpeech textToSpeech = this.f13436b;
                if (textToSpeech != null) {
                    if (textToSpeech.isLanguageAvailable(localeArr[i5]) != -2) {
                        int i9 = i6 + 1;
                        String displayName = localeArr[i5].getDisplayName();
                        arrayList2.add(localeArr[i5].getLanguage() + "-" + localeArr[i5].getCountry());
                        if (this.f13436b.isLanguageAvailable(localeArr[i5]) == -1) {
                            arrayList.add(displayName + "(*)");
                        } else {
                            arrayList.add(displayName);
                        }
                        i6 = i9;
                    }
                    if (spokenLocale != null && spokenLocale.getLanguage().equals(localeArr[i5].getLanguage())) {
                        if (spokenLocale.getLanguage().equals("en")) {
                            if ((!spokenLocale.getCountry().toLowerCase().equals("gb") && !spokenLocale.getCountry().toLowerCase().equals("")) || !localeArr[i5].getCountry().toLowerCase().equals("gb")) {
                                if ((!spokenLocale.getCountry().toLowerCase().equals("in") || !localeArr[i5].getCountry().toLowerCase().equals("in")) && (!spokenLocale.getCountry().toLowerCase().equals("au") || !localeArr[i5].getCountry().toLowerCase().equals("au"))) {
                                    if (!spokenLocale.getCountry().toLowerCase().equals("gb")) {
                                        if (!spokenLocale.getCountry().toLowerCase().equals("in")) {
                                            if (!localeArr[i5].getCountry().toLowerCase().equals("us")) {
                                            }
                                        }
                                    }
                                }
                            }
                            i8 = i5;
                        } else {
                            i7 = spokenLocale.getLanguage().equals(TranslateLanguage.SPANISH) ? i6 : i6;
                        }
                    }
                }
                i5++;
            }
            if (arrayList.size() == 0) {
                arrayList.add(Settings.LANGUAGE_NONE);
                arrayList2.add("");
            }
            if (arrayList.size() > 0) {
                strArr2 = new String[arrayList.size()];
                strArr = new String[arrayList2.size()];
                arrayList.toArray(strArr2);
                arrayList2.toArray(strArr);
            } else {
                strArr2 = new String[]{"No Languages Found"};
                strArr = new String[]{""};
            }
            listPreference.setEntries(strArr2);
            listPreference.setEntryValues(strArr);
            listPreference.setEnabled(true);
            try {
                listPreference.setValueIndex(i7);
            } catch (ArrayIndexOutOfBoundsException unused) {
                try {
                    listPreference.setValueIndex(i8);
                } catch (ArrayIndexOutOfBoundsException unused2) {
                    listPreference.setValueIndex(0);
                }
            }
            listPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.arlosoft.macrodroid.settings.n1
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    boolean y02;
                    y02 = PreferencesFragment.this.y0(strArr2, preference, obj);
                    return y02;
                }
            });
        } catch (IllegalArgumentException unused3) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i4, int i5, Intent intent) {
        if (i4 == 1) {
            final Preference findPreference = findPreference(Settings.PREFERENCE_EMAIL_GMAIL_ACCOUNT);
            if (i5 == -1) {
                String stringExtra = intent.getStringExtra("authAccount");
                GmailHelper.getInstance(getActivity()).updateAccountName(stringExtra);
                if (stringExtra != null) {
                    Settings.setEmailGmailAddress(requireContext(), stringExtra);
                    findPreference.setSummary(stringExtra);
                }
            } else {
                String emailGmailAddress = Settings.getEmailGmailAddress(getActivity());
                if (emailGmailAddress != null) {
                    Settings.setEmailGmailAddress(requireContext(), emailGmailAddress);
                    findPreference.setSummary(emailGmailAddress);
                }
            }
            Account[] accountsByType = AccountManager.get(getActivity()).getAccountsByType("com.google");
            String[] strArr = new String[accountsByType.length];
            for (int i6 = 0; i6 < accountsByType.length; i6++) {
                strArr[i6] = accountsByType[i6].name;
            }
            findPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.arlosoft.macrodroid.settings.w
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    boolean l12;
                    l12 = PreferencesFragment.this.l1(findPreference, preference, obj);
                    return l12;
                }
            });
        } else if (i4 == 2) {
            if (i5 == -1) {
                double doubleExtra = intent.getDoubleExtra(LocationTrigger.LATITUDE_EXTRA, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                double doubleExtra2 = intent.getDoubleExtra(LocationTrigger.LONGITUDE_EXTRA, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                FragmentActivity requireActivity = requireActivity();
                Settings.setWeatherLatLon(requireActivity, "lat=" + doubleExtra + "&lon=" + doubleExtra2);
            }
        } else if (i4 == 3 && i5 == -1) {
            double doubleExtra3 = intent.getDoubleExtra(LocationTrigger.LATITUDE_EXTRA, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            double doubleExtra4 = intent.getDoubleExtra(LocationTrigger.LONGITUDE_EXTRA, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            Context context = getContext();
            Settings.setSunriseSunsetLatLon(context, doubleExtra3 + "," + doubleExtra4);
        }
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle bundle, String str) {
        int i4;
        this.f13438d = str;
        if (str != null && str.equals("preferences:screen_gmail_settings")) {
            setPreferencesFromResource(R.xml.preferences_gmail_settings, str);
            i0();
        } else {
            setPreferencesFromResource(R.xml.preferences, str);
            j0();
        }
        Bundle arguments = getArguments();
        if (arguments != null && (i4 = arguments.getInt(PreferencesActivity.EXTRA_SHORTCUT, 0)) > 0) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        if (i4 == 5) {
                            setPreferenceScreen((PreferenceScreen) findPreference("preferences:read_screen_contents_trigger"));
                            return;
                        }
                        return;
                    }
                    setPreferenceScreen((PreferenceScreen) findPreference("preferences:screen_speak_text_action"));
                    return;
                }
                setPreferenceScreen((PreferenceScreen) findPreference("preferences:media_button_v2_trigger"));
                return;
            }
            setPreferenceScreen((PreferenceScreen) findPreference("preferences:screen_smtp_settings"));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        TextToSpeech textToSpeech = this.f13436b;
        if (textToSpeech != null) {
            textToSpeech.shutdown();
            this.f13436b = null;
        }
        TextToSpeech textToSpeech2 = this.f13437c;
        if (textToSpeech2 != null) {
            textToSpeech2.shutdown();
            this.f13437c = null;
        }
        super.onDestroy();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnNavigateToScreenListener
    public void onNavigateToScreen(PreferenceScreen preferenceScreen) {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof PreferenceFragmentCompat.OnPreferenceStartScreenCallback) {
            ((PreferenceFragmentCompat.OnPreferenceStartScreenCallback) parentFragment).onPreferenceStartScreen(this, preferenceScreen);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i4, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i4 != 10) {
            if (i4 == 11 && iArr[0] == 0) {
                h0();
            }
            super.onRequestPermissionsResult(i4, strArr, iArr);
        } else if (iArr[0] == 0) {
            i0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f13443a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f13444b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ EditText f13445c;

        d(Button button, EditText editText, EditText editText2) {
            this.f13443a = button;
            this.f13444b = editText;
            this.f13445c = editText2;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            boolean z3;
            Button button = this.f13443a;
            if (this.f13444b.getText().length() > 3 && this.f13444b.getText().toString().equals(this.f13445c.getText().toString())) {
                z3 = true;
            } else {
                z3 = false;
            }
            button.setEnabled(z3);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f13447a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f13448b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ EditText f13449c;

        e(Button button, EditText editText, EditText editText2) {
            this.f13447a = button;
            this.f13448b = editText;
            this.f13449c = editText2;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            boolean z3;
            Button button = this.f13447a;
            if (this.f13448b.getText().length() > 3 && this.f13448b.getText().toString().equals(this.f13449c.getText().toString())) {
                z3 = true;
            } else {
                z3 = false;
            }
            button.setEnabled(z3);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public Fragment getCallbackFragment() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n1(DialogInterface dialogInterface, int i4) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void p1(DialogInterface dialogInterface, int i4) {
    }
}
