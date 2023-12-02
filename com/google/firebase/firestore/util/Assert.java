package com.google.firebase.firestore.util;

/* loaded from: classes5.dex */
public class Assert {
    private static String a(String str, Object... objArr) {
        return "INTERNAL ASSERTION FAILED: " + String.format(str, objArr);
    }

    public static AssertionError fail(String str, Object... objArr) {
        throw new AssertionError(a(str, objArr));
    }

    public static void hardAssert(boolean z3, String str, Object... objArr) {
        if (z3) {
            return;
        }
        throw fail(str, objArr);
    }

    public static <T> T hardAssertNonNull(T t3, String str, Object... objArr) {
        if (t3 != null) {
            return t3;
        }
        throw fail(str, objArr);
    }

    public static AssertionError fail(Throwable th, String str, Object... objArr) {
        throw ApiUtil.newAssertionError(a(str, objArr), th);
    }
}
