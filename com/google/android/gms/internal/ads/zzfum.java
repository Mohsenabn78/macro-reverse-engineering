package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfum extends zzfuo {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfum(zzfwm zzfwmVar, Class cls, zzfvj zzfvjVar) {
        super(zzfwmVar, cls, zzfvjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfuo
    final /* bridge */ /* synthetic */ Object zzf(Object obj, Throwable th) throws Exception {
        zzfvj zzfvjVar = (zzfvj) obj;
        zzfwm zza = zzfvjVar.zza(th);
        zzfph.zzd(zza, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzfvjVar);
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfuo
    final /* synthetic */ void zzg(Object obj) {
        zzt((zzfwm) obj);
    }
}
