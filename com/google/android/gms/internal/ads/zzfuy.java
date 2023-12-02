package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzfuy extends zzfvs implements Runnable {
    public static final /* synthetic */ int zzc = 0;
    @CheckForNull
    zzfwm zza;
    @CheckForNull
    Object zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfuy(zzfwm zzfwmVar, Object obj) {
        zzfwmVar.getClass();
        this.zza = zzfwmVar;
        this.zzb = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z3;
        zzfwm zzfwmVar = this.zza;
        Object obj = this.zzb;
        boolean isCancelled = isCancelled();
        boolean z4 = true;
        if (zzfwmVar == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        boolean z5 = isCancelled | z3;
        if (obj != null) {
            z4 = false;
        }
        if (z5 | z4) {
            return;
        }
        this.zza = null;
        if (zzfwmVar.isCancelled()) {
            zzt(zzfwmVar);
            return;
        }
        try {
            try {
                Object zzf = zzf(obj, zzfwc.zzo(zzfwmVar));
                this.zzb = null;
                zzg(zzf);
            } catch (Throwable th) {
                try {
                    zzfwu.zza(th);
                    zze(th);
                } finally {
                    this.zzb = null;
                }
            }
        } catch (Error e4) {
            zze(e4);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (RuntimeException e5) {
            zze(e5);
        } catch (ExecutionException e6) {
            zze(e6.getCause());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzfuq
    @CheckForNull
    public final String zza() {
        String str;
        zzfwm zzfwmVar = this.zza;
        Object obj = this.zzb;
        String zza = super.zza();
        if (zzfwmVar != null) {
            str = "inputFuture=[" + zzfwmVar.toString() + "], ";
        } else {
            str = "";
        }
        if (obj != null) {
            return str + "function=[" + obj.toString() + "]";
        } else if (zza != null) {
            return str.concat(zza);
        } else {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfuq
    protected final void zzb() {
        zzs(this.zza);
        this.zza = null;
        this.zzb = null;
    }

    abstract Object zzf(Object obj, Object obj2) throws Exception;

    abstract void zzg(Object obj);
}
