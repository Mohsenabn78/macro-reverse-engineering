package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaac implements zzabv {
    private final zzaaf zza;
    private final long zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;
    private final long zzf;

    public zzaac(zzaaf zzaafVar, long j4, long j5, long j6, long j7, long j8, long j9) {
        this.zza = zzaafVar;
        this.zzb = j4;
        this.zzc = j6;
        this.zzd = j7;
        this.zze = j8;
        this.zzf = j9;
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final long zze() {
        return this.zzb;
    }

    public final long zzf(long j4) {
        return this.zza.zza(j4);
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final zzabt zzg(long j4) {
        zzabw zzabwVar = new zzabw(j4, zzaae.zzf(this.zza.zza(j4), 0L, this.zzc, this.zzd, this.zze, this.zzf));
        return new zzabt(zzabwVar, zzabwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final boolean zzh() {
        return true;
    }
}
