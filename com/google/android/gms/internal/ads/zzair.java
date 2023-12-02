package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzair {
    private final zzabz zza;
    private final zzfv zzd;
    private final byte[] zze;
    private int zzf;
    private long zzg;
    private long zzh;
    private long zzl;
    private long zzm;
    private boolean zzn;
    private final SparseArray zzb = new SparseArray();
    private final SparseArray zzc = new SparseArray();
    private final zzaiq zzi = new zzaiq(null);
    private final zzaiq zzj = new zzaiq(null);
    private boolean zzk = false;

    public zzair(zzabz zzabzVar, boolean z3, boolean z4) {
        this.zza = zzabzVar;
        byte[] bArr = new byte[128];
        this.zze = bArr;
        this.zzd = new zzfv(bArr, 0, 0);
    }

    public final void zza(zzfs zzfsVar) {
        this.zzc.append(zzfsVar.zza, zzfsVar);
    }

    public final void zzb(zzft zzftVar) {
        this.zzb.append(zzftVar.zzd, zzftVar);
    }

    public final void zzc() {
        this.zzk = false;
    }

    public final void zzd(long j4, int i4, long j5) {
        this.zzf = i4;
        this.zzh = j5;
        this.zzg = j4;
    }

    public final boolean zze(long j4, int i4, boolean z3, boolean z4) {
        boolean z5 = false;
        if (this.zzf == 9) {
            if (z3 && this.zzk) {
                long j5 = this.zzg;
                int i5 = i4 + ((int) (j4 - j5));
                long j6 = this.zzm;
                if (j6 != -9223372036854775807L) {
                    this.zza.zzs(j6, this.zzn ? 1 : 0, (int) (j5 - this.zzl), i5, null);
                }
            }
            this.zzl = this.zzg;
            this.zzm = this.zzh;
            this.zzn = false;
            this.zzk = true;
        }
        boolean z6 = this.zzn;
        int i6 = this.zzf;
        if (i6 == 5 || (z4 && i6 == 1)) {
            z5 = true;
        }
        boolean z7 = z6 | z5;
        this.zzn = z7;
        return z7;
    }
}
