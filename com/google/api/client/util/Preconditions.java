package com.google.api.client.util;

/* loaded from: classes5.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean z3) {
        com.google.api.client.repackaged.com.google.common.base.Preconditions.checkArgument(z3);
    }

    public static <T> T checkNotNull(T t3) {
        return (T) com.google.api.client.repackaged.com.google.common.base.Preconditions.checkNotNull(t3);
    }

    public static void checkState(boolean z3) {
        com.google.api.client.repackaged.com.google.common.base.Preconditions.checkState(z3);
    }

    public static void checkArgument(boolean z3, Object obj) {
        com.google.api.client.repackaged.com.google.common.base.Preconditions.checkArgument(z3, obj);
    }

    public static <T> T checkNotNull(T t3, Object obj) {
        return (T) com.google.api.client.repackaged.com.google.common.base.Preconditions.checkNotNull(t3, obj);
    }

    public static void checkState(boolean z3, Object obj) {
        com.google.api.client.repackaged.com.google.common.base.Preconditions.checkState(z3, obj);
    }

    public static void checkArgument(boolean z3, String str, Object... objArr) {
        com.google.api.client.repackaged.com.google.common.base.Preconditions.checkArgument(z3, str, objArr);
    }

    public static <T> T checkNotNull(T t3, String str, Object... objArr) {
        return (T) com.google.api.client.repackaged.com.google.common.base.Preconditions.checkNotNull(t3, str, objArr);
    }

    public static void checkState(boolean z3, String str, Object... objArr) {
        com.google.api.client.repackaged.com.google.common.base.Preconditions.checkState(z3, str, objArr);
    }
}
