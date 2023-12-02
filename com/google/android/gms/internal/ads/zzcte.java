package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcte implements zzgwe {
    private final zzctd zza;
    private final zzgwr zzb;
    private final zzgwr zzc;

    public zzcte(zzctd zzctdVar, zzgwr zzgwrVar, zzgwr zzgwrVar2) {
        this.zza = zzctdVar;
        this.zzb = zzgwrVar;
        this.zzc = zzgwrVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzgwr
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new com.google.android.gms.ads.internal.zzb((Context) this.zzb.zzb(), (zzbws) this.zzc.zzb(), null);
    }
}
