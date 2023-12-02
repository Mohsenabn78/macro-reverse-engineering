package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzchb implements zzgwe {
    private final zzcgx zza;

    public zzchb(zzcgx zzcgxVar) {
        this.zza = zzcgxVar;
    }

    public final WeakReference zza() {
        WeakReference zzf = this.zza.zzf();
        zzgwm.zzb(zzf);
        return zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzgwr
    public final /* synthetic */ Object zzb() {
        WeakReference zzf = this.zza.zzf();
        zzgwm.zzb(zzf);
        return zzf;
    }
}
