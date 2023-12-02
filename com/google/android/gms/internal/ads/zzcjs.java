package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzcjs implements zzdra {
    private final zzciq zza;
    private final zzcjy zzb;
    private Long zzc;
    private String zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcjs(zzciq zzciqVar, zzcjy zzcjyVar, zzcjr zzcjrVar) {
        this.zza = zzciqVar;
        this.zzb = zzcjyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdra
    public final /* synthetic */ zzdra zza(String str) {
        str.getClass();
        this.zzd = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdra
    public final /* bridge */ /* synthetic */ zzdra zzb(long j4) {
        this.zzc = Long.valueOf(j4);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdra
    public final zzdrb zzc() {
        zzgwm.zzc(this.zzc, Long.class);
        zzgwm.zzc(this.zzd, String.class);
        return new zzcju(this.zza, this.zzb, this.zzc, this.zzd, null);
    }
}
