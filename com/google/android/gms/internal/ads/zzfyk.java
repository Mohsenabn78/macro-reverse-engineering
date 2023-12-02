package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzfyk implements Comparable {
    private final byte[] zza;

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzfyk zzfykVar = (zzfyk) obj;
        int length = this.zza.length;
        int length2 = zzfykVar.zza.length;
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
            byte b5 = zzfykVar.zza[i4];
            if (b4 != b5) {
                return b4 - b5;
            }
            i4++;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzfyk)) {
            return false;
        }
        return Arrays.equals(this.zza, ((zzfyk) obj).zza);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        return zzgmz.zza(this.zza);
    }
}
