package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
/* loaded from: classes4.dex */
public final class DeviceProperties {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f20717a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f20718b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private static Boolean f20719c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private static Boolean f20720d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private static Boolean f20721e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static Boolean f20722f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static Boolean f20723g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static Boolean f20724h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static Boolean f20725i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static Boolean f20726j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private static Boolean f20727k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private static Boolean f20728l;

    private DeviceProperties() {
    }

    @KeepForSdk
    public static boolean isAuto(@NonNull Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f20725i == null) {
            boolean z3 = false;
            if (PlatformVersion.isAtLeastO() && packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                z3 = true;
            }
            f20725i = Boolean.valueOf(z3);
        }
        return f20725i.booleanValue();
    }

    @KeepForSdk
    public static boolean isBstar(@NonNull Context context) {
        if (f20728l == null) {
            boolean z3 = false;
            if (PlatformVersion.isAtLeastR() && context.getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE")) {
                z3 = true;
            }
            f20728l = Boolean.valueOf(z3);
        }
        return f20728l.booleanValue();
    }

    @KeepForSdk
    public static boolean isLatchsky(@NonNull Context context) {
        if (f20722f == null) {
            PackageManager packageManager = context.getPackageManager();
            boolean z3 = false;
            if (packageManager.hasSystemFeature("com.google.android.feature.services_updater") && packageManager.hasSystemFeature("cn.google.services")) {
                z3 = true;
            }
            f20722f = Boolean.valueOf(z3);
        }
        return f20722f.booleanValue();
    }

    @KeepForSdk
    public static boolean isPhone(@NonNull Context context) {
        if (f20717a == null) {
            boolean z3 = false;
            if (!isTablet(context) && !isWearable(context) && !zzb(context)) {
                if (f20724h == null) {
                    f20724h = Boolean.valueOf(context.getPackageManager().hasSystemFeature("org.chromium.arc"));
                }
                if (!f20724h.booleanValue() && !isAuto(context) && !isTv(context)) {
                    if (f20727k == null) {
                        f20727k = Boolean.valueOf(context.getPackageManager().hasSystemFeature("com.google.android.feature.AMATI_EXPERIENCE"));
                    }
                    if (!f20727k.booleanValue() && !isBstar(context)) {
                        z3 = true;
                    }
                }
            }
            f20717a = Boolean.valueOf(z3);
        }
        return f20717a.booleanValue();
    }

    @KeepForSdk
    public static boolean isSevenInchTablet(@NonNull Context context) {
        return zzc(context.getResources());
    }

    @KeepForSdk
    @TargetApi(21)
    public static boolean isSidewinder(@NonNull Context context) {
        return zza(context);
    }

    @KeepForSdk
    public static boolean isTablet(@NonNull Context context) {
        return isTablet(context.getResources());
    }

    @KeepForSdk
    public static boolean isTv(@NonNull Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f20726j == null) {
            boolean z3 = true;
            if (!packageManager.hasSystemFeature("com.google.android.tv") && !packageManager.hasSystemFeature("android.hardware.type.television") && !packageManager.hasSystemFeature("android.software.leanback")) {
                z3 = false;
            }
            f20726j = Boolean.valueOf(z3);
        }
        return f20726j.booleanValue();
    }

    @KeepForSdk
    public static boolean isUserBuild() {
        int i4 = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        return "user".equals(Build.TYPE);
    }

    @KeepForSdk
    @TargetApi(20)
    public static boolean isWearable(@NonNull Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f20720d == null) {
            boolean z3 = false;
            if (PlatformVersion.isAtLeastKitKatWatch() && packageManager.hasSystemFeature("android.hardware.type.watch")) {
                z3 = true;
            }
            f20720d = Boolean.valueOf(z3);
        }
        return f20720d.booleanValue();
    }

    @KeepForSdk
    @TargetApi(26)
    public static boolean isWearableWithoutPlayStore(@NonNull Context context) {
        if (!isWearable(context) || PlatformVersion.isAtLeastN()) {
            if (zza(context)) {
                if (!PlatformVersion.isAtLeastO() || PlatformVersion.isAtLeastR()) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return true;
    }

    @TargetApi(21)
    public static boolean zza(@NonNull Context context) {
        if (f20721e == null) {
            boolean z3 = false;
            if (PlatformVersion.isAtLeastLollipop() && context.getPackageManager().hasSystemFeature("cn.google")) {
                z3 = true;
            }
            f20721e = Boolean.valueOf(z3);
        }
        return f20721e.booleanValue();
    }

    public static boolean zzb(@NonNull Context context) {
        if (f20723g == null) {
            boolean z3 = true;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot") && !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                z3 = false;
            }
            f20723g = Boolean.valueOf(z3);
        }
        return f20723g.booleanValue();
    }

    public static boolean zzc(@NonNull Resources resources) {
        boolean z3 = false;
        if (resources == null) {
            return false;
        }
        if (f20719c == null) {
            Configuration configuration = resources.getConfiguration();
            if ((configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600) {
                z3 = true;
            }
            f20719c = Boolean.valueOf(z3);
        }
        return f20719c.booleanValue();
    }

    @KeepForSdk
    public static boolean isTablet(@NonNull Resources resources) {
        if (resources == null) {
            return false;
        }
        if (f20718b == null) {
            f20718b = Boolean.valueOf((resources.getConfiguration().screenLayout & 15) > 3 || zzc(resources));
        }
        return f20718b.booleanValue();
    }
}
