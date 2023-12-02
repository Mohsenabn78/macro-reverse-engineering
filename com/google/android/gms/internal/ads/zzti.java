package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@VisibleForTesting
/* loaded from: classes4.dex */
public final class zzti extends zzcw {
    private final zzbp zzc;

    public zzti(zzbp zzbpVar) {
        this.zzc = zzbpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcw
    public final int zza(Object obj) {
        if (obj == zzth.zzd) {
            return 0;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcw
    public final int zzb() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzcw
    public final int zzc() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzcw
    public final zzct zzd(int i4, zzct zzctVar, boolean z3) {
        Integer num;
        Object obj = null;
        if (z3) {
            num = 0;
        } else {
            num = null;
        }
        if (z3) {
            obj = zzth.zzd;
        }
        zzctVar.zzl(num, obj, 0, -9223372036854775807L, 0L, zzd.zza, true);
        return zzctVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcw
    public final zzcv zze(int i4, zzcv zzcvVar, long j4) {
        zzcvVar.zza(zzcv.zza, this.zzc, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, null, 0L, -9223372036854775807L, 0, 0, 0L);
        zzcvVar.zzl = true;
        return zzcvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcw
    public final Object zzf(int i4) {
        return zzth.zzd;
    }
}
