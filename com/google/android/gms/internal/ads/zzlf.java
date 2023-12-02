package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzlf {
    private final zzle zza;
    private final zzld zzb;
    private final zzdz zzc;
    private final zzcw zzd;
    private int zze;
    @Nullable
    private Object zzf;
    private final Looper zzg;
    private final int zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;

    public zzlf(zzld zzldVar, zzle zzleVar, zzcw zzcwVar, int i4, zzdz zzdzVar, Looper looper) {
        this.zzb = zzldVar;
        this.zza = zzleVar;
        this.zzd = zzcwVar;
        this.zzg = looper;
        this.zzc = zzdzVar;
        this.zzh = i4;
    }

    public final int zza() {
        return this.zze;
    }

    public final Looper zzb() {
        return this.zzg;
    }

    public final zzle zzc() {
        return this.zza;
    }

    public final zzlf zzd() {
        zzdy.zzf(!this.zzi);
        this.zzi = true;
        this.zzb.zzm(this);
        return this;
    }

    public final zzlf zze(@Nullable Object obj) {
        zzdy.zzf(!this.zzi);
        this.zzf = obj;
        return this;
    }

    public final zzlf zzf(int i4) {
        zzdy.zzf(!this.zzi);
        this.zze = i4;
        return this;
    }

    @Nullable
    public final Object zzg() {
        return this.zzf;
    }

    public final synchronized void zzh(boolean z3) {
        this.zzj = z3 | this.zzj;
        this.zzk = true;
        notifyAll();
    }

    public final synchronized boolean zzi(long j4) throws InterruptedException, TimeoutException {
        boolean z3;
        zzdy.zzf(this.zzi);
        if (this.zzg.getThread() != Thread.currentThread()) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzdy.zzf(z3);
        long elapsedRealtime = SystemClock.elapsedRealtime() + j4;
        while (!this.zzk) {
            if (j4 > 0) {
                wait(j4);
                j4 = elapsedRealtime - SystemClock.elapsedRealtime();
            } else {
                throw new TimeoutException("Message delivery timed out.");
            }
        }
        return this.zzj;
    }

    public final synchronized boolean zzj() {
        return false;
    }
}
