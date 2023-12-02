package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfwc extends zzfwe {
    /* JADX WARN: Multi-variable type inference failed */
    public static zzfwb zza(Iterable iterable) {
        return new zzfwb(false, zzfsc.zzj(iterable), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static zzfwb zzb(Iterable iterable) {
        int i4 = zzfsc.zzd;
        iterable.getClass();
        return new zzfwb(true, zzfsc.zzj(iterable), null);
    }

    @SafeVarargs
    public static zzfwb zzc(zzfwm... zzfwmVarArr) {
        return new zzfwb(true, zzfsc.zzk(zzfwmVarArr), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static zzfwm zzd(Iterable iterable) {
        return new zzfvk(zzfsc.zzj(iterable), true);
    }

    public static zzfwm zze(zzfwm zzfwmVar, Class cls, zzfov zzfovVar, Executor executor) {
        zzfun zzfunVar = new zzfun(zzfwmVar, cls, zzfovVar);
        zzfwmVar.zzc(zzfunVar, zzfwt.zzc(executor, zzfunVar));
        return zzfunVar;
    }

    public static zzfwm zzf(zzfwm zzfwmVar, Class cls, zzfvj zzfvjVar, Executor executor) {
        zzfum zzfumVar = new zzfum(zzfwmVar, cls, zzfvjVar);
        zzfwmVar.zzc(zzfumVar, zzfwt.zzc(executor, zzfumVar));
        return zzfumVar;
    }

    public static zzfwm zzg(Throwable th) {
        th.getClass();
        return new zzfwf(th);
    }

    public static zzfwm zzh(Object obj) {
        if (obj == null) {
            return zzfwg.zza;
        }
        return new zzfwg(obj);
    }

    public static zzfwm zzi() {
        return zzfwg.zza;
    }

    public static zzfwm zzj(Callable callable, Executor executor) {
        zzfxc zzfxcVar = new zzfxc(callable);
        executor.execute(zzfxcVar);
        return zzfxcVar;
    }

    public static zzfwm zzk(zzfvi zzfviVar, Executor executor) {
        zzfxc zzfxcVar = new zzfxc(zzfviVar);
        executor.execute(zzfxcVar);
        return zzfxcVar;
    }

    public static zzfwm zzl(zzfwm zzfwmVar, zzfov zzfovVar, Executor executor) {
        zzfux zzfuxVar = new zzfux(zzfwmVar, zzfovVar);
        zzfwmVar.zzc(zzfuxVar, zzfwt.zzc(executor, zzfuxVar));
        return zzfuxVar;
    }

    public static zzfwm zzm(zzfwm zzfwmVar, zzfvj zzfvjVar, Executor executor) {
        int i4 = zzfuy.zzc;
        executor.getClass();
        zzfuw zzfuwVar = new zzfuw(zzfwmVar, zzfvjVar);
        zzfwmVar.zzc(zzfuwVar, zzfwt.zzc(executor, zzfuwVar));
        return zzfuwVar;
    }

    public static zzfwm zzn(zzfwm zzfwmVar, long j4, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        if (zzfwmVar.isDone()) {
            return zzfwmVar;
        }
        return zzfwz.zzg(zzfwmVar, j4, timeUnit, scheduledExecutorService);
    }

    public static Object zzo(Future future) throws ExecutionException {
        if (future.isDone()) {
            return zzfxe.zza(future);
        }
        throw new IllegalStateException(zzfpw.zzb("Future was expected to be done: %s", future));
    }

    public static Object zzp(Future future) {
        try {
            return zzfxe.zza(future);
        } catch (ExecutionException e4) {
            Throwable cause = e4.getCause();
            if (cause instanceof Error) {
                throw new zzfvr((Error) cause);
            }
            throw new zzfxd(cause);
        }
    }

    public static void zzq(zzfwm zzfwmVar, zzfvy zzfvyVar, Executor executor) {
        zzfvyVar.getClass();
        zzfwmVar.zzc(new zzfvz(zzfwmVar, zzfvyVar), executor);
    }
}
