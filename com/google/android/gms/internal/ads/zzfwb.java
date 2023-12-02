package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfwb {
    private final boolean zza;
    private final zzfsc zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfwb(boolean z3, zzfsc zzfscVar, zzfwa zzfwaVar) {
        this.zza = z3;
        this.zzb = zzfscVar;
    }

    public final zzfwm zza(Callable callable, Executor executor) {
        return new zzfvp(this.zzb, this.zza, executor, callable);
    }
}
