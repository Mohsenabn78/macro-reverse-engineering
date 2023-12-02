package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzes {
    private int zza;
    private long[] zzb;

    public zzes(int i4) {
        this.zzb = new long[32];
    }

    public final int zza() {
        return this.zza;
    }

    public final long zzb(int i4) {
        if (i4 >= 0 && i4 < this.zza) {
            return this.zzb[i4];
        }
        int i5 = this.zza;
        throw new IndexOutOfBoundsException("Invalid index " + i4 + ", size is " + i5);
    }

    public final void zzc(long j4) {
        int i4 = this.zza;
        long[] jArr = this.zzb;
        if (i4 == jArr.length) {
            this.zzb = Arrays.copyOf(jArr, i4 + i4);
        }
        long[] jArr2 = this.zzb;
        int i5 = this.zza;
        this.zza = i5 + 1;
        jArr2[i5] = j4;
    }

    public zzes() {
        this(32);
    }
}
