package com.thebluealliance.spectrum.internal;

import android.graphics.Color;
import androidx.annotation.ColorInt;

/* loaded from: classes6.dex */
public final class ColorUtil {
    private ColorUtil() {
    }

    @ColorInt
    public static int getRippleColor(@ColorInt int i4) {
        Color.colorToHSV(i4, r0);
        float[] fArr = {0.0f, 0.0f, fArr[2] * 0.5f};
        return Color.HSVToColor(fArr);
    }

    public static boolean isColorDark(@ColorInt int i4) {
        if ((Color.red(i4) * 0.299d) + (Color.green(i4) * 0.587d) + (Color.blue(i4) * 0.114d) < 160.0d) {
            return true;
        }
        return false;
    }
}
