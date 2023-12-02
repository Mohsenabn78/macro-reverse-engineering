package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@Deprecated
/* loaded from: classes4.dex */
public final class zzdqf extends zzdqh {
    private final zzffd zzf;

    public zzdqf(Executor executor, zzbzw zzbzwVar, zzffd zzffdVar, zzfff zzfffVar) {
        super(executor, zzbzwVar, zzfffVar);
        this.zzf = zzffdVar;
        zzffdVar.zza(this.zzb);
    }

    public final Map zza() {
        return new HashMap(this.zzb);
    }
}
