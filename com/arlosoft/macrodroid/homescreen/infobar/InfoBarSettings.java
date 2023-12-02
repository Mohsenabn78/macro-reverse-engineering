package com.arlosoft.macrodroid.homescreen.infobar;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.preference.PreferenceManager;
import com.arlosoft.macrodroid.settings.Settings;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: InfoBarSettings.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class InfoBarSettings {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f12373a;

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f12374b;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: InfoBarSettings.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public InfoBarSettings(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f12373a = context;
        this.f12374b = PreferenceManager.getDefaultSharedPreferences(context);
    }

    private final SharedPreferences.Editor a() {
        SharedPreferences.Editor edit = this.f12374b.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "prefs.edit()");
        return edit;
    }

    public final boolean getCanShowDeviceAdminUnistallInfo() {
        return this.f12374b.getBoolean("can_show_device_admin_uninstall_info", true);
    }

    public final long getHelpTranslateMessageLastShown() {
        return this.f12374b.getLong("help_translate_timestamp", 0L);
    }

    public final boolean getShouldShowFileAccessWarning(int i4) {
        if (Build.VERSION.SDK_INT >= 30 && i4 > 0 && i4 < 519000) {
            return this.f12374b.getBoolean("should_show_file_access_warning", true);
        }
        a().putBoolean("should_show_file_access_warning", false).apply();
        return false;
    }

    public final boolean getShouldShowHomeScreenLongPressInfo() {
        return this.f12374b.getBoolean("should_show_long_press_home_info", true);
    }

    public final boolean getShouldShowNotificationBlockedWarning() {
        return this.f12374b.getBoolean("should_show_notification_blocked_warning", true);
    }

    public final boolean getShouldShowTwitterInfo() {
        if (((int) ((System.currentTimeMillis() - Settings.getInstallDate(this.f12373a)) / 86400000)) > 7) {
            return this.f12374b.getBoolean("should_show_twitter_info", true);
        }
        return false;
    }

    public final void setCanShowDeviceAdminUnistallInfo(boolean z3) {
        a().putBoolean("can_show_device_admin_uninstall_info", z3).apply();
    }

    public final void setHelpTranslateMessageLastShown(long j4) {
        a().putLong("help_translate_timestamp", j4).apply();
    }

    public final void setShouldShowFileAccessWarning(boolean z3) {
        a().putBoolean("should_show_file_access_warning", z3).apply();
    }

    public final void setShouldShowHomeScreenLongPressInfo(boolean z3) {
        a().putBoolean("should_show_long_press_home_info", z3).apply();
    }

    public final void setShouldShowNotificationBlockedWarning(boolean z3) {
        a().putBoolean("should_show_notification_blocked_warning", z3).apply();
    }

    public final void setShouldShowTwitterInfo(boolean z3) {
        a().putBoolean("should_show_twitter_info", z3).apply();
    }
}
