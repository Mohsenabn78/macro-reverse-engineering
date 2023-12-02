package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfxc extends zzfvs implements RunnableFuture {
    @CheckForNull
    private volatile zzfwl zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfxc(zzfvi zzfviVar) {
        this.zza = new zzfxa(this, zzfviVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfxc zzf(Runnable runnable, Object obj) {
        return new zzfxc(Executors.callable(runnable, obj));
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        zzfwl zzfwlVar = this.zza;
        if (zzfwlVar != null) {
            zzfwlVar.run();
        }
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzfuq
    @CheckForNull
    protected final String zza() {
        zzfwl zzfwlVar = this.zza;
        if (zzfwlVar != null) {
            String obj = zzfwlVar.toString();
            return "task=[" + obj + "]";
        }
        return super.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzfuq
    protected final void zzb() {
        zzfwl zzfwlVar;
        if (zzu() && (zzfwlVar = this.zza) != null) {
            zzfwlVar.zzh();
        }
        this.zza = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfxc(Callable callable) {
        this.zza = new zzfxb(this, callable);
    }
}
