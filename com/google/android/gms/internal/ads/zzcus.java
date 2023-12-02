package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcus implements zzgwe {
    private final zzcuq zza;
    private final zzgwr zzb;

    public zzcus(zzcuq zzcuqVar, zzgwr zzgwrVar) {
        this.zza = zzcuqVar;
        this.zzb = zzgwrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgwr
    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza = this.zza.zza(((zzcha) this.zzb).zza());
        zzgwm.zzb(zza);
        return zza;
    }
}
