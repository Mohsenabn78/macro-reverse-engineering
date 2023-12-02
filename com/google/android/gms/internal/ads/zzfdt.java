package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfdt {
    final /* synthetic */ zzfed zza;
    private final Object zzb;
    private final List zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfdt(zzfed zzfedVar, Object obj, List list, zzfds zzfdsVar) {
        this.zza = zzfedVar;
        this.zzb = obj;
        this.zzc = list;
    }

    public final zzfec zza(Callable callable) {
        zzfwn zzfwnVar;
        zzfwb zzb = zzfwc.zzb(this.zzc);
        zzfwm zza = zzb.zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzfdr
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return null;
            }
        }, zzcae.zzf);
        zzfed zzfedVar = this.zza;
        Object obj = this.zzb;
        List list = this.zzc;
        zzfwnVar = zzfedVar.zzb;
        return new zzfec(zzfedVar, obj, zza, list, zzb.zza(callable, zzfwnVar));
    }
}
