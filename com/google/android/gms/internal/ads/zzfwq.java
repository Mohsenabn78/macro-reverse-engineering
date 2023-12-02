package com.google.android.gms.internal.ads;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzfwq extends zzfvw implements ScheduledFuture {
    private final ScheduledFuture zza;

    public zzfwq(zzfwm zzfwmVar, ScheduledFuture scheduledFuture) {
        super(zzfwmVar);
        this.zza = scheduledFuture;
    }

    @Override // com.google.android.gms.internal.ads.zzfvv, java.util.concurrent.Future
    public final boolean cancel(boolean z3) {
        boolean cancel = zzb().cancel(z3);
        if (cancel) {
            this.zza.cancel(z3);
        }
        return cancel;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Delayed delayed) {
        return this.zza.compareTo(delayed);
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return this.zza.getDelay(timeUnit);
    }
}
