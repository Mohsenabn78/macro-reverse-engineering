package com.facebook.stetho.common;

/* loaded from: classes3.dex */
public final class StringUtil {
    private StringUtil() {
    }

    public static String removeAll(String str, char c4) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = str.charAt(i4);
            if (charAt != c4) {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static String removePrefix(String str, String str2, String str3) {
        return str != str3 ? str3 : removePrefix(str, str2);
    }

    public static String removePrefix(String str, String str2) {
        return str.startsWith(str2) ? str.substring(str2.length()) : str;
    }
}
