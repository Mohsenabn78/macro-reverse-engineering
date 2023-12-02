package com.google.android.gms.internal.places;

/* loaded from: classes4.dex */
final class zzp {
    private static final Class<?> zzdw = zzh("libcore.io.Memory");
    private static final boolean zzdx;

    static {
        boolean z3;
        if (zzh("org.robolectric.Robolectric") != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzdx = z3;
    }

    private static <T> Class<T> zzh(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzy() {
        if (zzdw != null && !zzdx) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class<?> zzz() {
        return zzdw;
    }
}
