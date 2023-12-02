package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@Deprecated
/* loaded from: classes4.dex */
public final class zzdqa {
    private final zzdqf zza;
    private final Executor zzb;
    private final Map zzc;

    public zzdqa(zzdqf zzdqfVar, Executor executor) {
        this.zza = zzdqfVar;
        this.zzc = zzdqfVar.zza();
        this.zzb = executor;
    }

    public final zzdpz zza() {
        zzdpz zzdpzVar = new zzdpz(this);
        zzdpz.zza(zzdpzVar);
        return zzdpzVar;
    }

    public final void zze() {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzjZ)).booleanValue()) {
            return;
        }
        zzdpz zza = zza();
        zza.zzb("action", "pecr");
        zza.zzg();
    }
}
