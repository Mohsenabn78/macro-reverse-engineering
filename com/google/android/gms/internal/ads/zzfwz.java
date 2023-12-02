package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfwz extends zzfvs {
    @CheckForNull
    private zzfwm zza;
    @CheckForNull
    private ScheduledFuture zzb;

    private zzfwz(zzfwm zzfwmVar) {
        zzfwmVar.getClass();
        this.zza = zzfwmVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfwm zzg(zzfwm zzfwmVar, long j4, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzfwz zzfwzVar = new zzfwz(zzfwmVar);
        zzfww zzfwwVar = new zzfww(zzfwzVar);
        zzfwzVar.zzb = scheduledExecutorService.schedule(zzfwwVar, j4, timeUnit);
        zzfwmVar.zzc(zzfwwVar, zzfvq.INSTANCE);
        return zzfwzVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzfuq
    @CheckForNull
    public final String zza() {
        zzfwm zzfwmVar = this.zza;
        ScheduledFuture scheduledFuture = this.zzb;
        if (zzfwmVar != null) {
            String str = "inputFuture=[" + zzfwmVar.toString() + "]";
            if (scheduledFuture != null) {
                long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
                if (delay > 0) {
                    return str + ", remaining delay=[" + delay + " ms]";
                }
                return str;
            }
            return str;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzfuq
    protected final void zzb() {
        zzs(this.zza);
        ScheduledFuture scheduledFuture = this.zzb;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zza = null;
        this.zzb = null;
    }
}
