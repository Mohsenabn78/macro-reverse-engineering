package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.compose.animation.core.AnimationKt;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzagb implements zzafz {
    private final long zza;
    private final int zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;
    @Nullable
    private final long[] zzf;

    private zzagb(long j4, int i4, long j5, long j6, @Nullable long[] jArr) {
        this.zza = j4;
        this.zzb = i4;
        this.zzc = j5;
        this.zzf = jArr;
        this.zzd = j6;
        this.zze = j6 != -1 ? j4 + j6 : -1L;
    }

    @Nullable
    public static zzagb zza(long j4, long j5, zzabp zzabpVar, zzfa zzfaVar) {
        int zzn;
        int i4 = zzabpVar.zzg;
        int i5 = zzabpVar.zzd;
        int zze = zzfaVar.zze();
        if ((zze & 1) == 1 && (zzn = zzfaVar.zzn()) != 0) {
            int i6 = zze & 6;
            long zzp = zzfj.zzp(zzn, i4 * AnimationKt.MillisToNanos, i5);
            if (i6 != 6) {
                return new zzagb(j5, zzabpVar.zzc, zzp, -1L, null);
            }
            long zzs = zzfaVar.zzs();
            long[] jArr = new long[100];
            for (int i7 = 0; i7 < 100; i7++) {
                jArr[i7] = zzfaVar.zzk();
            }
            if (j4 != -1) {
                long j6 = j5 + zzs;
                if (j4 != j6) {
                    zzer.zzf("XingSeeker", "XING data size mismatch: " + j4 + ", " + j6);
                }
            }
            return new zzagb(j5, zzabpVar.zzc, zzp, zzs, jArr);
        }
        return null;
    }

    private final long zzd(int i4) {
        return (this.zzc * i4) / 100;
    }

    @Override // com.google.android.gms.internal.ads.zzafz
    public final long zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzafz
    public final long zzc(long j4) {
        long j5;
        double d4;
        long j6 = j4 - this.zza;
        if (zzh() && j6 > this.zzb) {
            long[] jArr = this.zzf;
            zzdy.zzb(jArr);
            double d5 = (j6 * 256.0d) / this.zzd;
            int zzc = zzfj.zzc(jArr, (long) d5, true, true);
            long zzd = zzd(zzc);
            long j7 = jArr[zzc];
            int i4 = zzc + 1;
            long zzd2 = zzd(i4);
            if (zzc == 99) {
                j5 = 256;
            } else {
                j5 = jArr[i4];
            }
            if (j7 == j5) {
                d4 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            } else {
                d4 = (d5 - j7) / (j5 - j7);
            }
            return zzd + Math.round(d4 * (zzd2 - zzd));
        }
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final long zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final zzabt zzg(long j4) {
        double d4;
        if (!zzh()) {
            zzabw zzabwVar = new zzabw(0L, this.zza + this.zzb);
            return new zzabt(zzabwVar, zzabwVar);
        }
        long max = Math.max(0L, Math.min(j4, this.zzc));
        double d5 = (max * 100.0d) / this.zzc;
        double d6 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        if (d5 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            if (d5 >= 100.0d) {
                d6 = 256.0d;
            } else {
                int i4 = (int) d5;
                long[] jArr = this.zzf;
                zzdy.zzb(jArr);
                double d7 = jArr[i4];
                if (i4 == 99) {
                    d4 = 256.0d;
                } else {
                    d4 = jArr[i4 + 1];
                }
                d6 = d7 + ((d5 - i4) * (d4 - d7));
            }
        }
        zzabw zzabwVar2 = new zzabw(max, this.zza + Math.max(this.zzb, Math.min(Math.round((d6 / 256.0d) * this.zzd), this.zzd - 1)));
        return new zzabt(zzabwVar2, zzabwVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final boolean zzh() {
        if (this.zzf != null) {
            return true;
        }
        return false;
    }
}
