package com.google.firebase.firestore.util;

import android.util.Log;
import com.google.firebase.firestore.BuildConfig;

/* loaded from: classes5.dex */
public class Logger {

    /* renamed from: a  reason: collision with root package name */
    private static Level f31295a = Level.WARN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.firestore.util.Logger$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31296a;

        static {
            int[] iArr = new int[Level.values().length];
            f31296a = iArr;
            try {
                iArr[Level.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31296a[Level.WARN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31296a[Level.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public enum Level {
        DEBUG,
        WARN,
        NONE
    }

    private static void a(Level level, String str, String str2, Object... objArr) {
        if (level.ordinal() >= f31295a.ordinal()) {
            String str3 = String.format("(%s) [%s]: ", BuildConfig.VERSION_NAME, str) + String.format(str2, objArr);
            int i4 = AnonymousClass1.f31296a[level.ordinal()];
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 == 3) {
                        throw new IllegalStateException("Trying to log something on level NONE");
                    }
                    return;
                }
                Log.w("Firestore", str3);
                return;
            }
            Log.i("Firestore", str3);
        }
    }

    public static void debug(String str, String str2, Object... objArr) {
        a(Level.DEBUG, str, str2, objArr);
    }

    public static boolean isDebugEnabled() {
        if (f31295a.ordinal() >= Level.DEBUG.ordinal()) {
            return true;
        }
        return false;
    }

    public static void setLogLevel(Level level) {
        f31295a = level;
    }

    public static void warn(String str, String str2, Object... objArr) {
        a(Level.WARN, str, str2, objArr);
    }
}
