package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzlt {
    public final long zza;
    public final zzcw zzb;
    public final int zzc;
    @Nullable
    public final zzto zzd;
    public final long zze;
    public final zzcw zzf;
    public final int zzg;
    @Nullable
    public final zzto zzh;
    public final long zzi;
    public final long zzj;

    public zzlt(long j4, zzcw zzcwVar, int i4, @Nullable zzto zztoVar, long j5, zzcw zzcwVar2, int i5, @Nullable zzto zztoVar2, long j6, long j7) {
        this.zza = j4;
        this.zzb = zzcwVar;
        this.zzc = i4;
        this.zzd = zztoVar;
        this.zze = j5;
        this.zzf = zzcwVar2;
        this.zzg = i5;
        this.zzh = zztoVar2;
        this.zzi = j6;
        this.zzj = j7;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzlt.class == obj.getClass()) {
            zzlt zzltVar = (zzlt) obj;
            if (this.zza == zzltVar.zza && this.zzc == zzltVar.zzc && this.zze == zzltVar.zze && this.zzg == zzltVar.zzg && this.zzi == zzltVar.zzi && this.zzj == zzltVar.zzj && zzfpc.zza(this.zzb, zzltVar.zzb) && zzfpc.zza(this.zzd, zzltVar.zzd) && zzfpc.zza(this.zzf, zzltVar.zzf) && zzfpc.zza(this.zzh, zzltVar.zzh)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.zza), this.zzb, Integer.valueOf(this.zzc), this.zzd, Long.valueOf(this.zze), this.zzf, Integer.valueOf(this.zzg), this.zzh, Long.valueOf(this.zzi), Long.valueOf(this.zzj)});
    }
}
