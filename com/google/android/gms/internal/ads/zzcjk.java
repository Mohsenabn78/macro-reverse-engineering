package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzcjk implements zzewc {
    private final Context zza;
    private final com.google.android.gms.ads.internal.client.zzq zzb;
    private final String zzc;
    private final zzciq zzd;
    private final zzcjk zze = this;
    private final zzgwr zzf;
    private final zzgwr zzg;
    private final zzgwr zzh;
    private final zzgwr zzi;
    private final zzgwr zzj;
    private final zzgwr zzk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcjk(zzciq zzciqVar, Context context, String str, com.google.android.gms.ads.internal.client.zzq zzqVar, zzcjj zzcjjVar) {
        zzgwr zzgwrVar;
        zzgwr zzgwrVar2;
        zzgwr zzgwrVar3;
        this.zzd = zzciqVar;
        this.zza = context;
        this.zzb = zzqVar;
        this.zzc = str;
        zzgwe zza = zzgwf.zza(context);
        this.zzf = zza;
        zzgwe zza2 = zzgwf.zza(zzqVar);
        this.zzg = zza2;
        zzgwrVar = zzciqVar.zzn;
        zzgwr zzc = zzgwd.zzc(new zzejn(zzgwrVar));
        this.zzh = zzc;
        zzgwr zzc2 = zzgwd.zzc(zzejs.zza());
        this.zzi = zzc2;
        zzgwr zzc3 = zzgwd.zzc(zzdae.zza());
        this.zzj = zzc3;
        zzgwrVar2 = zzciqVar.zzo;
        zzgwrVar3 = zzciqVar.zzU;
        this.zzk = zzgwd.zzc(new zzewa(zza, zzgwrVar2, zza2, zzgwrVar3, zzc, zzc2, zzfak.zza(), zzc3));
    }

    @Override // com.google.android.gms.internal.ads.zzewc
    public final zzeis zza() {
        zzcgx zzcgxVar;
        zzgwr zzgwrVar;
        Context context = this.zza;
        com.google.android.gms.ads.internal.client.zzq zzqVar = this.zzb;
        String str = this.zzc;
        zzevz zzevzVar = (zzevz) this.zzk.zzb();
        zzejm zzejmVar = (zzejm) this.zzh.zzb();
        zzcgxVar = this.zzd.zza;
        zzbzx zzd = zzcgxVar.zzd();
        zzgwm.zzb(zzd);
        zzgwrVar = this.zzd.zzZ;
        return new zzeis(context, zzqVar, str, zzevzVar, zzejmVar, zzd, (zzdqa) zzgwrVar.zzb());
    }
}
