package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzezm {
    private final Clock zza;
    private final Object zzb = new Object();
    private volatile int zzd = 1;
    private volatile long zzc = 0;

    public zzezm(Clock clock) {
        this.zza = clock;
    }

    private final void zze() {
        long currentTimeMillis = this.zza.currentTimeMillis();
        synchronized (this.zzb) {
            if (this.zzd == 3) {
                if (this.zzc + ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzfK)).longValue() <= currentTimeMillis) {
                    this.zzd = 1;
                }
            }
        }
    }

    private final void zzf(int i4, int i5) {
        zze();
        long currentTimeMillis = this.zza.currentTimeMillis();
        synchronized (this.zzb) {
            if (this.zzd != i4) {
                return;
            }
            this.zzd = i5;
            if (this.zzd == 3) {
                this.zzc = currentTimeMillis;
            }
        }
    }

    public final void zza() {
        zzf(2, 3);
    }

    public final void zzb(boolean z3) {
        if (z3) {
            zzf(1, 2);
        } else {
            zzf(2, 1);
        }
    }

    public final boolean zzc() {
        boolean z3;
        synchronized (this.zzb) {
            zze();
            if (this.zzd == 3) {
                z3 = true;
            } else {
                z3 = false;
            }
        }
        return z3;
    }

    public final boolean zzd() {
        boolean z3;
        synchronized (this.zzb) {
            zze();
            if (this.zzd == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
        }
        return z3;
    }
}
