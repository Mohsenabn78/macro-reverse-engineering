package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzcjw implements zzdri {
    private final zzciq zza;
    private Context zzb;
    private zzbjg zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcjw(zzciq zzciqVar, zzcjv zzcjvVar) {
        this.zza = zzciqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdri
    public final /* synthetic */ zzdri zza(zzbjg zzbjgVar) {
        zzbjgVar.getClass();
        this.zzc = zzbjgVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdri
    public final /* synthetic */ zzdri zzb(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdri
    public final zzdrj zzc() {
        zzgwm.zzc(this.zzb, Context.class);
        zzgwm.zzc(this.zzc, zzbjg.class);
        return new zzcjy(this.zza, this.zzb, this.zzc, null);
    }
}
