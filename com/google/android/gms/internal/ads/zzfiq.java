package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfiq {
    private final BlockingQueue zza;
    private final ThreadPoolExecutor zzb;
    private final ArrayDeque zzc = new ArrayDeque();
    private zzfip zzd = null;

    public zzfiq() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.zza = linkedBlockingQueue;
        this.zzb = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    private final void zzc() {
        zzfip zzfipVar = (zzfip) this.zzc.poll();
        this.zzd = zzfipVar;
        if (zzfipVar != null) {
            zzfipVar.executeOnExecutor(this.zzb, new Object[0]);
        }
    }

    public final void zza(zzfip zzfipVar) {
        this.zzd = null;
        zzc();
    }

    public final void zzb(zzfip zzfipVar) {
        zzfipVar.zzb(this);
        this.zzc.add(zzfipVar);
        if (this.zzd == null) {
            zzc();
        }
    }
}
