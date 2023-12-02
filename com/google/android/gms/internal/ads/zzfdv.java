package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfdv {
    public static final zzfec zza(Callable callable, Object obj, zzfed zzfedVar) {
        zzfwn zzfwnVar;
        zzfwnVar = zzfedVar.zzb;
        return zzb(callable, zzfwnVar, obj, zzfedVar);
    }

    public static final zzfec zzb(Callable callable, zzfwn zzfwnVar, Object obj, zzfed zzfedVar) {
        zzfwm zzfwmVar;
        zzfwmVar = zzfed.zza;
        return new zzfec(zzfedVar, obj, zzfwmVar, Collections.emptyList(), zzfwnVar.zzb(callable));
    }

    public static final zzfec zzc(zzfwm zzfwmVar, Object obj, zzfed zzfedVar) {
        zzfwm zzfwmVar2;
        zzfwmVar2 = zzfed.zza;
        return new zzfec(zzfedVar, obj, zzfwmVar2, Collections.emptyList(), zzfwmVar);
    }

    public static final zzfec zzd(final zzfdp zzfdpVar, zzfwn zzfwnVar, Object obj, zzfed zzfedVar) {
        return zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzfdu
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzfdp.this.zza();
                return null;
            }
        }, zzfwnVar, obj, zzfedVar);
    }
}
