package com.twofortyfouram.spackle;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import com.twofortyfouram.assertion.Assertions;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
/* loaded from: classes6.dex */
public final class AppBuildInfo {
    private AppBuildInfo() {
        throw new UnsupportedOperationException("This class is non-instantiable");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static PackageInfo a(@NonNull Context context, int i4) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), i4);
        } catch (PackageManager.NameNotFoundException e4) {
            throw new RuntimeException(e4);
        }
    }

    @NonNull
    public static String getApplicationName(@NonNull Context context) {
        Assertions.assertNotNull(context, "context");
        CharSequence applicationLabel = context.getPackageManager().getApplicationLabel(context.getApplicationInfo());
        if (applicationLabel == null) {
            applicationLabel = context.getPackageName();
        }
        return applicationLabel.toString();
    }

    public static int getVersionCode(@NonNull Context context) {
        return a(context, 0).versionCode;
    }

    @NonNull
    public static String getVersionName(@NonNull Context context) {
        String str = a(context, 0).versionName;
        if (str == null) {
            return "";
        }
        return str;
    }
}
