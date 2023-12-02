package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzafq {
    private final zzfa zza = new zzfa(8);
    private int zzb;

    private final long zzb(zzaax zzaaxVar) throws IOException {
        zzaam zzaamVar = (zzaam) zzaaxVar;
        int i4 = 0;
        zzaamVar.zzm(this.zza.zzH(), 0, 1, false);
        int i5 = this.zza.zzH()[0] & 255;
        if (i5 != 0) {
            int i6 = 128;
            int i7 = 0;
            while ((i5 & i6) == 0) {
                i6 >>= 1;
                i7++;
            }
            int i8 = i5 & (~i6);
            zzaamVar.zzm(this.zza.zzH(), 1, i7, false);
            while (i4 < i7) {
                i4++;
                i8 = (this.zza.zzH()[i4] & 255) + (i8 << 8);
            }
            this.zzb += i7 + 1;
            return i8;
        }
        return Long.MIN_VALUE;
    }

    public final boolean zza(zzaax zzaaxVar) throws IOException {
        long zzb;
        int i4;
        long zzd = zzaaxVar.zzd();
        long j4 = 1024;
        int i5 = (zzd > (-1L) ? 1 : (zzd == (-1L) ? 0 : -1));
        if (i5 != 0 && zzd <= 1024) {
            j4 = zzd;
        }
        zzaam zzaamVar = (zzaam) zzaaxVar;
        zzaamVar.zzm(this.zza.zzH(), 0, 4, false);
        long zzs = this.zza.zzs();
        this.zzb = 4;
        while (zzs != 440786851) {
            int i6 = (int) j4;
            int i7 = this.zzb + 1;
            this.zzb = i7;
            if (i7 == i6) {
                return false;
            }
            zzaamVar.zzm(this.zza.zzH(), 0, 1, false);
            zzs = ((zzs << 8) & (-256)) | (this.zza.zzH()[0] & 255);
        }
        long zzb2 = zzb(zzaaxVar);
        long j5 = this.zzb;
        if (zzb2 != Long.MIN_VALUE && (i5 == 0 || j5 + zzb2 < zzd)) {
            while (true) {
                int i8 = (this.zzb > (j5 + zzb2) ? 1 : (this.zzb == (j5 + zzb2) ? 0 : -1));
                if (i8 < 0) {
                    if (zzb(zzaaxVar) == Long.MIN_VALUE || (zzb(zzaaxVar)) < 0) {
                        return false;
                    }
                    if (i4 != 0) {
                        int i9 = (int) zzb;
                        zzaamVar.zzl(i9, false);
                        this.zzb += i9;
                    }
                } else if (i8 == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
