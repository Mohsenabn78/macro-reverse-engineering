package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfwt {
    public static zzfwn zza(ExecutorService executorService) {
        zzfwn zzfwpVar;
        if (executorService instanceof zzfwn) {
            return (zzfwn) executorService;
        }
        if (executorService instanceof ScheduledExecutorService) {
            zzfwpVar = new zzfws((ScheduledExecutorService) executorService);
        } else {
            zzfwpVar = new zzfwp(executorService);
        }
        return zzfwpVar;
    }

    public static Executor zzb() {
        return zzfvq.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor zzc(Executor executor, zzfuq zzfuqVar) {
        executor.getClass();
        if (executor == zzfvq.INSTANCE) {
            return executor;
        }
        return new zzfwo(executor, zzfuqVar);
    }
}
