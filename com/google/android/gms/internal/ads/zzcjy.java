package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcjy implements zzdrj {
    private final Context zza;
    private final zzbjg zzb;
    private final zzciq zzc;
    private final zzcjy zzd = this;
    private final zzgwr zze;
    private final zzgwr zzf;
    private final zzgwr zzg;
    private final zzgwr zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcjy(zzciq zzciqVar, Context context, zzbjg zzbjgVar, zzcjx zzcjxVar) {
        this.zzc = zzciqVar;
        this.zza = context;
        this.zzb = zzbjgVar;
        zzgwe zza = zzgwf.zza(this);
        this.zze = zza;
        zzgwe zza2 = zzgwf.zza(zzbjgVar);
        this.zzf = zza2;
        zzdrf zzdrfVar = new zzdrf(zza2);
        this.zzg = zzdrfVar;
        this.zzh = zzgwd.zzc(new zzdrh(zza, zzdrfVar));
    }

    @Override // com.google.android.gms.internal.ads.zzdrj
    public final zzdra zzb() {
        return new zzcjs(this.zzc, this.zzd, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdrj
    public final zzdrg zzd() {
        return (zzdrg) this.zzh.zzb();
    }
}
