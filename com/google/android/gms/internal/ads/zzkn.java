package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzkn {
    public final zzto zza;
    public final long zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final boolean zzi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkn(zzto zztoVar, long j4, long j5, long j6, long j7, boolean z3, boolean z4, boolean z5, boolean z6) {
        boolean z7;
        boolean z8 = true;
        if (z6 && !z4) {
            z7 = false;
        } else {
            z7 = true;
        }
        zzdy.zzd(z7);
        if (z5 && !z4) {
            z8 = false;
        }
        zzdy.zzd(z8);
        this.zza = zztoVar;
        this.zzb = j4;
        this.zzc = j5;
        this.zzd = j6;
        this.zze = j7;
        this.zzf = false;
        this.zzg = z4;
        this.zzh = z5;
        this.zzi = z6;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzkn.class == obj.getClass()) {
            zzkn zzknVar = (zzkn) obj;
            if (this.zzb == zzknVar.zzb && this.zzc == zzknVar.zzc && this.zzd == zzknVar.zzd && this.zze == zzknVar.zze && this.zzg == zzknVar.zzg && this.zzh == zzknVar.zzh && this.zzi == zzknVar.zzi && zzfj.zzC(this.zza, zzknVar.zza)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i4 = (int) this.zzb;
        int i5 = (int) this.zzc;
        return ((((((((((((((this.zza.hashCode() + 527) * 31) + i4) * 31) + i5) * 31) + ((int) this.zzd)) * 31) + ((int) this.zze)) * 961) + (this.zzg ? 1 : 0)) * 31) + (this.zzh ? 1 : 0)) * 31) + (this.zzi ? 1 : 0);
    }

    public final zzkn zza(long j4) {
        if (j4 == this.zzc) {
            return this;
        }
        return new zzkn(this.zza, this.zzb, j4, this.zzd, this.zze, false, this.zzg, this.zzh, this.zzi);
    }

    public final zzkn zzb(long j4) {
        if (j4 == this.zzb) {
            return this;
        }
        return new zzkn(this.zza, j4, this.zzc, this.zzd, this.zze, false, this.zzg, this.zzh, this.zzi);
    }
}
