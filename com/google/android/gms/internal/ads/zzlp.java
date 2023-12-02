package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzlp implements zzkl {
    private final zzdz zza;
    private boolean zzb;
    private long zzc;
    private long zzd;
    private zzch zze = zzch.zza;

    public zzlp(zzdz zzdzVar) {
        this.zza = zzdzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final long zza() {
        long zza;
        long j4 = this.zzc;
        if (this.zzb) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzd;
            zzch zzchVar = this.zze;
            if (zzchVar.zzc == 1.0f) {
                zza = zzfj.zzo(elapsedRealtime);
            } else {
                zza = zzchVar.zza(elapsedRealtime);
            }
            return j4 + zza;
        }
        return j4;
    }

    public final void zzb(long j4) {
        this.zzc = j4;
        if (this.zzb) {
            this.zzd = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final zzch zzc() {
        return this.zze;
    }

    public final void zzd() {
        if (!this.zzb) {
            this.zzd = SystemClock.elapsedRealtime();
            this.zzb = true;
        }
    }

    public final void zze() {
        if (this.zzb) {
            zzb(zza());
            this.zzb = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final void zzg(zzch zzchVar) {
        if (this.zzb) {
            zzb(zza());
        }
        this.zze = zzchVar;
    }
}
