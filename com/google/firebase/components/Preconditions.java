package com.google.firebase.components;

import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* loaded from: classes5.dex */
public final class Preconditions {
    public static void checkArgument(boolean z3, String str) {
        if (z3) {
            return;
        }
        throw new IllegalArgumentException(str);
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t3) {
        t3.getClass();
        return t3;
    }

    public static void checkState(boolean z3, String str) {
        if (z3) {
            return;
        }
        throw new IllegalStateException(str);
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t3, String str) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(str);
    }
}
