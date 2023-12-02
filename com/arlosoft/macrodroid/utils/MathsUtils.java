package com.arlosoft.macrodroid.utils;

/* loaded from: classes3.dex */
public class MathsUtils {
    public static boolean areDecimalsEqual(double d4, double d5) {
        if (Math.abs(d4 - d5) < 1.0E-33d) {
            return true;
        }
        return false;
    }
}
