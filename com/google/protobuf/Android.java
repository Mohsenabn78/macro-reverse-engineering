package com.google.protobuf;

/* loaded from: classes6.dex */
final class Android {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f33150a;

    /* renamed from: b  reason: collision with root package name */
    private static final Class<?> f33151b = a("libcore.io.Memory");

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f33152c;

    static {
        boolean z3;
        if (!f33150a && a("org.robolectric.Robolectric") != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        f33152c = z3;
    }

    private Android() {
    }

    private static <T> Class<T> a(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class<?> b() {
        return f33151b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c() {
        if (!f33150a && (f33151b == null || f33152c)) {
            return false;
        }
        return true;
    }
}
