package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzblw implements zzbij {
    final /* synthetic */ long zza;
    final /* synthetic */ zzbmk zzb;
    final /* synthetic */ zzblg zzc;
    final /* synthetic */ zzbml zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzblw(zzbml zzbmlVar, long j4, zzbmk zzbmkVar, zzblg zzblgVar) {
        this.zzd = zzbmlVar;
        this.zza = j4;
        this.zzb = zzbmkVar;
        this.zzc = zzblgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        Object obj2;
        zzbmm zzbmmVar = (zzbmm) obj;
        long currentTimeMillis = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() - this.zza;
        com.google.android.gms.ads.internal.util.zze.zza("onGmsg /jsLoaded. JsLoaded latency is " + currentTimeMillis + " ms.");
        obj2 = this.zzd.zza;
        synchronized (obj2) {
            if (this.zzb.zze() != -1 && this.zzb.zze() != 1) {
                this.zzd.zzi = 0;
                zzblg zzblgVar = this.zzc;
                zzblgVar.zzq("/log", zzbii.zzg);
                zzblgVar.zzq("/result", zzbii.zzo);
                this.zzb.zzh(this.zzc);
                this.zzd.zzh = this.zzb;
                com.google.android.gms.ads.internal.util.zze.zza("Successfully loaded JS Engine.");
            }
        }
    }
}
