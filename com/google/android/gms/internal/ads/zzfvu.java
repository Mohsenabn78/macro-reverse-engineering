package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzfvu extends zzfvt {
    private final zzfwm zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfvu(zzfwm zzfwmVar) {
        zzfwmVar.getClass();
        this.zza = zzfwmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfuq, java.util.concurrent.Future
    public final boolean cancel(boolean z3) {
        return this.zza.cancel(z3);
    }

    @Override // com.google.android.gms.internal.ads.zzfuq, java.util.concurrent.Future
    public final Object get() throws InterruptedException, ExecutionException {
        return this.zza.get();
    }

    @Override // com.google.android.gms.internal.ads.zzfuq, java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.zza.isCancelled();
    }

    @Override // com.google.android.gms.internal.ads.zzfuq, java.util.concurrent.Future
    public final boolean isDone() {
        return this.zza.isDone();
    }

    @Override // com.google.android.gms.internal.ads.zzfuq
    public final String toString() {
        return this.zza.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzfuq, com.google.android.gms.internal.ads.zzfwm
    public final void zzc(Runnable runnable, Executor executor) {
        this.zza.zzc(runnable, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzfuq, java.util.concurrent.Future
    public final Object get(long j4, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.zza.get(j4, timeUnit);
    }
}
