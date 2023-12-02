package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgnk {
    private final byte[] zza;

    private zzgnk(byte[] bArr, int i4, int i5) {
        byte[] bArr2 = new byte[i5];
        this.zza = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, i5);
    }

    public static zzgnk zzb(byte[] bArr) {
        if (bArr != null) {
            return new zzgnk(bArr, 0, bArr.length);
        }
        throw new NullPointerException("data must be non-null");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgnk)) {
            return false;
        }
        return Arrays.equals(((zzgnk) obj).zza, this.zza);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        String zza = zzgmz.zza(this.zza);
        return "Bytes(" + zza + ")";
    }

    public final int zza() {
        return this.zza.length;
    }
}
