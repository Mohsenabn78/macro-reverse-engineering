package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzenk implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;

    public zzenk(zzgwr zzgwrVar, zzgwr zzgwrVar2) {
        this.zza = zzgwrVar;
        this.zzb = zzgwrVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzgwr
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfsh zzm;
        zzena zza = zzenc.zza();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.zzb.zzb();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzdK)).booleanValue()) {
            zzm = zzfsh.zzn(new zzepg(zza, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzdL)).intValue(), scheduledExecutorService));
        } else {
            zzm = zzfsh.zzm();
        }
        zzgwm.zzb(zzm);
        return zzm;
    }
}
