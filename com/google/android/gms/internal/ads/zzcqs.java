package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcqs implements zzcwu, zzaua {
    private final zzezn zza;
    private final zzcvy zzb;
    private final zzcxd zzc;
    private final AtomicBoolean zzd = new AtomicBoolean();
    private final AtomicBoolean zze = new AtomicBoolean();

    public zzcqs(zzezn zzeznVar, zzcvy zzcvyVar, zzcxd zzcxdVar) {
        this.zza = zzeznVar;
        this.zzb = zzcvyVar;
        this.zzc = zzcxdVar;
    }

    private final void zza() {
        if (this.zzd.compareAndSet(false, true)) {
            this.zzb.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaua
    public final void zzc(zzatz zzatzVar) {
        if (this.zza.zzf == 1 && zzatzVar.zzj) {
            zza();
        }
        if (zzatzVar.zzj && this.zze.compareAndSet(false, true)) {
            this.zzc.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwu
    public final synchronized void zzn() {
        if (this.zza.zzf != 1) {
            zza();
        }
    }
}
