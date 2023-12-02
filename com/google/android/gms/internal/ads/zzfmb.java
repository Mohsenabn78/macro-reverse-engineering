package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
final class zzfmb implements zzflz {
    private zzfmb() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfmb(zzfma zzfmaVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzflz
    public final ExecutorService zza(int i4) {
        return zzc(1, Executors.defaultThreadFactory(), 2);
    }

    @Override // com.google.android.gms.internal.ads.zzflz
    public final ExecutorService zzb(ThreadFactory threadFactory, int i4) {
        return zzc(1, threadFactory, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzflz
    public final ExecutorService zzc(int i4, ThreadFactory threadFactory, int i5) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i4, i4, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService(threadPoolExecutor);
    }
}
