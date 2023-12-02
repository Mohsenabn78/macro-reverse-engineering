package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzafu implements zzafz {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;

    private zzafu(long[] jArr, long[] jArr2, long j4) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j4 == -9223372036854775807L ? zzfj.zzo(jArr2[jArr2.length - 1]) : j4;
    }

    public static zzafu zza(long j4, zzaer zzaerVar, long j5) {
        int length = zzaerVar.zzd.length;
        int i4 = length + 1;
        long[] jArr = new long[i4];
        long[] jArr2 = new long[i4];
        jArr[0] = j4;
        long j6 = 0;
        jArr2[0] = 0;
        for (int i5 = 1; i5 <= length; i5++) {
            int i6 = i5 - 1;
            j4 += zzaerVar.zzb + zzaerVar.zzd[i6];
            j6 += zzaerVar.zzc + zzaerVar.zze[i6];
            jArr[i5] = j4;
            jArr2[i5] = j6;
        }
        return new zzafu(jArr, jArr2, j5);
    }

    private static Pair zzd(long j4, long[] jArr, long[] jArr2) {
        double d4;
        int zzc = zzfj.zzc(jArr, j4, true, true);
        long j5 = jArr[zzc];
        long j6 = jArr2[zzc];
        int i4 = zzc + 1;
        if (i4 == jArr.length) {
            return Pair.create(Long.valueOf(j5), Long.valueOf(j6));
        }
        long j7 = jArr[i4];
        long j8 = jArr2[i4];
        if (j7 == j5) {
            d4 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        } else {
            d4 = (j4 - j5) / (j7 - j5);
        }
        return Pair.create(Long.valueOf(j4), Long.valueOf(((long) (d4 * (j8 - j6))) + j6));
    }

    @Override // com.google.android.gms.internal.ads.zzafz
    public final long zzb() {
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzafz
    public final long zzc(long j4) {
        return zzfj.zzo(((Long) zzd(j4, this.zza, this.zzb).second).longValue());
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final long zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final zzabt zzg(long j4) {
        Pair zzd = zzd(zzfj.zzq(Math.max(0L, Math.min(j4, this.zzc))), this.zzb, this.zza);
        zzabw zzabwVar = new zzabw(zzfj.zzo(((Long) zzd.first).longValue()), ((Long) zzd.second).longValue());
        return new zzabt(zzabwVar, zzabwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final boolean zzh() {
        return true;
    }
}
