package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzciu implements zzcoo {
    private final zzciq zza;
    private zzexi zzb;
    private zzewl zzc;
    private zzdat zzd;
    private zzcuq zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzciu(zzciq zzciqVar, zzcit zzcitVar) {
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

    @Override // com.google.android.gms.internal.ads.zzcoo
    public final /* synthetic */ zzcoo zzc(zzdat zzdatVar) {
        this.zzd = zzdatVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcoo
    public final /* synthetic */ zzcoo zzd(zzcuq zzcuqVar) {
        this.zze = zzcuqVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcum
    /* renamed from: zze */
    public final zzcop zzh() {
        zzgwm.zzc(this.zzd, zzdat.class);
        zzgwm.zzc(this.zze, zzcuq.class);
        return new zzciw(this.zza, new zzcsm(), new zzfbm(), new zzctx(), new zzdqn(), this.zzd, this.zze, zzega.zza(), null, this.zzb, this.zzc, null);
    }
}
