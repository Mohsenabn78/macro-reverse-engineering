package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzblx implements zzbij {
    final /* synthetic */ zzblg zza;
    final /* synthetic */ com.google.android.gms.ads.internal.util.zzca zzb;
    final /* synthetic */ zzbml zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzblx(zzbml zzbmlVar, zzaqs zzaqsVar, zzblg zzblgVar, com.google.android.gms.ads.internal.util.zzca zzcaVar) {
        this.zzc = zzbmlVar;
        this.zza = zzblgVar;
        this.zzb = zzcaVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.gms.internal.ads.zzbij, java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzbij
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        Object obj2;
        int i4;
        zzbmm zzbmmVar = (zzbmm) obj;
        obj2 = this.zzc.zza;
        synchronized (obj2) {
            zzbzr.zzi("JS Engine is requesting an update");
            i4 = this.zzc.zzi;
            if (i4 == 0) {
                zzbzr.zzi("Starting reload.");
                this.zzc.zzi = 2;
                this.zzc.zzd(null);
            }
            this.zza.zzr("/requestReload", this.zzb.zza());
        }
    }
}
