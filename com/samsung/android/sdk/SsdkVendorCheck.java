package com.samsung.android.sdk;

import android.os.Build;

/* loaded from: classes6.dex */
public class SsdkVendorCheck {
    private static String strBrand = Build.BRAND;
    private static String strManufacturer = Build.MANUFACTURER;

    private SsdkVendorCheck() {
    }

    public static boolean isSamsungDevice() {
        String str = strBrand;
        if (str == null || strManufacturer == null) {
            return false;
        }
        if (str.compareToIgnoreCase("Samsung") != 0 && strManufacturer.compareToIgnoreCase("Samsung") != 0) {
            return false;
        }
        return true;
    }
}
