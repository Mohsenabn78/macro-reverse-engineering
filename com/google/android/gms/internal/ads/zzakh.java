package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzakh implements zzabv {
    private final zzake zza;
    private final int zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;

    public zzakh(zzake zzakeVar, int i4, long j4, long j5) {
        this.zza = zzakeVar;
        this.zzb = i4;
        this.zzc = j4;
        long j6 = (j5 - j4) / zzakeVar.zzd;
        this.zzd = j6;
        this.zze = zza(j6);
    }

    private final long zza(long j4) {
        return zzfj.zzp(j4 * this.zzb, AnimationKt.MillisToNanos, this.zza.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final long zze() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final zzabt zzg(long j4) {
        long max = Math.max(0L, Math.min((this.zza.zzc * j4) / (this.zzb * AnimationKt.MillisToNanos), this.zzd - 1));
        long j5 = this.zzc + (this.zza.zzd * max);
        long zza = zza(max);
        zzabw zzabwVar = new zzabw(zza, j5);
        if (zza < j4 && max != this.zzd - 1) {
            long j6 = max + 1;
            return new zzabt(zzabwVar, new zzabw(zza(j6), this.zzc + (this.zza.zzd * j6)));
        }
        return new zzabt(zzabwVar, zzabwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final boolean zzh() {
        return true;
    }
}
