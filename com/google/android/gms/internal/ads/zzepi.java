package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzepi implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;

    public zzepi(zzgwr zzgwrVar, zzgwr zzgwrVar2) {
        this.zza = zzgwrVar;
        this.zzb = zzgwrVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzgwr
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzeph(((zzduj) this.zza).zzb(), (PackageInfo) this.zzb.zzb());
    }
}
