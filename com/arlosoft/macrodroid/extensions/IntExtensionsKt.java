package com.arlosoft.macrodroid.extensions;

import android.content.res.Resources;

/* compiled from: IntExtensions.kt */
/* loaded from: classes3.dex */
public final class IntExtensionsKt {
    public static final int getDp(int i4) {
        return (int) (i4 / Resources.getSystem().getDisplayMetrics().density);
    }

    public static final int getHoursToMilliseconds(int i4) {
        return i4 * 3600000;
    }

    public static final int getPx(int i4) {
        return (int) (i4 * Resources.getSystem().getDisplayMetrics().density);
    }
}
