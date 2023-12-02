package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfwo implements Executor {
    final /* synthetic */ Executor zza;
    final /* synthetic */ zzfuq zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfwo(Executor executor, zzfuq zzfuqVar) {
        this.zza = executor;
        this.zzb = zzfuqVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        try {
            this.zza.execute(runnable);
        } catch (RejectedExecutionException e4) {
            this.zzb.zze(e4);
        }
    }
}
