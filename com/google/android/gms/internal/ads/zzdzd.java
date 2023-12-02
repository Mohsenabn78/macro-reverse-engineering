package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdzd implements zzcyb, zzcwu, zzcvj {
    private final zzfeu zza;
    private final zzfev zzb;
    private final zzbze zzc;

    public zzdzd(zzfeu zzfeuVar, zzfev zzfevVar, zzbze zzbzeVar) {
        this.zza = zzfeuVar;
        this.zzb = zzfevVar;
        this.zzc = zzbzeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcvj
    public final void zza(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzfeu zzfeuVar = this.zza;
        zzfeuVar.zza("action", "ftl");
        zzfeuVar.zza("ftl", String.valueOf(zzeVar.zza));
        zzfeuVar.zza("ed", zzeVar.zzc);
        this.zzb.zzb(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzcyb
    public final void zzb(zzezz zzezzVar) {
        this.zza.zzh(zzezzVar, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzcyb
    public final void zzbA(zzbue zzbueVar) {
        this.zza.zzi(zzbueVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzcwu
    public final void zzn() {
        zzfev zzfevVar = this.zzb;
        zzfeu zzfeuVar = this.zza;
        zzfeuVar.zza("action", "loaded");
        zzfevVar.zzb(zzfeuVar);
    }
}
