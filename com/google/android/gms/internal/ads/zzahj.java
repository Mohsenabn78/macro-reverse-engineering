package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzahj implements zzahp {
    private final zzabj zza;
    private final zzabi zzb;
    private long zzc = -1;
    private long zzd = -1;

    public zzahj(zzabj zzabjVar, zzabi zzabiVar) {
        this.zza = zzabjVar;
        this.zzb = zzabiVar;
    }

    public final void zza(long j4) {
        this.zzc = j4;
    }

    @Override // com.google.android.gms.internal.ads.zzahp
    public final long zzd(zzaax zzaaxVar) {
        long j4 = this.zzd;
        if (j4 < 0) {
            return -1L;
        }
        this.zzd = -1L;
        return -(j4 + 2);
    }

    @Override // com.google.android.gms.internal.ads.zzahp
    public final zzabv zze() {
        boolean z3;
        if (this.zzc != -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzdy.zzf(z3);
        return new zzabh(this.zza, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzahp
    public final void zzg(long j4) {
        long[] jArr = this.zzb.zza;
        this.zzd = jArr[zzfj.zzc(jArr, j4, true, true)];
    }
}
