package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzemj implements zzeqy {
    private final zzfwn zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzemj(zzfwn zzfwnVar) {
        this.zza = zzfwnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final int zza() {
        return 54;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final zzfwm zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzemi
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzemk.zzb();
            }
        });
    }
}
