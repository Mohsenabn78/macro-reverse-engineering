package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzck  reason: invalid package */
/* loaded from: classes4.dex */
final class zzck implements Comparable {
    private final byte[] zza;

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzck zzckVar = (zzck) obj;
        int length = this.zza.length;
        int length2 = zzckVar.zza.length;
        if (length != length2) {
            return length - length2;
        }
        int i4 = 0;
        while (true) {
            byte[] bArr = this.zza;
            if (i4 >= bArr.length) {
                return 0;
            }
            byte b4 = bArr[i4];
            byte b5 = zzckVar.zza[i4];
            if (b4 != b5) {
                return b4 - b5;
            }
            i4++;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzck)) {
            return false;
        }
        return Arrays.equals(this.zza, ((zzck) obj).zza);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        return zzvy.zza(this.zza);
    }
}
