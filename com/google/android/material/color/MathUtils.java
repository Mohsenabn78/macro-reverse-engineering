package com.google.android.material.color;

/* loaded from: classes5.dex */
final class MathUtils {
    private MathUtils() {
    }

    public static float a(float f4, float f5) {
        return 180.0f - Math.abs(Math.abs(f4 - f5) - 180.0f);
    }

    public static float b(float f4, float f5, float f6) {
        return ((1.0f - f6) * f4) + (f6 * f5);
    }

    public static float c(float f4) {
        if (f4 < 0.0f) {
            return (f4 % 360.0f) + 360.0f;
        }
        if (f4 >= 360.0f) {
            return f4 % 360.0f;
        }
        return f4;
    }
}
