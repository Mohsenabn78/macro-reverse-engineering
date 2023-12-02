package com.arlosoft.macrodroid.macro;

import android.content.Context;
import com.arlosoft.macrodroid.Analytics;

/* loaded from: classes3.dex */
public class DamnYouPirates {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f12810a = false;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f12811b = false;

    public static boolean isPirate(Context context) {
        if (f12810a) {
            return true;
        }
        if (!f12811b) {
            f12811b = true;
            if (Analytics.isNotGenuine(context)) {
                f12810a = true;
                return true;
            }
            return false;
        }
        return false;
    }
}
