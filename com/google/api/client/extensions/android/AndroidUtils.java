package com.google.api.client.extensions.android;

import android.os.Build;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;

@Beta
/* loaded from: classes5.dex */
public class AndroidUtils {
    private AndroidUtils() {
    }

    public static void checkMinimumSdkLevel(int i4) {
        Preconditions.checkArgument(isMinimumSdkLevel(i4), "running on Android SDK level %s but requires minimum %s", Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(i4));
    }

    public static boolean isMinimumSdkLevel(int i4) {
        if (Build.VERSION.SDK_INT >= i4) {
            return true;
        }
        return false;
    }
}
