package com.arlosoft.macrodroid.settings.notificationbar;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.CheckBoxPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import com.arlosoft.macrodroid.ConfigureNotificationBarActivity;
import com.arlosoft.macrodroid.MacroDroidService;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.settings.notificationbar.NotificationBarPreferencesFragment;
import com.arlosoft.macrodroid.triggers.activities.selecticon.IconSelectActivity;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.Nullable;

/* compiled from: NotificationBarPreferencesFragment.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class NotificationBarPreferencesFragment extends PreferenceFragmentCompat {
    public static final int $stable = 0;

    private final void i() {
        Preference findPreference = findPreference(Settings.PREFERENCE_CONFIGURE_NOTIFICATION_BUTTON_BAR);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPreference(Settings.PREFERENCE_FORCE_HIDE_ICON);
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 26) {
            if (checkBoxPreference != null) {
                checkBoxPreference.setVisible(false);
            }
        } else if (checkBoxPreference != null) {
            checkBoxPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: l0.b
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    boolean j4;
                    j4 = NotificationBarPreferencesFragment.j(NotificationBarPreferencesFragment.this, preference, obj);
                    return j4;
                }
            });
        }
        Preference findPreference2 = findPreference("preference:oreo_hide_info");
        if (i4 < 26) {
            if (findPreference2 != null) {
                findPreference2.setVisible(false);
            }
        } else if (findPreference2 != null) {
            findPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: l0.c
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean k4;
                    k4 = NotificationBarPreferencesFragment.k(NotificationBarPreferencesFragment.this, preference);
                    return k4;
                }
            });
        }
        ListPreference listPreference = (ListPreference) findPreference(Settings.PREFERENCE_NOTIFICATION_PRIORITY);
        if (listPreference != null) {
            listPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: l0.d
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean m4;
                    m4 = NotificationBarPreferencesFragment.m(NotificationBarPreferencesFragment.this, preference);
                    return m4;
                }
            });
        }
        if (findPreference != null) {
            findPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: l0.e
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean n4;
                    n4 = NotificationBarPreferencesFragment.n(NotificationBarPreferencesFragment.this, preference);
                    return n4;
                }
            });
        }
        Preference findPreference3 = findPreference("preferences:notification_icon");
        if (findPreference3 != null) {
            findPreference3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: l0.f
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean o4;
                    o4 = NotificationBarPreferencesFragment.o(NotificationBarPreferencesFragment.this, preference);
                    return o4;
                }
            });
        }
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) findPreference(Settings.PREFERENCE_NOTIFICATION_LIST_MACROS);
        if (checkBoxPreference2 != null) {
            checkBoxPreference2.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: l0.g
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    boolean p4;
                    p4 = NotificationBarPreferencesFragment.p(NotificationBarPreferencesFragment.this, preference, obj);
                    return p4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j(NotificationBarPreferencesFragment this$0, Preference preference, Object newValue) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        if (Intrinsics.areEqual(newValue.toString(), "true")) {
            MacroDroidService.Companion companion = MacroDroidService.Companion;
            Context applicationContext = this$0.requireActivity().getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "requireActivity().applicationContext");
            companion.stopService(applicationContext);
            return true;
        }
        MacroDroidService.Companion companion2 = MacroDroidService.Companion;
        FragmentActivity requireActivity = this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        companion2.startService(requireActivity);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean k(final NotificationBarPreferencesFragment this$0, Preference preference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AlertDialog.Builder builder = new AlertDialog.Builder(this$0.requireActivity());
        builder.setTitle(R.string.hide_notification_oreo);
        builder.setMessage(R.string.hide_notification_oreo_info);
        builder.setPositiveButton(R.string.notification_access, new DialogInterface.OnClickListener() { // from class: l0.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                NotificationBarPreferencesFragment.l(NotificationBarPreferencesFragment.this, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(NotificationBarPreferencesFragment this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
        } catch (Exception unused) {
            ToastCompat.makeText(this$0.requireActivity().getApplicationContext(), (CharSequence) this$0.getString(R.string.cannot_launch_notification_settings), 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m(NotificationBarPreferencesFragment this$0, Preference preference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MacroDroidService.Companion companion = MacroDroidService.Companion;
        FragmentActivity requireActivity = this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        companion.startService(requireActivity);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n(NotificationBarPreferencesFragment this$0, Preference preference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent(this$0.getActivity(), ConfigureNotificationBarActivity.class));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o(NotificationBarPreferencesFragment this$0, Preference preference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.getActivity(), IconSelectActivity.class);
        intent.putExtra(IconSelectActivity.EXTRA_DISPLAY_APP_ICONS, false);
        intent.putExtra(IconSelectActivity.EXTRA_DEFAULT_EXTRA_TEXT_ICON, Settings.getMacroDroidIconTextString(this$0.getContext()));
        this$0.startActivityForResult(intent, 100);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p(NotificationBarPreferencesFragment this$0, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        Boolean bool = (Boolean) obj;
        Intrinsics.checkNotNull(bool);
        Settings.setShowLastRunMacrosInNotification(activity, bool.booleanValue());
        MacroDroidService.Companion companion = MacroDroidService.Companion;
        FragmentActivity requireActivity = this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        MacroDroidService.Companion.updateNotification$default(companion, requireActivity, false, false, 4, null);
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i4, int i5, @Nullable Intent intent) {
        if (i4 == 100 && intent != null && i5 != 0) {
            String stringExtra = intent.getStringExtra(Util.ICON_TEXT_EXTRA);
            String stringExtra2 = intent.getStringExtra(Util.DRAWABLE_NAME_EXTRA);
            Settings.setMacroDroidIcon(getContext(), Util.getResId(getContext(), stringExtra2));
            Settings.setMacroDroidIconResourceName(getContext(), stringExtra2);
            Settings.setMacroDroidIconTextString(getContext(), stringExtra);
            MacroDroidService.Companion companion = MacroDroidService.Companion;
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            MacroDroidService.Companion.updateNotification$default(companion, requireActivity, true, false, 4, null);
        }
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(@Nullable Bundle bundle, @Nullable String str) {
        setPreferencesFromResource(R.xml.preferences_notification_bar, str);
        i();
    }
}
