package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfhr {
    private static zzfhr zza;
    private float zzb = 0.0f;
    private final zzfhk zzc;
    private final zzfhi zzd;
    private zzfhj zze;
    private zzfhl zzf;

    public zzfhr(zzfhk zzfhkVar, zzfhi zzfhiVar) {
        this.zzc = zzfhkVar;
        this.zzd = zzfhiVar;
    }

    public static zzfhr zzb() {
        if (zza == null) {
            zza = new zzfhr(new zzfhk(), new zzfhi());
        }
        return zza;
    }

    public final float zza() {
        return this.zzb;
    }

    public final void zzc(Context context) {
        this.zze = new zzfhj(new Handler(), context, new zzfhh(), this);
    }

    public final void zzd(float f4) {
        this.zzb = f4;
        if (this.zzf == null) {
            this.zzf = zzfhl.zza();
        }
        for (zzfha zzfhaVar : this.zzf.zzb()) {
            zzfhaVar.zzg().zzh(f4);
        }
    }

    public final void zze() {
        zzfhm.zza().zzd(this);
        zzfhm.zza().zzb();
        zzfin.zzd().zzi();
        this.zze.zza();
    }

    public final void zzf() {
        zzfin.zzd().zzj();
        zzfhm.zza().zzc();
        this.zze.zzb();
    }
}
