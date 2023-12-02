package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfoa extends zzfnx {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ zzfnx zzb;
    final /* synthetic */ zzfoh zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfoa(zzfoh zzfohVar, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, zzfnx zzfnxVar) {
        super(taskCompletionSource);
        this.zzc = zzfohVar;
        this.zza = taskCompletionSource2;
        this.zzb = zzfnxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfnx
    public final void zza() {
        Object obj;
        AtomicInteger atomicInteger;
        zzfnw zzfnwVar;
        obj = this.zzc.zzg;
        synchronized (obj) {
            zzfoh.zzn(this.zzc, this.zza);
            atomicInteger = this.zzc.zzl;
            if (atomicInteger.getAndIncrement() > 0) {
                zzfnwVar = this.zzc.zzc;
                zzfnwVar.zzc("Already connected to the service.", new Object[0]);
            }
            zzfoh.zzp(this.zzc, this.zzb);
        }
    }
}
