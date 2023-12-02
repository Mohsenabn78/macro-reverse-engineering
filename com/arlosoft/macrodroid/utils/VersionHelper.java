package com.arlosoft.macrodroid.utils;

import android.os.Build;

/* loaded from: classes3.dex */
public class VersionHelper {
    public static boolean isAndroidPOrAbove() {
        int i4;
        int i5 = Build.VERSION.SDK_INT;
        if (i5 < 28) {
            if (i5 >= 27) {
                i4 = Build.VERSION.PREVIEW_SDK_INT;
                if (i4 > 0) {
                }
            }
            return false;
        }
        return true;
    }
}
