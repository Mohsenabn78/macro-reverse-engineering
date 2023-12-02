package com.arlosoft.macrodroid.avatar.utils;

/* loaded from: classes3.dex */
public class StringUtils {
    public static final String EMPTY = "";

    private StringUtils() {
    }

    public static boolean isNotNullOrEmpty(String str) {
        if (str != null && !str.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isNullOrEmpty(String str) {
        if (str != null && !str.isEmpty()) {
            return false;
        }
        return true;
    }
}
