package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzcju implements zzdrb {
    private final Long zza;
    private final String zzb;
    private final zzciq zzc;
    private final zzcjy zzd;
    private final zzcju zze = this;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcju(zzciq zzciqVar, zzcjy zzcjyVar, Long l4, String str, zzcjt zzcjtVar) {
        this.zzc = zzciqVar;
        this.zzd = zzcjyVar;
        this.zza = l4;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdrb
    public final zzdrl zza() {
        Context context;
        zzdre zzc;
        long longValue = this.zza.longValue();
        zzcjy zzcjyVar = this.zzd;
        context = zzcjyVar.zza;
        zzc = zzdrf.zzc(zzcjyVar.zzb);
        return zzdrm.zza(longValue, context, zzc, this.zzc, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzdrb
    public final zzdrp zzb() {
        Context context;
        zzdre zzc;
        long longValue = this.zza.longValue();
        zzcjy zzcjyVar = this.zzd;
        context = zzcjyVar.zza;
        zzc = zzdrf.zzc(zzcjyVar.zzb);
        return zzdrq.zza(longValue, context, zzc, this.zzc, this.zzb);
    }
}
