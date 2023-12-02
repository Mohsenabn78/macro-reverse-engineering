package com.google.gson.internal;

/* renamed from: com.google.gson.internal.$Gson$Preconditions  reason: invalid class name */
/* loaded from: classes5.dex */
public final class C$Gson$Preconditions {
    private C$Gson$Preconditions() {
        throw new UnsupportedOperationException();
    }

    public static void checkArgument(boolean z3) {
        if (z3) {
            return;
        }
        throw new IllegalArgumentException();
    }

    @Deprecated
    public static <T> T checkNotNull(T t3) {
        t3.getClass();
        return t3;
    }
}
