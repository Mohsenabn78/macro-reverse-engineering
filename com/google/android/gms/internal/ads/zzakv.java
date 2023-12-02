package com.google.android.gms.internal.ads;

import java.util.concurrent.BlockingQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzakv implements Runnable {
    final /* synthetic */ zzalk zza;
    final /* synthetic */ zzakw zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzakv(zzakw zzakwVar, zzalk zzalkVar) {
        this.zzb = zzakwVar;
        this.zza = zzalkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BlockingQueue blockingQueue;
        try {
            blockingQueue = this.zzb.zzc;
            blockingQueue.put(this.zza);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
