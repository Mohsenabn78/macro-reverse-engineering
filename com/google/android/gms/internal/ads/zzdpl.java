package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdpl implements zzcyb, zzcwu, zzcvj {
    private final zzdpv zza;
    private final zzdqf zzb;

    public zzdpl(zzdpv zzdpvVar, zzdqf zzdqfVar) {
        this.zza = zzdpvVar;
        this.zzb = zzdqfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcvj
    public final void zza(com.google.android.gms.ads.internal.client.zze zzeVar) {
        this.zza.zza().put("action", "ftl");
        this.zza.zza().put("ftl", String.valueOf(zzeVar.zza));
        this.zza.zza().put("ed", zzeVar.zzc);
        this.zzb.zze(this.zza.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzcyb
    public final void zzb(zzezz zzezzVar) {
        this.zza.zzb(zzezzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcyb
    public final void zzbA(zzbue zzbueVar) {
        this.zza.zzc(zzbueVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzcwu
    public final void zzn() {
        this.zza.zza().put("action", "loaded");
        this.zzb.zze(this.zza.zza());
    }
}
