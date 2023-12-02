package com.google.firebase.firestore.util;

import java.util.Locale;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* loaded from: classes5.dex */
public class Preconditions {
    public static void checkArgument(boolean z3, @Nullable String str, @Nullable Object... objArr) {
        if (z3) {
            return;
        }
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    public static <T> T checkNotNull(@Nonnull T t3) {
        t3.getClass();
        return t3;
    }

    public static void checkState(boolean z3) {
        if (!z3) {
            throw new IllegalStateException();
        }
    }

    public static <T> T checkNotNull(@Nonnull T t3, @Nullable Object obj) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void checkState(boolean z3, String str) {
        if (!z3) {
            throw new IllegalStateException(str);
        }
    }

    public static <T> T checkNotNull(@Nonnull T t3, String str, @Nullable Object... objArr) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(String.format(Locale.US, str, objArr));
    }
}
