package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzeni implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;

    public zzeni(zzgwr zzgwrVar, zzgwr zzgwrVar2) {
        this.zza = zzgwrVar;
        this.zzb = zzgwrVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzgwr
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzemy(((zzerg) this.zza).zzb(), ((Long) zzbcv.zza.zze()).longValue(), (Clock) this.zzb.zzb());
    }
}
