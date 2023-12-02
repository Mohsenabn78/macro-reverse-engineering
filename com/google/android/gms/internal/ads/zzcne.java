package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcne implements zzcvj {
    private final zzezq zza;
    private final zzezz zzb;
    private final zzfgn zzc;
    private final zzfgr zzd;

    public zzcne(zzezz zzezzVar, zzfgr zzfgrVar, zzfgn zzfgnVar) {
        this.zzb = zzezzVar;
        this.zzd = zzfgrVar;
        this.zzc = zzfgnVar;
        this.zza = zzezzVar.zzb.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzcvj
    public final void zza(com.google.android.gms.ads.internal.client.zze zzeVar) {
        this.zzd.zzd(this.zzc.zzc(this.zzb, null, this.zza.zza));
    }
}
