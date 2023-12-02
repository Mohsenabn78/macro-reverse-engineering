package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsa  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzsa {
    private static final zzahg zza = new zzrz();

    public static int zza(int i4) {
        if (i4 != 1) {
            return i4 - 2;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static int zzb(int i4) {
        if (i4 == 0) {
            return 2;
        }
        if (i4 == 1) {
            return 3;
        }
        if (i4 == 2) {
            return 4;
        }
        if (i4 == 3) {
            return 5;
        }
        if (i4 != 4) {
            if (i4 != 5) {
                return 0;
            }
            return 7;
        }
        return 6;
    }
}
