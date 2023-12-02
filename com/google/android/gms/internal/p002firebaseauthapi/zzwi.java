package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwi  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzwi {
    private final byte[] zza;

    private zzwi(byte[] bArr, int i4, int i5) {
        byte[] bArr2 = new byte[i5];
        this.zza = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, i5);
    }

    public static zzwi zzb(byte[] bArr) {
        if (bArr != null) {
            return new zzwi(bArr, 0, bArr.length);
        }
        throw new NullPointerException("data must be non-null");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzwi)) {
            return false;
        }
        return Arrays.equals(((zzwi) obj).zza, this.zza);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        String zza = zzvy.zza(this.zza);
        return "Bytes(" + zza + ")";
    }

    public final int zza() {
        return this.zza.length;
    }

    public final byte[] zzc() {
        byte[] bArr = this.zza;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }
}
