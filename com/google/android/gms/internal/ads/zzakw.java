package com.google.android.gms.internal.ads;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzakw extends Thread {
    private static final boolean zza = zzalw.zzb;
    private final BlockingQueue zzb;
    private final BlockingQueue zzc;
    private final zzaku zzd;
    private volatile boolean zze = false;
    private final zzalx zzf;
    private final zzalb zzg;

    public zzakw(BlockingQueue blockingQueue, BlockingQueue blockingQueue2, zzaku zzakuVar, zzalb zzalbVar) {
        this.zzb = blockingQueue;
        this.zzc = blockingQueue2;
        this.zzd = zzakuVar;
        this.zzg = zzalbVar;
        this.zzf = new zzalx(this, blockingQueue2, zzalbVar);
    }

    private void zzc() throws InterruptedException {
        zzalk zzalkVar = (zzalk) this.zzb.take();
        zzalkVar.zzm("cache-queue-take");
        zzalkVar.zzt(1);
        try {
            zzalkVar.zzw();
            zzakt zza2 = this.zzd.zza(zzalkVar.zzj());
            if (zza2 == null) {
                zzalkVar.zzm("cache-miss");
                if (!this.zzf.zzc(zzalkVar)) {
                    this.zzc.put(zzalkVar);
                }
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (zza2.zza(currentTimeMillis)) {
                zzalkVar.zzm("cache-hit-expired");
                zzalkVar.zze(zza2);
                if (!this.zzf.zzc(zzalkVar)) {
                    this.zzc.put(zzalkVar);
                }
                return;
            }
            zzalkVar.zzm("cache-hit");
            zzalq zzh = zzalkVar.zzh(new zzalg(zza2.zza, zza2.zzg));
            zzalkVar.zzm("cache-hit-parsed");
            if (!zzh.zzc()) {
                zzalkVar.zzm("cache-parsing-failed");
                this.zzd.zzc(zzalkVar.zzj(), true);
                zzalkVar.zze(null);
                if (!this.zzf.zzc(zzalkVar)) {
                    this.zzc.put(zzalkVar);
                }
                return;
            }
            if (zza2.zzf < currentTimeMillis) {
                zzalkVar.zzm("cache-hit-refresh-needed");
                zzalkVar.zze(zza2);
                zzh.zzd = true;
                if (!this.zzf.zzc(zzalkVar)) {
                    this.zzg.zzb(zzalkVar, zzh, new zzakv(this, zzalkVar));
                } else {
                    this.zzg.zzb(zzalkVar, zzh, null);
                }
            } else {
                this.zzg.zzb(zzalkVar, zzh, null);
            }
        } finally {
            zzalkVar.zzt(2);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (zza) {
            zzalw.zzd("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.zzd.zzb();
        while (true) {
            try {
                zzc();
            } catch (InterruptedException unused) {
                if (this.zze) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzalw.zzb("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    public final void zzb() {
        this.zze = true;
        interrupt();
    }
}
