package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzalb {
    private final Executor zza;

    public zzalb(Handler handler) {
        this.zza = new zzakz(this, handler);
    }

    public final void zza(zzalk zzalkVar, zzalt zzaltVar) {
        zzalkVar.zzm("post-error");
        zzalq zza = zzalq.zza(zzaltVar);
        Executor executor = this.zza;
        ((zzakz) executor).zza.post(new zzala(zzalkVar, zza, null));
    }

    public final void zzb(zzalk zzalkVar, zzalq zzalqVar, Runnable runnable) {
        zzalkVar.zzq();
        zzalkVar.zzm("post-response");
        Executor executor = this.zza;
        ((zzakz) executor).zza.post(new zzala(zzalkVar, zzalqVar, runnable));
    }
}
