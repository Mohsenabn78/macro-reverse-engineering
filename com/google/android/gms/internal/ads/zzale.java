package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzale extends Thread {
    private final BlockingQueue zza;
    private final zzald zzb;
    private final zzaku zzc;
    private volatile boolean zzd = false;
    private final zzalb zze;

    public zzale(BlockingQueue blockingQueue, zzald zzaldVar, zzaku zzakuVar, zzalb zzalbVar) {
        this.zza = blockingQueue;
        this.zzb = zzaldVar;
        this.zzc = zzakuVar;
        this.zze = zzalbVar;
    }

    private void zzb() throws InterruptedException {
        zzalk zzalkVar = (zzalk) this.zza.take();
        SystemClock.elapsedRealtime();
        zzalkVar.zzt(3);
        try {
            zzalkVar.zzm("network-queue-take");
            zzalkVar.zzw();
            TrafficStats.setThreadStatsTag(zzalkVar.zzc());
            zzalg zza = this.zzb.zza(zzalkVar);
            zzalkVar.zzm("network-http-complete");
            if (zza.zze && zzalkVar.zzv()) {
                zzalkVar.zzp("not-modified");
                zzalkVar.zzr();
                return;
            }
            zzalq zzh = zzalkVar.zzh(zza);
            zzalkVar.zzm("network-parse-complete");
            if (zzh.zzb != null) {
                this.zzc.zzd(zzalkVar.zzj(), zzh.zzb);
                zzalkVar.zzm("network-cache-written");
            }
            zzalkVar.zzq();
            this.zze.zzb(zzalkVar, zzh, null);
            zzalkVar.zzs(zzh);
        } catch (zzalt e4) {
            SystemClock.elapsedRealtime();
            this.zze.zza(zzalkVar, e4);
            zzalkVar.zzr();
        } catch (Exception e5) {
            zzalw.zzc(e5, "Unhandled exception %s", e5.toString());
            zzalt zzaltVar = new zzalt(e5);
            SystemClock.elapsedRealtime();
            this.zze.zza(zzalkVar, zzaltVar);
            zzalkVar.zzr();
        } finally {
            zzalkVar.zzt(4);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                zzb();
            } catch (InterruptedException unused) {
                if (this.zzd) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzalw.zzb("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    public final void zza() {
        this.zzd = true;
        interrupt();
    }
}
