package com.varunest.sparkbutton.helpers;

import android.content.Context;
import android.graphics.Color;

/* loaded from: classes6.dex */
public class Utils {
    public static double clamp(double d4, double d5, double d6) {
        return Math.min(Math.max(d4, d5), d6);
    }

    public static int darkenColor(int i4, float f4) {
        Color.colorToHSV(i4, r0);
        float[] fArr = {0.0f, 0.0f, fArr[2] * f4};
        return Color.HSVToColor(fArr);
    }

    public static int dpToPx(Context context, int i4) {
        return Math.round(i4 * (context.getResources().getDisplayMetrics().xdpi / 160.0f));
    }

    public static double mapValueFromRangeToRange(double d4, double d5, double d6, double d7, double d8) {
        return d7 + (((d4 - d5) / (d6 - d5)) * (d8 - d7));
    }
}
