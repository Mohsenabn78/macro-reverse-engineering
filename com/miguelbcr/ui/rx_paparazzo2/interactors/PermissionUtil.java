package com.miguelbcr.ui.rx_paparazzo2.interactors;

import android.content.Intent;
import android.net.Uri;
import com.miguelbcr.ui.rx_paparazzo2.entities.TargetUi;

/* loaded from: classes6.dex */
public class PermissionUtil {
    public static final int READ_WRITE_PERMISSIONS = 3;

    public static String[] getReadAndWriteStoragePermissions(boolean z3) {
        if (z3) {
            return new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
        }
        return new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};
    }

    public static void grantReadPermissionToUri(TargetUi targetUi, Uri uri) {
        targetUi.getContext().grantUriPermission(targetUi.getContext().getPackageName(), uri, 1);
    }

    public static Intent requestReadWritePermission(TargetUi targetUi, Intent intent, Uri uri) {
        intent.addFlags(3);
        a(targetUi, intent, uri);
        return intent;
    }

    public static void revokeFileReadWritePermissions(TargetUi targetUi, Uri uri) {
    }

    private static void a(TargetUi targetUi, Intent intent, Uri uri) {
    }
}
