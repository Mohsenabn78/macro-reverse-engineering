package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzain {
    private final zzabz zza;
    private boolean zzb;
    private boolean zzc;
    private boolean zzd;
    private int zze;
    private int zzf;
    private long zzg;
    private long zzh;

    public zzain(zzabz zzabzVar) {
        this.zza = zzabzVar;
    }

    public final void zza(byte[] bArr, int i4, int i5) {
        boolean z3;
        if (this.zzc) {
            int i6 = this.zzf;
            int i7 = (i4 + 1) - i6;
            if (i7 < i5) {
                if (((bArr[i7] & 192) >> 6) == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                this.zzd = z3;
                this.zzc = false;
                return;
            }
            this.zzf = i6 + (i5 - i4);
        }
    }

    public final void zzb(long j4, int i4, boolean z3) {
        if (this.zze == 182 && z3 && this.zzb) {
            long j5 = this.zzh;
            if (j5 != -9223372036854775807L) {
                this.zza.zzs(j5, this.zzd ? 1 : 0, (int) (j4 - this.zzg), i4, null);
            }
        }
        if (this.zze != 179) {
            this.zzg = j4;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzc(int r5, long r6) {
        /*
            r4 = this;
            r4.zze = r5
            r0 = 0
            r4.zzd = r0
            r1 = 1
            r2 = 182(0xb6, float:2.55E-43)
            if (r5 == r2) goto L13
            r3 = 179(0xb3, float:2.51E-43)
            if (r5 != r3) goto L11
            r5 = 179(0xb3, float:2.51E-43)
            goto L13
        L11:
            r3 = 0
            goto L14
        L13:
            r3 = 1
        L14:
            r4.zzb = r3
            if (r5 != r2) goto L19
            goto L1a
        L19:
            r1 = 0
        L1a:
            r4.zzc = r1
            r4.zzf = r0
            r4.zzh = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzain.zzc(int, long):void");
    }

    public final void zzd() {
        this.zzb = false;
        this.zzc = false;
        this.zzd = false;
        this.zze = -1;
    }
}
