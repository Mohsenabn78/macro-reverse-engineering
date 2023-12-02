package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfws extends zzfwp implements ScheduledExecutorService {
    final ScheduledExecutorService zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfws(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        scheduledExecutorService.getClass();
        this.zza = scheduledExecutorService;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j4, TimeUnit timeUnit) {
        zzfxc zzf = zzfxc.zzf(runnable, null);
        return new zzfwq(zzf, this.zza.schedule(zzf, j4, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j4, long j5, TimeUnit timeUnit) {
        zzfwr zzfwrVar = new zzfwr(runnable);
        return new zzfwq(zzfwrVar, this.zza.scheduleAtFixedRate(zzfwrVar, j4, j5, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j4, long j5, TimeUnit timeUnit) {
        zzfwr zzfwrVar = new zzfwr(runnable);
        return new zzfwq(zzfwrVar, this.zza.scheduleWithFixedDelay(zzfwrVar, j4, j5, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Callable callable, long j4, TimeUnit timeUnit) {
        zzfxc zzfxcVar = new zzfxc(callable);
        return new zzfwq(zzfxcVar, this.zza.schedule(zzfxcVar, j4, timeUnit));
    }
}
