package com.arlosoft.macrodroid.utils;

import android.content.Context;
import android.os.Build;
import com.arlosoft.macrodroid.settings.Settings;

/* loaded from: classes3.dex */
public class OverlayUtils {
    public static int getOverlayType() {
        if (Build.VERSION.SDK_INT < 26) {
            return 2003;
        }
        return 2038;
    }

    public static int getOverlayTypeDrawer(Context context) {
        if (Settings.getShowDrawerOnLockScreen(context)) {
            return getOverlayTypeLockScreen();
        }
        return getOverlayType();
    }

    public static int getOverlayTypeLockScreen() {
        if (Build.VERSION.SDK_INT < 26) {
            return 2010;
        }
        return 2038;
    }
}
