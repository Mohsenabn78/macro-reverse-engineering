package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfvz implements Runnable {
    final Future zza;
    final zzfvy zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfvz(Future future, zzfvy zzfvyVar) {
        this.zza = future;
        this.zzb = zzfvyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Throwable zza;
        Future future = this.zza;
        if ((future instanceof zzfxf) && (zza = zzfxg.zza((zzfxf) future)) != null) {
            this.zzb.zza(zza);
            return;
        }
        try {
            this.zzb.zzb(zzfwc.zzo(this.zza));
        } catch (Error e4) {
            e = e4;
            this.zzb.zza(e);
        } catch (RuntimeException e5) {
            e = e5;
            this.zzb.zza(e);
        } catch (ExecutionException e6) {
            this.zzb.zza(e6.getCause());
        }
    }

    public final String toString() {
        zzfpa zza = zzfpb.zza(this);
        zza.zza(this.zzb);
        return zza.toString();
    }
}
