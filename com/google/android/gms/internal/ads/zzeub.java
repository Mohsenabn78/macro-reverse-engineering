package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzeub {
    public static zzeqy zza(zzetf zzetfVar, zzeoy zzeoyVar, ScheduledExecutorService scheduledExecutorService, int i4) {
        if (i4 == 0) {
            return new zzepg(zzeoyVar, 0L, scheduledExecutorService);
        }
        return new zzepg(zzetfVar, 0L, scheduledExecutorService);
    }

    public static zzeqy zzb(zzetp zzetpVar, ScheduledExecutorService scheduledExecutorService) {
        return new zzepg(zzetpVar, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzdO)).longValue(), scheduledExecutorService);
    }

    public static zzeqy zzc(zzeuk zzeukVar, ScheduledExecutorService scheduledExecutorService) {
        return new zzepg(zzeukVar, 0L, scheduledExecutorService);
    }
}
