package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzchg implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;

    public zzchg(zzgwr zzgwrVar, zzgwr zzgwrVar2) {
        this.zza = zzgwrVar;
        this.zzb = zzgwrVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzgwr
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set emptySet;
        zzdse zzdseVar = (zzdse) this.zza.zzb();
        zzfwn zzfwnVar = zzcae.zza;
        zzgwm.zzb(zzfwnVar);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbz)).booleanValue()) {
            emptySet = Collections.singleton(new zzdcm(zzdseVar, zzfwnVar));
        } else {
            emptySet = Collections.emptySet();
        }
        zzgwm.zzb(emptySet);
        return emptySet;
    }
}
