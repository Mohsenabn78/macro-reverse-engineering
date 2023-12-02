package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzckc implements zzden {
    private final zzciq zza;
    private zzexi zzb;
    private zzewl zzc;
    private zzdat zzd;
    private zzcuq zze;
    private zzehv zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzckc(zzciq zzciqVar, zzckb zzckbVar) {
        this.zza = zzciqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcum
    public final /* synthetic */ zzcum zza(zzewl zzewlVar) {
        this.zzc = zzewlVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcum
    public final /* synthetic */ zzcum zzb(zzexi zzexiVar) {
        this.zzb = zzexiVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final /* synthetic */ zzden zzc(zzehv zzehvVar) {
        this.zzf = zzehvVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final /* synthetic */ zzden zzd(zzdat zzdatVar) {
        this.zzd = zzdatVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final /* synthetic */ zzden zze(zzcuq zzcuqVar) {
        this.zze = zzcuqVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcum
    /* renamed from: zzf */
    public final zzdeo zzh() {
        zzgwm.zzc(this.zzd, zzdat.class);
        zzgwm.zzc(this.zze, zzcuq.class);
        zzgwm.zzc(this.zzf, zzehv.class);
        return new zzcke(this.zza, new zzcsm(), new zzfbm(), new zzctx(), new zzdqn(), this.zzd, this.zze, zzega.zza(), this.zzf, null, this.zzb, this.zzc, null);
    }
}
