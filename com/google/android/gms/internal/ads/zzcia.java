package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzcia implements zzdfj {
    private final zzciq zza;
    private zzexi zzb;
    private zzewl zzc;
    private zzdat zzd;
    private zzcuq zze;
    private zzdff zzf;
    private zzcoy zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcia(zzciq zzciqVar, zzchz zzchzVar) {
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

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ zzdfj zzc(zzcoy zzcoyVar) {
        this.zzg = zzcoyVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ zzdfj zzd(zzdff zzdffVar) {
        this.zzf = zzdffVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ zzdfj zze(zzdat zzdatVar) {
        this.zzd = zzdatVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ zzdfj zzf(zzcuq zzcuqVar) {
        this.zze = zzcuqVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcum
    /* renamed from: zzg */
    public final zzdfk zzh() {
        zzgwm.zzc(this.zzd, zzdat.class);
        zzgwm.zzc(this.zze, zzcuq.class);
        zzgwm.zzc(this.zzf, zzdff.class);
        zzgwm.zzc(this.zzg, zzcoy.class);
        return new zzcic(this.zza, this.zzg, this.zzf, new zzcsm(), new zzfbm(), new zzctx(), new zzdqn(), this.zzd, this.zze, zzega.zza(), null, this.zzb, this.zzc, null);
    }
}
