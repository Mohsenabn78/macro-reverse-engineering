package com.twofortyfouram.spackle;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.PowerManager;
import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.annotation.Size;
import com.twofortyfouram.assertion.Assertions;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
/* loaded from: classes6.dex */
public final class PermissionCompat {

    @ThreadSafe
    /* loaded from: classes6.dex */
    public enum PermissionStatus {
        NOT_GRANTED_BY_MANIFEST,
        NOT_GRANTED_BY_USER,
        GRANTED
    }

    private PermissionCompat() {
        throw new UnsupportedOperationException("This class is non-instantiable");
    }

    @NonNull
    private static PermissionStatus a(@NonNull Context context, @NonNull @Size(min = 1) String str) {
        Assertions.assertNotNull(context, "context");
        Assertions.assertNotEmpty(str, "permissionName");
        if (-1 == context.getPackageManager().checkPermission(str, context.getPackageName())) {
            return PermissionStatus.NOT_GRANTED_BY_MANIFEST;
        }
        return PermissionStatus.GRANTED;
    }

    @NonNull
    @TargetApi(23)
    private static PermissionStatus b(@NonNull Context context, @NonNull @Size(min = 1) String str) {
        Assertions.assertNotNull(context, "context");
        Assertions.assertNotEmpty(str, "permissionName");
        if (!d(context, str)) {
            if (c(context, str)) {
                return PermissionStatus.NOT_GRANTED_BY_USER;
            }
            return PermissionStatus.NOT_GRANTED_BY_MANIFEST;
        }
        return PermissionStatus.GRANTED;
    }

    private static boolean c(@NonNull Context context, @NonNull @Size(min = 1) String str) {
        Assertions.assertNotNull(context, "context");
        Assertions.assertNotEmpty(str, "permissionName");
        String[] strArr = AppBuildInfo.a(context, 4096).requestedPermissions;
        if (strArr != null) {
            for (String str2 : strArr) {
                if (str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @TargetApi(23)
    private static boolean d(@NonNull Context context, @NonNull @Size(min = 1) String str) {
        int checkSelfPermission;
        Object systemService;
        boolean isIgnoringBatteryOptimizations;
        boolean canWrite;
        Assertions.assertNotNull(context, "context");
        Assertions.assertNotEmpty(str, "permissionName");
        if ("android.permission.WRITE_SETTINGS".equals(str) && !"com.twofortyfouram.test.context.FeatureContextWrapper".equals(context.getClass().getName())) {
            canWrite = Settings.System.canWrite(context);
            if (canWrite) {
                return true;
            }
            return false;
        } else if (!"android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS".equals(str) || "com.twofortyfouram.test.context.FeatureContextWrapper".equals(context.getClass().getName())) {
            checkSelfPermission = context.checkSelfPermission(str);
            if (checkSelfPermission == 0) {
                return true;
            }
            return false;
        } else {
            systemService = context.getSystemService(PowerManager.class);
            isIgnoringBatteryOptimizations = ((PowerManager) systemService).isIgnoringBatteryOptimizations(context.getPackageName());
            if (isIgnoringBatteryOptimizations) {
                return true;
            }
            return false;
        }
    }

    @NonNull
    public static PermissionStatus getPermissionStatus(@NonNull Context context, @NonNull @Size(min = 1) String str) {
        Assertions.assertNotNull(context, "context");
        Assertions.assertNotEmpty(str, "permissionName");
        if (AndroidSdkVersion.isAtLeastSdk(23)) {
            return b(context, str);
        }
        return a(context, str);
    }
}
