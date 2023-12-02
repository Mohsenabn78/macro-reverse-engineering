package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzctv implements zzcyb {
    private final Context zza;
    private final zzfai zzb;
    private final zzbzx zzc;
    private final com.google.android.gms.ads.internal.util.zzg zzd;
    private final zzdsc zze;
    private final zzfgb zzf;

    public zzctv(Context context, zzfai zzfaiVar, zzbzx zzbzxVar, com.google.android.gms.ads.internal.util.zzg zzgVar, zzdsc zzdscVar, zzfgb zzfgbVar) {
        this.zza = context;
        this.zzb = zzfaiVar;
        this.zzc = zzbzxVar;
        this.zzd = zzgVar;
        this.zze = zzdscVar;
        this.zzf = zzfgbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcyb
    public final void zzbA(zzbue zzbueVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzdH)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zza().zzc(this.zza, this.zzc, this.zzb.zzf, this.zzd.zzh(), this.zzf);
        }
        this.zze.zzr();
    }

    @Override // com.google.android.gms.internal.ads.zzcyb
    public final void zzb(zzezz zzezzVar) {
    }
}
