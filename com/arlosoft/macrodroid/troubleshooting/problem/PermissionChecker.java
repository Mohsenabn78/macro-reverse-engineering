package com.arlosoft.macrodroid.troubleshooting.problem;

import android.app.AppOpsManager;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.accessibility.AccessibilityServiceState;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.triggers.receivers.MacroDroidDeviceAdminReceiver;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: PermissionChecker.kt */
@StabilityInferred(parameters = 0)
@Singleton
/* loaded from: classes3.dex */
public final class PermissionChecker {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f15824a;

    @Inject
    public PermissionChecker(@ApplicationContext @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f15824a = context;
    }

    public final AccessibilityServiceState isAccessibilityEnabled() {
        return Util.isMacroDroidAccessibilityEnabledWithCrashCheck(this.f15824a);
    }

    public final boolean isDeviceAdminEnabled() {
        ComponentName componentName = new ComponentName(this.f15824a, MacroDroidDeviceAdminReceiver.class);
        Object systemService = this.f15824a.getSystemService("device_policy");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.admin.DevicePolicyManager");
        return ((DevicePolicyManager) systemService).isAdminActive(componentName);
    }

    public final boolean isDrawOverlaysEnabed() {
        boolean canDrawOverlays;
        if (Build.VERSION.SDK_INT >= 23) {
            canDrawOverlays = Settings.canDrawOverlays(this.f15824a);
            if (!canDrawOverlays) {
                return false;
            }
        }
        return true;
    }

    public final boolean isFingerPrintAccessibilityEnabled() {
        return Util.isFingerprintGestureAccessibilityEnabled(this.f15824a);
    }

    public final boolean isLocationServicesEnabled() {
        boolean z3 = false;
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        try {
            if (Settings.Secure.getInt(this.f15824a.getContentResolver(), "location_mode") != 0) {
                z3 = true;
            }
            return z3;
        } catch (Settings.SettingNotFoundException unused) {
            return true;
        }
    }

    public final boolean isNotificationAccessEnabled() {
        boolean contains$default;
        String string = Settings.Secure.getString(this.f15824a.getContentResolver(), "enabled_notification_listeners");
        if (string == null) {
            return false;
        }
        String packageName = MacroDroidApplication.Companion.getInstance().getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "MacroDroidApplication.instance.packageName");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) string, (CharSequence) packageName, false, 2, (Object) null);
        if (!contains$default) {
            return false;
        }
        return true;
    }

    public final boolean isStandardPermissionEnabled(@NotNull String permission) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        if (ContextCompat.checkSelfPermission(this.f15824a, permission) == 0) {
            return true;
        }
        return false;
    }

    public final AccessibilityServiceState isUIInteractionAccessibilityEnabled() {
        return Util.isUIInteractionAccessibilityEnabledWithCrashCheck(this.f15824a);
    }

    public final boolean isUsageAccessEnabled() {
        try {
            PackageManager packageManager = this.f15824a.getPackageManager();
            Intrinsics.checkNotNullExpressionValue(packageManager, "context.packageManager");
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(this.f15824a.getPackageName(), 0);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "packageManager.getApplic…o(context.packageName, 0)");
            Object systemService = this.f15824a.getSystemService("appops");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AppOpsManager");
            if (((AppOpsManager) systemService).checkOpNoThrow("android:get_usage_stats", applicationInfo.uid, applicationInfo.packageName) != 0) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public final boolean isVolumeAccessibilityEnabled() {
        return Util.isMacroDroidVolumeAccessibilityEnabled(this.f15824a);
    }

    public final boolean isWriteSettingsEnabled() {
        boolean canWrite;
        if (Build.VERSION.SDK_INT >= 23) {
            canWrite = Settings.System.canWrite(this.f15824a);
            if (!canWrite) {
                return false;
            }
        }
        return true;
    }
}
