package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzepg implements zzeqy {
    private final zzeqy zza;
    private final long zzb;
    private final ScheduledExecutorService zzc;

    public zzepg(zzeqy zzeqyVar, long j4, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzeqyVar;
        this.zzb = j4;
        this.zzc = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final int zza() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final zzfwm zzb() {
        zzfwm zzb = this.zza.zzb();
        long j4 = this.zzb;
        if (j4 > 0) {
            zzb = zzfwc.zzn(zzb, j4, TimeUnit.MILLISECONDS, this.zzc);
        }
        return zzfwc.zzf(zzb, Throwable.class, new zzfvj() { // from class: com.google.android.gms.internal.ads.zzepf
            @Override // com.google.android.gms.internal.ads.zzfvj
            public final zzfwm zza(Object obj) {
                Throwable th = (Throwable) obj;
                return zzfwc.zzh(null);
            }
        }, zzcae.zzf);
    }
}
