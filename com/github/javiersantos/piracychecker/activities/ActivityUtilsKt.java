package com.github.javiersantos.piracychecker.activities;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.m;
import org.jetbrains.annotations.NotNull;

/* compiled from: ActivityUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¨\u0006\b"}, d2 = {"getAppName", "", "Landroid/content/Context;", "setupLightStatusBar", "", "Landroid/view/View;", "enable", "", "library_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class ActivityUtilsKt {
    @NotNull
    public static final String getAppName(@NotNull Context getAppName) {
        String str;
        boolean isBlank;
        String string;
        CharSequence charSequence;
        CharSequence charSequence2;
        Intrinsics.checkParameterIsNotNull(getAppName, "$this$getAppName");
        try {
            PackageManager packageManager = getAppName.getPackageManager();
            if (packageManager == null || (charSequence2 = packageManager.getApplicationLabel(getAppName.getApplicationInfo())) == null) {
                charSequence2 = "";
            }
            str = charSequence2.toString();
        } catch (Exception unused) {
            str = "";
        }
        isBlank = m.isBlank(str);
        boolean z3 = true;
        int i4 = 0;
        if (!isBlank) {
            if (str.length() <= 0) {
                z3 = false;
            }
            if (z3) {
                return str;
            }
        }
        ApplicationInfo applicationInfo = getAppName.getApplicationInfo();
        if (applicationInfo != null) {
            i4 = applicationInfo.labelRes;
        }
        if (i4 == 0) {
            ApplicationInfo applicationInfo2 = getAppName.getApplicationInfo();
            if (applicationInfo2 == null || (charSequence = applicationInfo2.nonLocalizedLabel) == null || (string = charSequence.toString()) == null) {
                return "";
            }
        } else {
            try {
                string = getAppName.getString(i4);
            } catch (Exception unused2) {
                return "";
            }
        }
        return string;
    }

    public static final void setupLightStatusBar(@NotNull View setupLightStatusBar, boolean z3) {
        int i4;
        Intrinsics.checkParameterIsNotNull(setupLightStatusBar, "$this$setupLightStatusBar");
        if (Build.VERSION.SDK_INT >= 23) {
            int systemUiVisibility = setupLightStatusBar.getSystemUiVisibility();
            if (z3) {
                i4 = systemUiVisibility | 8192;
            } else {
                i4 = systemUiVisibility & (-8193);
            }
            setupLightStatusBar.setSystemUiVisibility(i4);
        }
    }
}
