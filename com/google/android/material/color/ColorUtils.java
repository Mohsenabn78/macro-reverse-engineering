package com.google.android.material.color;

import java.util.Arrays;

/* loaded from: classes5.dex */
final class ColorUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final float[] f23384a = {95.047f, 100.0f, 108.883f};

    private ColorUtils() {
    }

    public static int a(int i4) {
        return i4 & 255;
    }

    public static float b(float f4) {
        if (f4 <= 0.0031308f) {
            return f4 * 12.92f;
        }
        return (((float) Math.pow(f4, 0.4166666567325592d)) * 1.055f) - 0.055f;
    }

    public static int c(int i4) {
        return (i4 & 65280) >> 8;
    }

    public static int d(float f4) {
        boolean z3;
        boolean z4;
        float f5;
        float f6;
        float f7 = (f4 + 16.0f) / 116.0f;
        float f8 = f7 * f7 * f7;
        if (f8 > 0.008856452f) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (f4 > 8.0f) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            f5 = f8;
        } else {
            f5 = f4 / 903.2963f;
        }
        if (z3) {
            f6 = f8;
        } else {
            f6 = ((f7 * 116.0f) - 16.0f) / 903.2963f;
        }
        if (!z3) {
            f8 = ((f7 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = f23384a;
        return f(new float[]{f6 * fArr[0], f5 * fArr[1], f8 * fArr[2]});
    }

    public static int e(int i4, int i5, int i6) {
        return (((((i4 & 255) << 16) | (-16777216)) | ((i5 & 255) << 8)) | (i6 & 255)) >>> 0;
    }

    public static int f(float[] fArr) {
        return g(fArr[0], fArr[1], fArr[2]);
    }

    public static int g(float f4, float f5, float f6) {
        float f7 = f4 / 100.0f;
        float f8 = f5 / 100.0f;
        float f9 = f6 / 100.0f;
        float f10 = (3.2406f * f7) + ((-1.5372f) * f8) + ((-0.4986f) * f9);
        float f11 = (f7 * 0.0557f) + (f8 * (-0.204f)) + (f9 * 1.057f);
        return e(Math.max(Math.min(255, Math.round(b(f10) * 255.0f)), 0), Math.max(Math.min(255, Math.round(b(((-0.9689f) * f7) + (1.8758f * f8) + (0.0415f * f9)) * 255.0f)), 0), Math.max(Math.min(255, Math.round(b(f11) * 255.0f)), 0));
    }

    public static double[] h(int i4) {
        double d4;
        double d5;
        double d6;
        float[] m4 = m(i4);
        float f4 = m4[1];
        float[] fArr = f23384a;
        double d7 = f4 / fArr[1];
        if (d7 > 0.008856451679035631d) {
            d4 = Math.cbrt(d7);
        } else {
            d4 = ((d7 * 903.2962962962963d) + 16.0d) / 116.0d;
        }
        double d8 = m4[0] / fArr[0];
        if (d8 > 0.008856451679035631d) {
            d5 = Math.cbrt(d8);
        } else {
            d5 = ((d8 * 903.2962962962963d) + 16.0d) / 116.0d;
        }
        double d9 = m4[2] / fArr[2];
        if (d9 > 0.008856451679035631d) {
            d6 = Math.cbrt(d9);
        } else {
            d6 = ((d9 * 903.2962962962963d) + 16.0d) / 116.0d;
        }
        return new double[]{(116.0d * d4) - 16.0d, (d5 - d4) * 500.0d, (d4 - d6) * 200.0d};
    }

    public static float i(float f4) {
        if (f4 <= 0.04045f) {
            return f4 / 12.92f;
        }
        return (float) Math.pow((f4 + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static float j(int i4) {
        return (float) h(i4)[0];
    }

    public static int k(int i4) {
        return (i4 & 16711680) >> 16;
    }

    public static final float[] l() {
        return Arrays.copyOf(f23384a, 3);
    }

    public static float[] m(int i4) {
        float i5 = i(k(i4) / 255.0f) * 100.0f;
        float i6 = i(c(i4) / 255.0f) * 100.0f;
        float i7 = i(a(i4) / 255.0f) * 100.0f;
        return new float[]{(0.41233894f * i5) + (0.35762063f * i6) + (0.18051042f * i7), (0.2126f * i5) + (0.7152f * i6) + (0.0722f * i7), (i5 * 0.01932141f) + (i6 * 0.11916382f) + (i7 * 0.9503448f)};
    }

    public static float n(float f4) {
        float f5;
        if (f4 > 8.0f) {
            f5 = (float) Math.pow((f4 + 16.0d) / 116.0d, 3.0d);
        } else {
            f5 = f4 / 903.2963f;
        }
        return f5 * 100.0f;
    }
}
