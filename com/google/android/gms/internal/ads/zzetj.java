package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzetj implements zzeqy {
    final zzfwn zza;
    final List zzb;
    final zzbax zzc;

    public zzetj(zzbax zzbaxVar, zzfwn zzfwnVar, List list) {
        this.zzc = zzbaxVar;
        this.zza = zzfwnVar;
        this.zzb = list;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final int zza() {
        return 48;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final zzfwm zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeti
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzetk(zzetj.this.zzb);
            }
        });
    }
}
