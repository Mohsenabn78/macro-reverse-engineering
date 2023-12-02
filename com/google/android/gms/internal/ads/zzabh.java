package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzabh implements zzabv {
    private final zzabj zza;
    private final long zzb;

    public zzabh(zzabj zzabjVar, long j4) {
        this.zza = zzabjVar;
        this.zzb = j4;
    }

    private final zzabw zza(long j4, long j5) {
        return new zzabw((j4 * AnimationKt.MillisToNanos) / this.zza.zze, this.zzb + j5);
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final long zze() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final zzabt zzg(long j4) {
        long j5;
        zzdy.zzb(this.zza.zzk);
        zzabj zzabjVar = this.zza;
        zzabi zzabiVar = zzabjVar.zzk;
        long[] jArr = zzabiVar.zza;
        long[] jArr2 = zzabiVar.zzb;
        int zzc = zzfj.zzc(jArr, zzabjVar.zzb(j4), true, false);
        long j6 = 0;
        if (zzc == -1) {
            j5 = 0;
        } else {
            j5 = jArr[zzc];
        }
        if (zzc != -1) {
            j6 = jArr2[zzc];
        }
        zzabw zza = zza(j5, j6);
        if (zza.zzb != j4 && zzc != jArr.length - 1) {
            int i4 = zzc + 1;
            return new zzabt(zza, zza(jArr[i4], jArr2[i4]));
        }
        return new zzabt(zza, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final boolean zzh() {
        return true;
    }
}
