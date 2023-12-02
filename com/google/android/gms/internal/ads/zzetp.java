package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzetp implements zzeqy {
    final ScheduledExecutorService zza;
    final Context zzb;
    final zzbrx zzc;

    public zzetp(zzbrx zzbrxVar, ScheduledExecutorService scheduledExecutorService, Context context) {
        this.zzc = zzbrxVar;
        this.zza = scheduledExecutorService;
        this.zzb = context;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final int zza() {
        return 49;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final zzfwm zzb() {
        return zzfwc.zzl(zzfwc.zzn(zzfwc.zzh(new Bundle()), ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzdO)).longValue(), TimeUnit.MILLISECONDS, this.zza), new zzfov() { // from class: com.google.android.gms.internal.ads.zzeto
            @Override // com.google.android.gms.internal.ads.zzfov
            public final Object apply(Object obj) {
                return new zzetq((Bundle) obj);
            }
        }, zzcae.zza);
    }
}
