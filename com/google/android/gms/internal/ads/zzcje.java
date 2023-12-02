package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzcje implements zzcpx {
    private final zzciq zza;
    private zzexi zzb;
    private zzewl zzc;
    private zzdat zzd;
    private zzcuq zze;
    private zzehv zzf;
    private zzcqv zzg;
    private zzefy zzh;
    private zzcoy zzi;
    private zzdff zzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcje(zzciq zzciqVar, zzcjd zzcjdVar) {
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

    @Override // com.google.android.gms.internal.ads.zzcpx
    public final /* synthetic */ zzcpx zzc(zzcoy zzcoyVar) {
        this.zzi = zzcoyVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcpx
    public final /* synthetic */ zzcpx zzd(zzdff zzdffVar) {
        this.zzj = zzdffVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcpx
    public final /* synthetic */ zzcpx zze(zzehv zzehvVar) {
        this.zzf = zzehvVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcpx
    public final /* synthetic */ zzcpx zzf(zzdat zzdatVar) {
        this.zzd = zzdatVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcpx
    public final /* synthetic */ zzcpx zzg(zzcqv zzcqvVar) {
        this.zzg = zzcqvVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcpx
    public final /* synthetic */ zzcpx zzi(zzcuq zzcuqVar) {
        this.zze = zzcuqVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcpx
    public final /* synthetic */ zzcpx zzj(zzefy zzefyVar) {
        this.zzh = zzefyVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcum
    /* renamed from: zzk */
    public final zzcpy zzh() {
        zzgwm.zzc(this.zzd, zzdat.class);
        zzgwm.zzc(this.zze, zzcuq.class);
        zzgwm.zzc(this.zzf, zzehv.class);
        zzgwm.zzc(this.zzg, zzcqv.class);
        if (this.zzh == null) {
            this.zzh = zzega.zza();
        }
        zzgwm.zzc(this.zzi, zzcoy.class);
        zzgwm.zzc(this.zzj, zzdff.class);
        return new zzcjg(this.zza, this.zzi, this.zzj, new zzcsm(), new zzfbm(), new zzctx(), new zzdqn(), this.zzd, this.zze, this.zzh, this.zzf, this.zzg, null, this.zzb, this.zzc, null);
    }
}
