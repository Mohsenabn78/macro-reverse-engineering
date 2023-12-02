package com.hanks.htextview.base;

import android.content.res.Resources;
import android.util.DisplayMetrics;

/* loaded from: classes6.dex */
public final class DisplayUtils {
    public static int dp2px(float f4) {
        return Math.round(f4 * getDisplayMetrics().density);
    }

    public static DisplayMetrics getDisplayMetrics() {
        return Resources.getSystem().getDisplayMetrics();
    }

    public static int getScreenHeight() {
        return getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth() {
        return getDisplayMetrics().widthPixels;
    }
}
