package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcnp implements zzbij {
    final /* synthetic */ zzcns zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcnp(zzcns zzcnsVar) {
        this.zza = zzcnsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zza(Object obj, Map map) {
        Executor executor;
        if (zzcns.zzg(this.zza, map)) {
            executor = this.zza.zzc;
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcno
                @Override // java.lang.Runnable
                public final void run() {
                    zzcnx zzcnxVar;
                    zzcnxVar = zzcnp.this.zza.zzd;
                    zzcnxVar.zzg();
                }
            });
        }
    }
}
