package com.airbnb.lottie.utils;

/* loaded from: classes2.dex */
public class GammaEvaluator {
    private static float a(float f4) {
        if (f4 <= 0.04045f) {
            return f4 / 12.92f;
        }
        return (float) Math.pow((f4 + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    private static float b(float f4) {
        if (f4 <= 0.0031308f) {
            return f4 * 12.92f;
        }
        return (float) ((Math.pow(f4, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int evaluate(float f4, int i4, int i5) {
        if (i4 == i5) {
            return i4;
        }
        float f5 = ((i4 >> 24) & 255) / 255.0f;
        float a4 = a(((i4 >> 16) & 255) / 255.0f);
        float a5 = a(((i4 >> 8) & 255) / 255.0f);
        float a6 = a((i4 & 255) / 255.0f);
        float a7 = a(((i5 >> 16) & 255) / 255.0f);
        float a8 = a(((i5 >> 8) & 255) / 255.0f);
        float a9 = a6 + (f4 * (a((i5 & 255) / 255.0f) - a6));
        return (Math.round(b(a4 + ((a7 - a4) * f4)) * 255.0f) << 16) | (Math.round((f5 + (((((i5 >> 24) & 255) / 255.0f) - f5) * f4)) * 255.0f) << 24) | (Math.round(b(a5 + ((a8 - a5) * f4)) * 255.0f) << 8) | Math.round(b(a9) * 255.0f);
    }
}
