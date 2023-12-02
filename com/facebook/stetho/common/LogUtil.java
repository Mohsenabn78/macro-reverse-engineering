package com.facebook.stetho.common;

import java.util.Locale;

/* loaded from: classes3.dex */
public class LogUtil {
    private static final String TAG = "stetho";

    public static void d(String str, Object... objArr) {
        d(format(str, objArr));
    }

    public static void e(String str, Object... objArr) {
        e(format(str, objArr));
    }

    private static String format(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static void i(String str, Object... objArr) {
        i(format(str, objArr));
    }

    public static boolean isLoggable(int i4) {
        if (i4 != 5 && i4 != 6) {
            return LogRedirector.isLoggable(TAG, i4);
        }
        return true;
    }

    public static void v(String str, Object... objArr) {
        v(format(str, objArr));
    }

    public static void w(String str, Object... objArr) {
        w(format(str, objArr));
    }

    public static void d(Throwable th, String str, Object... objArr) {
        d(th, format(str, objArr));
    }

    public static void e(Throwable th, String str, Object... objArr) {
        e(th, format(str, objArr));
    }

    public static void i(Throwable th, String str, Object... objArr) {
        i(th, format(str, objArr));
    }

    public static void v(Throwable th, String str, Object... objArr) {
        v(th, format(str, objArr));
    }

    public static void w(Throwable th, String str, Object... objArr) {
        w(th, format(str, objArr));
    }

    public static void d(String str) {
        if (isLoggable(3)) {
            LogRedirector.d(TAG, str);
        }
    }

    public static void e(String str) {
        if (isLoggable(6)) {
            LogRedirector.e(TAG, str);
        }
    }

    public static void i(String str) {
        if (isLoggable(4)) {
            LogRedirector.i(TAG, str);
        }
    }

    public static void v(String str) {
        if (isLoggable(2)) {
            LogRedirector.v(TAG, str);
        }
    }

    public static void w(String str) {
        if (isLoggable(5)) {
            LogRedirector.w(TAG, str);
        }
    }

    public static void d(Throwable th, String str) {
        if (isLoggable(3)) {
            LogRedirector.d(TAG, str, th);
        }
    }

    public static void e(Throwable th, String str) {
        if (isLoggable(6)) {
            LogRedirector.e(TAG, str, th);
        }
    }

    public static void i(Throwable th, String str) {
        if (isLoggable(4)) {
            LogRedirector.i(TAG, str, th);
        }
    }

    public static void v(Throwable th, String str) {
        if (isLoggable(2)) {
            LogRedirector.v(TAG, str, th);
        }
    }

    public static void w(Throwable th, String str) {
        if (isLoggable(5)) {
            LogRedirector.w(TAG, str, th);
        }
    }
}
