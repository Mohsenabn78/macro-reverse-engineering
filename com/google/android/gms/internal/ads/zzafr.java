package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzafr {
    private static final long[] zza = {128, 64, 32, 16, 8, 4, 2, 1};
    private final byte[] zzb = new byte[8];
    private int zzc;
    private int zzd;

    public static int zzb(int i4) {
        int i5 = 0;
        while (i5 < 8) {
            int i6 = ((zza[i5] & i4) > 0L ? 1 : ((zza[i5] & i4) == 0L ? 0 : -1));
            i5++;
            if (i6 != 0) {
                return i5;
            }
        }
        return -1;
    }

    public static long zzc(byte[] bArr, int i4, boolean z3) {
        long j4 = bArr[0] & 255;
        if (z3) {
            j4 &= ~zza[i4 - 1];
        }
        for (int i5 = 1; i5 < i4; i5++) {
            j4 = (j4 << 8) | (bArr[i5] & 255);
        }
        return j4;
    }

    public final int zza() {
        return this.zzd;
    }

    public final long zzd(zzaax zzaaxVar, boolean z3, boolean z4, int i4) throws IOException {
        if (this.zzc == 0) {
            if (!zzaaxVar.zzn(this.zzb, 0, 1, z3)) {
                return -1L;
            }
            int zzb = zzb(this.zzb[0] & 255);
            this.zzd = zzb;
            if (zzb != -1) {
                this.zzc = 1;
            } else {
                throw new IllegalStateException("No valid varint length mask found");
            }
        }
        int i5 = this.zzd;
        if (i5 > i4) {
            this.zzc = 0;
            return -2L;
        }
        if (i5 != 1) {
            ((zzaam) zzaaxVar).zzn(this.zzb, 1, i5 - 1, false);
        }
        this.zzc = 0;
        return zzc(this.zzb, this.zzd, z4);
    }

    public final void zze() {
        this.zzc = 0;
        this.zzd = 0;
    }
}
