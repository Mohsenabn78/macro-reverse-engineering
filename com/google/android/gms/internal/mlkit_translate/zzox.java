package com.google.android.gms.internal.mlkit_translate;

import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzox {
    boolean zza;
    private long zzb;
    private long zzc;
    private final zzs zzd = new zzs();
    private final zzs zze = new zzs();
    private final zzs zzf = new zzs();
    private int zzg;

    @VisibleForTesting
    public final zznj zza() {
        boolean z3;
        boolean z4 = true;
        if (this.zzb != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzj.zzf(z3);
        if (this.zzc == 0) {
            z4 = false;
        }
        zzj.zzf(z4);
        long j4 = this.zzc;
        long j5 = this.zzb;
        zznj zznjVar = new zznj();
        zznjVar.zzd(Long.valueOf(j4 - j5));
        zznjVar.zzh(this.zzd.zzd());
        zznjVar.zzg(this.zze.zzd());
        zznjVar.zze(this.zzf.zzd());
        int i4 = this.zzg;
        if (i4 != 0) {
            zznjVar.zzf(Integer.valueOf(i4));
        }
        return zznjVar;
    }

    public final void zzb(zznk zznkVar) {
        this.zzf.zzc(zznkVar);
    }

    public final void zzc(zznk zznkVar) {
        this.zze.zzc(zznkVar);
    }

    public final void zzd(zznk zznkVar) {
        if (this.zza) {
            this.zze.zzc(zznkVar);
        } else {
            this.zzd.zzc(zznkVar);
        }
    }

    public final void zze() {
        this.zzc = SystemClock.elapsedRealtime();
    }

    public final void zzf(int i4) {
        this.zzg = i4;
    }

    public final void zzg() {
        this.zzb = SystemClock.elapsedRealtime();
    }

    public final void zzh() {
        this.zza = true;
    }
}
