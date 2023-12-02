package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfey implements zzfev {
    private final zzfev zza;
    private final Queue zzb = new LinkedBlockingQueue();
    private final int zzc = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzij)).intValue();
    private final AtomicBoolean zzd = new AtomicBoolean(false);

    public zzfey(zzfev zzfevVar, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzfevVar;
        long intValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzii)).intValue();
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfex
            @Override // java.lang.Runnable
            public final void run() {
                zzfey.zzc(zzfey.this);
            }
        }, intValue, intValue, TimeUnit.MILLISECONDS);
    }

    public static /* synthetic */ void zzc(zzfey zzfeyVar) {
        while (!zzfeyVar.zzb.isEmpty()) {
            zzfeyVar.zza.zzb((zzfeu) zzfeyVar.zzb.remove());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfev
    public final String zza(zzfeu zzfeuVar) {
        return this.zza.zza(zzfeuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfev
    public final void zzb(zzfeu zzfeuVar) {
        if (this.zzb.size() >= this.zzc) {
            if (!this.zzd.getAndSet(true)) {
                Queue queue = this.zzb;
                zzfeu zzb = zzfeu.zzb("dropped_event");
                Map zzj = zzfeuVar.zzj();
                if (zzj.containsKey("action")) {
                    zzb.zza("dropped_action", (String) zzj.get("action"));
                }
                queue.offer(zzb);
                return;
            }
            return;
        }
        this.zzb.offer(zzfeuVar);
    }
}
