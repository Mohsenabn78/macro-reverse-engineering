package com.google.android.datatransport.runtime.logging;

import android.os.Build;
import android.util.Log;

/* loaded from: classes.dex */
public final class Logging {
    private Logging() {
    }

    private static String a(String str, String str2) {
        String str3 = str + str2;
        if (str3.length() > 23) {
            return str3.substring(0, 23);
        }
        return str3;
    }

    private static String b(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            return a("TRuntime.", str);
        }
        return "TRuntime." + str;
    }

    public static void d(String str, String str2) {
        Log.isLoggable(b(str), 3);
    }

    public static void e(String str, String str2, Throwable th) {
        String b4 = b(str);
        if (Log.isLoggable(b4, 6)) {
            Log.e(b4, str2, th);
        }
    }

    public static void i(String str, String str2, Object obj) {
        String b4 = b(str);
        if (Log.isLoggable(b4, 4)) {
            Log.i(b4, String.format(str2, obj));
        }
    }

    public static void w(String str, String str2, Object obj) {
        String b4 = b(str);
        if (Log.isLoggable(b4, 5)) {
            Log.w(b4, String.format(str2, obj));
        }
    }

    public static void d(String str, String str2, Object obj) {
        if (Log.isLoggable(b(str), 3)) {
            String.format(str2, obj);
        }
    }

    public static void d(String str, String str2, Object obj, Object obj2) {
        if (Log.isLoggable(b(str), 3)) {
            String.format(str2, obj, obj2);
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        if (Log.isLoggable(b(str), 3)) {
            String.format(str2, objArr);
        }
    }
}
