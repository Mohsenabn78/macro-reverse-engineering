package com.obsez.android.lib.filechooser.permissions;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Random;

/* loaded from: classes6.dex */
public final class PermissionsUtil {
    public static final String TAG = "com.obsez.android.lib.filechooser.permissions.PermissionsUtil";

    /* renamed from: a  reason: collision with root package name */
    private static final SparseArray<OnPermissionListener> f36571a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private static final Random f36572b = new Random();

    /* loaded from: classes6.dex */
    public interface OnPermissionListener {
        void onPermissionDenied(String[] strArr);

        void onPermissionGranted(String[] strArr);

        void onShouldShowRequestPermissionRationale(String[] strArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OnPermissionListener a(int i4) {
        SparseArray<OnPermissionListener> sparseArray = f36571a;
        OnPermissionListener onPermissionListener = sparseArray.get(i4, null);
        sparseArray.remove(i4);
        return onPermissionListener;
    }

    public static void checkPermissions(@NonNull Context context, @Nullable OnPermissionListener onPermissionListener, String... strArr) {
        if (Build.VERSION.SDK_INT >= 23 && strArr.length != 0) {
            int nextInt = f36572b.nextInt(1024);
            f36571a.put(nextInt, onPermissionListener);
            context.startActivity(new Intent(context, PermissionActivity.class).addFlags(65536).putExtra(PermissionActivity.INTENT_EXTRA_PERMISSIONS, strArr).putExtra(PermissionActivity.INTENT_EXTRA_REQUEST_CODE, nextInt));
        } else if (onPermissionListener != null) {
            onPermissionListener.onPermissionGranted(strArr);
        }
    }
}
