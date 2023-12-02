package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@Deprecated
/* loaded from: classes4.dex */
public class zzcaq {
    private final zzcaj zza;
    private final AtomicInteger zzb;

    public zzcaq() {
        zzcaj zzcajVar = new zzcaj();
        this.zza = zzcajVar;
        this.zzb = new AtomicInteger(0);
        zzfwc.zzq(zzcajVar, new zzcao(this), zzcae.zzf);
    }

    @Deprecated
    public final int zze() {
        return this.zzb.get();
    }

    @Deprecated
    public final void zzg() {
        this.zza.zze(new Exception());
    }

    @Deprecated
    public final void zzh(Object obj) {
        this.zza.zzd(obj);
    }

    @Deprecated
    public final void zzi(zzcan zzcanVar, zzcal zzcalVar) {
        zzfwc.zzq(this.zza, new zzcap(this, zzcanVar, zzcalVar), zzcae.zzf);
    }
}
