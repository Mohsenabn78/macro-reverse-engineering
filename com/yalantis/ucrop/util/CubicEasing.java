package com.yalantis.ucrop.util;

/* loaded from: classes6.dex */
public final class CubicEasing {
    public static float easeIn(float f4, float f5, float f6, float f7) {
        float f8 = f4 / f7;
        return (f6 * f8 * f8 * f8) + f5;
    }

    public static float easeInOut(float f4, float f5, float f6, float f7) {
        float f8;
        float f9 = f4 / (f7 / 2.0f);
        float f10 = f6 / 2.0f;
        if (f9 < 1.0f) {
            f8 = f10 * f9 * f9 * f9;
        } else {
            float f11 = f9 - 2.0f;
            f8 = f10 * ((f11 * f11 * f11) + 2.0f);
        }
        return f8 + f5;
    }

    public static float easeOut(float f4, float f5, float f6, float f7) {
        float f8 = (f4 / f7) - 1.0f;
        return (f6 * ((f8 * f8 * f8) + 1.0f)) + f5;
    }
}
