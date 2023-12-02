package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzath implements Callable {
    protected final String zza = getClass().getSimpleName();
    protected final zzart zzb;
    protected final String zzc;
    protected final String zzd;
    protected final zzanq zze;
    protected Method zzf;
    protected final int zzg;
    protected final int zzh;

    public zzath(zzart zzartVar, String str, String str2, zzanq zzanqVar, int i4, int i5) {
        this.zzb = zzartVar;
        this.zzc = str;
        this.zzd = str2;
        this.zze = zzanqVar;
        this.zzg = i4;
        this.zzh = i5;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() throws Exception {
        zzl();
        return null;
    }

    protected abstract void zza() throws IllegalAccessException, InvocationTargetException;

    public Void zzl() throws Exception {
        long nanoTime;
        Method zzj;
        int i4;
        try {
            nanoTime = System.nanoTime();
            zzj = this.zzb.zzj(this.zzc, this.zzd);
            this.zzf = zzj;
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
        if (zzj == null) {
            return null;
        }
        zza();
        zzaqn zzd = this.zzb.zzd();
        if (zzd != null && (i4 = this.zzg) != Integer.MIN_VALUE) {
            zzd.zzc(this.zzh, i4, (System.nanoTime() - nanoTime) / 1000, null, null);
        }
        return null;
    }
}
