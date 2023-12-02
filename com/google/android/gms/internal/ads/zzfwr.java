package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfuq;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzfwr extends zzfuq.zzi implements Runnable {
    private final Runnable zza;

    public zzfwr(Runnable runnable) {
        runnable.getClass();
        this.zza = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zza.run();
        } catch (Error | RuntimeException e4) {
            zze(e4);
            throw e4;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzfuq
    public final String zza() {
        String obj = this.zza.toString();
        return "task=[" + obj + "]";
    }
}
