package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfuw extends zzfuy {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfuw(zzfwm zzfwmVar, zzfvj zzfvjVar) {
        super(zzfwmVar, zzfvjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfuy
    final /* bridge */ /* synthetic */ Object zzf(Object obj, Object obj2) throws Exception {
        zzfvj zzfvjVar = (zzfvj) obj;
        zzfwm zza = zzfvjVar.zza(obj2);
        zzfph.zzd(zza, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzfvjVar);
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfuy
    final /* synthetic */ void zzg(Object obj) {
        zzt((zzfwm) obj);
    }
}
