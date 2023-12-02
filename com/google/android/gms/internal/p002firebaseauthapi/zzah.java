package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzah  reason: invalid package */
/* loaded from: classes4.dex */
public class zzah {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i4, int i5) {
        if (i5 >= 0) {
            int i6 = i4 + (i4 >> 1) + 1;
            if (i6 < i5) {
                int highestOneBit = Integer.highestOneBit(i5 - 1);
                i6 = highestOneBit + highestOneBit;
            }
            if (i6 < 0) {
                return Integer.MAX_VALUE;
            }
            return i6;
        }
        throw new AssertionError("cannot store more than MAX_VALUE elements");
    }
}
